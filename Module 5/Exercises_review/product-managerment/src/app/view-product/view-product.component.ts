import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from "../product";

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

  @Input('productDetail') productDetails : Product;

  @Output('productEdit') productEdits = new EventEmitter<number>();
  constructor() { }

  ngOnInit(): void {
  }

}
