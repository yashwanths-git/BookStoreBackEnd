import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfOrdersUserComponent } from './list-of-orders-user.component';

describe('ListOfOrdersUserComponent', () => {
  let component: ListOfOrdersUserComponent;
  let fixture: ComponentFixture<ListOfOrdersUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListOfOrdersUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListOfOrdersUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
