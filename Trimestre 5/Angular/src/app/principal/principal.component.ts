import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { ProveedoresComponent } from '../proveedores/proveedores.component';
import { VentaRComponent } from '../venta-r/venta-r.component';
import { UsuarioComponent } from '../usuario/usuario.component';
import { ProductosComponent } from '../productos/productos.component';

export const Routes = {
  
  Usuario: '/usuario',
  Proveedores: '/proveedores',
  Venta: '/venta-r',
  Producto:'/productos'
};

@Component({
  selector: 'app-principal',
  imports: [RouterOutlet,ProveedoresComponent,VentaRComponent,PrincipalComponent,UsuarioComponent,
    ProductosComponent
  ],

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

  navigateToVenta(): void {
    this.router.navigate([Routes.Venta]);
  }

  navigateToProductos(): void {
    this.router.navigate([Routes.Producto]);
  }
}
