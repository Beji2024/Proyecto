import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaVComponent } from './consulta-v.component';

describe('ConsultaVComponent', () => {
  let component: ConsultaVComponent;
  let fixture: ComponentFixture<ConsultaVComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsultaVComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultaVComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
