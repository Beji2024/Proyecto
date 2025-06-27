import { Routes } from '@angular/router';
import { AuthGuard } from './guard/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', 
    loadComponent: () => import('./components/login/login.component').then(m => m.LoginComponent)
  },
  { path: 'usuarios', 
    loadComponent: () => import('./components/principal/usuarios.component/usuarios.component.component').then(m => m.UsuariosComponent),
    canActivate:[AuthGuard]
  },
  { path: 'principal', 
    loadComponent: () => import('./components/principal/principal.component').then(m => m.PrincipalComponent),
    canActivate:[AuthGuard]
  },
  { path: 'header', 
    loadComponent: () => import('./components/principal/header.component/header.component.component').then(m => m.HeaderComponentComponent),
    canActivate:[AuthGuard]
  },
  { path: 'registro', 
    loadComponent: () =>import('./components/principal/usuarios.component/registro/registro.component').then(m => m.RegistroComponent),
    canActivate:[AuthGuard]
  },
  { 
    path: 'editar/:id', 
    loadComponent: () => import('./components/principal/usuarios.component/editar/editar.component').then(m => m.EditarComponent), 
    canActivate: [AuthGuard] 
  },
  { path: 'venta', 
    loadComponent: () => import('./components/principal/venta/venta.component').then(m => m.VentaComponent),
    canActivate:[AuthGuard]
  },
  { path: 'crear-venta', 
    loadComponent: () => import('./components/principal/venta/crear-venta/crear-venta.component').then(m => m.CrearVentaComponent),
    canActivate:[AuthGuard]
  },
  { path: 'consultar-venta', 
    loadComponent: () => import('./components/principal/venta/consultar-venta/consultar-venta.component').then(m => m.ConsultarVentaComponent),
    canActivate:[AuthGuard]
  },
  { path: 'devoluciones-venta', 
    loadComponent: () => import('./components/principal/venta/devoluciones-venta/devoluciones-venta.component').then(m => m.DevolucionesVentaComponent),
    canActivate:[AuthGuard]
  },
  { path: 'cambio-venta/:id', 
    loadComponent: () => import('./components/principal/venta/devoluciones-venta/cambio/cambio.component').then(m => m.CambioComponent),
    canActivate:[AuthGuard]
  },
  {
  path: 'proveedor',
  loadComponent: () => import('./components/principal/Proveedor/proveedores/proveedores.component').then(m => m.ProveedoresComponent),
  canActivate: [AuthGuard]
},
{
  path: 'regproveedores',
  loadComponent: () => import('./components/principal/Proveedor/regproveedores/regproveedores.component').then(m => m.RegproveedoresComponent),
  canActivate: [AuthGuard]
},
{
  path: 'proveditar/:id',
  loadComponent: () => import('./components/principal/Proveedor/proveditar/proveditar.component').then(m => m.ProveditarComponent),


  canActivate: [AuthGuard]
},
{
  path: 'pedido',
  loadComponent: () => import('./components/principal/pedido/pedido.component').then(m => m.PedidoComponent),
  canActivate: [AuthGuard]
}
,
{
  path: 'registros-pedido',
  loadComponent: () => import('./components/principal/pedido/registro/registro-pedido.component').then(m => m.RegistroPedidoComponent),
  canActivate: [AuthGuard]
},
{
  path: 'headerbod',
  loadComponent: () => import('./components/principalbod/headerbod/headerbod.component').then(m => m.HeaderbodComponent),
  canActivate: [AuthGuard]
},
{
  path: 'principalbod',
  loadComponent: () => import('./components/principalbod/principalbod.component').then(m => m.PrincipalbodComponent),
  canActivate: [AuthGuard]
},
{
  path: 'headerven',
  loadComponent: () => import('./components/principalven/headerven/headerven.component').then(m => m.HeadervenComponent),
  canActivate: [AuthGuard]
},
{
  path: 'principalven',
  loadComponent: () => import('./components/principalven/principalven.component').then(m => m.PrincipalvenComponent),
  canActivate: [AuthGuard]
},
{
  path: 'perfil',
  loadComponent: () => import ('./components/principalbod/usuariobod/usuariobod.component').then(m => m.UsuariobodComponent),
  canActivate: [AuthGuard]
},
{
  path: 'perfilven',
  loadComponent: () => import ('./components/principalven/usuarioven/usuarioven.component').then(m => m.UsuariovenComponent),
  canActivate: [AuthGuard]
},
{
  path:'consultarven',
  loadComponent: () => import('./components/principalven/ventasven/consultarven/consultarven.component').then(m => m.ConsultarvenComponent),
  canActivate: [AuthGuard]
},
{
  path:'crearven',
  loadComponent: () => import('./components/principalven/ventasven/crearven/crearven.component').then(m => m.CrearvenComponent),
  canActivate: [AuthGuard]
},
{
  path:'devolucionven',
  loadComponent: () => import('./components/principalven/ventasven/devolucionven/devolucionven.component').then(m => m.DevolucionvenComponent),
  canActivate: [AuthGuard]
},
{
  path:'ventasven',
  loadComponent: () => import ('./components/principalven/ventasven/ventasven.component').then(m => m.VentasvenComponent),
  canActivate: [AuthGuard]
},

{
    path: 'productos',
    loadComponent: () => import('./components/productos/productos/productos.component').then(m => m.ProductosComponent),
  },
  {
    path: 'productos/gestion',
    loadComponent: () => import('./components/productos/gestion-productos/gestion-productos.component').then(m => m.GestionProductosComponent),
    
  },
  {
    path: 'productos/nueva-categoria',
    loadComponent: () => import('./components/categorias y sub/nueva-categoria/nueva-categoria.component').then(m => m.NuevaCategoriaComponent),
  },
  {
    path: 'productos/nueva-subcategoria',
    loadComponent: () => import('./components/categorias y sub/nueva-subcategoria/nueva-subcategoria.component').then(m => m.NuevaSubcategoriaComponent),
  },
  // Ruta dinámica DEBE IR AL FINAL
  {
    path: 'productos/:categoriaSub',
    loadComponent: () => import('./components/productos/productos/productos.component').then(m => m.ProductosComponent),
  }


];
