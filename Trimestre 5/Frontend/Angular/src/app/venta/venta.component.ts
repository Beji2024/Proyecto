import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { Router } from '@angular/router';
export const Routes = {
  Ventar : '/venta-r',
  ConsultarV :'/consultar-v',
  Devoluciones :'/devoluciones'
}
@Component({
  selector: 'app-venta',
  imports: [HeaderComponent],
  templateUrl: './venta.component.html',
  styleUrl: './venta.component.css'
})
export class VentaComponent {
  constructor(private router: Router) {}

  navigateVentar(): void {
    this.router.navigate([Routes.Ventar]);
  }
  navigateConsultarV(): void {
    this.router.navigate([Routes.ConsultarV]);
  }
  navigateDevoluciones(): void {
    this.router.navigate([Routes.Devoluciones]);
  }

}
