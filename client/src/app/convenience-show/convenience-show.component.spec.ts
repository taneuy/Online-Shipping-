import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConvenienceShowComponent } from './convenience-show.component';

describe('ConvenienceShowComponent', () => {
  let component: ConvenienceShowComponent;
  let fixture: ComponentFixture<ConvenienceShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConvenienceShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConvenienceShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
