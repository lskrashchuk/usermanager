import { NgModule }      from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent }  from './app.component';
import { TitleComponent }  from './title.component';
import { UserAppComponent }  from './user/user-app.component';

import '@angular/common';

const appRoutes:Routes = [
  {path: 'home', component: AppComponent},
];

@NgModule({
  imports:      [ BrowserModule, FormsModule, HttpModule, RouterModule.forRoot(appRoutes) ],
  declarations: [ AppComponent, TitleComponent, UserAppComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
