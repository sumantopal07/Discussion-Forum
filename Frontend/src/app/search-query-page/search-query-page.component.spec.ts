import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchQueryPageComponent } from './search-query-page.component';

describe('SearchQueryPageComponent', () => {
  let component: SearchQueryPageComponent;
  let fixture: ComponentFixture<SearchQueryPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchQueryPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchQueryPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
