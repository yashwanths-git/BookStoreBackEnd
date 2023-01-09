import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomePageDashBoardComponent } from './home-page-dash-board.component';

describe('HomePageDashBoardComponent', () => {
  let component: HomePageDashBoardComponent;
  let fixture: ComponentFixture<HomePageDashBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomePageDashBoardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomePageDashBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
