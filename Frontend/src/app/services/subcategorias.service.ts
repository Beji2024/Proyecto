import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Subcategoria } from '../modelos/subcategoria';

@Injectable({
  providedIn: 'root'
})
export class SubcategoriasService {
  private apiUrl = 'http://localhost:8000/api/subcategorias';

  constructor(private http: HttpClient) {}

  getSubcategorias(): Observable<Subcategoria[]> {
    return this.http.get<Subcategoria[]>(this.apiUrl);
  }

  crearSubcategoria(subcategoria: { nom_sub: string, cat_sub: number }): Observable<Subcategoria> {
    return this.http.post<Subcategoria>(this.apiUrl, subcategoria);
  }

  actualizarSubcategoria(id: number, subcategoria: { nom_sub: string, cat_sub: number }): Observable<Subcategoria> {
    return this.http.put<Subcategoria>(`${this.apiUrl}/${id}`, subcategoria);
  }

  eliminarSubcategoria(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}