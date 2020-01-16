import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ClienteListComponent} from "./cliente-list/cliente-list.component";
import {ClienteFormComponent} from "./cliente-form/cliente-form.component";
import {LoginComponent} from "./login/login.component";
import {Constants} from "./util/constants";
import {LogoutComponent} from "./logout/logout.component";

const routes: Routes = [
  { path: Constants.LISTAGEM_CLIENTES, component: ClienteListComponent },
  { path: Constants.FORM_CLIENTE, component: ClienteFormComponent },
  { path: Constants.FORM_CLIENTE + '/:id', component: ClienteFormComponent } ,
  { path: Constants.LOGIN, component: LoginComponent },
  { path: Constants.LOGOUT, component: LogoutComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
