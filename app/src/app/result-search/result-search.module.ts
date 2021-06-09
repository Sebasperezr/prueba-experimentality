import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ComponentModule } from './../component/component.module';
import { ResultSearchRoutingModule } from './result-search-routing.module';
import { ResultSearchComponent } from './result-search.component';

@NgModule({
  declarations: [ResultSearchComponent],
  imports: [CommonModule, ComponentModule, ResultSearchRoutingModule],
})
export class ResultSearchModule {}
