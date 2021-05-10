export class Bar {
  private _value: number;
  private _active: boolean;

  constructor(value: number, active: boolean) {
    this._value = value;
    this._active = active;
  }

  get value(): number {
    return this._value;
  }

  set value(value: number) {
    this._value = value;
  }

  get active(): boolean {
    return this._active;
  }

  set active(value: boolean) {
    this._active = value;
  }
}
