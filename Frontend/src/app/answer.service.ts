/* eslint-disable import/no-unresolved */
/* eslint-disable import/extensions */
/* eslint-disable no-unused-vars */
/* eslint-disable import/prefer-default-export */
/* eslint-disable no-useless-constructor */
/* eslint-disable no-empty-function */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Answer } from './model/answer';

@Injectable({
  providedIn: 'root',
})

export class AnswerService {
  constructor(private http:HttpClient) { }

  quid : number;

  quesId_AddAns : number;

  getAnswer(quid) {
    return this.http.get<any>(`/api/answer/${quid}`);
  }

  postAnswer = (answer : any) : Observable<any> => this.http.post<any>('/api/addanswers', answer);

  markCorrect = (ansId : any) : Observable<any> => this.http.post<any>('/api/answer/markcorrect/', ansId);
}
