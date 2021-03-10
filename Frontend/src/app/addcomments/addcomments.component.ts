import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FormControl, FormGroup } from '@angular/forms';
import { CommentService } from '../comment.service';
import { AnswerService } from '../answer.service';
import { QuestionService } from '../question.service';
import { CommentlistComponent } from '../commentlist/commentlist.component';

@Component({
  selector: 'app-addcomments',
  templateUrl: './addcomments.component.html',
  styleUrls: ['./addcomments.component.css'],
})
export class AddcommentsComponent implements OnInit {
  lecform: FormGroup;

  err: string;

  constructor(private dialogRef: MatDialogRef<CommentlistComponent>,
    private answerService: AnswerService,
    private questionService: QuestionService,
    private commentService: CommentService) {
    this.err = '';
  }

  ngOnInit(): void {
    this.lecform = new FormGroup({
      comBody: new FormControl(''),
    });
  }

  get comBody() : FormControl{
    return this.lecform.get('comBody') as FormControl;
  }

  addCom() : void{
    if (!this.comBody.value) {
      this.err = 'This field cannot be empty';
      return;
    }
    const comObject = {
      userId: this.questionService.uid,
      ansId: this.commentService.temp,
      commentBody: this.comBody.value,
    };
    this.commentService.postComment(comObject).subscribe(() => {
      this.dialogRef.close();
    });
  }
}
