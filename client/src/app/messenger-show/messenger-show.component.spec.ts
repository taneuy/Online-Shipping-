import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MessengerShowComponent } from './messenger-show.component';

describe('MessengerShowComponent', () => {
  let component: MessengerShowComponent;
  let fixture: ComponentFixture<MessengerShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MessengerShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MessengerShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
