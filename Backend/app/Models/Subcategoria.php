<?php


namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Subcategoria extends Model
{
    protected $table = 'subcategoria';

    protected $primaryKey = 'id_sub';
    public $incrementing = true;
    protected $keyType = 'int';

    
    protected $fillable = [
        'nom_sub',
        'cat_sub'
    ];
   

public function categoria()
{
    return $this->belongsTo(Categoria::class, 'cat_sub', 'id');
}

}
