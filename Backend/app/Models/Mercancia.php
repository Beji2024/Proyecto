<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use App\Models\Subcategoria;

class Mercancia extends Model
{
    protected $table = 'mercancia'; // Nombre de la tabla

    protected $primaryKey = 'id_pro'; // Clave primaria personalizada
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
        'sub_mer',
        'imagen'
    ];

    // Relación: una mercancia pertenece a una subcategoría
    public function subcategoria()
    {
        return $this->belongsTo(Subcategoria::class, 'sub_mer', 'id_sub');
    }
}
