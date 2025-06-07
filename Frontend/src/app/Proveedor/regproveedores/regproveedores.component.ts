import { Component } from '@angular/core';

import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { HeaderComponentComponent } from "../../components/principal/header.component/header.component.component";


@Component({
  selector: 'app-regproveedores',
  standalone: true,
  imports: [CommonModule,
    ReactiveFormsModule,
    HttpClientModule, HeaderComponentComponent],
  templateUrl: './regproveedores.component.html',
  styleUrl: './regproveedores.component.css'
})
export class RegproveedoresComponent {
  proveedorForm: FormGroup;
  mensaje: string = '';
  error: string = '';
  proveedorService: any;
  erroresFormulario: { [key: string]: string[] } = {};
  // Removed duplicate router property

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
    this.proveedorForm = this.fb.group({
      nombre: [''],
      nit: [''],
      celular: [''],
      email: [''],
      direccion: [''],
      producto: [''],
      marca: [''],
      valor_unitario: []
    });
  }

  registrarProveedor() {
    const confirmado = confirm('¿Deseas registrar este proveedor?');
    if (!confirmado) {
      this.router.navigate(['/proveedores']);
      return; // Si el usuario cancela, no redirige a proveedores
    }
  
    const datos = this.proveedorForm.value;
    this.http.post('http://localhost:8000/api/proveedores', datos).subscribe({
      next: () => {
        this.error = '';
        this.erroresFormulario = {};
        this.proveedorForm.reset();
        alert('Proveedor registrado correctamente');
        this.router.navigate(['/proveedores']);
      },
      error: (err) => {
        this.mensaje = '';
        this.error = err.error.message || 'Error desconocido';
  
        if (err.status === 400 && err.error.errors) {
          this.erroresFormulario = err.error.errors;
        } else {
          this.erroresFormulario = {};
        }
      }
    });
  }
  
}
