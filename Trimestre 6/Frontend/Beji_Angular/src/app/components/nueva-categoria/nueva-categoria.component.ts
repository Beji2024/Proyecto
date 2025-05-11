import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CategoriasService } from '../../services/categorias.service';
import { Router } from '@angular/router';
import { HeaderComponentComponent } from "../principal/header.component/header.component.component";
import { AppComponent } from "../../app.component";

@Component({
  selector: 'app-nueva-categoria',
  standalone: true,
  imports: [CommonModule, FormsModule, AppComponent],
  templateUrl: './nueva-categoria.component.html',
  styleUrls: ['./nueva-categoria.component.css']
})
export class NuevaCategoriaComponent {
  nombreCategoria: string = '';
  mostrarConfirmacion: boolean = false;
  mostrarExito: boolean = false;

  constructor(
    private categoriasService: CategoriasService,
    private router: Router
  ) {}

  crearCategoria() {
    this.mostrarConfirmacion = true;
  }

  confirmarCreacion() {
    this.categoriasService.crearCategoria({ name: this.nombreCategoria }).subscribe({
      next: () => {
        this.mostrarConfirmacion = false;
        this.mostrarExito = true;
        this.nombreCategoria = '';
      },
      error: (err) => {
        console.error('Error al crear categoría:', err);
      }
    });
  }

  cerrarExito() {
    this.mostrarExito = false;
  }
}
