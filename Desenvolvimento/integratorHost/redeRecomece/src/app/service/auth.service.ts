import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/User';
import { UserLogin } from './../model/UserLogin';
import { environment } from 'src/environments/environment.prod';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  entrar(userLogin: UserLogin): Observable<UserLogin> {
    return this.http.post<UserLogin>('https://rederecomece.com.br/usuarios/logar', userLogin)
  }
  
   cadastrar(user: User):Observable<User>{
   return this.http.post<User>('https://rederecomece.com.br/usuarios/cadastrar', user)
   }

   logado(){
    let ok: boolean = false

    if(environment.token != ''){
      ok= true
    }

    return ok
  }
   

}