<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateSubcategoriaTable extends Migration
{
    public function up()
    {
        Schema::create('subcategoria', function (Blueprint $table) {
            $table->id('id_sub'); 
            $table->string('nom_sub');
            $table->unsignedBigInteger('cat_sub'); // clave foránea
        
            $table->foreign('cat_sub')
                  ->references('id') 
                  ->on('categorias')
                  ->onDelete('cascade');
        
            $table->timestamps();
        });
        
    }

    public function down()
    {
        Schema::dropIfExists('subcategoria');
    }
}

