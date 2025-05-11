import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModiproComponent } from './modipro.component';

export const Routes = {
  modificar : '/',
  
};
describe('ModiproComponent', () => {
  let component: ModiproComponent;
  let fixture: ComponentFixture<ModiproComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModiproComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModiproComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
