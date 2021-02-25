import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { User } from '../model/User';
import { UserLogin } from '../model/UserLogin';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  userLogin: UserLogin = new UserLogin()
  user: User = new User
  confirmarSenha: string
  tipoUsuario: string

  constructor(
    private auth: AuthService,
    private router: Router,
    private location: Location
  ) { }

  ngOnInit() {
    window.scroll(0, 0)
  }

  entrar() {
    this.auth.entrar(this.userLogin).subscribe((resp: UserLogin) => {
      this.userLogin = resp

      /*Variável definida com o escopo global na pasta Environment(blogPersonal/src/environments/environment.prod)
      ↓ Para acessa-la segura a tecla Ctrl + click na palavra environment*/
      environment.token = this.userLogin.token
      environment.nome = this.userLogin.nome
      environment.foto = this.userLogin.foto
      environment.id = this.userLogin.id
      environment.tipo = this.userLogin.tipo
      environment.email = this.userLogin.email
      environment.bio = this.userLogin.bio

      this.router.navigate(['/postagem'])
    }, erro => {
      if(erro.status == 500) {
        alert('Usuário ou senha estão incorretos')
      }
    })
    
  }

  

  confirmSenha(event: any) {
    this.confirmarSenha = event.target.value
  }

  tipoUser(event: any) {
    this.tipoUsuario = event.target.value
  }

  cadastrar() {
    this.user.tipo = this.tipoUsuario

    if(this.user.senha != this.confirmarSenha) {
      alert('Senha incompatíveis!')
    } else{
      this.auth.cadastrar(this.user).subscribe((resp: User) => {
        this.user = resp
        alert('Usuário cadastrado com sucesso.')
        window.scroll(0, 0)
        location.reload
      })
    }
  }

}
