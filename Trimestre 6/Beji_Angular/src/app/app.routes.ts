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
  }
];
