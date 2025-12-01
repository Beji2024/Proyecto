import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CambiovenComponent } from './cambioven.component';

describe('CambiovenComponent', () => {
  let component: CambiovenComponent;
  let fixture: ComponentFixture<CambiovenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CambiovenComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CambiovenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
