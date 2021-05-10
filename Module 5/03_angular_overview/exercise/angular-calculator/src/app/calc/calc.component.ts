import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-calc',
  templateUrl: './calc.component.html',
  styleUrls: ['./calc.component.css']
})
export class CalcComponent implements OnInit {
  public result: number;

  constructor() { }

  ngOnInit(): void {
  }
  public calculator(num1: string, num2: string, calc: string){
    let a:number = parseInt(num1);
    let b:number = parseInt(num2);

    switch (calc) {
      case 'Addition(+)':
        return this.result = a + b;
      case 'Subtraction(-)':
        return this.result = a - b;
      case 'Multiplication(x)':
        return this.result = a * b;
      default:
        return this.result = a / b;
    }
  }
}
