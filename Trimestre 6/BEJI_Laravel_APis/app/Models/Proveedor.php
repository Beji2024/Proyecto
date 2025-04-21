<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\Hasfactory;
use Illuminate\Database\Eloquent\Model;

class Proveedor extends Model
{
  use HasFactory;
    
    protected $table= 'proveedor';
    protected $fillable=[
        'nombre',
        'nit',
        'celular',
        'email',
        'direccion',
        'producto',
        'marca',
        'valor_unitario'
    ];
}
