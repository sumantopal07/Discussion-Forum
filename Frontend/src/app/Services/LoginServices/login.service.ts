import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../Models/User/user';

@Injectable({
  providedIn: 'root',
})

export class LoginService {
  constructor(private http:HttpClient) { }

    login = (user : User) : Observable<any> => this.http.post<any>('/api/login', user)
}
