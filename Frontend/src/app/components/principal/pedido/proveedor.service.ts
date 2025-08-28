import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface proveedor {
  id: number;
  nombre: string;
  nit: string;
   valor_unitario: number;
}

@Injectable({ providedIn: 'root' })
export class proveedorService {

  constructor(private http: HttpClient) {}

  getProveedor(page: number = 1): Observable<any> {
  return this.http.get<any>(`http://localhost:8000/api/proveedores?page=${page}`);
}
}
