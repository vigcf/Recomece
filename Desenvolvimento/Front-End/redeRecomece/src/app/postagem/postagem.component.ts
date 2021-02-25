import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Postagem } from '../model/Postagem';
import { Tema } from '../model/Tema';
import { User } from '../model/User';
import { AuthService } from '../service/auth.service';
import { PostagemService } from '../service/postagem.service';
import { TemaService } from '../service/tema.service';

@Component({
  selector: 'app-postagem',
  templateUrl: './postagem.component.html',
  styleUrls: ['./postagem.component.css']
})
export class PostagemComponent implements OnInit {

  postagem: Postagem = new Postagem()
  listaPostagens: Postagem[]

  tema: Tema = new Tema()
  listaTemas: Tema[]
  idTema: number

  user: User = new User()
  idUser = environment.id
  listaUsuario: User[]

  nome = environment.nome
  foto = environment. foto

  constructor(
    private router: Router,
    private postagemService: PostagemService,
    private temaService: TemaService,
    private authService: AuthService


  ) { }

  ngOnInit() {

    if(environment.token == '') {
      //alert('Sua seção expirou. Faça login novamente')
      this.router.navigate( ['/menu'] )
    }

    this.getAllTema()
    this.getAllPostagens()
    this.findByIdUser()
  }

  getAllTema() {
    this.temaService.getAllTema().subscribe((resp: Tema[]) => {
      this.listaTemas = resp
    })
  }

  findByIdTema(){
    this.temaService.getByIdTema(this.idTema).subscribe((resp: Tema) =>{
      this.tema = resp
    })
  }

  getAllPostagens() {
    this.postagemService.getAllPostagens().subscribe((resp: Postagem[]) =>{
      this.listaPostagens = resp
    })
  }


  findByIdUser() {
    this.postagemService.getByIdUser(this.idUser).subscribe((resp: User) => {
      this.user = resp
    })

  }


  publicar(){
    this.tema.idTema = this.idTema
    this.postagem.tema = this.tema

    this.user.idUsuario = this.idUser
    this.postagem.usuario = this.user


    this.postagemService.postPostagem(this.postagem).subscribe((resp: Postagem) => {
      this.postagem = resp
      this.postagem = new Postagem()
      this.getAllTema()
      this.getAllPostagens()
      alert('Postagem realizada com sucesso!')
    })
  }



  sair(){
    this.router.navigate(['/menu'])
    environment.token = ''
    environment.nome = ''
    environment.foto = ''
    environment.id = 0
  }
}
