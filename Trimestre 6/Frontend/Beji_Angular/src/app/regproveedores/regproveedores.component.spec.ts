import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegproveedoresComponent } from './regproveedores.component';

describe('RegproveedoresComponent', () => {
  let component: RegproveedoresComponent;
  let fixture: ComponentFixture<RegproveedoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegproveedoresComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegproveedoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
