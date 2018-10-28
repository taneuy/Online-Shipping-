import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConvenienceManageComponent } from './convenience-manage.component';

describe('ConvenienceManageComponent', () => {
  let component: ConvenienceManageComponent;
  let fixture: ComponentFixture<ConvenienceManageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConvenienceManageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConvenienceManageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
