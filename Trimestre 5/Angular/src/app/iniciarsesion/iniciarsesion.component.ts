import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { PrincipalComponent } from '../principal/principal.component';

@Component({
  selector: 'app-iniciarsesion',
  standalone: true,
  imports: [RouterOutlet,PrincipalComponent,IniciarsesionComponent],
  templateUrl: './iniciarsesion.component.html',
  styleUrl: './iniciarsesion.component.css'
})
export class IniciarsesionComponent {
  constructor(private router: Router) {}
  navigateToPrincipal(): void {
    this.router.navigate(['/principal']);
  }

}