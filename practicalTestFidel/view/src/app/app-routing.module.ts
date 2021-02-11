import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {EncuestaListarComponent} from './components/encuesta-listar/encuesta-listar.component';
import {EncuestaCrearComponent} from "./components/encuesta-crear/encuesta-crear.component";
import {LoginComponent} from "./components/login/login.component";
import {HomeComponent} from "./components/home/home.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'encuestas', component: EncuestaListarComponent},
  {path: 'crear', component: EncuestaCrearComponent},
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'logout', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
