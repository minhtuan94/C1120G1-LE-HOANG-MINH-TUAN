import { Component, OnInit } from '@angular/core';
import {Product} from "../product";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  public productList : Product[] = [
    new Product("realme",10000000,'1995-05-12',20,"Trung Quốc"),
    new Product("Nokia", 15000000,'1824-05-03',8,"Mỹ"),
    new Product("Iphone3", 20000000,'1895-06-05',5,"Anh"),
    new Product("Iphone4", 25000000,'1985-07-01',12,"Anh"),
    new Product("Iphone5", 30000000,'1958-12-12',23,"Anh"),
    new Product("Vsmart", 35000000,'1987-04-06',0,"Việt Nam"),
  ];

  public product : Product;

  constructor() { }

  ngOnInit(): void {
  }

  showDetail(item: Product) {
    this.product = item;
  }

  getCreateProduct(value: Product) {
   this.productList.push(value);
  }
}
