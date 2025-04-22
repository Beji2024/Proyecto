<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Estado;

class EstadoController extends Controller
{
    public function index()
    {
        return Estado::all();
    }

    public function store(Request $request)
    {
        $validated = $request->validate([
            'nombre' => 'required|string|max:255',
        ]);
        return Estado::create($request->only('nombre'));
    }

    public function show($id)
    {
        return Estado::findOrFail($id);
    }

    public function update(Request $request, $id)
    {
        $rol = Estado::findOrFail($id);
        $rol->update($request->only('nombre'));
        return $rol;
    }

    public function destroy($id)
    {
        Estado::destroy($id);
        return response()->json(['message' => 'Estado eliminado correctamente']);
    }
}
