import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable()
export class UserService
{
  /*
   * Значение для последнего ИД,
   * с помощью которого, мы будем имитировать автоматическое увеличение ИД
   * */
  lastId: number = 0;

  /*
   * Массив, в котором будут храниться записи
   * */
  users: User[] = [];

  constructor() {}

  /*
   * Имитируем метод POST при обращении к /users
   * */
  addUser( user: User ): UserService
  {
    if( !user.firstName )
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
  getAllUsers(): User[]
  {
    return this.users;
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
