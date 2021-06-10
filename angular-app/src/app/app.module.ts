import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { RegisterComponent } from './template/register/register.component';
import { ConsultComponent } from './template/consult/consult.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PginicialComponent } from './pginicial/pginicial.component';
import { TelaLoginComponent } from './tela-login/tela-login.component';
import { ConsultasAtivasComponent } from './consultas-ativas/consultas-ativas.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    ConsultComponent,
    NavbarComponent,
    PginicialComponent,
    TelaLoginComponent,
    ConsultasAtivasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {}
