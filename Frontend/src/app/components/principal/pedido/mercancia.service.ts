import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


export interface mercancia {
  id_pro: number;
  nombre: string;
  precio_compra: number;
}

@Injectable({ providedIn: 'root' })
export class mercanciaService {
  private apiUrl = 'http://localhost:8000/api/mercancia';

  constructor(private http: HttpClient) {}

  getMercancia(): Observable<mercancia[]> {
    return this.http.get<mercancia[]>(this.apiUrl);
  }
}