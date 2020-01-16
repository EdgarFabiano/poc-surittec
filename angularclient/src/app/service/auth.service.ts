import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Constants} from "../util/constants";

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) {
  }

  authenticate(usuario, senha): Promise<boolean> {
    const url = `${Constants.AUTH_ENDPOINT}?usuario=${usuario}&senha=${senha}`;
    let promise = this.http.get<boolean>(url).toPromise();
    promise.then(res=> {
      if (res) {
        console.log("Login successful");
        Constants.APP_COMPONENT.logged = usuario;
        localStorage.setItem('isLoggedIn', 'true');
        localStorage.setItem('user', usuario);
      } else {
        localStorage.setItem('isLoggedIn', 'false');
      }
      Constants.APP_COMPONENT.authenticated = res;
      return res;
    });

    return promise;
  }

  logout(): void {
    Constants.APP_COMPONENT.authenticated = false;
    localStorage.setItem('isLoggedIn', 'false');
  }

  isAuthenticated(): boolean {
    return 'true' === (localStorage.getItem('isLoggedIn'));
  }

  getLogged(): string {
    return localStorage.getItem('user');
  }

}
