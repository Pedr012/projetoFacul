import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PginicialComponent } from './pginicial.component';

describe('PginicialComponent', () => {
  let component: PginicialComponent;
  let fixture: ComponentFixture<PginicialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PginicialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PginicialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
