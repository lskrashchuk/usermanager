import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { User } from './user';
import { UserService } from './user.service';

@Component({
  moduleId: module.id.toString(),
  selector: 'app-user',
  templateUrl: 'user-app.component.html',
  styleUrls: ['./user-app.component.css'],

  providers: [ UserService ]
})

export class UserAppComponent
{
//  newUser: User = new User();

  users : User[] = [];
  loading = false;



  constructor( private userService: UserService, private router: Router ) {}

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
    this.userService.loadAll('/user').then(loadedUsers => this.users = loadedUsers);
  }

  logError(error: Error): void {
    this.loading = false;
    console.error('There was an error: ' + error.message ? error.message : error.toString());
    this.router.navigate(['/']);
  }
}

