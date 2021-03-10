import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerlistComponent } from './answerlist.component';

describe('AnswerlistComponent', () => {
  let component: AnswerlistComponent;
  let fixture: ComponentFixture<AnswerlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnswerlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswerlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
