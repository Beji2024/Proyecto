import { Component, OnInit } from '@angular/core';
import { HttpClient,HttpClientModule } from '@angular/common/http';
import { ProveedorService } from './proveedor.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HeaderComponentComponent } from '../../header.component/header.component.component';
@Component({
  selector: 'app-proveedores',
  templateUrl: './proveedores.component.html',
  imports: [CommonModule, FormsModule, HttpClientModule, RouterModule, HeaderComponentComponent],
})
export class ProveedoresComponent implements OnInit {
  proveedores: any[] = [];
  busqueda: string = '';
  proveedoresFiltrados: any[] = []; 

  constructor(
    private http: HttpClient,
    private proveedorService: ProveedorService,
    private router: Router,

  ) {}

  ngOnInit(): void {
    this.cargarProveedores();

    this.proveedorService.actualizarProveedores$.subscribe(() => {
      this.cargarProveedores();
    });
  }

  currentPage: number = 1;
  lastPage: number = 1;

cargarProveedores(page: number = 1): void {
  this.http.get<any>(`http://localhost:8000/api/proveedores?page=${page}`).subscribe(data => {
    this.proveedores = data.data;
    this.proveedoresFiltrados = this.proveedores;
    this.currentPage = data.current_page;
    this.lastPage = data.last_page;
  });
}

  eliminarProveedor(id: number): void {
    if (confirm('¿Estás seguro de que deseas eliminar este proveedor?')) {
      this.http.delete(`http://localhost:8000/api/proveedores/${id}`).subscribe(() => {
        this.cargarProveedores();
      });
    }
  }

  editarProveedor(proveedor: any): void {
  if (!proveedor || !proveedor.id) {
    console.error('Proveedor sin ID:', proveedor);
    return;
  }
  this.router.navigate(['/proveditar', proveedor.id]);
}
  

  buscarProveedor(): void {
    const term = this.busqueda.toLowerCase();

    if (term.trim() === '') {
      this.proveedoresFiltrados = this.proveedores;
      return;
    }

    this.proveedoresFiltrados = this.proveedores.filter(p =>
      (p.nombre?.toLowerCase() || '').includes(term) ||
      (p.marca?.toLowerCase() || '').includes(term) ||
      (p.nit?.toString() || '').includes(term)
    );
  }

  cambiarPagina(page: number): void {
    if (page >= 1 && page <= this.lastPage) {
      this.currentPage = page;
      this.cargarProveedores(page);

      // Reaplicar el filtro si hay búsqueda activa
      if (this.busqueda.trim() !== '') {
        setTimeout(() => this.buscarProveedor(), 50);
      }
    }
  }
}

