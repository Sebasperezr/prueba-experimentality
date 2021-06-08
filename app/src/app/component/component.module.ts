import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProductsMostWantedComponent } from './products-most-wanted/products-most-wanted.component';
import { SlideComponent } from './slide/slide.component';

@NgModule({
  declarations: [
    FooterComponent,
    NavBarComponent,
    HeaderComponent,
    SlideComponent,
    ProductsMostWantedComponent,
  ],
  imports: [CommonModule],
  exports: [
    FooterComponent,
    NavBarComponent,
    HeaderComponent,
    SlideComponent,
    ProductsMostWantedComponent,
  ],
})
export class ComponentModule {}
