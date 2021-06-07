import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';

@NgModule({
  declarations: [FooterComponent, NavBarComponent, HeaderComponent],
  imports: [CommonModule],
  exports: [FooterComponent, NavBarComponent, HeaderComponent],
})
export class ComponentModule {}
