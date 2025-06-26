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
  private popStateHandler =(event: PopStateEvent) =>{
    const confirmLogout =window.confirm('¿Deseas cerrar sesion y salir de la aplicacion?');
    if(confirmLogout){
      localStorage.removeItem('token');
      this.router.navigate(['login']);
    }else{
      history.pushState(null,'',window.location.href);
    }
  }
  constructor(private router: Router) {
    history.pushState(null,'',window.location.href);
    window.addEventListener('popstate', this.popStateHandler);
  }
  ngOnDestroy():void{
    window.removeEventListener('popstate', this.popStateHandler)
  }

  goToPerfil():void{
    this.router.navigate(['/perfilven']);
  }
  goToVentaven():void{
    this.router.navigate(['/ventasven']);
  }
   goToProductos(){
    this.router.navigate(['/productos']);
  }
}
