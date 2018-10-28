import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodViewComponent } from './food-view.component';

describe('FoodViewComponent', () => {
  let component: FoodViewComponent;
  let fixture: ComponentFixture<FoodViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FoodViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
