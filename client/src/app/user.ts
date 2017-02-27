export class User {
  id: number;
  firstName: string = '';
  isActive: boolean = true;

  constructor( values: Object = {} )
  {
    Object.assign( this, values );
  }
}
