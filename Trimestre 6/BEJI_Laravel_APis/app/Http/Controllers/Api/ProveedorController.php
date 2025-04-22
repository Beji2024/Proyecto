<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Proveedor;
use Illuminate\Http\Request;

class ProveedorController extends Controller
{
    public function index()
    {
        return Proveedor::all();
    }

    public function store(Request $request)
    {
        $request->validate([
            'nit' => 'required|string|max:10',
            'name' => 'required|string|max:50',
            'direccion' => 'required|string|max:50',
            'telefono' => 'required|string|max:10',
            'email' => 'required|string|email',
        ]);

        return Proveedor::create($request->only('nit', 'name', 'direccion', 'telefono', 'email'));
    }

    public function show($id)
    {
        return Proveedor::findOrFail($id);
    }

    public function update(Request $request, $id)
    {
        $proveedor = Proveedor::findOrFail($id);

        $request->validate([
            'nit' => 'required|string|max:10',
            'name' => 'required|string|max:50',
            'direccion' => 'required|string|max:50',
            'telefono' => 'required|string|max:10',
            'email' => 'required|string|email',
        ]);

        $proveedor->update($request->only('nit', 'name', 'direccion', 'telefono', 'email'));

        return $proveedor;
    }

    public function destroy($id)
    {
        Proveedor::destroy($id);

        return response()->json(['message' => 'Proveedor eliminado correctamente']);
    }
}
