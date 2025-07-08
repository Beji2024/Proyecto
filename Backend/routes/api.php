<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\AuthContoroller;
use App\Http\Controllers\Api\TipoDocController;
use App\Http\Controllers\Api\RolController;
use App\Http\Controllers\Api\CategoriaController;
use App\Http\Controllers\Api\ProveedorController;
use App\Http\Controllers\Api\EstadoController;
use App\Http\Controllers\Api\UsuarioController;
use App\Http\Controllers\Api\SubcategoriaController;
use App\Http\Controllers\Api\VentaController;
use App\Http\Controllers\Api\ProductoController;
use App\Http\Controllers\Api\MercanciaController;
use App\Http\Controllers\Api\PedidoController;

// RUTAS PÚBLICAS
Route::post('/login', [AuthContoroller::class, 'login']);

// RUTAS PROTEGIDAS POR JWT
Route::middleware(['auth:api'])->group(function () {

    // Auth
    Route::get('/me', [AuthContoroller::class, 'me']);
    Route::post('/logout', [AuthContoroller::class, 'logout']);

    // Categorías
    Route::apiResource('categorias', CategoriaController::class);
    Route::get('/mercancia/categoria/{id}', [MercanciaController::class, 'porCategoria']);
    Route::get('/mercancia/subcategoria/{id}', [MercanciaController::class, 'porSubcategoria']);
    
    //SUBACTEGORIA
    Route::apiResource('subcategorias', SubcategoriaController::class);
    // Proveedores
    Route::apiResource('proveedores', ProveedorController::class);

    // Usuarios
    Route::apiResource('usuarios', UsuarioController::class);
    Route::get('/vendedores', [UsuarioController::class, 'getVendedores']); // extra

    // Estados
    Route::apiResource('estados', EstadoController::class);

    // Productos
    Route::apiResource('producto', ProductoController::class);

    // Tipo de documento
    Route::apiResource('tipo-docs', TipoDocController::class);

    // Roles
    Route::get('/roles', [RolController::class, 'index']);

    // Ventas (algunas rutas personalizadas además del CRUD)
    Route::get('/venta', [VentaController::class, 'index']);
    Route::post('/venta', [VentaController::class, 'store']);
    Route::get('/venta/{id}', [VentaController::class, 'show']);
    Route::patch('/venta/{id}', [VentaController::class, 'update']);
    Route::put('/venta/{id}', [VentaController::class, 'update1']); // extra personalizada
    Route::delete('/venta/{id}', [VentaController::class, 'destroy']);

    //mercancías
    Route::apiResource('mercancia', MercanciaController::class);

    // pedidos
Route::apiResource('pedidos', PedidoController::class)->only([
    'index', 'store', 'show'
]);
});

    
    