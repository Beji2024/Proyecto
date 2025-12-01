import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../modelos/usuario';

@Injectable({
  providedIn: 'root'
})

export class UsuariosService {
  private apiUrl = 'http://localhost:8000/api/usuarios'

  constructor(private http: HttpClient) { }
  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.apiUrl);
  }
  eliminarUsuario(id: number): Observable<any> {
  const url = `${this.apiUrl}/${id}`;
  return this.http.delete(url);
}
  registrarUsuario(usuario: any) {
  return this.http.post<any>('http://localhost:8000/api/usuarios', usuario);
}
  actualizarUsuario(id: number, datos: any) {
  return this.http.put(`${this.apiUrl}/${id}`, datos);
}
  obtenerUsuarioPorId(id: number): Observable<Usuario> {
  return this.http.get<Usuario>(`${this.apiUrl}/${id}`);
}

}