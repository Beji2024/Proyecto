import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductosService } from '../../../../services/productos.service';
import { Producto } from '../../../../modelos/producto';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CategoriasService } from '../../../../services/categorias.service';
import { Subcategoria } from '../../../../modelos/subcategoria';
import { Categoria } from '../../../../modelos/categoria';
import { MenuCategoriasComponent } from "../../categorias_bodegero/menu-categorias/menu-categorias.component";
import { HeaderbodComponent } from "../../headerbod/headerbod.component";
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    MenuCategoriasComponent,
    HeaderbodComponent
  ],
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {
  productos: Producto[] = [];
  todosLosProductos: Producto[] = [];
  subcategorias: Subcategoria[] = [];
  categorias: Categoria[] = [];
  error: string | null = null;
  terminoBusqueda: string = '';

  constructor(
    private productosService: ProductosService,
    private categoriasService: CategoriasService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.categoriasService.getCategorias().subscribe(cats => {
      this.categorias = cats;

      this.categoriasService.getSubcategorias().subscribe(subs => {
        this.subcategorias = subs;

        this.route.params.subscribe(params => {
          const ruta = params['categoriaSub'] || params['nombre'];

          if (ruta) {
            const partes = ruta.split('-');

            if (partes.length === 1) {
              const nombreCategoria = partes[0];
              this.filtrarPorCategoria(nombreCategoria);
            } else {
              const nombreCategoria = partes[0];
              const nombreSubcategoria = partes.slice(1).join('-');
              this.filtrarPorCategoriaYSubcategoria(nombreCategoria, nombreSubcategoria);
            }
          } else {
            this.obtenerTodos();
          }
        });
      });
    });
  }

  obtenerTodos(): void {
    this.productosService.getProductos().subscribe({
      next: (data) => {
        this.todosLosProductos = data;
        this.productos = data;
        this.error = null;
      },
      error: (err) => {
        this.error = err.message || 'Error al cargar productos.';
      }
    });
  }

  filtrarPorCategoria(nombreCategoria: string): void {
    const categoria = this.categorias.find(cat => 
      cat.name.toLowerCase() === nombreCategoria.toLowerCase()
    );

    if (categoria && categoria.id !== undefined) {
      this.productosService.getProductosPorCategoria(categoria.id).subscribe({
        next: (data) => {
          this.todosLosProductos = data;
          this.productos = data;
          this.error = null;
        },
        error: () => {
          this.error = 'No se pudo cargar productos por categoría.';
        }
      });
    } else {
      this.error = 'Categoría no encontrada.';
    }
  }

  filtrarPorCategoriaYSubcategoria(nombreCategoria: string, nombreSubcategoria: string): void {
    const subcategoria = this.subcategorias.find(sub =>
      sub.nom_sub.toLowerCase() === nombreSubcategoria.toLowerCase() &&
      sub.categoria?.name?.toLowerCase() === nombreCategoria.toLowerCase()
    );

    if (subcategoria) {
      this.productosService.getProductosPorSubcategoria(subcategoria.id_sub).subscribe({
        next: (data) => {
          this.todosLosProductos = data;
          this.productos = data;
          this.error = null;
        },
        error: () => {
          this.error = 'No se pudo cargar productos por subcategoría.';
        }
      });
    } else {
      this.error = 'Subcategoría no encontrada o no coincide con la categoría.';
    }
  }

  buscarProductos(): void {
  const termino = this.terminoBusqueda.toLowerCase();
  this.productos = this.todosLosProductos.filter(p =>
    String(p.nombre).toLowerCase().includes(termino) ||
    String(p.material).toLowerCase().includes(termino) ||
    String(p.color).toLowerCase().includes(termino) ||
    String(p.talla).toLowerCase().includes(termino)
    );
  }
}
