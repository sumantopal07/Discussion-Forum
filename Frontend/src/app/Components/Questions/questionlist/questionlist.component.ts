import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { QuestionService } from '../../../Services/QuestionServices/question.service';
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

  page: number;

  totalPages: number;

  qlen2: number;

  showVar: boolean[] = [];

  quphoto: string;

  @Input('temp') temp:any;

  @Input('ftest') ftest:any;

  @Input('qlen1') qlen1:any;

  constructor(private questionService: QuestionService,
    private squery : SearchQueryPageComponent,
    private box: MatDialog) {

  }
  

  ngOnInit(): void {
    this.toogleques = true;
    this.questionService.getQuestions().subscribe((data) => {
      this.page= data.number;
      this.totalPages= data.totalPages;
      console.log(data);
      for (let i = 0; i < data.content.length; i += 1) {
        this.showVar.push(false);
        this.questionlist.push({
          title: data.content[i].title,
          body: data.content[i].body,
          qid: data.content[i].quesId,
          quphoto: data.content[i].user.photo,
        });
        this.qlen2 = this.questionlist.length;
      }
    });
  }

  ngOnChanges() : void{
    this.seachQueList = this.temp;
    this.toogleques = false;
  }

  addQues() : void{
    this.box.open(AddquestionsComponent);
  }

  showans= (i:number) : void => {
    this.showVar[i] = !this.showVar[i];
  }

  showsearchQues() : void {
    this.toogleques = true;
  }
}
