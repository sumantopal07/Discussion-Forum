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
export class LoginPageComponent implements OnInit {
  username : string;

  password : string;

  user : User;

  err: string;

  id : number;

  constructor(private router: Router,
    private loginservice : LoginService,
    private questionService : QuestionService) {
    this.username = '';
    this.password = '';
    this.err = '';
    this.id = -1;
  }

  loggedIn() : void{
    this.user = { username: this.username, password: this.password };
    this.loginservice.login(this.user).subscribe((response) => {
      if (!response) {
        this.err = 'Invalid credentials!';
      } else {
        this.id = response.userId;
        localStorage.setItem('token', JSON.stringify(this.id));
        localStorage.setItem('userrr', JSON.stringify(response.username));
        localStorage.setItem('userrrphoto', JSON.stringify(response.photo));
        this.questionService.uid = this.id;
        this.router.navigate(['/search']);
      }
    });
  }

  signUp= () : void => {
    this.router.navigate(['/signup']);
  }

  ngOnInit(): void {
    this.err="";
  }
}
