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
  private popStateHandler =(event: PopStateEvent) =>{
    const confirmLogout =window.confirm('¿Deseas cerrar sesion y salir de la aplicación?');
    if(confirmLogout){
      localStorage.removeItem('token');
      this.router.navigate(['login']);
    }else{
      history.pushState(null, '',window.location.href);
    }
  }
constructor(private router: Router) {
  history.pushState(null,'',window.location.href);
  window.addEventListener('popstate', this.popStateHandler);
}
ngOnDestroy():void{
  window.removeEventListener('popstate', this.popStateHandler);
}

  goToPerfil(): void {
    this.router.navigate(['/perfil']);
  }
  
  goToProductos(){
    this.router.navigate(['/productosbo']);
  }
}
