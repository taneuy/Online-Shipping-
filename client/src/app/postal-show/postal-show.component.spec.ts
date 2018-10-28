import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostalShowComponent } from './postal-show.component';

describe('PostalShowComponent', () => {
  let component: PostalShowComponent;
  let fixture: ComponentFixture<PostalShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostalShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostalShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
