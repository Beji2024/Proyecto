import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { ProveedoresComponent } from '../proveedores/proveedores.component';
import { VentaRComponent } from '../venta-r/venta-r.component';
import { UsuarioComponent } from '../usuario/usuario.component';
import { ProductosComponent } from '../productos/productos.component';
import { HeaderComponent } from "../header/header.component";
import { PedidoComponent } from '../pedido/pedido.component';

export const Routes = {
  
  Usuario: '/usuario',
  Proveedores: '/proveedores',
  Ventar: '/venta-r',
  Producto:'/productos',
  Pedido: '/pedido',
  Venta: '/venta',
};

@Component({
  selector: 'app-principal',
  imports: [RouterOutlet, ProveedoresComponent, VentaRComponent, PrincipalComponent, UsuarioComponent,
    ProductosComponent, HeaderComponent,PedidoComponent],

  templateUrl: './principal.component.html',
  styleUrl: './principal.component.css'
})
export class PrincipalComponent {
  constructor(private router: Router) {}

  navigateToUsuario(): void {
    this.router.navigate([Routes.Usuario]);
  }

  navigateToProveedores(): void {
    this.router.navigate([Routes.Proveedores]);
  }

  navigateToVentar(): void {
    this.router.navigate([Routes.Ventar]);
  }

  navigateToProductos(): void {
    this.router.navigate([Routes.Producto]);
  }

  navigateToPedido(): void {
    this.router.navigate([Routes.Pedido]);
  }
  navigateToVenta(): void {
    this.router.navigate([Routes.Venta]);
  }
}
