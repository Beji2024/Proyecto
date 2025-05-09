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

    // Usuarios
    Route::apiResource('usuarios', UsuarioController::class);
    Route::get('/vendedores', [UsuarioController::class, 'getVendedores']); // extra

    // Estados
    Route::apiResource('estados', EstadoController::class);

    // Productos
    Route::apiResource('producto', ProductoController::class);

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
      Route::apiResource('roles', RolController::class);
});


    