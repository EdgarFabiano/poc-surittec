import { Component, OnInit } from '@angular/core';
import {AuthService} from "../service/auth.service";
import {Router} from "@angular/router";
import {Constants} from "../util/constants";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(authService: AuthService, router: Router) {
    authService.logout();
    router.navigate(['/' + Constants.LOGIN]);
  }

  ngOnInit() {
  }

}
