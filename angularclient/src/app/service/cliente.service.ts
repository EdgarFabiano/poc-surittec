import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cliente} from "../model/cliente";
import {Constants} from "../util/constants";

@Injectable()
export class ClienteService {


  constructor(private http: HttpClient) {
  }

  public findAll(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(Constants.CLIENTES_ENDPOINT);
  }

  public find(id: string): Observable<Cliente> {
    return this.http.get<Cliente>(`${Constants.CLIENTE_ENDPOINT}/${id}`);
  }

  public save(cliente: Cliente) {
    return this.http.post<Cliente>(Constants.CLIENTES_ENDPOINT, cliente);
  }

  public delete(clienteId: string) {
    const url = `${Constants.CLIENTES_ENDPOINT}/${clienteId}`;
    this.http.delete(url).subscribe();
  }

}
