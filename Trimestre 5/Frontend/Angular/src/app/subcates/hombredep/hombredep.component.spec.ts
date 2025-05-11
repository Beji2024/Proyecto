import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HombredepComponent } from './hombredep.component';

describe('HombredepComponent', () => {
  let component: HombredepComponent;
  let fixture: ComponentFixture<HombredepComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HombredepComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HombredepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
