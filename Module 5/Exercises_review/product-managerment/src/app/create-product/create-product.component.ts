import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Product} from "../product";

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  @Output('createProduct') creatProducts = new EventEmitter<Product>();
  public place: string[] = ["Trung Quốc", "Mỹ", "Việt Nam", "Anh"];
  public tempplace: string;

  constructor() {
  }

  ngOnInit(): void {
  }

  create(name: string, price: string, dayOfManufacture: string, quantity: string, origin: string) {

    let product: Product = new Product(name, parseInt(price), dayOfManufacture, parseInt(quantity), origin);
    this.creatProducts.emit(product);
  }

  choosePlace(value: string) {
    this.tempplace = value;
  }
}
