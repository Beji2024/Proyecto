<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\TipoDoc;

class TipoDocController extends Controller
{
    public function index()
    {
        return TipoDoc::all();
    }

    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
        ]);

        return TipoDoc::create($request->only('name'));
    }

    public function show($id)
    {
        return TipoDoc::findOrFail($id);
    }

    public function update(Request $request, $id)
    {
        $tipoDoc = TipoDoc::findOrFail($id);
        $tipoDoc->update($request->only('name'));
        return $tipoDoc;
    }

    public function destroy($id)
    {
        TipoDoc::destroy($id);
        return response()->json(['message' => 'Eliminado correctamente']);
    }
}
