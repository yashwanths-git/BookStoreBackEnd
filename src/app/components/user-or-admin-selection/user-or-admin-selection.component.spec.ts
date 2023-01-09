import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserOrAdminSelectionComponent } from './user-or-admin-selection.component';

describe('UserOrAdminSelectionComponent', () => {
  let component: UserOrAdminSelectionComponent;
  let fixture: ComponentFixture<UserOrAdminSelectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserOrAdminSelectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserOrAdminSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
