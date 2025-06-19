import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuariosService } from '../../../../services/usuarios.service';
import { CommonModule } from '@angular/common';
import { HeaderComponentComponent } from '../../header.component/header.component.component';
import { markAsUntransferable } from 'worker_threads';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule,HeaderComponentComponent],
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent {
  registroForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private usuariosService: UsuariosService,
    private router: Router
  ) {
    this.registroForm = this.fb.group({
       num_doc: ['', [Validators.required, Validators.pattern(/^\d+$/)]],
      nombres: ['', Validators.required],
      apellidos: ['', Validators.required],
      direccion: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      num_tel: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      fec_nac: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      tipodoc_id: ['', Validators.required],
      rol_id: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.registroForm.valid) {
      this.registroForm.markAllAsTouched();
      return;}

      const nuevoUsuario = this.registroForm.value;

      this.usuariosService.registrarUsuario(nuevoUsuario).subscribe({
        next: (res) => {
          console.log('Usuario registrado con éxito:', res);
          alert('Registro exitoso');
          this.router.navigate(['/usuarios']); 
        },
        error: (err) => {
          console.error('Error al registrar usuario:', err);
          alert('Error en el registro');
        }
      });
    }
  }

