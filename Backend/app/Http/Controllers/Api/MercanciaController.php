<?php

namespace App\Http\Controllers\API;

use App\Models\Mercancia;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class MercanciaController extends Controller
{
    // Obtener todos los productos con la relación de subcategoría y categoría
    public function index()
    {
        return Mercancia::with('subcategoria.categoria')->get();
    }

    // Crear una nueva mercancia
    public function store(Request $request)
    {
        $data = $request->validate([
           'cantidad' => 'required|integer',
            'nombre' => 'required|string|max:50',
            'talla' => 'required|integer',
            'precio_venta' => 'required|numeric',
            'precio_compra' => 'required|numeric',
            'material' => 'required|string|max:30',
            'color' => 'required|string|max:20',
            'sub_mer' => 'required|integer',
        ]);

        $mercancia = Mercancia::create($data);
        return response()->json($mercancia, 201);
    }

    // Mostrar un producto específico
    public function show(Mercancia $mercancia)
    {
        return $mercancia->load('subcategoria.categoria');
    }

    // Filtrar mercancias por ID de subcategoría
    public function porSubcategoria($id)
    {
        return Mercancia::where('sub_mer', $id)
            ->with('subcategoria.categoria') // Traemos las relaciones de subcategoria y categoria
            ->get();
    }

    // Filtrar mercancias por ID de categoría
    public function porCategoria($id)
    {
        return Mercancia::whereHas('subcategoria.categoria', function ($query) use ($id) {
            $query->where('id', $id); // Filtrar mercancias con la categoría correspondiente
        })->with('subcategoria.categoria') ->get();
    }
    
    public function destroy($id)
    {
    $producto = Mercancia::find($id);

    if (!$producto) {
    return response()->json(['message' => 'Producto no encontrado'], 404);
    }

    $producto->delete();
    return response()->json(['message' => 'Producto eliminado correctamente']);
    }

    public function update(Request $request, $id)
{
    $producto = Mercancia::findOrFail($id);
    $producto->update($request->all());
    return response()->json($producto);
}

}