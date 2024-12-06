import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablabodyComponent } from './tablabody.component';

describe('TablabodyComponent', () => {
  let component: TablabodyComponent;
  let fixture: ComponentFixture<TablabodyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TablabodyComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TablabodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
