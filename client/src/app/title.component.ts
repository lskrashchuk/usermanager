import { Component, OnInit } from '@angular/core';
import { UserService } from './user/user.service';
import { User } from './user/user';

@Component({
  selector: 'app-title',
  //template: '<h1>Всего пользователей: <strong>{{users.length}}</strong></h1>',
  templateUrl: 'title.component.html',
  providers: [ UserService ]
})
export class TitleComponent implements OnInit{

  users : User[] = [];

  constructor( private userService: UserService ) {}

  ngOnInit(): void
  {
    this.loadUsers();
  }


  loadUsers(): void
  {
    this.userService.getAllUsers().then(loadedUsers => this.users = loadedUsers);
  }

}
