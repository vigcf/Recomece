import { Component, OnInit } from '@angular/core';
import { Postagem } from '../model/Postagem';
import { PostagemService } from '../service/postagem.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {


  listaPostagens: Postagem[]
  
  constructor(
    private postagemService: PostagemService
  ) { }

  ngOnInit() {

    this.getAllPostagens()
  }

  getAllPostagens() {
    this.postagemService.getAllPostagens().subscribe((resp: Postagem[]) =>{
      this.listaPostagens = resp
    })
  }

}
