import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProveditarComponent } from './proveditar.component';

describe('ProveditarComponent', () => {
  let component: ProveditarComponent;
  let fixture: ComponentFixture<ProveditarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProveditarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProveditarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
