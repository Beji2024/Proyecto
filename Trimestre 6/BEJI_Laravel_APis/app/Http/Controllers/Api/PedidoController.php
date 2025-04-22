<?php

namespace App\Http\Controllers\Api;

use App\Models\Pedido;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class PedidoController extends Controller
{
    public function index()
    {
        return Pedido::all();
    }

    public function store(Request $request)
{
    try {
        $request->validate([
            'fec_ped' => 'required|date',
            'ped_prov' => 'required|integer',
            'ped_est' => 'required|integer',
            'ped_user' => 'required|integer',
        ]);

        $pedido = Pedido::create($request->all());
        return response()->json($pedido, 201);

    } catch (\Exception $e) {
        return response()->json([
            'error' => $e->getMessage(),
            'line' => $e->getLine(),
            'file' => $e->getFile()
        ], 500);
    }
}


    public function show($id)
    {
        $pedido = Pedido::findOrFail($id);
        return $pedido;
    }

    public function update(Request $request, $id)
    {
        $pedido = Pedido::findOrFail($id);
        $pedido->update($request->all());
        return response()->json($pedido, 200);
    }

    public function destroy($id)
    {
        Pedido::destroy($id);
        return response()->json(null, 204);
    }
}