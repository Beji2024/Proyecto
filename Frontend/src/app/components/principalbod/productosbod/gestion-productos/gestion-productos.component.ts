import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProductosService } from '../../../../services/productos.service';
import { CategoriasService } from '../../../../services/categorias.service';
import { Categoria } from '../../../../modelos/categoria';
import { Subcategoria } from '../../../../modelos/subcategoria';
import { Producto } from '../../../../modelos/producto';
import { HeaderComponentComponent } from "../../../principal/header.component/header.component.component";

@Component({
  selector: 'app-gestion-productos',
  standalone: true,
  imports: [CommonModule, FormsModule, HeaderComponentComponent],
  templateUrl: './gestion-productos.component.html',
  styleUrls: ['./gestion-productos.component.css']
})
export class GestionProductosComponent implements OnInit {
  categorias: Categoria[] = [];
  subcategorias: Subcategoria[] = [];
  productos: Producto[] = [];
  selectedFile: File | null = null;
  
  // Estados
  isFormVisible = false;
  isEditing = false;
  showDeleteModal = false;
  isLoading = false;
  errorMessage: string | null = null;
  
  // Filtros
  filtroCategoria: number | null = null;
  filtroSubcategoria: number | null = null;
  
  // Formulario
  categoriaSeleccionada: number | null = null;
  subcategoriaSeleccionada: number | null = null;
  currentProducto: Partial<Producto> = this.getEmptyProducto();
  productoToDelete: Producto | null = null;

  constructor(
    private productosService: ProductosService,
    private categoriasService: CategoriasService
  ) {}

  ngOnInit(): void {
    this.loadData();
  }

  // Propiedad computada para subcategorías filtradas
  get subcategoriasFiltradas(): Subcategoria[] {
    return this.filtroCategoria 
      ? this.subcategorias.filter(sub => sub.cat_sub === this.filtroCategoria)
      : [];
  }

  // Propiedad computada para subcategorías del formulario
  get subcategoriasForm(): Subcategoria[] {
    return this.categoriaSeleccionada
      ? this.subcategorias.filter(sub => sub.cat_sub === this.categoriaSeleccionada)
      : [];
  }

  private loadData() {
    this.isLoading = true;
    this.errorMessage = null;

    this.productosService.getProductos().subscribe({
      next: (productos) => {
        this.productos = productos;
        this.loadCategorias();
      },
      error: (err) => {
        console.error('Error loading productos:', err);
        this.errorMessage = 'Error al cargar productos';
        this.isLoading = false;
      }
    });
  }

  private loadCategorias() {
    this.categoriasService.getCategorias().subscribe({
      next: (categorias) => {
        this.categorias = categorias;
        this.loadSubcategorias();
      },
      error: (err) => {
        console.error('Error loading categorias:', err);
        this.errorMessage = 'Error al cargar categorías';
        this.isLoading = false;
      }
    });
  }

  private loadSubcategorias() {
    this.categoriasService.getSubcategorias().subscribe({
      next: (subcategorias) => {
        this.subcategorias = subcategorias;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error loading subcategorias:', err);
        this.errorMessage = 'Error al cargar subcategorías';
        this.isLoading = false;
      }
    });
  }

  private getEmptyProducto(): Partial<Producto> {
    return {
      id_pro: 0,
      nombre: '',
      cantidad: 0,
      precio_venta: 0,
      precio_compra: 0,
      material: '',
      color: '',
      talla: 0,
      sub_mer: 0,
      imagen: ''
    };
  }

  filtrarPorCategoria(idCategoria: number | null) {
    this.filtroCategoria = idCategoria;
    this.filtroSubcategoria = null;
    this.isLoading = true;

    if (idCategoria) {
      this.productosService.getProductosPorCategoria(idCategoria).subscribe({
        next: (productos) => {
          this.productos = productos;
          this.isLoading = false;
        },
        error: (err) => {
          console.error('Error al filtrar por categoría:', err);
          this.errorMessage = 'Error al filtrar productos';
          this.isLoading = false;
        }
      });
    } else {
      this.loadData();
    }
  }

  filtrarPorSubcategoria(idSubcategoria: number | null) {
    this.filtroSubcategoria = idSubcategoria;
    this.isLoading = true;

    if (idSubcategoria) {
      this.productosService.getProductosPorSubcategoria(idSubcategoria).subscribe({
        next: (productos) => {
          this.productos = productos;
          this.isLoading = false;
        },
        error: (err) => {
          console.error('Error al filtrar por subcategoría:', err);
          this.errorMessage = 'Error al filtrar productos';
          this.isLoading = false;
        }
      });
    } else {
      this.filtrarPorCategoria(this.filtroCategoria);
    }
  }

  resetFiltros() {
    this.filtroCategoria = null;
    this.filtroSubcategoria = null;
    this.loadData();
  }

  onCategoriaChange() {
    this.subcategoriaSeleccionada = null;
  }

  openForm(edit: boolean = false, prod?: Producto) {
    this.isFormVisible = true;
    this.isEditing = edit;
    this.errorMessage = null;

    if (edit && prod) {
      this.currentProducto = { ...prod };
      this.categoriaSeleccionada = prod.subcategoria?.cat_sub || null;
      this.subcategoriaSeleccionada = prod.sub_mer;
    } else {
      this.currentProducto = this.getEmptyProducto();
      this.categoriaSeleccionada = null;
      this.subcategoriaSeleccionada = null;
    }
    this.selectedFile = null;
  }

  closeForm() {
    this.isFormVisible = false;
  }

  // Captura archivo seleccionado
  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.selectedFile = input.files[0];
    }
  }

  onSubmit() {
    if (!this.subcategoriaSeleccionada) {
      this.errorMessage = 'Debe seleccionar una subcategoría';
      return;
    }

    this.currentProducto.sub_mer = this.subcategoriaSeleccionada;

    // Construimos FormData
    const formData = new FormData();
    Object.entries(this.currentProducto).forEach(([key, value]) => {
      if (value !== null && value !== undefined) {
        formData.append(key, value.toString());
      }
    });

    if (this.selectedFile) {
      formData.append('imagen', this.selectedFile);
    }

    const operation = this.isEditing && this.currentProducto.id_pro
      ? this.productosService.updateProducto(this.currentProducto.id_pro!, formData)
      : this.productosService.createProducto(formData);

    this.isLoading = true;
    operation.subscribe({
      next: () => {
        this.closeForm();
        this.loadData();
        this.selectedFile = null;
      },
      error: (err) => {
        console.error('Error saving product:', err);
        this.errorMessage = 'Error al guardar el producto';
        this.isLoading = false;
      }
    });
  }

  editProducto(prod: Producto) {
    this.openForm(true, prod);
  }

  deleteProducto(prod: Producto) {
    this.productoToDelete = prod;
    this.showDeleteModal = true;
  }

  confirmDelete() {
    if (this.productoToDelete?.id_pro) {
      this.isLoading = true;
      this.productosService.deleteProducto(this.productoToDelete.id_pro).subscribe({
        next: () => {
          this.closeDeleteModal();
          this.loadData();
        },
        error: (err) => {
          console.error('Error deleting product:', err);
          this.errorMessage = 'Error al eliminar el producto';
          this.closeDeleteModal();
          this.isLoading = false;
        }
      });
    }
  }

  closeDeleteModal() {
    this.showDeleteModal = false;
    this.productoToDelete = null;
  }
}
