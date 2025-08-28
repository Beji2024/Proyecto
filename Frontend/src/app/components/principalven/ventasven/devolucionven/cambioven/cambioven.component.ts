import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { VentaService } from '../../../../../services/venta.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators,FormControl } from '@angular/forms';
import { HeadervenComponent } from '../../../headerven/headerven.component';
import { CommonModule } from '@angular/common';
import { Venta } from '../../../../../modelos/venta';

@Component({
  selector: 'app-cambioven',
  standalone:true,
  imports: [HeadervenComponent,ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './cambioven.component.html',
  styleUrl: './cambioven.component.css'
})
export class CambiovenComponent implements OnInit {
  ventaForm!: FormGroup;
  ventaId!: number;
  
  
  

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private ventaService: VentaService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    // Obtener el ID de la venta de la URL
    this.ventaId = Number(this.route.snapshot.paramMap.get('id'));

    // Llamar al servicio para obtener la venta por ID
    this.ventaService.obtenerVenta(this.ventaId).subscribe({
      next: (venta: Venta) => {  // Aquí se recibe la respuesta como 'venta'
        console.log('Datos de la venta:', venta);

        // Inicializar el formulario con los datos de la venta
        this.ventaForm = this.fb.group({
          nombre_cli: [venta.nombre_cli, [Validators.required]],
          direccion_cli: [venta.direccion_cli, [Validators.required]],
          correo_cli: [venta.correo_cli, [Validators.required]],
          num_tel_cli: [venta.num_tel_cli, [Validators.required]],
          num_doc_cli: [venta.num_doc_cli, [Validators.required]],
          producto_id: [venta.producto.id, [Validators.required]],  // ID del producto actual (solo lectura)
          nuevo_producto_id: [venta.producto.id, [Validators.required]],  // Campo editable para el nuevo producto
          vendedor_id: [venta.vendedor_id, [Validators.required]], // ID del vendedor
        });
      },
      error: (err) => {
        console.error('Error al cargar la venta:', err);
        alert('No se pudo cargar la información de la venta');
      }
    });
  }

  guardarCambios() {
    if (this.ventaForm.invalid) {
      alert('Por favor completa todos los campos.');
      return;
    }
  
    const datosActualizados = {
      ...this.ventaForm.value,
      producto_id: this.ventaForm.value.nuevo_producto_id  // aquí se hace el cambio
    };
  
    this.ventaService.actualizarVenta(this.ventaId, datosActualizados)
      .subscribe({
        next: () => {
          alert('Venta actualizada correctamente');
          this.router.navigate(['/devoluciones-venta']); // o la ruta que desees
        },
        error: (err) => {
          console.error('Error al actualizar la venta:', err);
          alert('Error al actualizar la venta');
        }
      });
  }
}

