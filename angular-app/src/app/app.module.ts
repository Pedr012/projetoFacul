import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { RegisterComponent } from './template/register/register.component';
import { CabecalhoComponent } from './cabecalho/cabecalho.component';
import { ConsultComponent } from './template/consult/consult.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    CabecalhoComponent,
    ConsultComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule],
  providers: [

  ],
  bootstrap: [
    AppComponent
  ],
})
export class AppModule { }
