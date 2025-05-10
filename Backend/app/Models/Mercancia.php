<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Mercancia extends Model
{
    protected $table = 'mercancia'; // si el nombre es personalizado

    protected $primaryKey = 'id_pro'; // si no usas "id" como clave primaria
    public $incrementing = true;
    protected $keyType = 'int';
    public $timestamps = false;

    protected $fillable = [
        'cantidad',
        'nombre',
        'talla',
        'precio_venta',
        'precio_compra',
        'material',
        'color',
        'sub_mer'
    ];
}

