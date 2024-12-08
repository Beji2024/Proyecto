import { RouterModule, Routes } from '@angular/router';
import { IniciarsesionComponent } from './iniciarsesion/iniciarsesion.component';
import { PrincipalComponent } from './principal/principal.component';
import { ProveedoresComponent } from './proveedores/proveedores.component';
import { Component, NgModule } from '@angular/core';
import { VentaRComponent } from './venta-r/venta-r.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { ProductosComponent } from './productos/productos.component';
import { RegproveedoresComponent } from './regproveedores/regproveedores.component';
import { ProveditarComponent } from './proveditar/proveditar.component';
import { ContentComponent } from './content/content.component'
import { PedidoComponent } from './pedido/pedido.component';
import { UsuarioeditComponent } from './usuarioedit/usuarioedit.component';
import { VentaComponent } from './venta/venta.component';
import { ConsultaVComponent } from './consulta-v/consulta-v.component';
import { DevolucionesComponent } from './devoluciones/devoluciones.component';
import { CambioComponent } from './cambio/cambio.component';
export const routes: Routes = [
    {path: '', redirectTo: 'iniciarsesion', pathMatch: 'full'},
    {path:'iniciarsesion',component:IniciarsesionComponent},
    {path: 'principal', component: PrincipalComponent},
    {path: 'usuario', component:UsuarioComponent},
    {path: 'proveedores', component:ProveedoresComponent},
    {path: 'venta-r', component:VentaRComponent},
    {path:'productos',component:ProductosComponent},
    {path: 'regproveedores', component:RegproveedoresComponent},
    {path:'proveditar',component:ProveditarComponent},
    {path: 'content', component:ContentComponent},
    {path: 'pedido', component:PedidoComponent},
    {path: 'editaru', component:UsuarioeditComponent}, 
    {path: 'venta', component:VentaComponent},
    {path:'consultar-v',component:ConsultaVComponent},
    {path:'devoluciones',component:DevolucionesComponent},
    {path:'cambio',component:CambioComponent}

]
@NgModule({
  imports: [RouterModule.forRoot(routes)],  // Asegúrate de usar RouterModule.forRoot
  exports: [RouterModule]
})
export class AppRoutingModule { }