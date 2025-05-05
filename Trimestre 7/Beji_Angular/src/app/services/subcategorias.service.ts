import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Subcategoria } from '../modelos/subcategoria';

@Injectable({
  providedIn: 'root'
})
export class SubcategoriasService {
  private apiUrl = 'http://localhost:8000/api/subcategorias'; // La URL de tu API para obtener subcategorías

  constructor(private http: HttpClient) {}

  getSubcategorias(): Observable<Subcategoria[]> {
    return this.http.get<Subcategoria[]>(this.apiUrl);
  }
}
