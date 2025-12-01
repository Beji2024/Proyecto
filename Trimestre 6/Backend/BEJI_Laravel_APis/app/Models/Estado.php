<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Estado extends Model
{
    use Hasfactory;
    protected $table = 'estado'; 

    protected $fillable = ['nombre'];

    
    public function estado()
{
    return $this->belongsTo(Estado::class, 'estado_id');
}
}
