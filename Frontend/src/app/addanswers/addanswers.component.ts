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

export class AddanswersComponent implements OnInit {
  lecform: FormGroup;

  err: string;

  constructor(private dialogRef: MatDialogRef<AnswerlistComponent>,
    private answerSevice: AnswerService,
    private questionService: QuestionService) {
    this.err = '';
  }

  ngOnInit(): void {
    this.lecform = new FormGroup({
      ansBody: new FormControl(''),
    });
  }

  get ansBody() : FormControl {
    return this.lecform.get('ansBody') as FormControl;
  }

  addAns() : void {
    if (!this.ansBody.value) {
      this.err = 'This field cannot be empty';
      return;
    }
    const ansObject = {
      userId: this.questionService.uid,
      quesId: this.answerSevice.quesAnsId,
      answerBody: this.ansBody.value,
    };
    this.answerSevice.postAnswer(ansObject).subscribe(() => {
      this.dialogRef.close();
    });
  }
}
