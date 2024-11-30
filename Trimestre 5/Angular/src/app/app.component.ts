import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./header/header.component";
import { ContentComponent } from "./content/content.component";
import { UsuarioComponent } from "./usuario/usuario.component";
import { VentaRComponent } from "./venta-r/venta-r.component";
import { ConsultaVComponent } from "./consulta-v/consulta-v.component";
import { DevolucionesComponent } from "./devoluciones/devoluciones.component";

@Component({
  selector: 'app-root',
  imports: [HeaderComponent, ContentComponent, UsuarioComponent, VentaRComponent, ConsultaVComponent, DevolucionesComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Angular';
}
