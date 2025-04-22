<?php

namespace App\Http\Controllers\Api;

use App\Models\Producto;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Hash;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class ProductoController extends Controller
{
    // Listar todos los productos
    public function index()
    {
        $productos = Producto::all();
        return response()->json($productos);
    }

    // Crear un nuevo producto
    public function store(Request $request)
    {
        $request->validate([
            'referencia' => 'required|string|max:50|unique:producto,referencia',
            'cantidad' => 'required|integer|min:0',
        ]);

        $producto = Producto::create($request->all());

        return response()->json($producto, 201);
    }

    // Mostrar un producto específico
    public function show($id)
    {
        $producto = Producto::findOrFail($id);
        return response()->json($producto);
    }

    // Actualizar un producto
    public function update(Request $request, $id)
    {
        $producto = Producto::findOrFail($id);

        $request->validate([
            'referencia' => 'sometimes|string|max:50|unique:producto,referencia,' . $producto->id,
            'cantidad' => 'sometimes|integer|min:0',
        ]);

        $producto->update($request->all());

        return response()->json($producto);
    }

    // Eliminar un producto
    public function destroy($id)
    {
        $producto = Producto::findOrFail($id);
        $producto->delete();

        return response()->json(['mensaje' => 'Producto eliminado']);
    }
}


