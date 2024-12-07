import { RouterModule, Routes } from '@angular/router';
import { IniciarsesionComponent } from './iniciarsesion/iniciarsesion.component';
import { PrincipalComponent } from './principal/principal.component';
import { ProveedoresComponent } from './proveedores/proveedores.component';
import { NgModule } from '@angular/core';
import { VentaRComponent } from './venta-r/venta-r.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { ProductosComponent } from './productos/productos.component';
import { RegproveedoresComponent } from './regproveedores/regproveedores.component';

export const routes: Routes = [
    {path: '', redirectTo: 'iniciarsesion', pathMatch: 'full'},
    {path:'iniciarsesion',component:IniciarsesionComponent},
    {path: 'principal', component: PrincipalComponent},
    {path: 'usuario', component:UsuarioComponent},
    {path: 'proveedores', component:ProveedoresComponent},
    {path: 'venta-r', component:VentaRComponent},
    {path:'productos',component:ProductosComponent},
    {path: 'regproveedores', component:RegproveedoresComponent}

        
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],  // Asegúrate de usar RouterModule.forRoot
  exports: [RouterModule]
})
export class AppRoutingModule { }