import { Component } from '@angular/core';
import { HeadervenComponent } from './headerven/headerven.component';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-principalven',
  standalone:true,
  imports: [HeadervenComponent,RouterModule],
  templateUrl: './principalven.component.html',
  styleUrl: './principalven.component.css'
})
export class PrincipalvenComponent {
  constructor(private router: Router) {}

  goToPerfil():void{
    this.router.navigate(['/perfilven']);
  }
}
