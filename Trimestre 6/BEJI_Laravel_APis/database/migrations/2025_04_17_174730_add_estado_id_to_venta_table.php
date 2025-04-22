<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up(): void
    {
        Schema::table('venta', function (Blueprint $table) {
            // Agregar la columna estado_id con valor por defecto
            $table->unsignedBigInteger('estado_id')->default(1); 

            // Establecer la relación con la tabla estados
            $table->foreign('estado_id')->references('id')->on('estados')->onDelete('cascade');
        });
    }

    public function down(): void
    {
        Schema::table('venta', function (Blueprint $table) {
            // Si revertimos la migración, eliminamos la clave foránea y la columna
            $table->dropForeign(['estado_id']);
            $table->dropColumn('estado_id');
        });
    }
};