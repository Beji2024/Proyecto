<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Proveedor;
use Illuminate\Support\Facades\Validator;

class proveedorController extends Controller
{
    public function index()
    {
        $proveedores = Proveedor::paginate(10);
        if ($proveedores->isEmpty()) {
            $data = [
                'message' => 'No se encontraron proveedores',
                'status'=> 200
            ];
            return response()->json([$data],404);
        }
        return response()->json($proveedores, 200);
    }

    public function store(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'nombre' => 'required|max:255',
            'nit' => 'required|unique:proveedor|numeric',
            'celular' => 'required|digits:10',
            'email' => 'required|email|unique:proveedor',
            'direccion' => 'required|max:255',
        ], [
            'required' => 'El campo :attribute es obligatorio.',
            'unique' => 'El :attribute ya está registrado.',
            'numeric' => 'El campo :attribute debe ser numérico.',
            'email' => 'El campo :attribute debe ser un correo válido.',
            'digits' => 'El campo :attribute debe tener exactamente :digits dígitos.'
        ]);
        
    
        if ($validator->fails()) {
            return response()->json([
                'message' => 'Error en la validación de los datos',
                'errors' => $validator->errors(),
                'status' => 400
            ], 400);
        }
    
        $proveedor = Proveedor::create([
            'nombre' => $request->nombre,
            'nit' => $request->nit,
            'celular' => $request->celular,
            'email' => $request->email,
            'direccion' => $request->direccion,

        ]);
    
        if ($proveedor) {
            return response()->json([
                'message' => 'Proveedor creado correctamente',
                'status' => 201
            ], 201);
        }
    
        return response()->json([
            'message' => 'Error al crear el proveedor',
            'status' => 500
        ], 500);
    }
    public function destroy($id)
{
    $proveedor = Proveedor::find($id);

    if (!$proveedor) {
        return response()->json([
            'message' => 'Proveedor no encontrado',
            'status' => 404
        ], 404);
    }

    $proveedor->delete();

    return response()->json([
        'message' => 'Proveedor eliminado correctamente',
        'status' => 200
    ], 200);
}

public function update(Request $request, $id)
{
    $proveedor = Proveedor::find($id);

    if (!$proveedor) {
        return response()->json([
            'message' => 'Proveedor no encontrado',
            'status' => 404
        ], 404);
    }

    $validator = Validator::make($request->all(), [
        'nombre' => 'required|max:255',
        'nit' => 'required|numeric|unique:proveedor,nit,'.$id,
        'celular' => 'required|digits:10',
        'email' => 'required|email|unique:proveedor,email,'.$id,
        'direccion' => 'required|max:255'
    ]);

    if ($validator->fails()) {
        return response()->json([
            'message' => 'Error en la validación de los datos',
            'errors' => $validator->errors(),
            'status' => 400
        ], 400);
    }

    $proveedor->update($request->all());

    return response()->json([
        'message' => 'Proveedor actualizado correctamente',
        'status' => 200
    ], 200);
}  
public function show($id)
{
    $proveedor = Proveedor::find($id);

    if (!$proveedor) {
        return response()->json([
            'message' => 'Proveedor no encontrado',
            'status' => 404
        ], 404);
    }

    return response()->json($proveedor, 200);
  
}
}