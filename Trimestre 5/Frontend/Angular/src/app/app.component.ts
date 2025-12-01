import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./header/header.component";
import { ContentComponent } from "./content/content.component";
import { UsuarioComponent } from "./usuario/usuario.component";
import { VentaRComponent } from "./venta-r/venta-r.component";
import { ConsultaVComponent } from "./consulta-v/consulta-v.component";
import { DevolucionesComponent } from "./devoluciones/devoluciones.component";
import { PedidoComponent } from "./pedido/pedido.component";
import { PrincipalComponent } from "./principal/principal.component";
import { ProductosComponent } from './productos/productos.component';
import { CategoriasComponent } from "./categorias/categorias.component";
import { IniciarsesionComponent } from './iniciarsesion/iniciarsesion.component';
import { ProveedoresComponent } from "./proveedores/proveedores.component";
import { RegproveedoresComponent } from "./regproveedores/regproveedores.component";
import { SubcategoriasComponent } from "./subcategorias/subcategorias.component";
import { HombreComponent } from "./hombre/hombre.component";
import { MujerComponent } from "./mujer/mujer.component";
import { NinoComponent } from "./nino/nino.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,HeaderComponent, ContentComponent, UsuarioComponent, VentaRComponent,
    ConsultaVComponent, DevolucionesComponent, PedidoComponent, PrincipalComponent,
    ProductosComponent, CategoriasComponent, IniciarsesionComponent, ProveedoresComponent, RegproveedoresComponent, SubcategoriasComponent, HombreComponent, MujerComponent, NinoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Angular';
}

