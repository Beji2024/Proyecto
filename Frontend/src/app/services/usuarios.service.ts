import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../modelos/usuario';

@Injectable({
  providedIn: 'root'
})

export class UsuariosService {
  private apiUrl = 'http://localhost:8000/api/usuarios';
  private apiRolesUrl = 'http://localhost:8000/api/roles';

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
    console.log('Datos enviados al backend:', datos);
  return this.http.put(`${this.apiUrl}/${id}`, datos);
}
  obtenerUsuarioPorId(id: number): Observable<Usuario> {
  return this.http.get<Usuario>(`${this.apiUrl}/${id}`);
}
  obtenerRoles(): Observable<any[]> {
  return this.http.get<any[]>('http://localhost:8000/api/roles');
}
obtenerUsuarioActual() {
  const userJson = localStorage.getItem('usuario');
  return userJson ? JSON.parse(userJson) : null;
}

}