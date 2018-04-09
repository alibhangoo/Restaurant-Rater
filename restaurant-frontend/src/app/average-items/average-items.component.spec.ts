import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AverageItemsComponent } from './average-items.component';

describe('AverageItemsComponent', () => {
  let component: AverageItemsComponent;
  let fixture: ComponentFixture<AverageItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AverageItemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AverageItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
