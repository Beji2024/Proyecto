import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-headerbod',
  imports: [],
  templateUrl: './headerbod.component.html',
  styleUrl: './headerbod.component.css'
})
export class HeaderbodComponent {
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
