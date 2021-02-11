import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const baseUrl = 'http://localhost:8080/api/';

@Injectable({
  providedIn: 'root'
})
export class EncuestasService {

  constructor(private http: HttpClient) {
  }

  getAll(idUsuario): Observable<any> {
    return this.http.get(baseUrl + 'encuestas/usuario/' + idUsuario);
  }

  getMarcas(): Observable<any> {
    return this.http.get(baseUrl + 'marcas');
  }

  get(id): Observable<any> {
    return this.http.get(baseUrl + 'encuestas/' + id);
  }

  create(data): Observable<any> {
    return this.http.post(baseUrl + 'encuestas', data);
  }

  delete(id): Observable<any> {
    return this.http.delete(baseUrl + 'encuestas/' + id);
  }

}
