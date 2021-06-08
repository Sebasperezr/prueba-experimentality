import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsMostWantedComponent } from './products-most-wanted.component';

describe('ProductsMostWantedComponent', () => {
  let component: ProductsMostWantedComponent;
  let fixture: ComponentFixture<ProductsMostWantedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductsMostWantedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsMostWantedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
