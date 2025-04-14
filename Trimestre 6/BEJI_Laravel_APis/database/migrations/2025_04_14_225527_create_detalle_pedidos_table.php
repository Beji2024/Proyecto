<?php



use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration {
    public function up(): void {
        Schema::create('detalle_peds', function (Blueprint $table) {
            $table->id('iddet_ped');
            $table->tinyInteger('cantidad');
            $table->decimal('precio_uni', 10, 2);
            $table->decimal('precio_tt', 10, 2);
            $table->unsignedBigInteger('det_p_mer');
            $table->unsignedBigInteger('det_p_ped');

            $table->foreign('det_p_mer')->references('id_pro')->on('mercancias')->onDelete('cascade');
            $table->foreign('det_p_ped')->references('idpedido')->on('pedidos')->onDelete('cascade');

            $table->timestamps();
        });
    }

    public function down(): void {
        Schema::dropIfExists('detalle_peds');
    }
};