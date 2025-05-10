<?php

namespace App\Http\Controllers\API;

use App\Models\Mercancia;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class MercanciaController extends Controller
{
    public function index()
    {
        return Mercancia::all();
    }

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

    public function show(Mercancia $mercancia)
    {
        return $mercancia;
    }

    public function update(Request $request, Mercancia $mercancia)
    {
        $data = $request->validate([
            'cantidad' => 'integer',
            'nombre' => 'string|max:50',
            'talla' => 'integer',
            'precio_venta' => 'numeric',
            'precio_compra' => 'numeric',
            'material' => 'string|max:30',
            'color' => 'string|max:20',
            'sub_mer' => 'integer',
        ]);

        $mercancia->update($data);
        return $mercancia;
    }

    public function destroy(Mercancia $mercancia)
    {
        $mercancia->delete();
        return response()->noContent();
    }
}
