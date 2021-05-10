export class Product {
  private _name:string;
  private _price:number;
  private _dateOfManufacture:string;
  private _quantity: number;
  private _origin: string;

  constructor(name: string, price: number, dateOfManufacture: string, quantity: number, origin: string) {
    this._name = name;
    this._price = price;
    this._dateOfManufacture = dateOfManufacture;
    this._quantity = quantity;
    this._origin = origin;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }

  get dateOfManufacture(): string {
    return this._dateOfManufacture;
  }

  set dateOfManufacture(value: string) {
    this._dateOfManufacture = value;
  }

  get quantity(): number {
    return this._quantity;
  }

  set quantity(value: number) {
    this._quantity = value;
  }

  get origin(): string {
    return this._origin;
  }

  set origin(value: string) {
    this._origin = value;
  }
}
