import { Component, OnInit } from '@angular/core';
import { HttpClient,HttpClientModule } from '@angular/common/http';
import { ProveedorService } from './proveedor.service';
import { Router, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HeaderComponentComponent } from '../components/principal/header.component/header.component.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-proveedores',
  templateUrl: './proveedores.component.html',
  imports: [RouterOutlet,RouterModule, CommonModule, FormsModule,HeaderComponentComponent],
})
export class ProveedoresComponent implements OnInit {
  proveedores: any[] = [];
  busqueda: string = '';

  constructor(
    private http: HttpClient,
    private proveedorService: ProveedorService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cargarProveedores();

    this.proveedorService.actualizarProveedores$.subscribe(() => {
      this.cargarProveedores();
    });
  }

  cargarProveedores(): void {
    this.http.get<any[]>('http://localhost:8000/api/proveedores').subscribe(data => {
      this.proveedores = data;
    });
  }

  eliminarProveedor(id: number): void {
    if (confirm('¿Estás seguro de que deseas eliminar este proveedor?')) {
      this.http.delete(`http://localhost:8000/api/proveedores/${id}`).subscribe(() => {
        this.cargarProveedores();
      });
    }
  }

  editarProveedor(proveedor: any): void {
    this.router.navigate(['/proveditar', proveedor.id]);
  }
  

  buscarProveedor(): void {
    if (this.busqueda.trim() === '') {
      this.cargarProveedores();
    } else {
      this.proveedores = this.proveedores.filter(p =>
        p.nombre.toLowerCase().includes(this.busqueda.toLowerCase()) ||
        p.marca.toLowerCase().includes(this.busqueda.toLowerCase())
      );
    }
  }
  goToRegProveedores(){
    this.router.navigate(['/regproveedores'])
  }
  
}

