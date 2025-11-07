import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';  // Asegúrate de importar CommonModule
import { RouterModule } from '@angular/router';  // Asegúrate de importar RouterModule
import { CategoriasService } from '../../../../services/categorias.service';
import { Categoria } from '../../../../modelos/categoria';
import { Subcategoria } from '../../../../modelos/subcategoria';

@Component({
  selector: 'app-menu-categoriasven',
  standalone: true,  // Asegúrate de que el componente es standalone
  imports: [
    CommonModule,  // Importa CommonModule para usar *ngFor
    RouterModule,  // Importa RouterModule para usar [routerLink]
  ],
  templateUrl: './menu-categorias.component.html',
  styleUrls: ['./menu-categorias.component.css']
})
export class MenuCategoriasComponent implements OnInit {
  categorias: Categoria[] = [];
  subcategorias: Subcategoria[] = [];

  constructor(private categoriasService: CategoriasService) {}

  ngOnInit(): void {
    // Cargar las categorías y subcategorías desde el servicio
    this.categoriasService.getCategorias().subscribe(cats => {
      this.categorias = cats;
    });

    this.categoriasService.getSubcategorias().subscribe(subs => {
      this.subcategorias = subs;
    });
  }

  obtenerSubcategorias(categoriaId: number): Subcategoria[] {
    return this.subcategorias.filter(sub => sub.cat_sub === categoriaId);
  }
  

  generarRuta(categoria: string, subcategoria?: string): string {
    return subcategoria ? `/productosven/${categoria}-${subcategoria}` : `/productosven/${categoria}`;
  }
}
