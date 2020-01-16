import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {Usuario} from "../model/usuario";

@Injectable()
export class UsuarioService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:4200/usuarios';
  }

  public findAll(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.usersUrl);
  }

  public save(user: Usuario) {
    return this.http.post<Usuario>(this.usersUrl, user);
  }

}
