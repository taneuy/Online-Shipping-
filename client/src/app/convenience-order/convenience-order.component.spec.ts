import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConvenienceOrderComponent } from './convenience-order.component';

describe('ConvenienceOrderComponent', () => {
  let component: ConvenienceOrderComponent;
  let fixture: ComponentFixture<ConvenienceOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConvenienceOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConvenienceOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
