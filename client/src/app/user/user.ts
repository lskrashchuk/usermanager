import {Authority} from "./authority";
export class User {
  id: number;
  name: string = '';
  email: string = '';
  password: string = '';
  isActive: boolean = true;
  authorities: Authority[];
  token: string;

  constructor(username: string, password: string) {
    this.email = username;
    this.password = password;
  }
}
