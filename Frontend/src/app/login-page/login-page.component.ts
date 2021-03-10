/* eslint-disable import/extensions */
/* eslint-disable import/no-unresolved */
/* eslint-disable no-console */
/* eslint-disable class-methods-use-this */
/* eslint-disable no-unused-vars */
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../model/user';
import { QuestionService } from '../question.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})
// eslint-disable-next-line import/prefer-default-export
export class LoginPageComponent implements OnInit {
  username : string;

  password : string;

  user : User;

  err: string;

  id : number;

  // eslint-disable-next-line no-useless-constructor
  constructor(private router: Router,
    private loginservice : LoginService,
    private questionService : QuestionService) {
    this.username = '';
    this.password = '';
    this.err = '';
    this.id = -1;
  }

  loggedIn() {
    this.user = { username: this.username, password: this.password };
    this.loginservice.login(this.user).subscribe((response) => {
      console.log(response);
      if (!response) {
        this.err = 'Invalid credentials!';
      } else {
        this.id = response.userId;
        localStorage.setItem('token', JSON.stringify(this.id));
        this.questionService.uid = this.id;
        this.router.navigate(['/search']);
      }
    });
  }

  signUp() {
    this.router.navigate(['/signup']);
  }

  ngOnInit(): void {
  }
}
