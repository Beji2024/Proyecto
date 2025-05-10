import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
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

  constructor(private authservice: AuthService, private router: Router,private http: HttpClient) {}

  login() {
    const credentials = { email: this.email, password: this.password };

    this.authservice.login(credentials).subscribe({
      next: (response) => {
        
        const token = response.access_token;
        console.log('Token:', token);

        localStorage.setItem('token', token);

        const rol = response.user.rol.name;
        
        if(rol === 'Administrador'){
          this.router.navigate(['/principal']);
        }else if(rol ==='Vendedor'){
          this.router.navigate(['/usuarios']);
        }else if(rol ==='Bodeguero'){
          this.router.navigate(['/usuarios']);
        }
      },
      error: (error) => {
        this.error = 'Credenciales inválidas';
        console.error(error);
      }
    });
  }
}