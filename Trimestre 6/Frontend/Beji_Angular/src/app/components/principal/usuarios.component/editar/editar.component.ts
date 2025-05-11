import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuariosService } from '../../../../services/usuarios.service';
import { CommonModule } from '@angular/common';
import { HeaderComponentComponent } from '../../header.component/header.component.component';
import { Usuario } from '../../../../modelos/usuario';

@Component({
  selector: 'app-editar-usuario',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule,HeaderComponentComponent],
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {
  editarForm: FormGroup;
  userId: number = 0;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private usuariosService: UsuariosService,
    private router: Router
  ) {
    this.editarForm = this.fb.group({
      direccion: ['', Validators.required],
      email: ['', Validators.required],
      num_tel:['', Validators.required],
      tipo_doc: ['', Validators.required],
      rol_id: ['', Validators.required],
      apellidos: ['', Validators.required],
      nombres:['',Validators.required]
    });
  }

  ngOnInit() {
    this.userId = Number(this.route.snapshot.paramMap.get('id'));
    console.log('User ID recibido:', this.userId); 
    
    this.usuariosService.obtenerUsuarioPorId(this.userId).subscribe({
      next: (usuario: Usuario) => {
        this.editarForm.patchValue({
          direccion: usuario.direccion,
          email: usuario.email,
          num_tel: usuario.num_tel,
          tipo_doc: usuario.tipodoc_id,
          rol_id: usuario.rol_id,
          nombres: usuario.nombres,
          apellidos: usuario.apellidos
        });
      },
      error: (err) => console.error('Error al cargar el usuario', err)
    });
  }

  onSubmit() {
    if (this.editarForm.valid) {
      this.usuariosService.actualizarUsuario(this.userId, this.editarForm.value).subscribe({
        next: (res) => {
          alert('Usuario actualizado con éxito');
          this.router.navigate(['/usuarios']);
        },
        error: (err) => {
          console.error('Error al actualizar usuario:', err);
          alert('Error en la actualización');
        }
      });
    }
  }
}