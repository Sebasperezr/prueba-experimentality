import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.scss'],
})
export class ProductCardComponent implements OnInit {
  @Input() product: any;
  constructor() {}

  ngOnInit(): void {}

  onPromotion() {
    let result = false;
    this.product.tags.forEach((element: any) => {
      if (element == 'loyalty_discount_eligible') result = true;
    });
    return result;
  }
  priceDiscount(): any {
    let result = '';
    this.product.prices.prices.forEach((element: any) => {
      if (element.type == 'promotion') result = element.amount;
    });
    return result;
  }
}
