<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;

class Proveedor extends Model
{
    use HasFactory;
    
    protected $table= 'proveedor';
    protected $fillable=[
        'nombre',
        'nit',
        'celular',
        'email',
        'direccion'
    ];
 
}
