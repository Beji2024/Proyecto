import { HeaderComponent } from "../header/header.component";
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient,HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-proveditar',
  imports: [HeaderComponent, CommonModule, FormsModule, HttpClientModule],
  templateUrl: './proveditar.component.html',
  styleUrl: './proveditar.component.css'
})
export class ProveditarComponent  implements OnInit{
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

  constructor(private route: ActivatedRoute, private http: HttpClient,private router: Router) {}
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.http.get(`http://localhost:8000/api/proveedores/${id}`).subscribe((data: any) => {
      this.proveedor = data;
      console.log("Proveedor recibido:", this.proveedor); // <-- Aquí verifica que venga el campo "id"
    });
    
}


actualizarProveedor(): void {
  const id = this.proveedor.id;

  this.http.put(`http://localhost:8000/api/proveedores/${id}`, this.proveedor)
    .subscribe({
      next: (response) => {
        alert('Proveedor actualizado correctamente');
        this.router.navigate(['/proveedores']);
      },
      error: (error) => {
        console.error('Error al actualizar proveedor:', error);
        alert('Error: ' + error.error.message);
      }
    });
}

}
