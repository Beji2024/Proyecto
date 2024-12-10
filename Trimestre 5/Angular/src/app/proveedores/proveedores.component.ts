import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { Router } from '@angular/router';
import { ProveditarComponent } from '../proveditar/proveditar.component';

export const Routes = {
  
  regpro: '/regproveedores',
  edit: '/proveditar'
};

@Component({
  selector: 'app-proveedores',
  imports: [HeaderComponent,ProveedoresComponent,ProveditarComponent],
  templateUrl: './proveedores.component.html',
  styleUrl: './proveedores.component.css'
})
export class ProveedoresComponent {
  constructor(private router: Router) {}
  
  navigateToRegproveedores(): void {
    this.router.navigate([Routes.regpro]);
  }

  navigateToProveditar(): void {
    this.router.navigate([Routes.edit]);
  }
}
