import { Component } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'app-headerven',
  imports: [],
  templateUrl: './headerven.component.html',
  styleUrl: './headerven.component.css'
})
export class HeadervenComponent {
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
