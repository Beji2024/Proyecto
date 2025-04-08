<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Foundation\Auth\User as Authenticatable;

class Usuario extends Authenticatable
{
    use HasFactory;

    protected $table = 'usuarios'; // Asegura que esté correcto

    protected $fillable = [
        'num_doc',
        'nombres',
        'apellidos',
        'direccion',
        'email',
        'num_tel',
        'fec_nac',
        'password',
        'tipodoc',
        'rol',
    ];
    protected $hidden =[
        'password',
    ];

    // Relación con el modelo TipoDoc si aplica
    public function tipoDoc()
    {
        return $this->belongsTo(TipoDoc::class, 'tipodoc');
    }

    // Relación con el modelo Rol (tabla 'rols')
    public function rol()
    {
        return $this->belongsTo(Rol::class, 'rol'); 
    }
}
