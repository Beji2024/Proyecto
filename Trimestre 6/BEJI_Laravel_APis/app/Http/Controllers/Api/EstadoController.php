<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Estado;
use Illuminate\Http\Request;

class EstadoController extends Controller
{
    public function index()
    {
        return Estado::all();
    }
    
    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required',
        ]);
        return Estado::create($request->only('name'));
    }
    public function show($id)
    {
        return Estado::findOrFail($id);
    }
    public function update(Request $request, $id)
    {
        $estado = Estado::findOrFail($id);
        $estado ->update($request->only('name'));
        return $estado;
    }
    public function destroy($id)
    {
        Estado::destroy($id);
        return response()->json(['message'=>'Estado eliminado correctamente']);
    }
}
