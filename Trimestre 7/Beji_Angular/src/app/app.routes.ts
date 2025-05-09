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

];
