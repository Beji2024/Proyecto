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

  constructor(private ventaService: VentaService) { }

  ngOnInit(): void {
    this.cargarVentas();
  }
  cargarVentas():void{
    this.ventaService.obtenerVentas().subscribe({
      next:(res) => this.ventas =res,
      error: (err) => console.error('Error cargando las ventas:',err)
    });
  }

}
