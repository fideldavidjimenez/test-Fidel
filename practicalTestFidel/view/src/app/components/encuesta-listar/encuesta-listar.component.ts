import {Component, OnInit} from '@angular/core';
import {EncuestasService} from "../../services/encuestas.service";
import {Marca} from "../../model/marca";
import {Encuesta} from "../../model/encuesta";
import {Router} from "@angular/router";
import {LoginService} from "../../services/login.service";

@Component({
  selector: 'app-encuesta-listar',
  templateUrl: './encuesta-listar.component.html',
  styleUrls: ['./encuesta-listar.component.css']
})
export class EncuestaListarComponent implements OnInit {

  marcas: Marca[];
  encuestas: Encuesta[];
  encuestaSeleccionada: Encuesta;

  constructor(private router: Router, private encuestasService: EncuestasService, private loginService: LoginService) {
  }

  ngOnInit(): void {
    if (!this.loginService.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }

    this.consultarEncuestas();
  }

  consultarEncuestas(): void {
    this.encuestasService.getAll(1)
      .subscribe(
        data => {
          this.encuestas = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  setEncuesta(encuesta: Encuesta): void {
    this.encuestaSeleccionada = encuesta;
    console.log(encuesta);
  }

  eliminarEncuesta(encuesta: Encuesta): void {
    this.encuestasService.delete(encuesta.id)
      .subscribe(
        response => {
          console.log(response);
          this.consultarEncuestas();
          this.encuestaSeleccionada = null;
        },
        error => {
          console.log(error);
        });
  }

}
