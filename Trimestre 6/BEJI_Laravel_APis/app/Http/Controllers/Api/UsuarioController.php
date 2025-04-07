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
        $request->validate([
            'num_doc' => 'required|string|max:15',
            'nombres' => 'required|string|max:100',
            'apellidos' => 'required|string|max:100',
            'direccion' => 'required|string|max:100',
            'email' => 'required|string|email|max:100|unique:usuarios,email',
            'num_tel' => 'required|string|max:15',
            'fec_nac' => 'required|date',
            'password' => 'required|string|min:5',
            'tipodoc' => 'required|integer|exists:tipo_docs,id',
            'rol' => 'required|integer|exists:rols,id',
        ]);
        $usuario = Usuario::create([
            'num_doc' => $request->num_doc,
            'nombres' => $request->nombres,
            'apellidos' => $request->apellidos,
            'direccion' => $request->direccion,
            'email' => $request->email,
            'num_tel' => $request->num_tel,
            'fec_nac' => $request->fec_nac,
            'password' => bcrypt($request->password),
            'tipodoc' => $request->tipodoc,
            'rol' => $request->rol,
        ]);
        return response()->json($usuario,201);
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
            'email', 'num_tel', 'fec_nac', 'tipodoc_id', 'rol_id'
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
