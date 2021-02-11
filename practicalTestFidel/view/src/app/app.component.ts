import {Component} from '@angular/core';
import {LoginService} from "./services/login.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'view';

  constructor(private loginService: LoginService) {
  }

  isUserLoggedIn() {
    return this.loginService.isUserLoggedIn();
  }
}
