import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBookButComponent } from './update-book-but.component';

describe('UpdateBookButComponent', () => {
  let component: UpdateBookButComponent;
  let fixture: ComponentFixture<UpdateBookButComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateBookButComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateBookButComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
