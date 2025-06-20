import { Component } from '@angular/core';
import { HeadervenComponent } from '../headerven/headerven.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-ventasven',
  imports: [HeadervenComponent],
  standalone:true,
  templateUrl: './ventasven.component.html',
  styleUrl: './ventasven.component.css'
})
export class VentasvenComponent {

  constructor(private router:Router){}
  goToCrearven(){
    this.router.navigate(['/crearven']);
  }
  goToConsultarven(){
    this.router.navigate(['/consultarven']);
  }
  goToDevolucionven(){
    this.router.navigate(['/devolucionven']);
  }
}
