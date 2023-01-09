import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomeBookListComponent } from './user-home-book-list.component';

describe('UserHomeBookListComponent', () => {
  let component: UserHomeBookListComponent;
  let fixture: ComponentFixture<UserHomeBookListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserHomeBookListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserHomeBookListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
