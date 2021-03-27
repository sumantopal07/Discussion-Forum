import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddanswersComponent } from '../../Answers/addanswers/addanswers.component';
import { QuestionService } from '../../../Services/QuestionServices/question.service';
import { AnswerService } from '../../../Services/AnswerServices/answer.service';

@Component({
  selector: 'app-questiontopiclist',
  templateUrl: './questiontopiclist.component.html',
  styleUrls: ['./questiontopiclist.component.css'],
})
export class QuestiontopiclistComponent implements OnInit {
  questiontopiclist=[];

  queId: number;

  showVar:boolean[]=[];

  @Input() userId: number;

  constructor(private answerService: AnswerService,
    private box: MatDialog,
    private questionService: QuestionService) { }

  ngOnInit(): void {
    this.questionService.getQuestionsbytopic().subscribe((data) => {
      for (let i = 0; i < data.length; i += 1) {
        this.showVar.push(false);
        if (!data[i].marked) {
          this.questiontopiclist.push({
            title: data[i].title,
            body: data[i].body,
            qid: data[i].quesId,
            quser: data[i].user.username,
            qphoto: data[i].user.photo,
          });
        }
      }
    });
  }

  showans= (i : number) : void => {
    this.showVar[i] = !this.showVar[i];
  }

  addAns(qID, i:  number) : void {
    this.answerService.quesAnsId = qID;
    this.box.open(AddanswersComponent);
    this.showVar[i] = false;
  }
}
