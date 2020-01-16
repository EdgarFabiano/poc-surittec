import {Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ClienteService} from "../service/cliente.service";
import {Constants} from "../util/constants";
import {Cliente} from "../model/cliente";
import {AuthService} from "../service/auth.service";
import {UsuarioService} from "../service/user-service.service";
import {Usuario} from "../model/usuario";
import {Perfil} from "../model/perfil";

@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css']
})
export class ClienteFormComponent {

  cliente: Cliente;

  constructor(private route: ActivatedRoute, private router: Router,
              private clienteService: ClienteService) {

    let id = null;
    this.cliente = new Cliente();
    route.params.subscribe(value => id = value.id);
    clienteService.find(id).subscribe(c => this.cliente = c);
  }


  onSubmit() {
    this.clienteService.save(this.cliente).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/' + Constants.LISTAGEM_CLIENTES]);
  }

}
