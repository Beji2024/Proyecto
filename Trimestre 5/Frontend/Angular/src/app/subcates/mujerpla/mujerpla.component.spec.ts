import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MujerplaComponent } from './mujerpla.component';

describe('MujerplaComponent', () => {
  let component: MujerplaComponent;
  let fixture: ComponentFixture<MujerplaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MujerplaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MujerplaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
