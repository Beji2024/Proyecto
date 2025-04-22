<?php

use App\Http\Controllers\Api\TipoDocController;
use App\Http\Controllers\Api\RolController;
use App\Http\Controllers\Api\CategoriaController;
use App\Http\Controllers\Api\ProveedorController;
use App\Http\Controllers\Api\EstadoController;
use App\Http\Controllers\Api\UsuarioController;
use App\Http\Controllers\Api\SubcategoriaController;
use App\Http\Controllers\API\MercanciaController;
use App\Http\Controllers\Api\PedidoController;
use App\Http\Controllers\API\DetallePedController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\AuthContoroller;
use App\Http\Middleware\VerificarRol;


//Tipo de documento
Route::get('tipo-docs', [TipoDocController::class, 'index']);               // Listar todos
Route::post('tipo-docs', [TipoDocController::class, 'store']);              // Crear nuevo
Route::get('tipo-docs/{id}', [TipoDocController::class, 'show']);           // Ver uno
Route::put('tipo-docs/{id}', [TipoDocController::class, 'update']);         // Actualizar
Route::delete('tipo-docs/{id}', [TipoDocController::class, 'destroy']);     // Eliminar

//Rol
Route::get('roles', [RolController::class, 'index']);
Route::post('roles', [RolController::class, 'store']);
Route::get('roles/{id}', [RolController::class, 'show']);
Route::put('roles/{id}', [RolController::class, 'update']);
Route::delete('roles/{id}', [RolController::class, 'destroy']);

//Categoria
Route::get('categorias', [CategoriaController::class, 'index']);
Route::post('categorias', [CategoriaController::class, 'store']);
Route::get('categorias/{id}', [CategoriaController::class, 'show']);
Route::put('categorias/{id}', [CategoriaController::class, 'update']);
Route::delete('categorias/{id}', [CategoriaController::class, 'destroy']);

//Proovedores
Route::get('proveedores', [ProveedorController::class, 'index']);
Route::post('proveedores', [ProveedorController::class, 'store']);
Route::get('proveedores/{id}',[ProveedorController::class, 'show']);
Route::put('proveedores/{id}', [ProveedorController::class, 'update']);
Route::delete('proveedores/{id}', [ProveedorController::class, 'destroy']);

//Estado
Route::get('estados', [EstadoController::class, 'index']);
Route::post('estados', [EstadoController::class, 'store']);
Route::get('estados/{id}', [EstadoController::class, 'show']);
Route::put('estados/{id}', [EstadoController::class, 'update']);
Route::delete('estados/{id}', [EstadoController::class, 'destroy']);


Route::middleware('auth:api')->group(function () {
    
    Route::get('/usuarios', [UsuarioController::class, 'index']);
    Route::post('/usuarios', [UsuarioController::class, 'store']);
    Route::get('/usuarios/{id}', [UsuarioController::class, 'show']);
    Route::put('/usuarios/{id}', [UsuarioController::class, 'update']);
    Route::delete('/usuarios/{id}', [UsuarioController::class, 'destroy']);
    // Añade aquí todas las rutas que deben ser protegidas
});

    //Usuarios    
    //token
    Route::get('/me', [AuthContoroller::class, 'me']);
    Route::post('/logout', [AuthContoroller::class, 'logout']);


//subcategoria
Route::get('subcategorias', [SubcategoriaController::class, 'index']);
Route::post('subcategorias', [SubcategoriaController::class, 'store']);
Route::get('subcategorias/{id}', [SubcategoriaController::class, 'show']);
Route::put('subcategorias/{id}', [SubcategoriaController::class, 'update']);
Route::delete('subcategorias/{id}', [SubcategoriaController::class, 'destroy']);


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

//Detallepedido
Route::get('detalleped', [DetallePedController::class, 'index']);
Route::post('detalleped', [DetallePedController::class, 'store']);
Route::get('detalleped/{id}', [DetallePedController::class, 'show']);
Route::put('detalleped/{id}', [DetallePedController::class, 'update']);
Route::delete('detalleped/{id}', [DetallePedController::class, 'destroy']);

//Ingreso
Route::post('/login', [AuthContoroller::class, 'login'])->name('login');
