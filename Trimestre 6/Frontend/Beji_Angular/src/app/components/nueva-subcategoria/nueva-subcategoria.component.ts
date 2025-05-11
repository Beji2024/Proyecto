import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CategoriasService } from '../../services/categorias.service';
import { Router } from '@angular/router';
import { Categoria } from '../../modelos/categoria';

@Component({
  selector: 'app-nueva-subcategoria',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './nueva-subcategoria.component.html',
  styleUrls: ['./nueva-subcategoria.component.css']
})
export class NuevaSubcategoriaComponent implements OnInit {
  nombreSubcategoria: string = '';
  categoriaSeleccionada: number | null = null;
  categorias: Categoria[] = [];
  mensajeExito: string = '';
  mensajeError: string = '';

  constructor(
    private categoriasService: CategoriasService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.categoriasService.getCategorias().subscribe({
      next: (data) => this.categorias = data,
      error: (err) => console.error('Error al obtener categorías', err)
    });
  }  
}
