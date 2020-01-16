import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/';
import {Usuario} from "../model/usuario";

@Injectable()
export class UsuarioService {

  private usersUrl: string;
  private userUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:4200/usuarios';
    this.userUrl = 'http://localhost:4200/usuario';
  }

  public findAll(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.usersUrl);
  }

  public findByUsername(username: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.userUrl}/${username}`);
  }

  public save(user: Usuario) {
    return this.http.post<Usuario>(this.usersUrl, user);
  }

}
