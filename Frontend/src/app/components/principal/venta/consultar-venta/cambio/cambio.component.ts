import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { VentaService } from '../../../../../services/venta.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HeaderComponentComponent } from '../../../header.component/header.component.component';
import { CommonModule } from '@angular/common';
import { Venta } from '../../../../../modelos/venta';

@Component({
  selector: 'app-cambio-venta',
  standalone: true,
  imports: [HeaderComponentComponent, ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './cambio.component.html',
  styleUrls: ['./cambio.component.css']
})
export class CambioComponent implements OnInit {

  ventaForm!: FormGroup;
  ventaId!: number;

  // 🔥 IMPORTANTE: Aquí guardas lo que vas a mostrar en el select
  productos: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private ventaService: VentaService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {

    // 1️⃣ Cargar productos para el select
    this.ventaService.obtenerProductos().subscribe({
      next: (data) => {
        this.productos = data;
        console.log("Productos cargados:", data);
      },
      error: (err) => {
        console.error("Error al cargar productos:", err);
      }
    });

    // 2️⃣ Obtener el ID de la venta
    this.ventaId = Number(this.route.snapshot.paramMap.get('id'));

    // 3️⃣ Cargar la venta
    this.ventaService.obtenerVenta(this.ventaId).subscribe({
      next: (venta: Venta) => {
        console.log("Venta cargada:", venta);

        // 4️⃣ Ahora sí construir formulario
        this.ventaForm = this.fb.group({
          nombre_cli: [venta.nombre_cli, Validators.required],
          direccion_cli: [venta.direccion_cli, Validators.required],
          correo_cli: [venta.correo_cli, Validators.required],
          num_tel_cli: [venta.num_tel_cli, Validators.required],
          num_doc_cli: [venta.num_doc_cli, Validators.required],

          producto_id: [venta.producto.id, Validators.required],

          // 🔥 EL CAMPO QUE SE VA A CAMBIAR — VACÍO PARA ESCOGER
          nuevo_producto_id: ['', Validators.required],

          vendedor_id: [venta.vendedor_id, Validators.required],
        });

      },
      error: (err) => {
        console.error("Error al cargar la venta:", err);
        alert("No se pudo cargar la información de la venta");
      }
    });
  }

  guardarCambios() {

    if (this.ventaForm.invalid) {
      alert("Por favor completa todos los campos.");
      return;
    }

    const datosActualizados = {
      ...this.ventaForm.value,
      // 🔥 Aquí se hace el verdadero cambio
      producto_id: this.ventaForm.value.nuevo_producto_id
    };

    this.ventaService.actualizarVenta(this.ventaId, datosActualizados).subscribe({
      next: () => {
        alert("Venta actualizada correctamente");
        this.router.navigate(['/devoluciones-venta']);
      },
      error: (err) => {
        console.error("Error al actualizar la venta:", err);
        alert("Error al actualizar la venta");
      }
    });
  }
}
