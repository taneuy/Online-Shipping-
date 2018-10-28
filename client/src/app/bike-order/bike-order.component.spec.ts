import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BikeOrderComponent } from './bike-order.component';

describe('BikeOrderComponent', () => {
  let component: BikeOrderComponent;
  let fixture: ComponentFixture<BikeOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BikeOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BikeOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
