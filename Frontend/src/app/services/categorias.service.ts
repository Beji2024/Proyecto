import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Categoria } from '../modelos/categoria';
import { Subcategoria } from '../modelos/subcategoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {
  private apiUrlCategorias = 'http://localhost:8000/api/categorias';
  private apiUrlSubcategorias = 'http://localhost:8000/api/subcategorias';

  constructor(private http: HttpClient) {}

  // Obtener todas las categorías
  getCategorias(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.apiUrlCategorias);
  }

  // Obtener todas las subcategorías
  getSubcategorias(): Observable<Subcategoria[]> {
    return this.http.get<Subcategoria[]>(this.apiUrlSubcategorias);
  }

  // Crear una nueva categoría
  crearCategoria(categoria: Categoria): Observable<Categoria> {
  return this.http.post<Categoria>(this.apiUrlCategorias, categoria, {
    headers: {
      'Authorization': `Bearer ${localStorage.getItem('token')}`,
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    }
  });
}

  // Crear una nueva subcategoría
  crearSubcategoria(subcategoria: { nom_sub: string, categoria: Categoria }): Observable<Subcategoria> {
    return this.http.post<Subcategoria>(this.apiUrlSubcategorias, subcategoria);
  }
  // Actualizar una categoría
  actualizarCategoria(id: number, categoria: Categoria): Observable<Categoria> {
    return this.http.put<Categoria>(`${this.apiUrlCategorias}/${id}`, categoria);
  }

  // Eliminar una categoría
  eliminarCategoria(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrlCategorias}/${id}`);
  }
}
