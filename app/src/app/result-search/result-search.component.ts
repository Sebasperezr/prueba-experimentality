import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { SearhcService } from './../services/components/searhc.service';

@Component({
  selector: 'app-result-search',
  templateUrl: './result-search.component.html',
  styleUrls: ['./result-search.component.scss'],
})
export class ResultSearchComponent implements OnInit, OnDestroy {
  constructor(private searhcService: SearhcService) {}
  subscriptions: Array<Subscription> = [];
  products = [];
  ngOnInit(): void {
    this.getResult();
  }

  getResult() {
    let subs = this.searhcService.getObservable().subscribe(
      (data: any) => {
        this.products = this.searhcService.getValue().results;
      },
      (error) => {
        console.log(error);
      }
    );
    this.subscriptions.push(subs);
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach((element) => {
      element.unsubscribe();
    });
  }
}
