import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CategoriasService } from '../../../services/categorias.service';
import { SubcategoriasService } from '../../../services/subcategorias.service';
import { Router } from '@angular/router';
import { Categoria } from '../../../modelos/categoria';
import { Subcategoria } from '../../../modelos/subcategoria';
import { HeaderComponentComponent } from "../../principal/header.component/header.component.component";

@Component({
  selector: 'app-nueva-subcategoria',
  standalone: true,
  imports: [CommonModule, FormsModule, HeaderComponentComponent],
  templateUrl: './nueva-subcategoria.component.html',
  styleUrls: ['./nueva-subcategoria.component.css']
})
export class NuevaSubcategoriaComponent implements OnInit {
  nombreSubcategoria: string = '';
  categoriaSeleccionada: number | null = null;
  categorias: Categoria[] = [];
  subcategorias: (Subcategoria & { editando?: boolean, originalData?: any })[] = [];
  mensajeExito: string = '';
  mensajeError: string = '';
  mostrarConfirmacionEliminarModal: boolean = false;
  subcategoriaAEliminar: Subcategoria | null = null;

  constructor(
    private categoriasService: CategoriasService,
    private subcategoriasService: SubcategoriasService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cargarDatos();
  }

  cargarDatos(): void {
    this.categoriasService.getCategorias().subscribe({
      next: (data) => this.categorias = data,
      error: (err) => console.error('Error al obtener categorías', err)
    });

    this.subcategoriasService.getSubcategorias().subscribe({
      next: (data) => {
        this.subcategorias = data.map(sc => ({ ...sc, editando: false }));
      },
      error: (err) => console.error('Error al obtener subcategorías', err)
    });
  }

  getNombreCategoria(id: number): string {
    const categoria = this.categorias.find(c => c.id === id);
    return categoria ? categoria.name : 'Desconocida';
  }

  crearSubcategoria() {
  if (this.categoriaSeleccionada && this.nombreSubcategoria.trim() !== '') {
    // Envía cat_sub en lugar de categoria
    this.subcategoriasService.crearSubcategoria({
      nom_sub: this.nombreSubcategoria,
      cat_sub: this.categoriaSeleccionada // Cambiado de 'categoria' a 'cat_sub'
    }).subscribe({
      next: () => {
        this.mensajeExito = 'Subcategoría creada con éxito.';
        this.nombreSubcategoria = '';
        this.categoriaSeleccionada = null;
        this.cargarDatos();
      },
      error: (err) => {
        this.mensajeError = 'Error al crear subcategoría: ' + (err.error?.message || err.message);
        console.error('Error completo:', err);
      }
    });
  } else {
    this.mensajeError = 'Debe completar todos los campos';
  }
}

  activarEdicion(subcategoria: any) {
    subcategoria.editando = true;
    subcategoria.originalData = {
      nom_sub: subcategoria.nom_sub,
      cat_sub: subcategoria.cat_sub
    };
  }

  guardarCambios(subcategoria: any) {
    this.subcategoriasService.actualizarSubcategoria(subcategoria.id_sub, {
      nom_sub: subcategoria.nom_sub,
      cat_sub: subcategoria.cat_sub
    }).subscribe({
      next: () => {
        subcategoria.editando = false;
        this.mensajeExito = 'Subcategoría actualizada con éxito.';
        this.cargarDatos();
      },
      error: (err) => {
        this.mensajeError = 'Error al actualizar subcategoría.';
        console.error('Error al actualizar subcategoría:', err);
      }
    });
  }

  cancelarEdicion(subcategoria: any) {
    subcategoria.editando = false;
    subcategoria.nom_sub = subcategoria.originalData.nom_sub;
    subcategoria.cat_sub = subcategoria.originalData.cat_sub;
  }

  mostrarConfirmacionEliminar(subcategoria: Subcategoria) {
    this.subcategoriaAEliminar = subcategoria;
    this.mostrarConfirmacionEliminarModal = true;
  }

  confirmarEliminacion() {
    if (this.subcategoriaAEliminar) {
      this.subcategoriasService.eliminarSubcategoria(this.subcategoriaAEliminar.id_sub).subscribe({
        next: () => {
          this.mostrarConfirmacionEliminarModal = false;
          this.mensajeExito = 'Subcategoría eliminada con éxito.';
          this.cargarDatos();
        },
        error: (err) => {
          this.mensajeError = 'Error al eliminar subcategoría.';
          console.error('Error al eliminar subcategoría:', err);
        }
      });
    }
  }
}