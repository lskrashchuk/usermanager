import {Authority} from "./authority";
export class User {
  id: number;
  name: string = '';
  username: string = '';
  password: string = '';
  isActive: boolean = true;
  authorities: Authority[];
  token: string;

  constructor(username: string, password: string) {
    this.username = username;
    this.password = password;
  }
}
