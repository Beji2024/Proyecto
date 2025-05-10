<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Categoria;
use Illuminate\Http\Request;



class CategoriaController extends Controller
{
    public function index()
    {
        return Categoria::all();
    }

    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
        ]);
        return Categoria::create($request->only('name'));
    }
    public function show($id)
    {
        return Categoria::findOrFail($id);
    }
    public function update(Request $request, $id)
    {
        $categoria = Categoria::findOrFail($id);
        $categoria ->update($request->only('name'));
        return $categoria;
    }
    public function destroy($id)
    {
        Categoria::destroy($id);
        return response()->json(['message' => 'Categoria eliminada con exito'], 200);
    }
}
