import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { UserService } from './user.service';

@Component({
  moduleId: module.id.toString(),
  selector: 'app-user',
  templateUrl: 'user-app.component.html',
  styleUrls: ['user-app.component.css'],

  providers: [ UserService ]
})

export class UserAppComponent
{
  newUser: User = new User();

  constructor( private userService: UserService ) {}

  toggleUserActive( user:User )
  {
    this.userService.toggleUserActive( user );
  }

  addUser()
  {
    this.userService.addUser( this.newUser );
    this.newUser = new User();
  }

  removeUser( user:User )
  {
    this.userService.deleteUserById( user.id );
  }

  get users()
  {
    return this.userService.getAllUsers();
  }
}

