import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderRecieptComponent } from './order-reciept.component';

describe('OrderRecieptComponent', () => {
  let component: OrderRecieptComponent;
  let fixture: ComponentFixture<OrderRecieptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderRecieptComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderRecieptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
