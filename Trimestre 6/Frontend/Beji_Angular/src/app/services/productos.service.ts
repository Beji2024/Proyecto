import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from '../modelos/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {
  private apiUrlProductos = 'http://localhost:8000/api/mercancia';
  
  constructor(private http: HttpClient) {}

  getProductos(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.apiUrlProductos);
  }

  getProductosPorCategoria(idCategoria: number): Observable<Producto[]> {
    return this.http.get<Producto[]>(`${this.apiUrlProductos}/categoria/${idCategoria}`);
  }

  getProductosPorSubcategoria(idSubcategoria: number): Observable<Producto[]> {
    return this.http.get<Producto[]>(`${this.apiUrlProductos}/subcategoria/${idSubcategoria}`);
  }
}
