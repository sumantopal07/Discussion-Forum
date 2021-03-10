import { Component, Input, OnInit } from '@angular/core';
import { CommentService } from '../comment.service';

@Component({
  selector: 'app-commentlist',
  templateUrl: './commentlist.component.html',
  styleUrls: ['./commentlist.component.css'],
})

export class CommentlistComponent implements OnInit {
  commentList = [];

  len: number;

  @Input() ansId: any;

  constructor(private commentService: CommentService) { }

  ngOnInit(): void {
    this.getComment();
  }

  getComment() : void{
    this.commentService.getComment(this.ansId).subscribe((data) => {
      for (let i = 0; i < data.length; i += 1) {
        this.commentList.push({
          user: data[i].user.username,
          body: data[i].commentBody,
          cphoto: data[i].user.photo,
        });
      }
      this.len = this.commentList.length;
    });
  }
}
