<?php

namespace App\Http\Controllers\Api;

use App\Models\Usuario;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Hash;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class UsuarioController extends Controller
{
    public function index()
    {
        $user = auth()->user();

        if (!$user || $user->rol->name !== 'Administrador') {
           return response()->json(['error' => 'No autorizado'], 403);
        }
        $usuarios = Usuario::with(['rol', 'tipodoc'])->get();
        return response()->json($usuarios);
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
            'tipodoc_id' => 'required|exists:tipo_docs,id',
            'rol_id' => 'required|exists:rols,id',
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

    public function getVendedores()
    {
        $vendedores = Usuario::whereHas('rol', function($query) {
            $query->where('name', 'Vendedor'); // Asegúrate de que 'nombre' sea el campo correcto en tu tabla de roles
        })->with(['rol', 'tipodoc'])->get(); // Asegura que la relación con rol y tipo de documento esté cargada

        return response()->json($vendedores);
    }
}
