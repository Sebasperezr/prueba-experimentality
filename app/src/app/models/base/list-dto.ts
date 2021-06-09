export class ListDTO<T> {
  page;
  size;
  sort: any;
  direction: any;
  from: any;
  to: any;
  deleted: any;
  filter: T;

  constructor() {
    this.page = 0;
    this.size = 3000;
  }
}
