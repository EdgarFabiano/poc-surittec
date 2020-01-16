import {Component, OnInit} from '@angular/core';
import {ClienteService} from "../service/cliente.service";
import {Cliente} from "../model/cliente";
import {Router} from "@angular/router";
import {Constants} from "../util/constants";

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css']
})
export class ClienteListComponent implements OnInit {

  clientes: Cliente[];
  page: number;
  pageSize: number;
  length: number;

  constructor(private clienteService: ClienteService, private router: Router) {
    this.page = 1;
    this.pageSize = 10;
  }

  ngOnInit() {
    this.clienteService.findAll().subscribe(data => {
      this.clientes = data;
      this.length = 100
    });
  }

  editar(id: string) {
    this.gotoForm(id);
  }

  gotoForm(id: string) {
    this.router.navigate([`/${Constants.FORM_CLIENTE}/${id}`]);
  }

  excluir(id: string) {
    this.clienteService.delete(id);
    location.reload();
  }

}
