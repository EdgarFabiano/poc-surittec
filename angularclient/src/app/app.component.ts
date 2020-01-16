import { Component } from '@angular/core';
import {AuthService} from "./service/auth.service";
import {Constants} from "./util/constants";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title: string;
  public authenticated: boolean;
  public logged: string;

  constructor(authService: AuthService, private router: Router) {
    this.authenticated = authService.isAuthenticated();
    this.title = 'Avalição para seleção - Desenvolvedor júnior';
    this.logged = authService.getLogged();
    Constants.APP_COMPONENT = this;

    if (this.authenticated) {
      this.gotoUserList();
    } else {
      this.gotoLogin();
    }
  }

  gotoUserList() {
    this.router.navigate(['/' + Constants.LISTAGEM_CLIENTES]);
  }

  gotoLogin() {
    this.router.navigate(['/' + Constants.LOGIN]);
  }

}
