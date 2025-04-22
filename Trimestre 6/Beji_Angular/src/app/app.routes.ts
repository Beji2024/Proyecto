import { Routes } from '@angular/router';
import { AuthGuard } from './guard/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  // Rutas públicas
  {
    path: 'login',
    loadComponent: () =>
      import('./components/login/login.component').then(m => m.LoginComponent),
  },

  // Rutas protegidas (requieren autenticación)
  {
    path: 'usuarios',
    loadComponent: () =>
      import('./components/principal/usuarios.component/usuarios.component.component').then(m => m.UsuariosComponent),
    canActivate: [AuthGuard],
  },
  {
    path: 'principal',
    loadComponent: () =>
      import('./components/principal/principal.component').then(m => m.PrincipalComponent),
    canActivate: [AuthGuard],
  },
  {
    path: 'header',
    loadComponent: () =>
      import('./components/principal/header.component/header.component.component').then(m => m.HeaderComponentComponent),
    canActivate: [AuthGuard],
  },

  // Página principal de productos
  {
    path: 'productos',
    loadComponent: () =>
      import('./components/productos/productos.component').then(m => m.ProductosComponent),
  },

  // 🟢 Ruta específica: Nueva categoría
  {
    path: 'productos/nueva-categoria',
    loadComponent: () =>
      import('./components/nueva-categoria/nueva-categoria.component').then(m => m.NuevaCategoriaComponent),
  },

  // 🟠 Ruta específica: Nueva subcategoría
  {
    path: 'productos/nueva-subcategoria',
    loadComponent: () =>
      import('./components/nueva-subcategoria/nueva-subcategoria.component').then(m => m.NuevaSubcategoriaComponent),
  },

  // 🟡 Ruta flexible: categoría o subcategoría (para ver productos por categoría o subcategoría)
  {
    path: 'productos/:categoriaSub',
    loadComponent: () =>
      import('./components/productos/productos.component').then(m => m.ProductosComponent),
  },
<<<<<<< HEAD
=======
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
  { path: 'proveedores', 
    loadComponent: () => import('./proveedores/proveedores.component').then(m=>m.ProveedoresComponent)
  }
>>>>>>> 930e891ef29530aad4274fcaf5e8daaf494d8fce
];
