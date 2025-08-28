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
        Schema::create('pedidos', function (Blueprint $table) {
    $table->id('idpedido');
    $table->date('fec_ped');
    $table->String('ped_prov');
    $table->String('ped_user');

    $table->foreign('ped_prov')->references('nit')->on('proveedor');
    $table->foreign('ped_user')->references('num_doc')->on('usuarios');
    $table->timestamps();
});

        
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pedidos');
    }
};
