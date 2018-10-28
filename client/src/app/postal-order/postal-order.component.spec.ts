import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostalOrderComponent } from './postal-order.component';

describe('PostalOrderComponent', () => {
  let component: PostalOrderComponent;
  let fixture: ComponentFixture<PostalOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostalOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostalOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
