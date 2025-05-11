import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MujereleComponent } from './mujerele.component';

describe('MujereleComponent', () => {
  let component: MujereleComponent;
  let fixture: ComponentFixture<MujereleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MujereleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MujereleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
