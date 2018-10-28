import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConvenienceViewComponent } from './convenience-view.component';

describe('ConvenienceViewComponent', () => {
  let component: ConvenienceViewComponent;
  let fixture: ComponentFixture<ConvenienceViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConvenienceViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConvenienceViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
