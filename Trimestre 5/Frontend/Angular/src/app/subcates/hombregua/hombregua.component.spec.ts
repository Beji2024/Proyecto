import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HombreguaComponent } from './hombregua.component';

describe('HombreguaComponent', () => {
  let component: HombreguaComponent;
  let fixture: ComponentFixture<HombreguaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HombreguaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HombreguaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
