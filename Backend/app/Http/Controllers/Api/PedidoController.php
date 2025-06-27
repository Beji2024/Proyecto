<?php

namespace App\Http\Controllers\Api;

use App\Models\Pedido;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\DetallePed;
use Illuminate\Support\Facades\Validator;

class PedidoController extends Controller
{
    public function index()
    {
        return Pedido::with('detalles')->paginate(10);
    }

    public function store(Request $req)
{
    $data = $req->validate([
        'fec_ped'   => 'required|date',
        'ped_prov'  => 'required|string|exists:proveedor,nit',
        'ped_user'  => 'required|integer|exists:usuarios,num_doc',
        'detalles'  => 'required|array|min:1',
        'detalles.*.cantidad'    => 'required|integer|min:1',
        'detalles.*.precio_uni'  => 'required|numeric|min:0',
        'detalles.*.det_p_mer'   => 'required|integer|exists:mercancia,id_pro'
    ]);

    try {
        $pedido = Pedido::create($data);

        foreach ($data['detalles'] as $d) {
            DetallePed::create([
                'cantidad'    => $d['cantidad'],
                'precio_uni'  => $d['precio_uni'],
                'precio_tt'   => $d['cantidad'] * $d['precio_uni'],
                'det_p_mer'   => $d['det_p_mer'],
                'det_p_ped'   => $pedido->idpedido
            ]);
        }

        return response()->json(['success' => true, 'pedido' => $pedido], 201);

    } catch (\Exception $e) {
        return response()->json([
            'error' => $e->getMessage(),
            'trace' => $e->getTrace()
        ], 500);
    }
}


    public function show(Pedido $pedido)
    {
        return $pedido->load('detalles');
    }
}
