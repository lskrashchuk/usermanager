export class User {
  id: number;
  name: string = '';
  isActive: boolean = true;


  constructor( values: Object = {} )
  {
    Object.assign( this, values );
  }
}
