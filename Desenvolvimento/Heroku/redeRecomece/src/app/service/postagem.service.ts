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
    return this.http.get<Postagem[]>('https://recomece.herokuapp.com/post', this.token)
  }

  getByIdPostagem(id: number): Observable<Postagem> {
    return this.http.get<Postagem>(`https://recomece.herokuapp.com/post/${id}`, this.token)
  }

  postPostagem(postagem: Postagem) : Observable<Postagem>{
    return this.http.post<Postagem>('https://recomece.herokuapp.com/post', postagem, this.token)
  }

  getByIdUser(id: number): Observable<User> {
    return this.http.get<User>(`https://recomece.herokuapp.com/usuarios/${id}`, this.token)
  }

  putPostagem(postagem: Postagem): Observable<Postagem> {
    return this.http.put<Postagem> ('https://recomece.herokuapp.com/post', postagem, this.token)
  }

  deletePostagem(id: number) {
    return this.http.delete(`https://recomece.herokuapp.com/post/${id}`)
  }
}
