<?php



namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Pedido extends Model
{
protected $table = 'pedidos';
protected $primaryKey = 'idpedido';
protected $fillable = ['fec_ped','ped_prov','ped_user','det_p_ped'];

public function detalles()
{
    return $this->hasMany(DetallePed::class, 'det_p_ped', 'idpedido');
}
  public function proveedor()
    {
        return $this->belongsTo(Proveedor::class, 'ped_prov', 'nit');
    

}
}