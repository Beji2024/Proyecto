import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NonoesComponent } from './nonoes.component';

describe('NonoesComponent', () => {
  let component: NonoesComponent;
  let fixture: ComponentFixture<NonoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NonoesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NonoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
