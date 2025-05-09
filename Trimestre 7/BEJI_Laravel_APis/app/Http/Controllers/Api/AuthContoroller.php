<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Http\JsonResponse;
use Illuminate\Support\Facades\Auth;
use Tymon\JWTAuth\Facades\JWTAuth;
use Tymon\JWTAuth\Exceptions\JWTException;

class AuthController extends Controller
{
    public function login(Request $request)
    {
        $credentials = $request->only('email', 'password');

        if (!$token = JWTAuth::attempt($credentials)) {
            return response()->json(['error' => 'Credenciales incorrectas'], 401);
        }

        $user = Auth::user()->load('rol'); 

        return response()->json([
            'access_token' => $token,
            'token_type' => 'bearer',
            'expires_in' => config('jwt.ttl') * 60, // Tiempo de expiración según la configuración
            'user' => $user,
        ]);
    }

    public function logout(): JsonResponse
    {
        try {
            JWTAuth::invalidate(JWTAuth::getToken());
            return response()->json(['message' => 'Sesión cerrada']);
        } catch (JWTException $e) {
            return response()->json(['error' => 'Error al cerrar sesión'], 500);
        }
    }

    public function me(): JsonResponse
    {
        try {
            $user = Auth::user()->load('rol');
            return response()->json($user);
        } catch (\Exception $e) {
            return response()->json(['error' => 'No se pudo obtener el usuario'], 500);
        }
    }

    public function refresh(): JsonResponse
    {
        try {
            $newToken = JWTAuth::refresh();
            return response()->json([
                'access_token' => $newToken,
                'token_type' => 'bearer',
                'expires_in' => config('jwt.ttl') * 60,
            ]);
        } catch (JWTException $e) {
            return response()->json(['error' => 'Token inválido'], 401);
        }
    }
}