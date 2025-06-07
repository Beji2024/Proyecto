import { Component, HostListener,OnDestroy } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';
import { HeaderComponentComponent } from './header.component/header.component.component';


@Component({
  selector: 'app-principal',
  standalone: true,
  imports: [RouterOutlet,HeaderComponentComponent,RouterModule],
  templateUrl: './principal.component.html',
  styleUrl: './principal.component.css'
})
export class PrincipalComponent {
  private popStateHandler = (event: PopStateEvent) => {
    const confirmLogout = window.confirm('¿Deseas cerrar sesión y salir de la aplicación?');
    if (confirmLogout) {
      localStorage.removeItem('token');
      this.router.navigate(['/login']);
    } else {
      
      history.pushState(null, '', window.location.href);
    }
  };

  constructor(private router: Router) {
    history.pushState(null, '', window.location.href);
    window.addEventListener('popstate', this.popStateHandler);
  }
  ngOnDestroy(): void {
    window.removeEventListener('popstate', this.popStateHandler);
  }
  
  goToUsuarios() {
    this.router.navigate(['/usuarios']);
  }
  goToVenta(){
    this.router.navigate(['/venta']);
  }
  goToProveedor(){
    this.router.navigate(['/proveedor']);
  }
}