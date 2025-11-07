import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  templateUrl: './header.component.component.html',
  styleUrl: './header.component.component.css'
})
export class HeaderComponentComponent {
  constructor(private router: Router) {}

  confirmarLogout() {
    const confirmAction = window.confirm('¿Estás seguro de que deseas cerrar sesión?');
    if (confirmAction) {
      this.logout();
    }
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
}