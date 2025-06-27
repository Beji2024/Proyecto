import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProductosService } from '../../../services/productos.service';
import { CategoriasService } from '../../../services/categorias.service';
import { Categoria } from '../../../modelos/categoria';
import { Subcategoria } from '../../../modelos/subcategoria';
import { Producto } from '../../../modelos/producto';
import { MenuCategoriasComponent } from "../../categorias y sub/menu-categorias/menu-categorias.component";
import { HeaderComponentComponent } from "../../principal/header.component/header.component.component";

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
  filteredSubcategorias: Subcategoria[] = [];

  productos: Producto[] = [];
  isFormVisible = false;
  isEditing = false;

  categoriaSeleccionada: number | null = null;
  subcategoriaSeleccionada: number | null = null;

  currentProducto: Partial<Producto> = {
    id_pro: 0,
    nombre: '',
    cantidad: 0,
    precio_venta: 0,
    precio_compra: 0,
    material: '',
    color: '',
    talla: 0, 
    sub_mer: 0
  };

  constructor(
    private productosService: ProductosService,
    private categoriasService: CategoriasService
  ) {}

  ngOnInit(): void {
    this.loadDatos();
    this.loadProductos();
  }

  private loadDatos() {
    this.categoriasService.getCategorias().subscribe(cats => this.categorias = cats);
    this.categoriasService.getSubcategorias().subscribe(subs => {
      this.subcategorias = subs;
      this.filteredSubcategorias = [];
    });
  }

  onCategoriaChange() {
    if (this.categoriaSeleccionada != null) {
      this.filteredSubcategorias = this.subcategorias.filter(
        sub => sub.cat_sub === this.categoriaSeleccionada
      );
    } else {
      this.filteredSubcategorias = [];
    }
    this.subcategoriaSeleccionada = null;
  }

  openForm(edit: boolean = false, prod?: Producto) {
    this.isFormVisible = true;
    this.isEditing = edit;

    if (edit && prod) {
      this.currentProducto = { ...prod };
      this.categoriaSeleccionada = prod.subcategoria?.cat_sub || null;
      this.onCategoriaChange();
      this.subcategoriaSeleccionada = prod.sub_mer;
    } else {
      this.currentProducto = {
        id_pro: 0,
        nombre: '',
        cantidad: 0,
        precio_venta: 0,
        precio_compra: 0,
        material: '',
        color: '',
        talla: 0, 
        sub_mer: 0
      };
      this.categoriaSeleccionada = null;
      this.subcategoriaSeleccionada = null;
      this.filteredSubcategorias = [];
    }
  }

  closeForm() {
    this.isFormVisible = false;
  }

  onSubmit() {
    if (this.subcategoriaSeleccionada != null) {
      this.currentProducto.sub_mer = this.subcategoriaSeleccionada;
    }

    if (this.isEditing && this.currentProducto.id_pro) {
      this.productosService
        .updateProducto(this.currentProducto.id_pro, this.currentProducto)
        .subscribe(() => this.afterSave());
    } else {
      this.productosService
        .createProducto(this.currentProducto)
        .subscribe(() => this.afterSave());
    }
  }

  private afterSave() {
    this.closeForm();
    this.loadProductos();
  }

  editProducto(prod: Producto) {
    this.openForm(true, prod);
  }

  deleteProducto(prod: Producto) {
    if (!prod.id_pro) return;
    this.productosService.deleteProducto(prod.id_pro)
      .subscribe(() => this.loadProductos());
  }

  private loadProductos() {
    this.productosService.getProductos().subscribe({
      next: data => this.productos = data,
      error: err => console.error('Error cargando productos', err)
    });
  }
}
