import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// URL de la API Laravel
const API_URL = 'http://tu-dominio-api.com/api/pedidos'; // Ajusta esta URL

@Injectable({
  providedIn: 'root',
})
export class PedidoService {
  constructor(private http: HttpClient) {}

  // Método para obtener todos los pedidos
  getPedidos(): Observable<any> {
    return this.http.get(API_URL);
  }

  // Método para obtener un solo pedido por ID
  getPedido(id: number): Observable<any> {
    return this.http.get(`${API_URL}/${id}`);
  }

  // Método para crear un nuevo pedido
  createPedido(pedido: any): Observable<any> {
    return this.http.post(API_URL, pedido, this.getHttpOptions());
  }

  // Método para actualizar un pedido
  updatePedido(id: number, pedido: any): Observable<any> {
    return this.http.put(`${API_URL}/${id}`, pedido, this.getHttpOptions());
  }

  // Método para eliminar un pedido
  deletePedido(id: number): Observable<any> {
    return this.http.delete(`${API_URL}/${id}`, this.getHttpOptions());
  }

  // Opciones comunes para las cabeceras HTTP (autenticación, etc.)
  private getHttpOptions() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token'), // Si usas autenticación con token
    });

    return { headers };
  }
}
