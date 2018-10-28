import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MessengerViewComponent } from './messenger-view.component';

describe('MessengerViewComponent', () => {
  let component: MessengerViewComponent;
  let fixture: ComponentFixture<MessengerViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MessengerViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MessengerViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
