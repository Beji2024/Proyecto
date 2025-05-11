import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VentaRComponent } from './venta-r.component';

describe('VentaRComponent', () => {
  let component: VentaRComponent;
  let fixture: ComponentFixture<VentaRComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VentaRComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VentaRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
