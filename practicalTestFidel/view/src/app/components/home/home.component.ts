import {Component, OnInit} from '@angular/core';
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private loginService: LoginService) {
  }

  ngOnInit(): void {

    if (!this.loginService.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }

  }

}
