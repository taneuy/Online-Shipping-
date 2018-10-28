import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaxiViewComponent } from './taxi-view.component';

describe('TaxiViewComponent', () => {
  let component: TaxiViewComponent;
  let fixture: ComponentFixture<TaxiViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaxiViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaxiViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
