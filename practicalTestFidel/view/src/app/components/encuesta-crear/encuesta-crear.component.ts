import {Component, OnInit} from '@angular/core';
import {Marca} from "../../model/marca";
import {Encuesta} from "../../model/encuesta";
import {EncuestasService} from "../../services/encuestas.service";
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-encuesta-crear',
  templateUrl: './encuesta-crear.component.html',
  styleUrls: ['./encuesta-crear.component.css']
})
export class EncuestaCrearComponent implements OnInit {

  marcas: Marca[];
  encuesta: Encuesta;
  creado: boolean;

  constructor(private router: Router, private encuestasService: EncuestasService, private loginService: LoginService) {
  }

  ngOnInit(): void {

    if (!this.loginService.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }

    this.creado = false;
    this.consultarMarcas();
    this.iniciarEncuesta();
  }

  guardarEncuesta(): void {
    this.encuesta.usuario = Number(sessionStorage.getItem("idUsuario"));
    this.encuestasService.create(this.encuesta)
      .subscribe(
        response => {
          console.log(response);
          this.creado = true;
        },
        error => {
          console.log(error);
        });
  }

  iniciarEncuesta(): void {
    this.creado = false;
    this.encuesta = {
      id: null,
      documento: '',
      email: '',
      comentarios: '',
      marca: {id: null, nombre: ''},
      fecha: null,
      usuario: null
    };
  }

  consultarMarcas(): void {
    this.encuestasService.getMarcas()
      .subscribe(
        data => {
          this.marcas = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}
