import { Component, OnInit } from '@angular/core';
import { PedidoService } from './services/pedido.service';

@Component({
  selector: 'app-pedido-list',
  templateUrl: './pedido-list.component.html',
  styleUrls: ['./pedido-list.component.css']
})
export class PedidoListComponent implements OnInit {
  pedidos: any[] = [];

  constructor(private pedidoService: PedidoService) { }

  ngOnInit(): void {
    this.cargarPedidos();
  }

  cargarPedidos(): void {
    this.pedidoService.getPedidos().subscribe(
      (data) => {
        this.pedidos = data;
      },
      (error) => {
        console.error('Error al cargar los pedidos:', error);
      }
    );
  }
}
