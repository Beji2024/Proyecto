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

// RUTAS PÚBLICAS
Route::post('/login', [AuthContoroller::class, 'login']);

// RUTAS PROTEGIDAS POR JWT
Route::middleware(['auth:api'])->group(function () {

    // Auth
    Route::get('/me', [AuthContoroller::class, 'me']);
    Route::post('/logout', [AuthContoroller::class, 'logout']);

    // Categorías
    Route::apiResource('categorias', CategoriaController::class);

    // Proveedores
    Route::apiResource('proveedores', ProveedorController::class);
<<<<<<< HEAD

    // Usuarios
    Route::apiResource('usuarios', UsuarioController::class);
    Route::get('/vendedores', [UsuarioController::class, 'getVendedores']); // extra

    // Estados
    Route::apiResource('estados', EstadoController::class);

    // Productos
    Route::apiResource('producto', ProductoController::class);

=======

<<<<<<< HEAD

//Mercancia
// web.php o api.php
Route::get('mercancia', [MercanciaController::class, 'index']);
Route::post('mercancia', [MercanciaController::class, 'store']);
Route::get('mercancia/{id}', [MercanciaController::class, 'show']);
Route::put('mercancia/{id}', [MercanciaController::class, 'update']);
Route::delete('mercancia/{id}', [MercanciaController::class, 'destroy']);

// Corrección: usar los nombres reales del controlador
Route::get('/mercancia/categoria/{id}', [MercanciaController::class, 'porCategoria']);
Route::get('/mercancia/subcategoria/{id}', [MercanciaController::class, 'porSubcategoria']);




//Pedido
Route::get('pedido', [PedidoController::class, 'index']);
Route::post('pedido', [PedidoController::class, 'store']);
Route::get('pedido/{id}', [PedidoController::class, 'show']);
Route::put('pedido/{id}', [PedidoController::class, 'update']);
Route::delete('pedido/{id}', [PedidoController::class, 'destroy']);
=======
    // Usuarios
    Route::apiResource('usuarios', UsuarioController::class);
    Route::get('/vendedores', [UsuarioController::class, 'getVendedores']); // extra

    // Estados
    Route::apiResource('estados', EstadoController::class);
>>>>>>> 930e891ef29530aad4274fcaf5e8daaf494d8fce

    // Productos
    Route::apiResource('producto', ProductoController::class);

>>>>>>> 871f1df527b74a41c45ebc45ba3c530334e7c90b
    // Tipo de documento
    Route::apiResource('tipo-docs', TipoDocController::class);

    // Roles
    Route::apiResource('roles', RolController::class);

    // Ventas (algunas rutas personalizadas además del CRUD)
    Route::get('/venta', [VentaController::class, 'index']);
    Route::post('/venta', [VentaController::class, 'store']);
    Route::get('/venta/{id}', [VentaController::class, 'show']);
    Route::patch('/venta/{id}', [VentaController::class, 'update']);
    Route::put('/venta/{id}', [VentaController::class, 'update1']); // extra personalizada
    Route::delete('/venta/{id}', [VentaController::class, 'destroy']);
});

<<<<<<< HEAD
=======

>>>>>>> 871f1df527b74a41c45ebc45ba3c530334e7c90b
    
    