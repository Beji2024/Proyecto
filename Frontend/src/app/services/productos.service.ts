import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from '../modelos/producto';
import { Categoria } from '../modelos/categoria';
import { Subcategoria } from '../modelos/subcategoria';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {
  private apiUrl = 'http://localhost:8000/api';

  constructor(private http: HttpClient) {}

  getProductos(): Observable<Producto[]> {
    return this.http.get<Producto[]>(`${this.apiUrl}/mercancia`, {
      params: { 'with': 'subcategoria.categoria' }
    });
  }

  createProducto(producto: FormData): Observable<Producto> {
  return this.http.post<Producto>(`${this.apiUrl}/mercancia`, producto);
}

updateProducto(id: number, producto: FormData): Observable<Producto> {
  return this.http.post<Producto>(`${this.apiUrl}/mercancia/${id}?_method=PUT`, producto);
  // usamos POST con _method=PUT porque FormData no se lleva bien con PUT en Laravel
}

  deleteProducto(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/mercancia/${id}`);
  }

  getCategorias(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(`${this.apiUrl}/categorias`);
  }

  getSubcategorias(): Observable<Subcategoria[]> {
    return this.http.get<Subcategoria[]>(`${this.apiUrl}/subcategorias`);
  }

  getProductosPorCategoria(idCategoria: number): Observable<Producto[]> {
  return this.http.get<Producto[]>(`${this.apiUrl}/mercancia/categoria/${idCategoria}`);
}


  getProductosPorSubcategoria(idSubcategoria: number): Observable<Producto[]> {
  return this.http.get<Producto[]>(`${this.apiUrl}/mercancia/subcategoria/${idSubcategoria}`);
  }

}