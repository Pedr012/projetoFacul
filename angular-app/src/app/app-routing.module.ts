import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultasAtivasComponent } from './consultas-ativas/consultas-ativas.component';
import { PginicialComponent } from './pginicial/pginicial.component';
import { TelaLoginComponent } from './tela-login/tela-login.component';
import { ConsultComponent } from './template/consult/consult.component';
import { RegisterComponent } from './template/register/register.component';

const routes: Routes = [
  { path: '', component: PginicialComponent },
  { path: 'login', component: TelaLoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'consultAtv', component: ConsultasAtivasComponent },
  { path: 'consultas', component: ConsultComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
