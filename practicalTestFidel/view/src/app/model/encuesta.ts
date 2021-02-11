import {Marca} from "./marca";

export interface Encuesta {

  id: number;
  documento: string;
  email: string;
  comentarios: string;
  marca: Marca;
  fecha: number;
  usuario: number;

}
