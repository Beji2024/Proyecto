import { Component } from '@angular/core';
import { HeadervenComponent } from '../../headerven/headerven.component';
import { VentaService } from '../../../../services/venta.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-devolucionven',
  standalone:true,
  imports: [HeadervenComponent,CommonModule,RouterModule],
  templateUrl: './devolucionven.component.html',
  styleUrl: './devolucionven.component.css'
})
export class DevolucionvenComponent {
  ventas: any[] = [];
  ventasPaginadas: any[] = [];
  paginaActual: number = 1;
  ventasPorPagina: number = 5;
  totalPaginas: number = 0;

  constructor(private ventaService: VentaService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.cargarVentas();
  }

  cargarVentas(): void {
    this.ventaService.obtenerVentas().subscribe({
      next: (res) => {
        this.ventas = res;
        this.totalPaginas = Math.ceil(this.ventas.length / this.ventasPorPagina);
        this.actualizarVentasPaginadas();
      },
      error: (err) => console.error('Error cargando las ventas:', err)
    });
  }

  actualizarVentasPaginadas(): void {
    const inicio = (this.paginaActual - 1) * this.ventasPorPagina;
    const fin = inicio + this.ventasPorPagina;
    this.ventasPaginadas = this.ventas.slice(inicio, fin);
  }

  siguientePagina(): void {
    if (this.paginaActual < this.totalPaginas) {
      this.paginaActual++;
      this.actualizarVentasPaginadas();
    }
  }

  paginaAnterior(): void {
    if (this.paginaActual > 1) {
      this.paginaActual--;
      this.actualizarVentasPaginadas();
    }
  }

  cambiarEstado(ventaId: number) {
    const confirmar = window.confirm('¿Estás seguro que desea hacer la devolución de dinero de este producto?');
    if (confirmar) {
      this.ventaService.actualizarEstadoVenta(ventaId, 2).subscribe({
        next: () => {
          alert('Estado actualizado correctamente');
          this.cargarVentas();
        },
        error: (err) => {
          console.error('Error al actualizar estado:', err);
          alert('Hubo un error al cambiar el estado de la venta.');
        }
      });
    }
  }

  goToCambio(id: number) {
    const confirmar = window.confirm('¿Estás seguro que desea cambiar el producto de esta venta?');
    if (confirmar) {
      this.ventaService.actualizarEstadoVenta(id, 3).subscribe({
        next: () => {
          this.router.navigate(['/cambio-venta', id]);
        },
        error: (err) => {
          console.error('Error al cambiar el estado:', err);
          alert('No se pudo cambiar el estado de la venta.');
        }
      });
    }
  }
}