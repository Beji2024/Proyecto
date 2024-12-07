import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { Router } from '@angular/router';

@Component({
  selector: 'app-proveedores',
  imports: [HeaderComponent],
  templateUrl: './proveedores.component.html',
  styleUrl: './proveedores.component.css'
})
export class ProveedoresComponent {
  constructor(private router: Router) {}
  navigateToRegproveedores(): void {
    this.router.navigate(['/regproveedores']);
  }
}
