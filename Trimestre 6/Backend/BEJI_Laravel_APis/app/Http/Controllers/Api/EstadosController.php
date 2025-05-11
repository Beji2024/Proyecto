<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Estados;
use Illuminate\Http\Request;

class EstadosController extends Controller
{
    public function index()
    {
        return Estados::all();
    }

    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
        ]);

        return Estados::create($request->only('name'));
    }

    public function show($id)
    {
        return Estados::findOrFail($id);
    }

    public function update(Request $request, $id)
    {
        $rol = Estados::findOrFail($id);
        $rol->update($request->only('name'));
        return $rol;
    }

    public function destroy($id)
    {
        Estados::destroy($id);
        return response()->json(['message' => 'Rol eliminado correctamente']);
    }
}
