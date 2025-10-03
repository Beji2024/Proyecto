<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up(): void
    {
        Schema::create('venta', function (Blueprint $table) {
            $table->id();

            $table->string('nombre_cli',100);
            $table->string('direccion_cli',50);
            $table->string('correo_cli',50)->nullable();
            $table->string('num_tel_cli',20)->nullable();
            $table->string('num_doc_cli',20)->nullable();

            $table->unsignedBigInteger('producto_id');
            $table->integer('cantidad');

            $table->unsignedBigInteger('vendedor_id');

            $table->unsignedBigInteger('estado_id')->default(1);

            $table->timestamp('fecha')->useCurrent();
            $table->timestamps();

            
            $table->foreign('producto_id')->references('id')->on('producto')->onDelete('cascade');
            $table->foreign('vendedor_id')->references('id')->on('usuarios')->onDelete('cascade');
            $table->foreign('estado_id')->references('id')->on('estado_venta')->onDelete('cascade');
        });
    }
    public function down(): void
    {
        Schema::dropIfExists('venta');
    }
};
