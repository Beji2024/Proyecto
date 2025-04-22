import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VentaService {
  private apiUrl = 'http://localhost:8000/api/venta';
  private apiVendedoresUrl = 'http://127.0.0.1:8000/api/vendedores';
  private apiProductoUrl = 'http://127.0.0.1:8000/api/producto';
  constructor( private http: HttpClient) { }

  obtenerVentas(): Observable<any>{
    return this.http.get(this.apiUrl);
  }
  obtenerVenta(id:number): Observable<any>{
    return this.http.get(`${this.apiUrl}/${id}`);
  }
  registrarVenta(data:any): Observable<any>{
    return this.http.post(this.apiUrl, data);
  }
  actualizarVenta(id:number, data: any): Observable<any>{
    return this.http.put(`${this.apiUrl}/${id}`,data );
  }
  eliminarVenta(id:number): Observable<any>{
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
  actualizarEstadoVenta(ventaId: number, estadoId: number): Observable<any> {
    return this.http.patch(`${this.apiUrl}/${ventaId}`, { estado_id: estadoId });
  }
  obtenerVendedores(): Observable<any[]> {
    return this.http.get<any[]>(this.apiVendedoresUrl);
  }
  obtenerProductos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiProductoUrl);
  }


  
}