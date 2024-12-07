import { RouterModule, Routes } from '@angular/router';
import { IniciarsesionComponent } from './iniciarsesion/iniciarsesion.component';
import { PrincipalComponent } from './principal/principal.component';
import { ProveedoresComponent } from './proveedores/proveedores.component';
import { NgModule } from '@angular/core';
import { VentaRComponent } from './venta-r/venta-r.component';
import { UsuarioComponent } from './usuario/usuario.component';

export const routes: Routes = [
    {path: '', redirectTo: 'iniciarsesion', pathMatch: 'full'},
    {path:'iniciarsesion',component:IniciarsesionComponent},
    {path: 'principal', component: PrincipalComponent},
    {path: 'usuario', component:UsuarioComponent},
    {path: 'proveedores', component:ProveedoresComponent},
    {path: 'ventas-r', component:VentaRComponent}
    

        
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],  // Asegúrate de usar RouterModule.forRoot
  exports: [RouterModule]
})
export class AppRoutingModule { }