import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateOrderUserComponent } from './create-order-user.component';

describe('CreateOrderUserComponent', () => {
  let component: CreateOrderUserComponent;
  let fixture: ComponentFixture<CreateOrderUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateOrderUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateOrderUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
