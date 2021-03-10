/* eslint-disable */
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerQueryPageComponent } from './answer-query-page.component';

describe('AnswerQueryPageComponent', () => {
  let component: AnswerQueryPageComponent;
  let fixture: ComponentFixture<AnswerQueryPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnswerQueryPageComponent]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswerQueryPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
