import { Component, OnInit } from '@angular/core';
import { HeaderComponentComponent } from '../../header.component/header.component.component';
import { VentaService } from '../../../../services/venta.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router} from '@angular/router';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { CommonModule} from '@angular/common';


@Component({
  selector: 'app-crear-venta',
  standalone:true,
  imports: [HeaderComponentComponent,FormsModule,ReactiveFormsModule,CommonModule],
  templateUrl: './crear-venta.component.html',
  styleUrl: './crear-venta.component.css'
})
export class CrearVentaComponent implements OnInit {
  ventaForm: FormGroup;
  mensaje: string = '';
  error: string = '';
  vendedores: any[] = [];
  productos: any[] = [];

  constructor(
    private ventaService: VentaService,
    private fb: FormBuilder,
    private router: Router
  ) {
    this.ventaForm = this.fb.group({
      nombre_cli: ['', Validators.required],
      direccion_cli: ['', Validators.required],
      correo_cli: ['', Validators.required],
      num_tel_cli: ['', Validators.required],
      num_doc_cli: ['', Validators.required],
      producto_id: ['', Validators.required],
      cantidad: ['', [Validators.required, Validators.min(1)]],
      vendedor_id: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.cargarVendedores();
    this.cargarProductos(); 
  }

  cargarVendedores(): void {
    this.ventaService.obtenerVendedores().subscribe({
      next: (data) => {
        this.vendedores = data;
        console.log('Vendedores:', this.vendedores);
      },
      error: (err) => {
        console.error('Error cargando vendedores', err);
      }
    });
  }

  cargarProductos(): void {
    this.ventaService.obtenerProductos().subscribe({
      next: (data) => {
        this.productos = data;
        console.log('Productos:', this.productos);
      },
      error: (err) => {
        console.error('Error cargando productos', err);
      }
    });
  }

  registrarVenta(): void {
    if (this.ventaForm.valid) {
      console.log('Formulario de venta:', this.ventaForm.value)
      this.ventaService.registrarVenta(this.ventaForm.value).subscribe({
        next: (respuesta) => {
          this.mensaje = 'Venta registrada correctamente';
          this.error = '';
          this.ventaForm.reset();
          this.router.navigate(['/venta']);
        },
        error: (err) => {
          console.error(err);
          this.error = 'Error al registrar la venta';
          this.mensaje = '';
        }
      });
    } else {
      this.error = 'Por favor completa todos los campos correctamente';
      this.mensaje = '';
    }
  }
}
