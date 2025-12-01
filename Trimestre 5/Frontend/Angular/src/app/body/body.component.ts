import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { TablabodyComponent } from '../tablabody/tablabody.component';
import { Router } from '@angular/router';
export const Routes = {
  
  Tabla: '/tablainf'
};
@Component({
  selector: 'app-body',
  standalone: true,
  imports: [HeaderComponent],
  templateUrl: './body.component.html',
  styleUrl: './body.component.css'
})
export class BodyComponent {
  constructor(private router: Router) {}

  navigateToTabla(): void {
    this.router.navigate([Routes.Tabla]);
  }
}
