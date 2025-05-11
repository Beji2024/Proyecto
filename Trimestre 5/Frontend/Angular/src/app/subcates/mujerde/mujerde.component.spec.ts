import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MujerdeComponent } from './mujerde.component';

describe('MujerdeComponent', () => {
  let component: MujerdeComponent;
  let fixture: ComponentFixture<MujerdeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MujerdeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MujerdeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
