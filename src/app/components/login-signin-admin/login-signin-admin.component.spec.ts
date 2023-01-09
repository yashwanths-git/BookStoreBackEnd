import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginSigninAdminComponent } from './login-signin-admin.component';

describe('LoginSigninAdminComponent', () => {
  let component: LoginSigninAdminComponent;
  let fixture: ComponentFixture<LoginSigninAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginSigninAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginSigninAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
