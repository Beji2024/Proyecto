import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NinopanComponent } from './ninopan.component';

describe('NinopanComponent', () => {
  let component: NinopanComponent;
  let fixture: ComponentFixture<NinopanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NinopanComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NinopanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
