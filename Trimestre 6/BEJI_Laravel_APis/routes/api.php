<?php

use App\Http\Controllers\Api\TipoDocController;
use App\Http\Controllers\Api\RolController;
use App\Http\Controllers\Api\CategoriaController;
use App\Http\Controllers\Api\ProveedorController;
use App\Http\Controllers\Api\EstadoController;
use App\Http\Controllers\Api\UsuarioController;
use Illuminate\Support\Facades\Route;

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

//Usuario
Route::get('usuarios', [UsuarioController::class, 'index']);
Route::post('usuarios', [UsuarioController::class, 'store']);
Route::get('usuarios/{id}', [UsuarioController::class, 'show']);
Route::put('usuarios/{id}', [UsuarioController::class, 'update']);
Route::delete('usuarios/{id}', [UsuarioController::class, 'destroy']);
