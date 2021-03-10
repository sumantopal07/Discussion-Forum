import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import * as EmailValidator from 'email-validator';
import { QuestionService } from '../question.service';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  signup: FormGroup;

  username: string;

  password: string;

  passwordAgain: string;

  photo: string;

  email: string;

  err: string;

  err1: string;

  err2: string;

  err3: string;

  err4: string;

  err5: string;

  id: number;

  constructor(private router: Router,
    private signupservice: SignupService,
    private questionService: QuestionService) {
    this.username = '';
    this.password = '';
    this.passwordAgain = '';
    this.email = '';
    this.err1 = '';
    this.err2 = '';
    this.err3 = '';
    this.err4 = '';

    this.err5 = '';

    this.id = -1;
  }

  ngOnInit(): void {
    this.signup = new FormGroup({
      topic: new FormControl(''),
    });
  }

  get topic() : FormControl {
    return this.signup.get('topic') as FormControl;
  }

  loggedIn() : void{
    if (!this.username) {
      this.err1 = 'Username cannot be empty';
      return;
    }

    this.err1 = '';

    if (!this.password) {
      this.err2 = 'Password cannot be empty';
      return;
    }

    this.err2 = '';

    if (this.password !== this.passwordAgain) {
      this.err3 = 'Passwords do not match';
      return;
    }

    this.err3 = '';

    if (!EmailValidator.validate(this.email)) {
      this.err4 = 'Enter a valid email id';
      return;
    }

    this.err4 = '';

    if (!this.topic.value) {
      this.err5 = 'Topic cannot be empty';
      return;
    }

    this.err5 = '';

    const user = {
      signupUsername: this.username,
      signupPassword: this.password,
      signupEmail: this.email,
      signupPhoto: 'https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg',
      signupTopic: this.topic.value,
    };
    this.signupservice.signup(user).subscribe((response) => {
      if (response === 0) this.router.navigate(['']);
      if (response === 1) this.err = 'username not available';
      if (response === 2) this.err = 'Email already used';
    });
  }
}
