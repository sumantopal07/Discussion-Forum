/* eslint-disable import/no-unresolved */
/* eslint-disable import/extensions */
/* eslint-disable no-unused-vars */
/* eslint-disable import/prefer-default-export */
/* eslint-disable no-useless-constructor */
/* eslint-disable no-empty-function */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Question } from './model/question';
import { QuestionlistComponent } from './questionlist/questionlist.component';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root',
})

export class QuestionService {
    uid : number;

    Squestions=[];

    oldkey: string;

    constructor(private http:HttpClient, private router: Router) {
      this.uid = JSON.parse(localStorage.getItem('token'));
      if(!this.uid){
        this.router.navigate(['']);
      }
     }

    getQuestions() {
      console.log(this.uid);
      return this.http.get<any>(`/api/userquestions/${this.uid}`);
    }

    Searching = (keywords : string) : Observable<any> => this.http.post<any>('/api/question/keywords', keywords);

    getQuestionsbytopic() {
      return this.http.get<any>(`/api/questions/${this.uid}`);
    }

    postQuestion = (ques : any) : Observable<any> => this.http.post<any>('/api/addquestion', ques);
}
