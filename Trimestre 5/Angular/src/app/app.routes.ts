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
import { HombreComponent } from './hombre/hombre.component';
import { MujerComponent } from './mujer/mujer.component';
import { NinoComponent } from './nino/nino.component';
import { CategoriasComponent } from './categorias/categorias.component';
import { SubcategoriasComponent } from './subcategorias/subcategorias.component';
import { GesproComponent } from './gespro/gespro.component';
import { ModiproComponent } from './modipro/modipro.component';
import { RegiproComponent } from './regipro/regipro.component';
import { HombreeleComponent } from './subcates/hombreele/hombreele.component';
import { HombreguaComponent } from './subcates/hombregua/hombregua.component';
import { HombredepComponent } from './subcates/hombredep/hombredep.component';
import { MujereleComponent } from './subcates/mujerele/mujerele.component';
import { MujerdeComponent } from './subcates/mujerde/mujerde.component';
import { MujerplaComponent } from './subcates/mujerpla/mujerpla.component';
import { NonoesComponent } from './subcates/nonoes/nonoes.component';
import { NinopanComponent } from './subcates/ninopan/ninopan.component';
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
    {path:'cambio',component:CambioComponent},
    {path:'productos/hombre',component:HombreComponent},
    {path:'productos/mujer',component:MujerComponent},
    {path:'productos/niño',component:NinoComponent},
    {path:'productos/new-categoria',component:CategoriasComponent},
    {path:'productos/new-subcategoria',component:SubcategoriasComponent},
    {path:'productos/gestión',component:GesproComponent},
    {path:'productos/gestión/modificar',component:ModiproComponent},
    {path:'productos/gestión/nuevoproducto',component:RegiproComponent},
    {path:'productos/hombre-elegante',component:HombreeleComponent},
    {path:'productos/hombre-guayos',component:HombreguaComponent},
    {path:'productos/hombre-deportivo',component:HombredepComponent},
    {path:'productos/mujer-elegante',component:MujereleComponent},
    {path:'productos/mujer-deportivo',component:MujerdeComponent},
    {path:'productos/mujer-plataformas',component:MujerplaComponent},
    {path:'productos/niño-escolar',component:NonoesComponent},
    {path:'productos/niño-pantaneras',component:NinopanComponent}
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],  // Asegúrate de usar RouterModule.forRoot
  exports: [RouterModule]
})
export class AppRoutingModule { }