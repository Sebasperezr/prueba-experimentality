import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';
import { SearhcService } from './../../services/components/searhc.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
})
export class SearchComponent implements OnInit {
  constructor(
    private productService: ProductService,
    private route: Router,
    private searhcService: SearhcService
  ) {}
  criterial: any;
  ngOnInit(): void {}

  findProduct() {
    this.productService.searhc(this.criterial).subscribe(
      (data: any) => {
        this.searhcService.searhc(data);
        this.navigate('resultSearch');
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  navigate(route: string) {
    this.route.navigateByUrl(route);
  }
}
