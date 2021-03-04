import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from "./login-page/login-page.component";
import { SearchQueryPageComponent } from './search-query-page/search-query-page.component';
import { AnswerQueryPageComponent } from './answer-query-page/answer-query-page.component';
const routes: Routes = [
  {
    path: '',
    component: LoginPageComponent,
  },
  {
    path: 'search',
    component: SearchQueryPageComponent,
  },
  {
    path: 'answer',
    component: AnswerQueryPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
