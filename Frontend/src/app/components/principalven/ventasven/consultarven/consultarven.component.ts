import { Component, OnInit } from '@angular/core';
import { HeadervenComponent } from '../../headerven/headerven.component';
import { VentaService } from '../../../../services/venta.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-consultarven',
  standalone:true,
  imports: [HeadervenComponent,CommonModule],
  templateUrl: './consultarven.component.html',
  styleUrl: './consultarven.component.css'
})
export class ConsultarvenComponent implements OnInit {
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

