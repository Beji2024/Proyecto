import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { CambioComponent } from '../cambio/cambio.component';
import { Router } from '@angular/router';
export const Routes = {
  Cambio : '/cambio'
};
@Component({
  selector: 'app-devoluciones',
  imports: [HeaderComponent],
  templateUrl: './devoluciones.component.html',
  styleUrl: './devoluciones.component.css'
})
export class DevolucionesComponent {

  constructor(private router: Router) {}

  navigateToCambio(): void {
    this.router.navigate([Routes.Cambio]);
  }
}
