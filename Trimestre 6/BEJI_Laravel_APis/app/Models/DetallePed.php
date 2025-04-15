<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class DetallePed extends Model
{
    protected $table = 'detalle_peds';

    protected $primaryKey = 'iddet_ped';

    protected $fillable = [
        'cantidad',
        'precio_uni',
        'precio_tt',
        'det_p_mer',
        'det_p_ped'
    ];
}