import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';

@Component({
  selector: 'app-title',
  template: '<h1>Всего пользователей: <strong>{{users.length}}</strong></h1>',
  providers: [ UserService ]
})
export class TitleComponent {

  constructor( private userService: UserService ) {}


  get users()
  {
    return this.userService.getAllUsers();
  }

}
