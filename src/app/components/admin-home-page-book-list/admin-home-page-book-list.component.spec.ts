import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminHomePageBookListComponent } from './admin-home-page-book-list.component';

describe('AdminHomePageBookListComponent', () => {
  let component: AdminHomePageBookListComponent;
  let fixture: ComponentFixture<AdminHomePageBookListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminHomePageBookListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminHomePageBookListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
