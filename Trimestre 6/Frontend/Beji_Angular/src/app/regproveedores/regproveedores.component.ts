import { Component } from '@angular/core';
import { HeaderComponentComponent } from '../components/principal/header.component/header.component.component';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


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

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.proveedorForm = this.fb.group({
      nombre: [''],
      nit: [''],
      celular: [''],
      email: [''],
      direccion: [''],
      producto: [''],
      marca: [''],
      valor_unitario: [0]
    });
  }

  registrarProveedor() {
    const datos = this.proveedorForm.value;
    this.http.post('http://localhost:8000/api/proveedores', datos).subscribe({
      next: () => {
        this.mensaje = 'Proveedor registrado con éxito';
        this.error = '';
        this.proveedorForm.reset();
        this.proveedorService.emitirActualizacion(); // ← Notifica la actualización
      },
      error: (err) => {
        console.error('Detalles del error:', err.error.errors);
        this.error = err.error.message || 'Error desconocido';
      }
    });
  }
}
