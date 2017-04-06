import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { UserService } from './user.service';

@Component({
  moduleId: module.id.toString(),
  selector: 'app-user',
  templateUrl: 'user-app.component.html',

  providers: [ UserService ]
})

export class UserAppComponent
{
//  newUser: User = new User();

  users : User[] = [];

  constructor( private userService: UserService ) {}

  ngOnInit(): void
  {
    this.loadUsers();
  }

  toggleUserActive( user:User )
  {
    this.userService.toggleUserActive( user );
  }

/*
  addUser()
  {
    this.userService.addUser( this.newUser );
    this.newUser = new User();
  }
*/

  removeUser( user:User )
  {
    this.userService.deleteUserById( user.id );
  }

  loadUsers(): void
  {
    this.userService.getAllUsers().then(loadedUsers => this.users = loadedUsers);
  }
}

