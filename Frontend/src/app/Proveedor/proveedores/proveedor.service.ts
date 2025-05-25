import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {
  private actualizarProveedores = new Subject<void>();

  actualizarProveedores$ = this.actualizarProveedores.asObservable();

  emitirActualizacion() {
    this.actualizarProveedores.next();
  }
}
