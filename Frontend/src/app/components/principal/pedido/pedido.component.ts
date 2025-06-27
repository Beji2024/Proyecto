import { Component, OnInit } from '@angular/core';
import { HttpClient,HttpClientModule } from '@angular/common/http';
import { Detalle, Pedido, PedidoService} from './pedido.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HeaderComponentComponent } from "../header.component/header.component.component";
import { proveedor, proveedorService } from './proveedor.service';
import { usuarios, usuariosService } from './usuario.service';
import { mercancia,mercanciaService } from './mercancia.service';


@Component({
  selector: 'app-pedido',
  standalone: true,
  templateUrl: './pedido.component.html',
  imports: [FormsModule, CommonModule, HttpClientModule, RouterModule, HeaderComponentComponent],
})export class PedidoComponent implements OnInit {

proveedor: proveedor[] = [];
  usuarios: usuarios[] = [];
  mercancias: mercancia[] = [];

  provPagination = {
  current_page: 1,
  last_page: 1
};


  pedido: Pedido = {
    fec_ped: new Date().toISOString().slice(0, 10),
    ped_prov: '',
    ped_user: 0,
    detalles: []
  };

  newDetalle: Detalle = { cantidad: 1, precio_uni: 0, det_p_mer: 0 };

  constructor(
    private svc: PedidoService,
    private proveedorSvc: proveedorService,
    private usuariosSvc: usuariosService,
    private mercanciaSvc: mercanciaService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cargarProveedores(1);

  this.usuariosSvc.getUsuarios().subscribe(data => {
    this.usuarios = data;
  });
    this.mercanciaSvc.getMercancia().subscribe(data => {
      this.mercancias = data;
    });
  }

cargarProveedores(page: number): void {
  this.proveedorSvc.getProveedor(page).subscribe(res => {
    this.proveedor = res.data;
    this.provPagination.current_page = res.current_page;
    this.provPagination.last_page = res.last_page;
  });
}
goToRegistro() {
  this.router.navigate(['/registros-pedido']);
}

asignarPrecioPorProducto(): void {
  const productoSeleccionado = this.mercancias.find(m => m.id_pro === this.newDetalle.det_p_mer);
  if (productoSeleccionado) {
    this.newDetalle.precio_uni = productoSeleccionado.precio_compra;
  }
}

obtenerNombreUsuario(num_doc: number | string): string {
  const user = this.usuarios.find(u => u.num_doc == num_doc);
  return user ? `${user.nombres} ${user.apellidos}` : 'Desconocido';
}

obtenerNombreProveedor(nit: number | string): string {
  const prov = this.proveedor.find(p => p.nit == nit);
  return prov ? prov.nombre : 'Desconocido';
}

obtenerNombreProducto(id_pro: number | string): string {
  const prod = this.mercancias.find(m => m.id_pro == id_pro);
  return prod ? prod.nombre : 'Desconocido';
}


addDetalle(): void {
  // Validar si hay proveedor seleccionado
  if (!this.pedido.ped_prov) {
    alert('Debe seleccionar un proveedor antes de añadir un detalle.');
    return;
  }

   if (!this.pedido.ped_user) {
    alert('Debe seleccionar un usuario antes de crear el pedido.');
    return;
  }

  const { det_p_mer, cantidad, precio_uni } = this.newDetalle;

  if (!det_p_mer) {
    alert('Debe seleccionar un producto.');
    return;
  }

  if (!cantidad || cantidad <= 0) {
    alert('La cantidad debe ser mayor a 0.');
    return;
  }

  if (!precio_uni || precio_uni <= 0) {
    alert('El precio unitario debe ser mayor a 0.');
    return;
  }

  this.pedido.detalles.push({
    ...this.newDetalle,
    precio_tt: cantidad * precio_uni
  });

  this.newDetalle = { cantidad: 1, precio_uni: 0, det_p_mer: 0 };
}



  removeDetalle(index: number) {
    this.pedido.detalles.splice(index, 1);
  }

  calcularTotal(): number {
  return this.pedido.detalles.reduce((total, detalle) => total + (detalle.precio_tt ?? 0), 0);
  }

  submit() {
    if (this.pedido.detalles.length === 0) {
      alert('Debe agregar al menos un detalle al pedido.');
      return;
    }
    
    this.svc.crearPedido(this.pedido).subscribe({
      next: (res) => {
        alert(`Pedido #${res.idpedido} creado!`);
        this.pedido = {
          fec_ped: new Date().toISOString().slice(0, 10),
          ped_prov: '',
          ped_user: 0,
          detalles: []
        };
      },
      error: (err) => {
        console.error('Error recibido del backend:', err);
        if (err.error && err.error.error) {
          alert('Error backend: ' + err.error.error);
        } else {
          alert('Error al crear pedido.');
        }
      }
    });
  }
}