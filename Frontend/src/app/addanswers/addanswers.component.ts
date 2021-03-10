/* eslint-disable import/no-unresolved */
/* eslint-disable no-unused-vars */
/* eslint-disable max-len */
/* eslint-disable no-useless-constructor */
/* eslint-disable no-empty-function */
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FormControl, FormGroup } from '@angular/forms';
import { AnswerlistComponent } from '../answerlist/answerlist.component';
import { AnswerService } from '../answer.service';
import { QuestionService } from '../question.service';

@Component({
  selector: 'app-addanswers',
  templateUrl: './addanswers.component.html',
  styleUrls: ['./addanswers.component.css'],
})
// eslint-disable-next-line import/prefer-default-export
export class AddanswersComponent implements OnInit {
  lecform: FormGroup;

  err: string;

  // eslint-disable-next-line no-unused-vars
  constructor(private dialogRef: MatDialogRef<AnswerlistComponent>, private answerSevice: AnswerService,
    // eslint-disable-next-line no-unused-vars
    private questionService: QuestionService) {
    this.err = '';
  }

  ngOnInit(): void {
    this.lecform = new FormGroup({
      ansBody: new FormControl(''),
    });
  }

  get ansBody() {
    return this.lecform.get('ansBody') as FormControl;
  }

  addAns() {
    if (!this.ansBody.value) {
      this.err = 'This field cannot be empty';
      return;
    }
    const ansObject = {
      userId: this.questionService.uid,
      quesId: this.answerSevice.quesId_AddAns,
      answerBody: this.ansBody.value,
    };
    console.log(ansObject);
    this.answerSevice.postAnswer(ansObject).subscribe(() => {
      this.dialogRef.close();
    });
  }
}
