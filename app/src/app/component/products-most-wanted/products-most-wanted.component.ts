import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products-most-wanted',
  templateUrl: './products-most-wanted.component.html',
  styleUrls: ['./products-most-wanted.component.scss'],
})
export class ProductsMostWantedComponent implements OnInit {
  products = [];
  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    console.log('init');

    this.listOffererAuctions();
  }

  listOffererAuctions() {
    this.productService.listMostWanted().subscribe(
      (data) => {
        this.products = data.results;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
