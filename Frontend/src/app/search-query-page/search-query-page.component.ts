import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-search-query-page',
  templateUrl: './search-query-page.component.html',
  styleUrls: ['./search-query-page.component.css']
})
export class SearchQueryPageComponent implements OnInit {

  constructor(private router: Router) { }

  answerTab(){
    this.router.navigate(['/answer']);
  }

  logout(){
    this.router.navigate(['']);
  }

  ngOnInit(): void {
  }

}
