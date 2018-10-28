import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MessengerOrderComponent } from './messenger-order.component';

describe('MessengerOrderComponent', () => {
  let component: MessengerOrderComponent;
  let fixture: ComponentFixture<MessengerOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MessengerOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MessengerOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
