import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserMyOrdersPageComponent } from './user-my-orders-page.component';

describe('UserMyOrdersPageComponent', () => {
  let component: UserMyOrdersPageComponent;
  let fixture: ComponentFixture<UserMyOrdersPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserMyOrdersPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserMyOrdersPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
