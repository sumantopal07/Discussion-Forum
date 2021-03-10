import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class AnswerService {
  constructor(private http:HttpClient) { }

  quid : number;

  quesAnsId : number;

  getAnswer(quid) {
    return this.http.get<any>(`/api/answer/${quid}`);
  }

  postAnswer = (answer : any) : Observable<any> => this.http.post<any>('/api/addanswers', answer);

  markCorrect = (ansId : any) : Observable<any> => this.http.post<any>('/api/answer/markcorrect/', ansId);
}
