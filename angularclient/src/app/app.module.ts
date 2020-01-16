import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {UsuarioService} from "./service/user-service.service";
import { ClienteListComponent } from './cliente-list/cliente-list.component';
import {ClienteService} from "./service/cliente.service";
import { ClienteFormComponent } from './cliente-form/cliente-form.component';
import {IConfig, NgxMaskModule} from "ngx-mask";
import { LoginComponent } from './login/login.component';
import {AuthService} from "./service/auth.service";
import { LogoutComponent } from './logout/logout.component';
import {NgbPaginationModule} from "@ng-bootstrap/ng-bootstrap";

export var options: Partial<IConfig> | (() => Partial<IConfig>);

@NgModule({
  declarations: [
    AppComponent,
    ClienteListComponent,
    ClienteFormComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgxMaskModule.forRoot(options),
    ReactiveFormsModule,
    NgbPaginationModule,
  ],
  providers: [UsuarioService, ClienteService, AuthService],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
