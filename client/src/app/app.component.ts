import { Component } from '@angular/core';


@Component({
  selector: 'my-app',
  template:
    `<h1>Hello {{name}}</h1>
     <app-title></app-title>
     <app-user></app-user>`
})
export class AppComponent  {
  name = 'Angular';
}
