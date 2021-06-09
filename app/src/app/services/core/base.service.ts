import { HttpClient } from '@angular/common/http';
import { environment } from './../../../environments/environment';
import { Page } from './../../models/base/page';
export class BaseService<T> {
  path: any;

  constructor(protected http: HttpClient) {}

  save(item: any) {
    let url = environment.api + this.path;
    return this.http.put<T>(url, item);
  }

  list(params: any) {
    let url = environment.api + this.path;
    return this.http.post<Page<T>>(url, params);
  }

  delete(id: any) {
    let url = environment.api + this.path + '/' + id;
    return this.http.delete(url);
  }

  find(id: any) {
    let url = environment.api + this.path + '/' + id;
    return this.http.get<T>(url);
  }
}
