<?php

namespace App\Http\Controllers\Api;

use App\Models\Usuario;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Hash;
use Illuminate\Http\Request;

class UsuarioController extends Controller
{
    public function index()
    {
        return Usuario::with(['tipodoc', 'rol'])->get();
    }

    public function store(Request $request)
    {
        $validated = $request->validate([
            'num_doc' => 'required|unique:usuarios',
            'nombres' => 'required',
            'apellidos' => 'required',
            'direccion' => 'required',
            'email' => 'required|email|unique:usuarios',
            'num_tel' => 'required',
            'fec_nac' => 'required|date',
            'password' => 'required|min:6',
            'tipodoc' => 'required|exists:tipo_docs,id',
            'rol' => 'required|exists:rols,id',
        ]);
        
        $validated['password']=bcrypt($validated['password']);
        $usuario = Usuario::create($validated);
        return response()->json(['mensaje'=>'Usuario creado correctamente', 'usuario'=> $usuario],201);
    }

    public function show($id)
    {
        return Usuario::with(['tipodoc', 'rol'])->findOrFail($id);
    }

    public function update(Request $request, $id)
    {
        $usuario = Usuario::findOrFail($id);

        $usuario->update($request->only(
            'num_doc', 'nombres', 'apellidos', 'direccion',
            'email', 'num_tel', 'fec_nac', 'tipodoc', 'rol'
        ));

        if ($request->password) {
            $usuario->password = Hash::make($request->password);
            $usuario->save();
        }

        return $usuario;
    }

    public function destroy($id)
    {
        Usuario::destroy($id);
        return response()->json(['message' => 'Usuario eliminado correctamente']);
    }
   
}
