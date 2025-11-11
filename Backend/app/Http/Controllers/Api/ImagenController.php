<?php

namespace App\Http\Controllers\Api;

use Illuminate\Http\Request;
use App\Models\Imagen;
use App\Http\Controllers\Controller;

class ImagenController extends Controller
{
    public function store(Request $request)
    {
        $request->validate([
            'nombre' => 'required|string',
            'imagen' => 'required|image|mimes:jpg,jpeg,png,gif|max:2048',
        ]);

        // Guardar imagen en storage/app/public/imagenes
        $path = $request->file('imagen')->store('imagenes', 'public');

        // Guardar registro en la base de datos
        $imagen = Imagen::create([
            'nombre' => $request->nombre,
            'ruta_imagen' => $path
        ]);

        return response()->json([
            'mensaje' => 'Imagen subida correctamente',
            'data' => $imagen
        ], 201);
    }
}

