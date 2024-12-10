import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GesproComponent } from './gespro.component';

describe('GesproComponent', () => {
  let component: GesproComponent;
  let fixture: ComponentFixture<GesproComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GesproComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GesproComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
