import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {LoginService} from "../../services/login.service";
import {Usuario} from "../../model/usuario";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  errorMessage = 'Datos inválidos';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;

  constructor(private route: ActivatedRoute, private router: Router, private loginService: LoginService) {
  }

  ngOnInit() {
    this.invalidLogin = false;
    this.loginSuccess = false;

    this.loginService.logout();
  }

  login() {

    this.loginService.login({usuario: this.username, contrasena: this.password}).subscribe((result) => {
      console.log(result);

      if (result != null && result > -1) {
        this.invalidLogin = false;
        this.loginSuccess = true;
        this.successMessage = 'Inicio de sesión correcto';
        this.router.navigate(['/home']);
        sessionStorage.setItem("usuario", this.username);
        sessionStorage.setItem("idUsuario", result);
      } else {
        this.invalidLogin = true;
        this.loginSuccess = false;
      }
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
  }

}
