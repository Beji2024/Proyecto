<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\Hasfactory;
use Illuminate\Database\Eloquent\Model;

class Proveedor extends Model
{
  use HasFactory;
  protected $fillable = [
    'nit',
    'name',
    'direccion',
    'telefono',
    'email'
  ];
}
