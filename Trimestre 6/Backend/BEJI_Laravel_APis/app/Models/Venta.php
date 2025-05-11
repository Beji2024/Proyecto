<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Venta extends Model
{
    protected $table = 'venta';

    protected $fillable = [
        'nombre_cli',
        'direccion_cli',
        'correo_cli',
        'num_tel_cli',
        'num_doc_cli',
        'producto_id',
        'cantidad',
        'vendedor_id',
        'fecha',
        'estado_id'
    ];

    // Relacion con Producto
    public function producto()
    {
        return $this->belongsTo(Producto::class, 'producto_id');
    }

    // Relacion con Usuario 
    public function vendedor()
    {
        return $this->belongsTo(Usuario::class, 'vendedor_id');
    }
    //Relacion con Estado
    public function estado()
    {
    return $this->belongsTo(Estado::class, 'estado_id');
    }
}
