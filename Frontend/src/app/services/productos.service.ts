import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {
  private apiUrl = 'http://localhost:8000/api'; // Cambia la URL si usas otro backend/puerto

  constructor(private http: HttpClient) {}

  // Obtener todos los productos
  getProductos(): Observable<any> {
    return this.http.get(`${this.apiUrl}/mercancia`);
  }

  // Crear un nuevo producto
  createProducto(producto: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/mercancia`, producto);
  }

  // Actualizar un producto
  updateProducto(id: number, producto: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/mercancia/${id}`, producto);
  }

  // Eliminar un producto por ID
  deleteProducto(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/mercancia/${id}`);
  }

  // Obtener todas las categorías
  getCategorias(): Observable<any> {
    return this.http.get(`${this.apiUrl}/categorias`);
  }

  // Obtener todas las subcategorías
  getSubcategorias(): Observable<any> {
    return this.http.get(`${this.apiUrl}/subcategorias`);
  }

  // Obtener productos por categoría
  getProductosPorCategoria(idCategoria: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/categoria/${idCategoria}`);
  }

  // Obtener productos por subcategoría
  getProductosPorSubcategoria(idSubcategoria: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/subcategoria/${idSubcategoria}`);
  }
}