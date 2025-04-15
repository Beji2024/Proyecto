<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('mercancia', function (Blueprint $table) {
            $table->id('id_pro');
            $table->tinyInteger('cantidad');
            $table->string('nombre', 50);
            $table->tinyInteger('talla');
            $table->double('precio_venta', 8, 2);
            $table->double('precio_compra', 8, 2);
            $table->string('material', 30);
            $table->string('color', 20);
            $table->unsignedBigInteger('sub_mer');
            
            $table->foreign('sub_mer')->references('id_sub')->on('subcategoria');
           

        });
        
        
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('mercancia');

    }
};
