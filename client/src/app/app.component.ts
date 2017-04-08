import { Component } from '@angular/core';
import {AuthorizationService} from "./authorization/authorization.service";
import {Router} from "@angular/router";
import {User} from "./user/user";
import {SecurityService} from "./security/security.service";

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./main.css']})

export class AppComponent  {
  name: string;

  constructor(private router: Router, private authorizationService: AuthorizationService) {
  }

  public isLoggedIn(): boolean {
    const user: User = JSON.parse(localStorage.getItem("CURRENT_USER"));
    if (user) {
      this.name = user.username;
      return true;
    }
    return false;
  }

  logout(): void {
    this.name = null;
    this.authorizationService.logout();
    this.router.navigate(["/"]);
  }

  public canWorkWithUser():boolean {
    return SecurityService.hasAuthority("ROLE_ADMIN");
  }
}
