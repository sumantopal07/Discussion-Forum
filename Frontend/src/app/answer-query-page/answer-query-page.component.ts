import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-answer-query-page',
  templateUrl: './answer-query-page.component.html',
  styleUrls: ['./answer-query-page.component.css'],
})
export class AnswerQueryPageComponent implements OnInit {
	
	 foto: string;

  duname: string;
  
  constructor(private router : Router) { 
    this.foto=JSON.parse(localStorage.getItem('userrrphoto')); 
    this.duname=JSON.parse(localStorage.getItem('userrr'));
  }

  searchTab() : void{
    this.router.navigate(['/search']);
  }

  logout() : void{
    localStorage.removeItem('token');
    localStorage.removeItem('userrr');
    localStorage.removeItem('userrrphoto');
    this.router.navigate(['']);
  }

  ngOnInit(): void {
    this.foto=JSON.parse(localStorage.getItem('userrrphoto')); 
    this.duname=JSON.parse(localStorage.getItem('userrr'));
  }
}
