import { Component, OnInit } from '@angular/core';
import { VentaService } from '../../../../services/venta.service';
import { CommonModule } from '@angular/common';
import { HeaderComponentComponent } from '../../header.component/header.component.component';
@Component({
  selector: 'app-consultar-venta',
  standalone: true,
  imports: [HeaderComponentComponent,CommonModule],
  templateUrl: './consultar-venta.component.html',
  styleUrl: './consultar-venta.component.css'
})
export class ConsultarVentaComponent implements OnInit {
  ventas: any[]=[];
  ventasPaginadas: any[] = [];
  paginaActual: number = 1;
  ventasPorPagina: number = 10;

  constructor(private ventaService: VentaService) { }

  ngOnInit(): void {
    this.cargarVentas();
  }

  cargarVentas():void{
    this.ventaService.obtenerVentas().subscribe({
      next:(res) => {
        this.ventas = res;
        this.actualizarVentasPaginadas();
      },
      error: (err) => console.error('Error cargando las ventas:',err)
    });
  }

  actualizarVentasPaginadas(): void {
    const inicio = (this.paginaActual - 1) * this.ventasPorPagina;
    const fin = inicio + this.ventasPorPagina;
    this.ventasPaginadas = this.ventas.slice(inicio, fin);
  }

   cambiarPagina(nuevaPagina: number): void {
    if (nuevaPagina < 1 || nuevaPagina > this.totalPaginas) return;
    this.paginaActual = nuevaPagina;
    this.actualizarVentasPaginadas();
  }

  get totalPaginas(): number {
    return Math.ceil(this.ventas.length / this.ventasPorPagina);
  }
  get paginas(): number[] {
    return Array.from({ length: this.totalPaginas }, (_, i) => i + 1);
  }
}




