<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Subcategoria;

class SubcategoriaController extends Controller
{
    // Listar todas las subcategorías
    public function index()
    {
        return Subcategoria::all();
    }

    // Mostrar una subcategoría por ID
    public function show($id)
    {
        return Subcategoria::findOrFail($id);
    }

    // Crear una nueva subcategoría
    public function store(Request $request)
{
    $data = $request->validate([
        'nom_sub' => 'required|string|max:255',
        'cat_sub' => 'required|integer',
    ]);

    $subcategoria = Subcategoria::create($data);

    return response()->json($subcategoria, 201);
}


    // Actualizar una subcategoría existente
    public function update(Request $request, $id)
    {
        $subcategoria = Subcategoria::findOrFail($id);

        $data = $request->validate([
            'nom_sub' => 'required|string|max:255',
            'cat_sub' => 'required|integer',
        ]);

        $subcategoria->update($data);

        return $subcategoria;
    }

    // Eliminar una subcategoría
    public function destroy($id)
    {
        Subcategoria::destroy($id);

        return response()->json(['message' => 'Subcategoría eliminada correctamente']);
    }
}
