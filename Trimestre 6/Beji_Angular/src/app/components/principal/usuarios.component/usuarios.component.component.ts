import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../../../services/usuarios.service';
import { Usuario } from '../../../modelos/usuario';
import { HeaderComponentComponent } from '../header.component/header.component.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-usuarios',
  standalone: true,
  templateUrl: './usuarios.component.component.html',
  styleUrls: ['./usuarios.component.component.css'],
  imports:[CommonModule,HeaderComponentComponent],
})
export class UsuariosComponent implements OnInit {
  usuarios: Usuario[] = [];

  constructor(private usuariosService: UsuariosService) {}

  ngOnInit(): void {
    this.usuariosService.getUsuarios().subscribe({
      next: (data) => {
        this.usuarios = data;
        console.log('Usuarios cargados:', this.usuarios);
      },
      error: (error) => {
        console.error('Error al cargar usuarios:', error);
      }
    }); 
  }
  eliminarUsuario(id: number): void {
    const confirmar = window.confirm('¿Estás seguro de que deseas eliminar este usuario?');
  
    if (!confirmar) {
      return; 
    }
  
    this.usuariosService.eliminarUsuario(id).subscribe({
      next: () => {
        this.usuarios = this.usuarios.filter(usuario => usuario.id !== id);
        console.log(`Usuario con id ${id} eliminado.`);
      },
      error: (error) => {
        console.error('Error al eliminar usuario:', error);
      }
    });
  }
}