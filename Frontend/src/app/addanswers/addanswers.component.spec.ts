import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddanswersComponent } from './addanswers.component';

describe('AddanswersComponent', () => {
  let component: AddanswersComponent;
  let fixture: ComponentFixture<AddanswersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddanswersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddanswersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
