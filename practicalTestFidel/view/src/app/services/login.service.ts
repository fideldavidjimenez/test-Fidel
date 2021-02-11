import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';
import {Observable} from "rxjs";

const baseUrl = 'http://localhost:8080/api/';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {

  }

  login(data): Observable<any> {

    return this.http.post(baseUrl + 'login', data);

  }

  logout() {
    sessionStorage.removeItem("usuario");
    sessionStorage.removeItem("idUsuario");
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("usuario");

    return user != null;

  }

}
