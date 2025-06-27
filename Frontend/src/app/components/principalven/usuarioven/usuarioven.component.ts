import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UsuariosService } from '../../../services/usuarios.service';
import { AuthService } from '../../../services/auth.service';
import { HeadervenComponent } from '../headerven/headerven.component';
import { ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {NgIf,NgClass} from '@angular/common';


@Component({
  selector: 'app-usuarioven',
  imports: [HeadervenComponent,ReactiveFormsModule,CommonModule,NgIf,NgClass],
  standalone:true,
  templateUrl: './usuarioven.component.html',
  styleUrl: './usuarioven.component.css'
})
export class UsuariovenComponent implements OnInit {
  perfilForm: FormGroup;
  usuario: any;

  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuariosService,
    private authService: AuthService,
    private router: Router
  ) {
    this.perfilForm = this.fb.group({
  nombres: this.fb.control({ value: '', disabled: true }),
  apellidos: this.fb.control({ value: '', disabled: true }),
  num_doc: this.fb.control({ value: '', disabled: true }),
  fec_nac: this.fb.control({ value: '', disabled: true }),
  rol: this.fb.control({ value: '', disabled: true }),
  direccion: ['', Validators.required],
  num_tel: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
  email: ['', [Validators.required, Validators.email]]
});
  }
  ngOnInit(): void {
     console.log('ngOnInit ejecutado');
    const user = this.authService.obtenerUsuarioActual();
    console.log('👤 Usuario autenticado:', user);
    if (user && user.id) {
      this.usuarioService.obtenerUsuarioPorId(user.id).subscribe(data => {
        console.log('Datos recibidos',data);
        this.usuario = data;
        this.perfilForm.patchValue({
          nombres: data.nombres,
          apellidos: data.apellidos,
          direccion: data.direccion,
          num_tel: data.num_tel,
          num_doc: data.num_doc,    
          fec_nac: data.fec_nac,
          email: data.email,
          rol: data.rol.name
        });
      });
    }
  }
  guardarCambios(): void {
    if(this.perfilForm.invalid){
      this.perfilForm.markAllAsTouched();
      return;
    }
  const confirmacion = window.confirm('¿Estás seguro de que deseas guardar los cambios?');

  if (!confirmacion) {
    return; 
  }
  const id = this.usuario.id;
  const datosActualizados = this.perfilForm.getRawValue();

  this.usuarioService.actualizarUsuario(id, datosActualizados).subscribe(() => {
    alert('Perfil actualizado con éxito.');
    this.router.navigate(['/principalven']);
  });
  }

}
