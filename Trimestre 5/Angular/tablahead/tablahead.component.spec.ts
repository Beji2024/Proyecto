import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaheadComponent } from './tablahead.component';

describe('TablaheadComponent', () => {
  let component: TablaheadComponent;
  let fixture: ComponentFixture<TablaheadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TablaheadComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TablaheadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
