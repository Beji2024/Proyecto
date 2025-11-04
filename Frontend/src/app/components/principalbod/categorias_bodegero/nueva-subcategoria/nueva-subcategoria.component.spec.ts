import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevaSubcategoriaComponent } from './nueva-subcategoria.component';

describe('NuevaSubcategoriaComponent', () => {
  let component: NuevaSubcategoriaComponent;
  let fixture: ComponentFixture<NuevaSubcategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NuevaSubcategoriaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NuevaSubcategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
