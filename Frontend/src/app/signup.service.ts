import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SignupService {
  constructor(private http:HttpClient) { }

    signup = (user : any) : Observable<any> => this.http.post<any>('/api/signup', user)
}
