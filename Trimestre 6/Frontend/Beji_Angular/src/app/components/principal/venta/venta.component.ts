import { Component } from '@angular/core';
import { HeaderComponentComponent } from '../header.component/header.component.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-venta',
  standalone:true,
  imports: [HeaderComponentComponent],
  templateUrl: './venta.component.html',
  styleUrl: './venta.component.css'
})
export class VentaComponent {
  
  constructor(private router: Router){

  }
  goToCrearVenta(){
    this.router.navigate(['/crear-venta']);
  }
  goToConsultarVenta(){
    this.router.navigate(['/consultar-venta']);
  }
  goToDevoluciones(){
    this.router.navigate(['/devoluciones-venta']);
  }
}
