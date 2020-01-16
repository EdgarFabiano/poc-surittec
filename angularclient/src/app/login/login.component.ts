import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from "../service/auth.service";
import {Constants} from "../util/constants";
import {Usuario} from "../model/usuario";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  model: Usuario;
  message: string;

  constructor(private router: Router, public authService: AuthService) {
    this.model = new Usuario();
  }

  login() {
    var promise = this.authService.authenticate(this.model.login, this.model.senha);

    promise.then(authenticated => {
      if(authenticated){
        this.router.navigate(['/' + Constants.LISTAGEM_PESSOAS]);
      }
      else{
        this.message = "Usuário e senha não encontrados";
      }
    });

  }

}
