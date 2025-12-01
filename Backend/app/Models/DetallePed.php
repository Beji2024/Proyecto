<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class DetallePed extends Model
{
    protected $table = 'detalle_ped'; // Asegúrate de que este sea el nombre correcto de la tabla

    protected $primaryKey = 'iddet_ped';

    protected $fillable = [
        'cantidad',
        'precio_uni',
        'precio_tt',
        'det_p_mer',
        'det_p_ped'
    ];

    public function pedido()
    {
        return $this->belongsTo(Pedido::class, 'det_p_ped', 'idpedido');
    }
}