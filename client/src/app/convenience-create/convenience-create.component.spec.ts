import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConvenienceCreateComponent } from './convenience-create.component';

describe('ConvenienceCreateComponent', () => {
  let component: ConvenienceCreateComponent;
  let fixture: ComponentFixture<ConvenienceCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConvenienceCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConvenienceCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
