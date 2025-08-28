import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface usuarios {
  id: number;
  nombres: string;
  apellidos: string;
  num_doc: string;
}

@Injectable({ providedIn: 'root' })
export class usuariosService {
  private apiUrl = 'http://localhost:8000/api/usuarios';

  constructor(private http: HttpClient) {}

  getUsuarios(): Observable<usuarios[]> {
    return this.http.get<usuarios[]>(this.apiUrl);
  }
}