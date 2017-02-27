import { NgModule }      from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent }  from './app.component';
import { TitleComponent }  from './title.component';
import { UserAppComponent }  from './user-app.component';

@NgModule({
  imports:      [ BrowserModule, FormsModule ],
  declarations: [ AppComponent, TitleComponent, UserAppComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
