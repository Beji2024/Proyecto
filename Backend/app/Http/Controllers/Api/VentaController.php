<?php

namespace App\Http\Controllers\Api;

use App\Models\Venta;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Hash;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class VentaController extends Controller
{
    // Listar todas las ventas
    public function index()
    {
        $ventas = Venta::with(['producto', 'vendedor','estado'])->get();
        return response()->json($ventas);
    }

    // Crear una nueva venta
    public function store(Request $request)
    {
        $request->validate([
            'nombre_cli' => 'required|string|max:100',
            'direccion_cli' => 'required|string|max:50',
            'correo_cli' => 'nullable|email|max:50',
            'num_tel_cli' => 'nullable|string|max:20',
            'num_doc_cli' => 'nullable|string|max:20',
            'producto_id' => 'required|exists:producto,id',
            'cantidad' => 'required|integer|min:1',
            'vendedor_id' => 'required|exists:usuarios,id',
        ]);

        $venta = Venta::create($request->all());

        return response()->json($venta, 201);
    }

    // Mostrar una venta específica
    public function show($id)
    {
        $venta = Venta::with(['producto', 'vendedor'])->findOrFail($id);
        return response()->json($venta);
    }

    // Actualizar una venta
    public function update(Request $request, $id)
{
    $request->validate([
        'estado_id' => 'required|exists:estado,id',
    ]);
    
    $venta = Venta::find($id);
    if (!$venta) {
        return response()->json(['message' => 'Venta no encontrada'], 404);
    }
    $venta->estado_id = $request->estado_id;
    $venta->save(); 
    
    return response()->json([
        'message' => 'Estado actualizado correctamente',
        'venta' => $venta 
    ], 200);
}
public function update1(Request $request, $id)
{
    $venta = Venta::findOrFail($id);
    $venta->update($request->all()); // Asegúrate de que producto_id esté permitido

    return response()->json(['mensaje' => 'Venta actualizada correctamente', 'venta' => $venta]);
}

    // Eliminar una venta
    public function destroy($id)
    {
        $venta = Venta::findOrFail($id);
        $venta->delete();

        return response()->json(['mensaje' => 'Venta eliminada']);
    }
    
}



