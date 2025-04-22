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
];
