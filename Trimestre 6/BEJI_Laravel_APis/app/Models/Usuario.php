<?php

namespace App\Models;

use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Tymon\JWTAuth\Contracts\JWTSubject;

class Usuario extends Authenticatable implements JWTSubject
{
    use Notifiable;

    protected $table = 'usuarios';

    protected $fillable = [
        'num_doc',
        'nombres',
        'apellidos',
        'direccion',
        'email',
        'num_tel',
        'fec_nac',
        'password',
        'tipodoc_id',
        'rol_id'
    ];

    protected $hidden = [
        'password',
    ];

    public function getJWTIdentifier()
    {
        return $this->getKey();
    }

    public function getJWTCustomClaims()
    {
        return [];
    }
    public function tipodoc()
{
    return $this->belongsTo(TipoDoc::class, 'tipodoc_id'); // Usa el nombre correcto del modelo y campo FK
}
public function rol()
{
    return $this->belongsTo(Rol::class, 'rol_id'); // Usa el nombre correcto del modelo y campo FK
}
}