import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Postagem } from '../model/Postagem';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class PostagemService {

  constructor(private http: HttpClient) { }
  
  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  getAllPostagens(): Observable<Postagem[]>{
    return this.http.get<Postagem[]>('https://rederecomece.com.br/post', this.token)
  }

  getByIdPostagem(id: number): Observable<Postagem> {
    return this.http.get<Postagem>(`https://rederecomece.com.br/post/${id}`, this.token)
  }

  postPostagem(postagem: Postagem) : Observable<Postagem>{
    return this.http.post<Postagem>('https://rederecomece.com.br/post', postagem, this.token)
  }

  getByIdUser(id: number): Observable<User> {
    return this.http.get<User>(`https://rederecomece.com.br/usuarios/${id}`, this.token)
  }

  putPostagem(postagem: Postagem): Observable<Postagem> {
    return this.http.put<Postagem> ('https://rederecomece.com.br/post', postagem, this.token)
  }

  deletePostagem(id: number) {
    return this.http.delete(`https://rederecomece.com.br/post/${id}`)
  }
}
