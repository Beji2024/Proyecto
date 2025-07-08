import { Component } from '@angular/core';
import { FormGroup, FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

import { HeaderComponentComponent } from '../../header.component/header.component.component';

@Component({
  selector: 'app-regproveedores',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    HeaderComponentComponent
  ],
  templateUrl: './regproveedores.component.html',
  styleUrls: ['./regproveedores.component.css']
})
export class RegproveedoresComponent {
  proveedorForm: FormGroup;
  mensaje: string = '';
  error: string = '';
  erroresFormulario: { [key: string]: string[] } = {};

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {
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

  registrarProveedor(): void {
    const confirmado = confirm('¿Deseas registrar este proveedor?');
    if (!confirmado) {
      this.router.navigate(['/proveedores']);
      return;
    }

    const datos = this.proveedorForm.value;
    this.http.post('http://localhost:8000/api/proveedores', datos).subscribe({
      next: () => {
        this.error = '';
        this.erroresFormulario = {};
        this.proveedorForm.reset();
        alert('Proveedor registrado correctamente');
        this.router.navigate(['/proveedor']);
      },
      error: (err) => {
        this.mensaje = '';
        this.error = err.error.message || 'Error desconocido';

        if (err.status === 422 && err.error.errors) {
          this.erroresFormulario = err.error.errors;
        } else {
          this.erroresFormulario = {};
        }
      }
    });
  }
}
