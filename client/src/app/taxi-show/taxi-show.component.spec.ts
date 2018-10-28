import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaxiShowComponent } from './taxi-show.component';

describe('TaxiShowComponent', () => {
  let component: TaxiShowComponent;
  let fixture: ComponentFixture<TaxiShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaxiShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaxiShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
