import {Component, OnInit} from '@angular/core';
import {PessoaService} from "../service/pessoa.service";
import {Pessoa} from "../model/pessoa";
import {Router} from "@angular/router";

@Component({
  selector: 'app-pessoa-list',
  templateUrl: './pessoa-list.component.html',
  styleUrls: ['./pessoa-list.component.css']
})
export class PessoaListComponent implements OnInit {

  pessoas: Pessoa[];
  page: number;
  pageSize: number;
  length: number;

  constructor(private pessoaService: PessoaService) {
    this.page = 1;
    this.pageSize = 10;
  }

  ngOnInit() {
    this.pessoaService.findAll().subscribe(data => {
      this.pessoas = data;
      this.length = 100
    });
  }

  editar(id: string) {

  }

  excluir(id: string) {
    this.pessoaService.delete(id);
    // location.reload();
  }

}
