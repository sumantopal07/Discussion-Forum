import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { SearchQueryPageComponent } from './search-query-page/search-query-page.component';
import { AnswerQueryPageComponent } from './answer-query-page/answer-query-page.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {
    path: '',
    component: LoginPageComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'search',
    component: SearchQueryPageComponent,
  },
  {
    path: 'answer',
    component: AnswerQueryPageComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
