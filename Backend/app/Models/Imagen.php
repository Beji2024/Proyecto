<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Imagen extends Model
{
    // Campos que se pueden asignar masivamente
    protected $fillable = [
        'nombre',
        'ruta_imagen',
    ];

    // Opcional: si tu tabla no se llama 'imagens', especifica el nombre real
    protected $table = 'imagenes';
}
