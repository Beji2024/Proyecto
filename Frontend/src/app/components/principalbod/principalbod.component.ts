import { Component } from '@angular/core';
import { HeaderbodComponent } from './headerbod/headerbod.component';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-principalbod',
  standalone:true,
  imports: [HeaderbodComponent,RouterModule],
  templateUrl: './principalbod.component.html',
  styleUrl: './principalbod.component.css'
})
export class PrincipalbodComponent {
constructor(private router: Router) {}

  goToPerfil(): void {
    this.router.navigate(['/perfil']);
  }
}
