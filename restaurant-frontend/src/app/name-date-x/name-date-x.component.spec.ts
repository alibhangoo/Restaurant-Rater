import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NameDateXComponent } from './name-date-x.component';

describe('NameDateXComponent', () => {
  let component: NameDateXComponent;
  let fixture: ComponentFixture<NameDateXComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NameDateXComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NameDateXComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
