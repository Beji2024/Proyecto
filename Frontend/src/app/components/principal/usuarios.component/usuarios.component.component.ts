import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../../../services/usuarios.service';
import { Usuario } from '../../../modelos/usuario';
import { HeaderComponentComponent } from '../header.component/header.component.component';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-usuarios',
  standalone: true,
  templateUrl: './usuarios.component.component.html',
  styleUrls: ['./usuarios.component.component.css'],
  imports:[CommonModule,HeaderComponentComponent,RouterModule],
})
export class UsuariosComponent implements OnInit {
   usuarios: Usuario[] = [];
  usuariosPaginados: Usuario[] = [];

  paginaActual: number = 1;
  usuariosPorPagina: number = 2;

  constructor(private usuariosService: UsuariosService, private router: Router) {}

  ngOnInit(): void {
    this.usuariosService.getUsuarios().subscribe({
      next: (data) => {
        this.usuarios = data;
        console.log('Usuarios cargados:', this.usuarios);
        this.actualizarUsuariosPaginados();
      },
      error: (error) => {
        console.error('Error al cargar usuarios:', error);
      }
    });
  }

  actualizarUsuariosPaginados(): void {
    const inicio = (this.paginaActual - 1) * this.usuariosPorPagina;
    const fin = inicio + this.usuariosPorPagina;
    this.usuariosPaginados = this.usuarios.slice(inicio, fin);
  }

  cambiarPagina(nuevaPagina: number): void {
    if (nuevaPagina < 1 || nuevaPagina > this.totalPaginas) return;
    this.paginaActual = nuevaPagina;
    this.actualizarUsuariosPaginados();
  }

  get totalPaginas(): number {
    return Math.ceil(this.usuarios.length / this.usuariosPorPagina);
  }

  get paginas(): number[] {
    return Array.from({ length: this.totalPaginas }, (_, i) => i + 1);
  }

  eliminarUsuario(id: number): void {
    const confirmar = window.confirm('¿Estás seguro de que deseas eliminar este usuario?');
  
    if (!confirmar) {
      return; 
    }
  
    this.usuariosService.eliminarUsuario(id).subscribe({
      next: () => {
        this.usuarios = this.usuarios.filter(usuario => usuario.id !== id);
        this.actualizarUsuariosPaginados();
        console.log(`Usuario con id ${id} eliminado.`);
      },
      error: (error) => {
        console.error('Error al eliminar usuario:', error);
      }
    });
  }
  IRRegistro() {
    this.router.navigate(['/registro']);
  }
  editarUsuario(id: number) {
    this.router.navigate(['/editar', id]);
  }
}