import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ComponentModule } from './../component/component.module';
import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';

@NgModule({
  declarations: [HomeComponent],
  imports: [CommonModule, ComponentModule, HomeRoutingModule],
})
export class HomeModule {}
