import { Component, OnInit } from '@angular/core';
import { Pedido, PedidoService } from '../pedido.service';
import { proveedor, proveedorService } from '../proveedor.service';
import { usuarios, usuariosService } from '../usuario.service';
import { mercancia, mercanciaService } from '../mercancia.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HeaderComponentComponent } from "../../header.component/header.component.component";
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-registro-pedido',
  templateUrl: './registro-pedido.component.html',
  styleUrls: ['./registro-pedido.component.css'],
  imports: [CommonModule, FormsModule, HeaderComponentComponent, RouterModule]
})
export class RegistroPedidoComponent implements OnInit {

  pedidos: Pedido[] = [];
  proveedores: proveedor[] = [];
  usuarios: usuarios[] = [];
  mercancias: mercancia[] = [];

  pedidosFiltrados: Pedido[] = [];

  busqueda: string = '';
  totalRowIndex = 0;
  currentPage: number = 1;
  lastPage: number = 1;

  constructor(
    private pedidoSvc: PedidoService,
    private proveedorSvc: proveedorService,
    private usuariosSvc: usuariosService,
    private mercanciaSvc: mercanciaService
  ) {}

  ngOnInit(): void {
    this.cargarDatos();
  }

  cargarDatos() {
    this.cargarPedidos(this.currentPage);
    this.proveedorSvc.getProveedor(1).subscribe(res => {
      this.proveedores = res.data;
    });
    this.usuariosSvc.getUsuarios().subscribe(data => {
      this.usuarios = data;
    });
    this.mercanciaSvc.getMercancia().subscribe(data => {
      this.mercancias = data;
    });
  }

cargarPedidos(page: number = 1) {
  this.pedidoSvc.getPedidos(page).subscribe(res => {
    this.pedidos = res.data;
    this.pedidosFiltrados = this.pedidos; // o aplicar filtro si tienes
    this.currentPage = res.current_page;
    this.lastPage = res.last_page;
  });
}



  filtrarPedidos() {
    const term = this.busqueda.toLowerCase();

    this.pedidosFiltrados = this.pedidos.filter(pedido => {
      const usuario = this.obtenerNombreUsuario(pedido.ped_user).toLowerCase();
      const proveedor = this.obtenerNombreProveedor(pedido.ped_prov).toLowerCase();
      // Puedes ampliar para filtrar también por productos, fecha, etc.
      return usuario.includes(term) || proveedor.includes(term);
    });
  }

  obtenerNombreUsuario(num_doc: number | string): string {
    const user = this.usuarios.find(u => u.num_doc == num_doc);
    return user ? `${user.nombres} ${user.apellidos}` : 'Desconocido';
  }

  obtenerNombreProveedor(nit: number | string): string {
    const prov = this.proveedores.find(p => p.nit == nit);
    return prov ? prov.nombre : 'Desconocido';
  }

  obtenerNombreProducto(id_pro: number | string | undefined): string {
  if (id_pro === undefined) return 'Desconocido';
  const prod = this.mercancias.find(m => m.id_pro == id_pro);
  return prod ? prod.nombre : 'Desconocido';
}

}
