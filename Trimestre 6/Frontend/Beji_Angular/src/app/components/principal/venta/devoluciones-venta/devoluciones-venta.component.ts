import { Component } from '@angular/core';
import { HeaderComponentComponent } from '../../header.component/header.component.component';
import { VentaService } from '../../../../services/venta.service';
import { CommonModule } from '@angular/common';
import { Router} from '@angular/router';
import { RouterModule } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-devoluciones-venta',
  standalone: true,
  imports: [HeaderComponentComponent,CommonModule,RouterModule],
  templateUrl: './devoluciones-venta.component.html',
  styleUrl: './devoluciones-venta.component.css'
})
export class DevolucionesVentaComponent {
    ventas: any[]=[];
    
  
    constructor(private ventaService: VentaService, private router: Router, private route:ActivatedRoute) { }
  
    ngOnInit(): void {
      this.cargarVentas();
    }

   

    
    cargarVentas():void{
      this.ventaService.obtenerVentas().subscribe({
        next:(res) => this.ventas =res,
        error: (err) => console.error('Error cargando las ventas:',err)
      });
    }
    cambiarEstado(ventaId: number) {
      console.log('Venta ID:', ventaId);
      const confirmar = window.confirm('¿Estás seguro que desea hacer la devolucion de dinero de este producto?');
      if (confirmar) {
        this.ventaService.actualizarEstadoVenta(ventaId, 2).subscribe({
          next: (response) => {
            console.log('Respuesta de la API:', response);  // Verificar la respuesta del backend
            alert('Estado actualizado correctamente');
            this.cargarVentas(); 
          },
          error: (err) => {
            console.error('Error al actualizar estado:', err);
            alert('Hubo un error al cambiar el estado de la venta. Intenta nuevamente.');
          }
        });
      }
    }
    goToCambio(id: number) {
      const confirmar = window.confirm('¿Estás seguro que desea cambiar el producto de esta venta?');
      if (confirmar) {
        // Cambia el estado a 3 antes de redirigir
        this.ventaService.actualizarEstadoVenta(id, 3).subscribe({
          next: (response) => {
            console.log('Estado cambiado a 3 para cambio de producto');
            // Redirigir al formulario de cambio de producto
            this.router.navigate(['/cambio-venta', id]);
          },
          error: (err) => {
            console.error('Error al cambiar el estado:', err);
            alert('No se pudo cambiar el estado de la venta. Intente de nuevo.');
          }
        });
      }
    }
  }
