import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Pessoa} from "../model/pessoa";
import {Constants} from "../util/constants";

@Injectable()
export class PessoaService {


  constructor(private http: HttpClient) {
  }

  public findAll(): Observable<Pessoa[]> {
    return this.http.get<Pessoa[]>(Constants.PESSOAS_ENDPOINT);
  }

  public save(pessoa: Pessoa) {
    return this.http.post<Pessoa>(Constants.PESSOAS_ENDPOINT, pessoa);
  }

  public delete(pessoaId: string) {
    const url = `${Constants.PESSOAS_ENDPOINT}/${pessoaId}`;
    this.http.delete(url).subscribe();
  }

}
