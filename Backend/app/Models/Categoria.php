<?php

namespace App\Models;
use Illuminate\Database\Eloquent\Factories\Hasfactory;
use Illuminate\Database\Eloquent\Model;

class Categoria extends Model
{
   use HasFactory;
   protected $fillable = ['name'];
}
