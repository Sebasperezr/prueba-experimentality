import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';
import { Page } from './../models/base/page';
import { productModel } from './../models/productModel';
import { BaseService } from './core/base.service';

@Injectable({
  providedIn: 'root',
})
export class ProductService extends BaseService<productModel> {
  url = environment.api;

  constructor(http: HttpClient) {
    super(http);
    this.path = 'product';
  }
  listMostWanted() {
    let url = environment.api + 'search?category=MCO1430';
    return this.http.get<Page<any>>(url);
  }
  searhc(criterial: string) {
    let url = environment.api + 'search?q=' + criterial;
    return this.http.get<Page<any>>(url);
  }
}
