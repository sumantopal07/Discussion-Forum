/* eslint-disable max-len */
/* eslint-disable import/prefer-default-export */
/* eslint-disable no-useless-constructor */
/* eslint-disable no-unused-vars */
/* eslint-disable no-empty-function */
import { Component, Input, OnInit } from '@angular/core';
import { SimpleChanges } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Question } from '../model/question';
import { QuestionService } from '../question.service';
import { AnswerlistComponent } from '../answerlist/answerlist.component';
import { SearchQueryPageComponent } from '../search-query-page/search-query-page.component';
import { AddquestionsComponent } from '../addquestions/addquestions.component';

@Component({
  selector: 'app-questionlist',
  templateUrl: './questionlist.component.html',
  styleUrls: ['./questionlist.component.css'],
})
export class QuestionlistComponent implements OnInit {
  questionlist= [];

  seachQueList=[];

  toogleques: boolean;

  queId: number;

  qlen2: number;

  showVar: boolean[] = [];

  quphoto: string;

  @Input('temp') temp:any;

  @Input('ftest') ftest:any;

  @Input('qlen1') qlen1:any;

  constructor(private questionService: QuestionService, private squery : SearchQueryPageComponent, private box: MatDialog) {
    
   }

  ngOnInit(): void {
    this.toogleques = true;
    this.questionService.getQuestions().subscribe((data) => {
      for (let i = 0; i < data.length; i += 1) {
        this.showVar.push(false);
        this.questionlist.push({
          title: data[i].title,
          body: data[i].body,
          qid: data[i].quesId,
          quphoto: data[i].user.photo,
        });
        this.qlen2 = this.questionlist.length;
      }
    });
  }

  ngOnChanges(changes: SimpleChanges) {
    this.seachQueList = this.temp;
    this.toogleques = false;
  }

  addQues() {
    this.box.open(AddquestionsComponent);
  }

  showans= (i) => {
    this.showVar[i] = !this.showVar[i];
  }

  showsearchQues() {
    console.log(this.temp);
    this.toogleques = true;
  }
}
