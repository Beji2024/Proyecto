<?php
namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Producto extends Model
{
    protected $table = 'producto';

    protected $fillable = [
        'referencia',
        'cantidad',
    ];

    public function ventas()
    {
        return $this->hasMany(Venta::class, 'producto_id');
    }
}