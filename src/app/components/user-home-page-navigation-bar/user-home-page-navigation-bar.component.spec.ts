import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomePageNavigationBarComponent } from './user-home-page-navigation-bar.component';

describe('UserHomePageNavigationBarComponent', () => {
  let component: UserHomePageNavigationBarComponent;
  let fixture: ComponentFixture<UserHomePageNavigationBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserHomePageNavigationBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserHomePageNavigationBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
