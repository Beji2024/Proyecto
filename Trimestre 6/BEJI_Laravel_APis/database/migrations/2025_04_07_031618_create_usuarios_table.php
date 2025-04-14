<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up()
    {
        Schema::create('usuarios', function (Blueprint $table) {
            $table->id();
            $table->string('num_doc')->unique();
            $table->string('nombres');
            $table->string('apellidos');
            $table->string('direccion');
            $table->string('email')->unique();
            $table->string('num_tel');
            $table->date('fec_nac');
            $table->string('password');
            $table->unsignedBigInteger('tipodoc');
            $table->unsignedBigInteger('rol');
            $table->timestamps();

            $table->foreign('tipodoc')->references('id')->on('tipo_docs')->onDelete('cascade');
            $table->foreign('rol')->references('id')->on('rols')->onDelete('cascade');     
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('usuarios');
    }
};
