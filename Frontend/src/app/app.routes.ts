import { Routes } from '@angular/router';
import { AuthGuard } from './guard/auth.guard';

export const routes: Routes = [
  { path: 'login', 
    loadComponent: () => import('./components/login/login.component').then(m => m.LoginComponent)
  },
  { path: 'usuarios', 
    loadComponent: () => import('./components/principal/usuarios.component/usuarios.component.component').then(m => m.UsuariosComponent),
  },
  { path: 'principal', 
    loadComponent: () => import('./components/principal/principal.component').then(m => m.PrincipalComponent),
  },
  { path: 'header', 
    loadComponent: () => import('./components/principal/header.component/header.component.component').then(m => m.HeaderComponentComponent),
  },
  { path: 'registro', 
    loadComponent: () =>import('./components/principal/usuarios.component/registro/registro.component').then(m => m.RegistroComponent),
  },
  { 
    path: 'editar/:id', 
    loadComponent: () => import('./components/principal/usuarios.component/editar/editar.component').then(m => m.EditarComponent), 
  },
  { path: 'venta', 
    loadComponent: () => import('./components/principal/venta/venta.component').then(m => m.VentaComponent),
  },
  { path: 'crear-venta', 
    loadComponent: () => import('./components/principal/venta/crear-venta/crear-venta.component').then(m => m.CrearVentaComponent),
  },
  { path: 'consultar-venta', 
    loadComponent: () => import('./components/principal/venta/consultar-venta/consultar-venta.component').then(m => m.ConsultarVentaComponent),
  },
  { path: 'devoluciones-venta', 
    loadComponent: () => import('./components/principal/venta/devoluciones-venta/devoluciones-venta.component').then(m => m.DevolucionesVentaComponent),
  },
  { path: 'cambio-venta/:id', 
    loadComponent: () => import('./components/principal/venta/devoluciones-venta/cambio/cambio.component').then(m => m.CambioComponent),
  },
  {
    path: 'proveedor',
    loadComponent: () => import('./components/principal/Proveedor/proveedores/proveedores.component').then(m => m.ProveedoresComponent),
  },
  {
    path: 'regproveedores',
    loadComponent: () => import('./components/principal/Proveedor/regproveedores/regproveedores.component').then(m => m.RegproveedoresComponent),
  },
  {
    path: 'proveditar/:id',
    loadComponent: () => import('./components/principal/Proveedor/proveditar/proveditar.component').then(m => m.ProveditarComponent),
  },
  {
    path: 'pedido',
    loadComponent: () => import('./components/principal/pedido/pedido.component').then(m => m.PedidoComponent),
  }
  ,
  {
    path: 'registros-pedido',
    loadComponent: () => import('./components/principal/pedido/registro/registro-pedido.component').then(m => m.RegistroPedidoComponent),
  },
  {
    path: 'headerbod',
    loadComponent: () => import('./components/principalbod/headerbod/headerbod.component').then(m => m.HeaderbodComponent),
  },
  {
    path: 'principalbod',
    loadComponent: () => import('./components/principalbod/principalbod.component').then(m => m.PrincipalbodComponent),
  },
  {
    path: 'headerven',
    loadComponent: () => import('./components/principalven/headerven/headerven.component').then(m => m.HeadervenComponent),
  },
  {
    path: 'principalven',
    loadComponent: () => import('./components/principalven/principalven.component').then(m => m.PrincipalvenComponent),
  },
  {
    path: 'perfil',
    loadComponent: () => import ('./components/principalbod/usuariobod/usuariobod.component').then(m => m.UsuariobodComponent),
  },
  {
    path: 'perfilven',
    loadComponent: () => import ('./components/principalven/usuarioven/usuarioven.component').then(m => m.UsuariovenComponent),
  },
  {
    path:'consultarven',
    loadComponent: () => import('./components/principalven/ventasven/consultarven/consultarven.component').then(m => m.ConsultarvenComponent),
  },
  {
    path:'crearven',
    loadComponent: () => import('./components/principalven/ventasven/crearven/crearven.component').then(m => m.CrearvenComponent),
  },
  {
    path:'devolucionven',
    loadComponent: () => import('./components/principalven/ventasven/devolucionven/devolucionven.component').then(m => m.DevolucionvenComponent),
  },
  {
    path:'ventasven',
    loadComponent: () => import ('./components/principalven/ventasven/ventasven.component').then(m => m.VentasvenComponent),
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
  {
    path: 'productos/:categoriaSub',
    loadComponent: () => import('./components/productos/productos/productos.component').then(m => m.ProductosComponent),
  }


];