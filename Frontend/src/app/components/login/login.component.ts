import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { bootstrapApplication } from '@angular/platform-browser';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AuthService]
  
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  error: string = '';
  loading: boolean = false;
  showPassword: boolean = false;

  constructor(private authservice: AuthService, private router: Router,private http: HttpClient) {}

  login(loginForm: NgForm) {
    this.error = '';
    if (loginForm.invalid) {
      try {
        loginForm.form.markAllAsTouched();
      } catch (e) {
        // fallback: nothing
      }
      return;
    }

    this.loading = true;
    const credentials = { email: this.email, password: this.password };

    this.authservice.login(credentials).subscribe({
      next: (response) => {
        this.loading = false;
        const token = response?.access_token;
        if (!token) {
          this.error = 'Respuesta inválida del servidor';
          console.error('Sin token en la respuesta', response);
          return;
        }

        console.log('Token:', token);
        localStorage.setItem('token', token);

        const rol = response?.user?.rol?.name ?? null;
        if (!rol) {
          this.error = 'No se pudo determinar el rol del usuario';
          return;
        }

        if (rol === 'Administrador') {
          this.router.navigate(['/principal']);
        } else if (rol === 'Bodeguero') {
          this.router.navigate(['/principalbod']);
        } else if (rol === 'Vendedor') {
          this.router.navigate(['/principalven']);
        } else {
          this.error = 'Rol de usuario no soportado';
        }
      },
      error: (error) => {
        this.loading = false;
        this.error = 'Credenciales inválidas';
        console.error(error);
      }
    });
  }

  togglePassword() {
    this.showPassword = !this.showPassword;
  }
}