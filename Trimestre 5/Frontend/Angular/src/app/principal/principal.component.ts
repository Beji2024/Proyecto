import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { ProveedoresComponent } from '../proveedores/proveedores.component';
import { VentaRComponent } from '../venta-r/venta-r.component';
import { UsuarioComponent } from '../usuario/usuario.component';
import { ProductosComponent } from '../productos/productos.component';
import { HeaderComponent } from "../header/header.component";
import { PedidoComponent } from '../pedido/pedido.component';
import { IniciarsesionComponent } from '../iniciarsesion/iniciarsesion.component';

export const Routes = {
  
  Usuario: '/usuario',
  Proveedores: '/proveedores',
  Informes: '/informes',
  Producto:'/productos',
  Pedido: '/pedido',
  Venta: '/venta',
  Iniciar: '/iniciarsesion',
};

@Component({
  selector: 'app-principal',
  imports: [RouterOutlet],

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

  navigateToInformes(): void {
    this.router.navigate([Routes.Informes]);
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
  navigateIniciar(): void {
    this.router.navigate([Routes.Iniciar]);
  }
}
