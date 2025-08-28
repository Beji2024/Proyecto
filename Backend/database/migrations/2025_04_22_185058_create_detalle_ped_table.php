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
    if (!Schema::hasTable('detalle_ped')) {
        Schema::create('detalle_ped', function (Blueprint $table) {
            $table->id('iddet_ped');
            $table->tinyInteger('cantidad');
            $table->decimal('precio_uni', 10, 2);
            $table->decimal('precio_tt', 10, 2);
            $table->unsignedBigInteger('det_p_ped');
            $table->unsignedBigInteger('det_p_mer'); 
            $table->timestamps();
        });

        // Agregar claves foráneas después (opcional)
        Schema::table('detalle_ped', function (Blueprint $table) {
            $table->foreign('det_p_mer')->references('id_pro')->on('mercancia');
            $table->foreign('det_p_ped')->references('idpedido')->on('pedidos');
        });
    }

}

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('detalle_ped');
    }
};
