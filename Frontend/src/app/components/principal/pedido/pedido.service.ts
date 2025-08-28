import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Detalle {
  cantidad: number;
  precio_uni: number;
  det_p_mer: number;
  precio_tt?: number;
}

export interface Pedido {
  idpedido?: number;
  fec_ped: string;
  ped_prov: string;
  ped_user: number;
  detalles: Detalle[];
}

@Injectable({ providedIn: 'root' })
export class PedidoService {
  private apiUrl = 'http://localhost:8000/api/pedidos';

  constructor(private http: HttpClient) {}

  getPedidos(page: number = 1): Observable<any> {
  return this.http.get<any>(`${this.apiUrl}?page=${page}`);
}


  getPedido(id: number): Observable<Pedido> {
    return this.http.get<Pedido>(`${this.apiUrl}/${id}`);
  }

  crearPedido(pedido: Pedido): Observable<Pedido> {
    return this.http.post<Pedido>(this.apiUrl, pedido);
  }
}