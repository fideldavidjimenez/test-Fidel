import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EncuestaCrearComponent } from './encuesta-crear.component';

describe('EncuestaCrearComponent', () => {
  let component: EncuestaCrearComponent;
  let fixture: ComponentFixture<EncuestaCrearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EncuestaCrearComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EncuestaCrearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
