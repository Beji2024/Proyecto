import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegiproComponent } from './regipro.component';

describe('RegiproComponent', () => {
  let component: RegiproComponent;
  let fixture: ComponentFixture<RegiproComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegiproComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegiproComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
