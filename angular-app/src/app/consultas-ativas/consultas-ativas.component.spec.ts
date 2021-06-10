import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultasAtivasComponent } from './consultas-ativas.component';

describe('ConsultasAtivasComponent', () => {
  let component: ConsultasAtivasComponent;
  let fixture: ComponentFixture<ConsultasAtivasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultasAtivasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultasAtivasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
