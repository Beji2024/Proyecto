import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HeaderComponentComponent } from '../../header.component/header.component.component';

@Component({
  selector: 'app-proveditar',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    HeaderComponentComponent
  ],
  templateUrl: './proveditar.component.html',
  styleUrls: ['./proveditar.component.css']
})
export class ProveditarComponent implements OnInit {
  erroresFormulario: { [key: string]: string[] } = {};

  proveedor: any = {
    nombre: '',
    nit: '',
    celular: '',
    email: '',
    direccion: '',
    producto: '',
    marca: '',
    valor_unitario: ''
  };

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.http.get(`http://localhost:8000/api/proveedores/${id}`).subscribe(
        (data: any) => {
          this.proveedor = data;
          console.log("Proveedor recibido:", this.proveedor);
        },
        error => {
          console.error('Error al cargar el proveedor:', error);
        }
      );
    }
  }

  actualizarProveedor(): void {
    const id = this.proveedor.id;
    if (!id) {
      alert('Error: el proveedor no tiene un ID válido.');
      return;
    }

    if (confirm('¿Está seguro de que desea actualizar el proveedor?')) {
      this.http.put(`http://localhost:8000/api/proveedores/${id}`, this.proveedor)
        .subscribe(
          () => {
            alert('Proveedor actualizado correctamente');
            this.router.navigate(['/proveedor']);
          },
          error => {
            console.error('Error al actualizar el proveedor:', error);
            if (error.status === 422) {
              this.erroresFormulario = error.error.errors;
            }
          }
        );
    }
  }
}
