<?php

namespace App\Http\Controllers\Api;

use App\Models\DetallePed;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class DetallePedController extends Controller
{
    public function index()
    {
        return DetallePed::all();
    }

    public function store(Request $request)
    {
        $request->validate([
            'cantidad' => 'required|integer|min:1',
            'precio_uni' => 'required|numeric',
            'precio_tt' => 'required|numeric',
            'det_p_mer' => 'required|integer',
            'det_p_ped' => 'required|integer',
        ]);

        $detalle = DetallePed::create($request->all());
        return response()->json($detalle, 201);
    }

    public function show($id)
    {
        return DetallePed::findOrFail($id);
    }

    public function update(Request $request, $id)
    {
        $detalle = DetallePed::findOrFail($id);

        $request->validate([
            'cantidad' => 'integer|min:1',
            'precio_uni' => 'numeric',
            'precio_tt' => 'numeric',
            'det_p_mer' => 'integer',
            'det_p_ped' => 'integer',
        ]);

        $detalle->update($request->all());
        return response()->json($detalle, 200);
    }

    public function destroy($id)
    {
        DetallePed::destroy($id);
        return response()->json(null, 204);
    }
}
