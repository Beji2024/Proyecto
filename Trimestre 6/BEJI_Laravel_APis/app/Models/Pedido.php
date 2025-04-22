<?php



namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Pedido extends Model
{
    protected $table = 'pedido'; // importante si la tabla no se llama 'pedidos'

    protected $primaryKey = 'idpedido';

    protected $fillable = [
        'fec_ped',
        'ped_prov',
        'ped_est',
        
    ];
}