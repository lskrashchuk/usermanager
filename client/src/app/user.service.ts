import { Injectable } from '@angular/core';
import { User } from './user';
import { Http, Response, Headers, RequestOptions } from "@angular/http";
import 'rxjs/add/operator/toPromise';

@Injectable()
export class UserService
{
  /*
   * Значение для последнего ИД,
   * с помощью которого, мы будем имитировать автоматическое увеличение ИД
   * */
  lastId: number = 4;

  /*
   * Массив, в котором будут храниться записи
   * */
  users: User[] = [];

  constructor(private http:Http) {}

  /*
   * Имитируем метод POST при обращении к /users
   * */
  addUser( user: User ): UserService
  {
    if( !user.name )
    {
      return;
    }

    if ( !user.id )
    {
      user.id = ++this.lastId;
    }

    this.users.push( user );

    return this;
  }
/*
  addUser(user: User) {
    return this.http.post(user, this.generateOptions())
      .map((response: Response) => response.status === 201)
      .catch(this.handleError);
  }
*/


  /*
   * Имитируем метод DELETE при обращении к /users/:id
   * */
  deleteUserById( id: number ): UserService
  {
    this.users = this.users
      .filter( user => user.id !== id );

    return this;
  }

  /*
   * Имитируем метод PUT при обращении к /users/:id
   * */
  updateUserById( id: number, values: Object = {} ): User
  {
    let user = this.getUserById( id );

    if ( !user )
    {
      return null;
    }

    Object.assign( user, values );

    return user;
  }

  /*
   * Имитируем метод GET при обращении к /users
   * */
/*
  getAllUsers(): User[]
  {
//    return this.users;
    return [{"id":1,"name":"Tatiana","isActive":true,"new":false},{"id":2,"name":"Marta","isActive":true,"new":false},{"id":3,"name":"Alex","isActive":true,"new":false},{"id":4,"name":"Igor","isActive":true,"new":false}];
  }
*/

  getAllUsers():Promise<User[]> {
    return this.http.get('users')
      .toPromise()
      .then(responce => responce.json())
      .catch(this.handleError);
  }

  private handleError(error:any):Promise<any> {
    console.error('Error', error);
    return Promise.reject(error.message || error);
  }


  /*
   * Имитируем метод GET при обращении к /users/:id
   * */
  getUserById( id: number ): User
  {
    return this.users
      .filter( user => user.id === id )
      .pop();
  }

  /*
   * Изменить статус записи
   * */
  toggleUserActive( user: User )
  {
    let updatedUser = this.updateUserById( user.id, {
      complete: !user.isActive
    } );

    return updatedUser;
  }
}
