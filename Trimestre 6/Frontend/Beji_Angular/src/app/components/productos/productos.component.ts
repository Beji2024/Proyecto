import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductosService } from '../../services/productos.service';
import { Producto } from '../../modelos/producto';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CategoriasService } from '../../services/categorias.service';
import { Subcategoria } from '../../modelos/subcategoria';
import { Categoria } from '../../modelos/categoria';
import { MenuCategoriasComponent } from "../menu-categorias/menu-categorias.component";

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    MenuCategoriasComponent
  ],
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {
  productos: Producto[] = [];
  subcategorias: Subcategoria[] = [];
  categorias: Categoria[] = [];
  error: string | null = null;

  constructor(
    private productosService: ProductosService,
    private categoriasService: CategoriasService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // Carga categorías y subcategorías antes de procesar la ruta
    this.categoriasService.getCategorias().subscribe(cats => {
      this.categorias = cats;

      this.categoriasService.getSubcategorias().subscribe(subs => {
        this.subcategorias = subs;

        // Obtiene el parámetro de la ruta
        this.route.params.subscribe(params => {
          const ruta = params['categoriaSub'] || params['nombre']; // 'categoriaSub' o 'nombre' dependiendo de cómo esté configurado
          console.log('Ruta obtenida:', ruta); // Verifica el valor de la ruta

          if (ruta) {
            const partes = ruta.split('-');
            if (partes.length === 1) {
              // Solo categoría
              const nombreCategoria = partes[0];
              this.filtrarPorCategoria(nombreCategoria);
            } else {
              // Categoría + Subcategoría
              const nombreCategoria = partes[0];
              const nombreSubcategoria = partes.slice(1).join('-'); // Maneja casos donde la subcategoría tiene guiones
              this.filtrarPorCategoriaYSubcategoria(nombreCategoria, nombreSubcategoria);
            }
          } else {
            this.obtenerTodos(); // Si no hay categoría ni subcategoría, cargar todos los productos
          }
        });
      });
    });
  }

  obtenerTodos(): void {
    this.productosService.getProductos().subscribe({
      next: (data) => {
        this.productos = data;
        this.error = null;
      },
      error: (err) => {
        this.error = err.message || 'Error al cargar productos.';
      }
    });
  }

  filtrarPorCategoriaYSubcategoria(nombreCategoria: string, nombreSubcategoria: string): void {
    const subcategoria = this.subcategorias.find(sub =>
      sub.nom_sub.toLowerCase() === nombreSubcategoria.toLowerCase() &&
      sub.categoria?.name?.toLowerCase() === nombreCategoria.toLowerCase()
    );

    if (subcategoria) {
      this.productosService.getProductosPorSubcategoria(subcategoria.id_sub).subscribe({
        next: (data) => {
          this.productos = data;
          this.error = null;
        },
        error: () => {
          this.error = 'No se pudo cargar productos por subcategoría.';
        }
      });
    } else {
      this.error = 'Subcategoría no encontrada o mal escrita.';
    }
  }

  filtrarPorCategoria(nombreCategoria: string): void {
    // Verificamos si hay categorías y que el id esté definido
    if (this.categorias && this.categorias.length > 0) {
      const categoria = this.categorias.find(cat => cat.name.toLowerCase() === nombreCategoria.toLowerCase());
      
      // Verificamos que el id de la categoría sea válido (no undefined)
      if (categoria && categoria.id !== undefined) {  // Aseguramos que id no sea undefined
        this.productosService.getProductosPorCategoria(categoria.id).subscribe({
          next: (data) => {
            this.productos = data;
            this.error = null;
          },
          error: () => {
            this.error = 'No se pudo cargar productos por categoría.';
          }
        });
      } else {
        this.error = 'Categoría no encontrada o id inválido.';
      }
    } else {
      this.error = 'No se han cargado las categorías.';
    }
  }
}

