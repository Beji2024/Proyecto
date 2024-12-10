import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HombreeleComponent } from './hombreele.component';

describe('HombreeleComponent', () => {
  let component: HombreeleComponent;
  let fixture: ComponentFixture<HombreeleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HombreeleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HombreeleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
