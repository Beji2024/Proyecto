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
        Schema::create('pedido', function (Blueprint $table) {
            $table->id('idpedido');
            $table->date('fec_ped');
            $table->unsignedBigInteger('ped_prov');
            $table->unsignedBigInteger('ped_est');
            $table->unsignedBigInteger('ped_user');
        
            // Definir las claves foráneas
            $table->foreign('ped_prov')->references('id')->on('proveedors')->onDelete('cascade');
            $table->foreign('ped_est')->references('id')->on('estados')->onDelete('cascade');
            $table->foreign('ped_user')->references('id')->on('usuarios')->onDelete('cascade');
        
            $table->timestamps();
        });
        
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pedido');
    }
};