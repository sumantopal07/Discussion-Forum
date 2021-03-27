import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class CommentService {
  constructor(private http:HttpClient) {}

      ansid : number;

      temp : number;

      getComment(ansid) {
        return this.http.get<any>(`/api/comment/${ansid}`);
      }

      postComment = (comment : any) : Observable<any> => this.http.post<any>('/api/addcomment', comment);
}
