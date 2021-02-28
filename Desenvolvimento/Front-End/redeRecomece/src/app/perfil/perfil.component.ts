import { User } from './../model/User';
import { Tema } from './../model/Tema';
import { TemaService } from './../service/tema.service';
import { PostagemService } from './../service/postagem.service';
import { Postagem } from './../model/Postagem';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from './../../environments/environment.prod';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { UserLogin } from '../model/UserLogin';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  idUsuario: number

  userLogin: UserLogin = new UserLogin()

  postagem: Postagem = new Postagem()
  listaPostagens: Postagem[]
  tituloPost: string
  
  tema: Tema = new Tema()
  listaTemas: Tema[]
  idTema: number
  nomeTema: string

  user: User = new User()
  idUser = environment.id

  key = 'data'
  reverse = true

  foto = environment.foto
  nome = environment.nome
  email = environment.email
  bio = environment.bio

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private postagemService: PostagemService,
    private temaService: TemaService,
    public authService: AuthService
  ) { }

  ngOnInit() {
    window.scroll(0,0)
    console.log('Atributos do environment: ')
    console.log(environment)

    if(environment.token == ''){
      this.router.navigate(['/menu'])
    }

    this.getAllTemas()
    this.getAllPostagens()
    
    this.idUsuario = this.route.snapshot.params['id']
    this.findByIdUser(this.idUsuario)
  }

  getAllTemas(){
    this.temaService.getAllTema().subscribe((resp: Tema[]) => {
      this.listaTemas = resp
    })
  }

  findByIdTema(){
    this.temaService.getByIdTema(this.idTema).subscribe((resp: Tema) =>{
      this.tema = resp
    })
  }

  getAllPostagens(){
    this.postagemService.getAllPostagens().subscribe((resp: Postagem[]) => {
      this.listaPostagens = resp
    })
  }

  findByIdUser(id: number){
    this.postagemService.getByIdUser(id).subscribe((resp: User) => {
      this.user = resp
      console.log(this.user);
      
    })
  }

  sair() {
    this.router.navigate( ['/menu'] )
    environment.token = ''
    environment.nome = ''
    environment.foto = ''
    environment.id = 0
    environment.bio = ''
    environment.email = ''
  }

}

