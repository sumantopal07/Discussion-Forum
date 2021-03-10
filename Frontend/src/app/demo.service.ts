/* eslint-disable import/prefer-default-export */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  constructor(private http:HttpClient) { }

    hello = () : Observable<any> => this.http.get<any>('/testing')
}
