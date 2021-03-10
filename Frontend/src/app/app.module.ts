import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatTreeModule } from '@angular/material/tree';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule } from '@angular/material/card';
import { NavbarModule, WavesModule, ButtonsModule } from 'angular-bootstrap-md';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatIconModule } from '@angular/material/icon';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { SearchQueryPageComponent } from './search-query-page/search-query-page.component';
import { AnswerQueryPageComponent } from './answer-query-page/answer-query-page.component';
import { QuestionlistComponent } from './questionlist/questionlist.component';
import { AnswerlistComponent } from './answerlist/answerlist.component';
import { QuestiontopiclistComponent } from './questiontopiclist/questiontopiclist.component';
import { AddquestionsComponent } from './addquestions/addquestions.component';
import { AddanswersComponent } from './addanswers/addanswers.component';
import { CommentlistComponent } from './commentlist/commentlist.component';
import { AddcommentsComponent } from './addcomments/addcomments.component';
import { SignupComponent } from './signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    SearchQueryPageComponent,
    AnswerQueryPageComponent,
    QuestionlistComponent,
    AnswerlistComponent,
    QuestiontopiclistComponent,
    AddquestionsComponent,
    AddanswersComponent,
    CommentlistComponent,
    AddcommentsComponent,
    SignupComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatTreeModule,
    BrowserAnimationsModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatCardModule,
    NavbarModule,
    WavesModule,
    ButtonsModule,
    MatSnackBarModule,
    MatIconModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
