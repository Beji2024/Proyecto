<?php

namespace App\Http\Controllers\API;

use App\Models\Mercancia;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class MercanciaController extends Controller
{
    // Obtener todos los productos con la relación de subcategoría y categoría
    public function index()
    {
        $mercancias = Mercancia::with('subcategoria.categoria')->get();

        // Asegurar que la URL de la imagen sea completa
        $mercancias->transform(function ($item) {
            if ($item->imagen) {
                $item->imagen = asset($item->imagen);
            }
            return $item;
        });

        return $mercancias;
    }

    // Crear una nueva mercancia
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
            'imagen' => 'nullable|image|mimes:jpg,jpeg,png|max:2048',
        ]);

        if ($request->hasFile('imagen')) {
            $path = $request->file('imagen')->store('mercancias', 'public');
            $data['imagen'] = 'storage/' . $path;
        }

        $mercancia = Mercancia::create($data);

        // Devolver con URL completa
        if ($mercancia->imagen) {
            $mercancia->imagen = asset($mercancia->imagen);
        }

        return response()->json($mercancia, 201);
    }

    // Mostrar un producto específico
    public function show(Mercancia $mercancia)
    {
        $mercancia->load('subcategoria.categoria');

        if ($mercancia->imagen) {
            $mercancia->imagen = asset($mercancia->imagen);
        }

        return $mercancia;
    }

    // Filtrar mercancias por ID de subcategoría
    public function porSubcategoria($id)
    {
        $mercancias = Mercancia::where('sub_mer', $id)
            ->with('subcategoria.categoria')
            ->get();

        $mercancias->transform(function ($item) {
            if ($item->imagen) {
                $item->imagen = asset($item->imagen);
            }
            return $item;
        });

        return $mercancias;
    }

    // Filtrar mercancias por ID de categoría
    public function porCategoria($id)
    {
        $mercancias = Mercancia::whereHas('subcategoria.categoria', function ($query) use ($id) {
            $query->where('id', $id);
        })->with('subcategoria.categoria')->get();

        $mercancias->transform(function ($item) {
            if ($item->imagen) {
                $item->imagen = asset($item->imagen);
            }
            return $item;
        });

        return $mercancias;
    }

    // Eliminar producto
    public function destroy($id)
    {
        $producto = Mercancia::find($id);

        if (!$producto) {
            return response()->json(['message' => 'Producto no encontrado'], 404);
        }

        $producto->delete();
        return response()->json(['message' => 'Producto eliminado correctamente']);
    }

    // Actualizar producto
    public function update(Request $request, $id)
    {
        $producto = Mercancia::findOrFail($id);

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

        // Si viene una nueva imagen, reemplazar
        if ($request->hasFile('imagen')) {
            $path = $request->file('imagen')->store('mercancias', 'public');
            $data['imagen'] = url('/storage/' . $path);
        }

        if ($request->hasFile('imagen')) {
            $path = $request->file('imagen')->store('mercancias', 'public');
            $data['imagen'] = 'storage/' . $path;
        }

        $producto->update($data);

        if ($producto->imagen) {
            $producto->imagen = asset($producto->imagen);
        }

        return response()->json($producto);
    }
}
