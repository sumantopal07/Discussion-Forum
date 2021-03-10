import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestiontopiclistComponent } from './questiontopiclist.component';

describe('QuestiontopiclistComponent', () => {
  let component: QuestiontopiclistComponent;
  let fixture: ComponentFixture<QuestiontopiclistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuestiontopiclistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestiontopiclistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
