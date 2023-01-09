import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserMyProfileComponent } from './user-my-profile.component';

describe('UserMyProfileComponent', () => {
  let component: UserMyProfileComponent;
  let fixture: ComponentFixture<UserMyProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserMyProfileComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserMyProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
