import { NgModule }      from '@angular/core';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';
import {AuthorizationComponent} from "./authorization/authorization.component";
import {AuthorizationService} from "./authorization/authorization.service";


import { AppComponent }  from './app.component';
import { TitleComponent }  from './title.component';
import { UserAppComponent }  from './user/user-app.component';

import '@angular/common';
import {SecurityService} from "./security/security.service";


const appRoutes: Routes = [
  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: 'login', component: AuthorizationComponent},
];

@NgModule({
  imports:      [ BrowserModule, FormsModule, ReactiveFormsModule, HttpModule, RouterModule.forRoot(appRoutes) ],
  declarations: [ AppComponent, TitleComponent, UserAppComponent, AuthorizationComponent ],
  bootstrap:    [ AppComponent ],
  providers:    [ AuthorizationService, SecurityService ],
})



export class AppModule { }
