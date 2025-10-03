import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CategoriasService } from '../../../../services/categorias.service';
import { Router } from '@angular/router';
import { HeaderComponentComponent } from "../../../principal/header.component/header.component.component";

@Component({
  selector: 'app-nueva-categoriabod',
  standalone: true,
  imports: [CommonModule, FormsModule, HeaderComponentComponent],
  templateUrl: './nueva-categoria.component.html',
  styleUrls: ['./nueva-categoria.component.css']
})
export class NuevaCategoriaComponent implements OnInit {
  nombreCategoria: string = '';
  categorias: any[] = [];
  mostrarConfirmacion: boolean = false;
  mostrarExito: boolean = false;
  mostrarConfirmacionEliminarModal: boolean = false;
  categoriaAEliminar: any = null;
  mensajeError: string = '';
  cargando: boolean = false;

  constructor(
    private categoriasService: CategoriasService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cargarCategorias();
  }

  cargarCategorias(): void {
    this.categoriasService.getCategorias().subscribe({
      next: (data) => {
        this.categorias = data.map(c => ({ ...c, editando: false }));
      },
      error: (err) => {
        console.error('Error al cargar categorías:', err);
      }
    });
  }

  crearCategoria() {
  if (!this.nombreCategoria.trim()) {
    this.mensajeError = 'El nombre de la categoría es requerido';
    return;
  }
  
  this.cargando = true;
  this.mensajeError = '';
  
  this.categoriasService.crearCategoria({ name: this.nombreCategoria }).subscribe({
    next: () => {
      this.mostrarConfirmacion = false;
      this.mostrarExito = true;
      this.nombreCategoria = '';
      this.cargando = false;
      this.cargarCategorias();
    },
    error: (err) => {
      this.cargando = false;
      console.error('Error completo:', err);
      
      if (err.status === 401) {
        this.mensajeError = 'No autorizado - debe iniciar sesión';
      } else if (err.status === 422) {
        this.mensajeError = err.error?.message || 'Datos inválidos';
      } else {
        this.mensajeError = 'Error al crear categoría. Intente nuevamente.';
      }
    }
  });
}

  confirmarCreacion() {
    this.categoriasService.crearCategoria({ name: this.nombreCategoria }).subscribe({
      next: () => {
        this.mostrarConfirmacion = false;
        this.mostrarExito = true;
        this.nombreCategoria = '';
        this.cargarCategorias();
      },
      error: (err) => {
        console.error('Error al crear categoría:', err);
      }
    });
  }

  activarEdicion(categoria: any) {
    categoria.editando = true;
  }

  guardarCambios(categoria: any) {
    this.categoriasService.actualizarCategoria(categoria.id, { name: categoria.name }).subscribe({
      next: () => {
        categoria.editando = false;
        this.cargarCategorias();
      },
      error: (err) => {
        console.error('Error al actualizar categoría:', err);
      }
    });
  }

  mostrarConfirmacionEliminar(categoria: any) {
    this.categoriaAEliminar = categoria;
    this.mostrarConfirmacionEliminarModal = true;
  }

  confirmarEliminacion() {
    if (this.categoriaAEliminar) {
      this.categoriasService.eliminarCategoria(this.categoriaAEliminar.id).subscribe({
        next: () => {
          this.mostrarConfirmacionEliminarModal = false;
          this.cargarCategorias();
        },
        error: (err) => {
          console.error('Error al eliminar categoría:', err);
        }
      });
    }
  }

  cerrarExito() {
    this.mostrarExito = false;
  }
}