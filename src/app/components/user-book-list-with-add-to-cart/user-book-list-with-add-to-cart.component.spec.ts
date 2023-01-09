import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserBookListWithAddToCartComponent } from './user-book-list-with-add-to-cart.component';

describe('UserBookListWithAddToCartComponent', () => {
  let component: UserBookListWithAddToCartComponent;
  let fixture: ComponentFixture<UserBookListWithAddToCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserBookListWithAddToCartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserBookListWithAddToCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
