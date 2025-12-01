import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { ContentComponent } from '../content/content.component';
import { HeaderComponent } from "../header/header.component";
import { UsuarioeditComponent } from '../usuarioedit/usuarioedit.component';
 

export const Routes = {
  
  Content: '/content',
  Usuarioe: '/editaru'
}

@Component({
  selector: 'app-usuario',
  imports: [HeaderComponent],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})
export class UsuarioComponent {
  constructor(private router: Router) {}

  navigateContent(): void {
    this.router.navigate([Routes.Content]);
  }
  navigateUsuarioe(): void {
    this.router.navigate([Routes.Usuarioe]);
  }

}
