import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { Router } from '@angular/router';
export const Routes = {
  modificar: '/productos/gestión/modificar',
  crear:'/productos/gestión/nuevoproducto'
}
@Component({
  selector: 'app-gespro',
  imports: [HeaderComponent],
  templateUrl: './gespro.component.html',
  styleUrl: './gespro.component.css'
})
export class GesproComponent {
  constructor(private router: Router) {}

  navigatemodificar():void {
    this.router.navigate([Routes.modificar])
  }
  navigatecrear():void {
    this.router.navigate([Routes.crear])
  }
}
