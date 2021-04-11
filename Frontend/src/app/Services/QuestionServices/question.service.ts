import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})

export class QuestionService {
    uid : number;

    page : number;

    Squestions=[];

    oldkey: string;

    constructor(private http:HttpClient, private router: Router) {
      this.uid = JSON.parse(localStorage.getItem('token'));
      if (!this.uid) {
        this.router.navigate(['']);
      }
      this.page=0;
    }

    getQuestions() {
      return this.http.get<any>(`/api/userquestions/${this.uid}/${this.page}`);
    }

    Searching = (keywords : string) : Observable<any> => this.http.post<any>('/api/question/keywords', keywords);

    getQuestionsbytopic() {
      return this.http.get<any>(`/api/questions/${this.uid}`);
    }

    postQuestion = (ques : any) : Observable<any> => this.http.post<any>('/api/addquestion', ques);
}
