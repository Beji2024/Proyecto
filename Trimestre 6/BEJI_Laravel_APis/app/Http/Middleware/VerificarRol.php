<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class VerificarRol
{
    public function handle(Request $request, Closure $next, ...$roles)
    {
        $user = Auth::guard('api')->user();

        if (!$user || !in_array($user->rol->name, $roles)) {
            return response()->json(['error' => 'No autorizado'], 403);
        }

        return $next($request);
    }
}
