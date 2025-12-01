import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8000/api'; 

  constructor(private http: HttpClient, private router: Router) {}

  login(credentials: { email: string; password: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, credentials).pipe(
      tap((res: any) => {
        localStorage.setItem('token', res.access_token);
        localStorage.setItem('rol', res.user.rol.name);
        localStorage.setItem('usuario', JSON.stringify(res.user));
        
      })
    );
  }
  getRol(): string | null {
    return localStorage.getItem('rol');
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }
   obtenerUsuarioActual() {
    const user = localStorage.getItem('usuario');
    return user ? JSON.parse(user) : null;
  }
}

