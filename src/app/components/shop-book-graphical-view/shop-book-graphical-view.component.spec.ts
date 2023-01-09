import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopBookGraphicalViewComponent } from './shop-book-graphical-view.component';

describe('ShopBookGraphicalViewComponent', () => {
  let component: ShopBookGraphicalViewComponent;
  let fixture: ComponentFixture<ShopBookGraphicalViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShopBookGraphicalViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShopBookGraphicalViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
