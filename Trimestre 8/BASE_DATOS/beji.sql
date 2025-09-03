-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 02-09-2025 a las 17:22:55
-- Versión del servidor: 11.8.2-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bej1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cache`
--

CREATE TABLE `cache` (
  `key` varchar(255) NOT NULL,
  `value` mediumtext NOT NULL,
  `expiration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cache_locks`
--

CREATE TABLE `cache_locks` (
  `key` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `expiration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `name`, `created_at`, `updated_at`) VALUES
(1, 'Zapatos Casual', '2025-08-29 00:31:15', '2025-08-29 00:31:15'),
(2, 'Zapatos Deportivos', '2025-08-29 00:31:15', '2025-08-29 00:31:15'),
(3, 'Botas', '2025-08-29 00:31:15', '2025-08-29 00:31:15'),
(4, 'Sandalias', '2025-08-29 00:31:15', '2025-08-29 00:31:15'),
(5, 'Zapatos de Vestir', '2025-08-29 00:31:15', '2025-08-29 00:31:15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ped`
--

CREATE TABLE `detalle_ped` (
  `iddet_ped` bigint(20) UNSIGNED NOT NULL,
  `cantidad` tinyint(4) NOT NULL,
  `precio_uni` decimal(10,2) NOT NULL,
  `precio_tt` decimal(10,2) NOT NULL,
  `det_p_ped` bigint(20) UNSIGNED NOT NULL,
  `det_p_mer` bigint(20) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id`, `nombre`, `created_at`, `updated_at`) VALUES
(1, 'Activo', '2025-08-28 14:53:24', '2025-08-28 14:53:24'),
(2, 'Inactivo', '2025-08-28 14:53:24', '2025-08-28 14:53:24'),
(3, 'Pendiente', '2025-08-28 14:53:24', '2025-08-28 14:53:24');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `connection` text NOT NULL,
  `queue` text NOT NULL,
  `payload` longtext NOT NULL,
  `exception` longtext NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs`
--

CREATE TABLE `jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `queue` varchar(255) NOT NULL,
  `payload` longtext NOT NULL,
  `attempts` tinyint(3) UNSIGNED NOT NULL,
  `reserved_at` int(10) UNSIGNED DEFAULT NULL,
  `available_at` int(10) UNSIGNED NOT NULL,
  `created_at` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `job_batches`
--

CREATE TABLE `job_batches` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `total_jobs` int(11) NOT NULL,
  `pending_jobs` int(11) NOT NULL,
  `failed_jobs` int(11) NOT NULL,
  `failed_job_ids` longtext NOT NULL,
  `options` mediumtext DEFAULT NULL,
  `cancelled_at` int(11) DEFAULT NULL,
  `created_at` int(11) NOT NULL,
  `finished_at` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mercancia`
--

CREATE TABLE `mercancia` (
  `id_pro` bigint(20) UNSIGNED NOT NULL,
  `cantidad` tinyint(4) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `talla` tinyint(4) NOT NULL,
  `precio_venta` double NOT NULL,
  `precio_compra` double NOT NULL,
  `material` varchar(30) NOT NULL,
  `color` varchar(20) NOT NULL,
  `sub_mer` bigint(20) UNSIGNED NOT NULL,
  `imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `mercancia`
--

INSERT INTO `mercancia` (`id_pro`, `cantidad`, `nombre`, `talla`, `precio_venta`, `precio_compra`, `material`, `color`, `sub_mer`, `imagen`) VALUES
(1, 100, 'Zapato Deportivo Hombre', 42, 130000, 90000, 'Cuero Sintético', 'Negro', 1, 'zapato_deportivo_hombre.jpg'),
(2, 20, 'Puma', 40, 400000, 500000, 'Algodon', 'Verde', 2, 'Nacional.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '0001_01_01_000000_create_users_table', 1),
(2, '0001_01_01_000001_create_cache_table', 1),
(3, '0001_01_01_000002_create_jobs_table', 1),
(4, '2025_03_19_010215_create_proveedor_table', 1),
(5, '2025_04_07_005127_create_tipo_docs_table', 1),
(6, '2025_04_07_005445_create_personal_access_tokens_table', 1),
(7, '2025_04_07_011635_create_rols_table', 1),
(8, '2025_04_07_012922_create_categorias_table', 1),
(9, '2025_04_07_025509_create_estados_table', 1),
(10, '2025_04_07_031618_create_usuarios_table', 1),
(11, '2025_04_09_000448_create_subcategoria_table', 1),
(12, '2025_04_11_032337_create_mercancias_table', 1),
(13, '2025_04_14_210134_create_pedidos_table', 1),
(14, '2025_04_16_171442_create_estado_table', 1),
(15, '2025_04_17_005959_create_producto_table', 1),
(16, '2025_04_17_010021_create_venta_table', 1),
(17, '2025_04_22_185058_create_detalle_ped_table', 1),
(18, '2025_07_09_153226_add_imagen_to_mercancias_table', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `password_reset_tokens`
--

CREATE TABLE `password_reset_tokens` (
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `idpedido` bigint(20) UNSIGNED NOT NULL,
  `fec_ped` date NOT NULL,
  `ped_prov` varchar(255) NOT NULL,
  `ped_user` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal_access_tokens`
--

CREATE TABLE `personal_access_tokens` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tokenable_type` varchar(255) NOT NULL,
  `tokenable_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `token` varchar(64) NOT NULL,
  `abilities` text DEFAULT NULL,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `referencia` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `referencia`, `cantidad`, `created_at`, `updated_at`) VALUES
(1, 'ZAP-001-NIKE-AIR', 25, '2025-08-28 14:25:21', '2025-08-28 14:25:21'),
(2, 'ZAP-002-ADIDAS-ULTRA', 15, '2025-08-28 14:25:21', '2025-08-28 14:25:21'),
(3, 'ZAP-003-PUMA-RUNNER', 30, '2025-08-28 14:25:21', '2025-08-28 14:25:21'),
(4, 'ZAP-004-CONVERSE-CLASSIC', 20, '2025-08-28 14:25:21', '2025-08-28 14:25:21'),
(5, 'ZAP-005-REEBOK-ENERGY', 12, '2025-08-28 14:25:21', '2025-08-28 14:25:21'),
(6, 'ZAP-006-CROCS-URBAN', 40, '2025-08-28 14:25:21', '2025-08-28 14:25:21'),
(7, 'ZAP-007-TIMBERLAND-BOOTS', 8, '2025-08-28 14:25:21', '2025-08-28 14:25:21'),
(8, 'ZAP-008-VANS-OLD-SKOOL', 18, '2025-08-28 14:25:21', '2025-08-28 14:25:21'),
(9, 'ZAP-009-NEWBALANCE-574', 22, '2025-08-28 14:25:21', '2025-08-28 14:25:21'),
(10, 'ZAP-010-JORDAN-RETRO', 10, '2025-08-28 14:25:21', '2025-08-28 14:25:21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nit` varchar(255) NOT NULL,
  `celular` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `nombre`, `nit`, `celular`, `email`, `direccion`, `created_at`, `updated_at`) VALUES
(1, 'Calzado Urbano', '910123456', '3111234567', 'contacto@calzadourbano.com', 'Calle 12 #45-67 Bogotá', '2025-08-29 00:29:39', '2025-08-29 00:29:39'),
(2, 'Zapatería La Moda', '920987654', '3109873210', 'ventas@zapaterialamoda.com', 'Carrera 8 #23-56 Medellín', '2025-08-29 00:29:39', '2025-08-29 00:29:39'),
(3, 'Calzados Deportivos SAS', '930234567', '3202345678', 'info@calzadosdeportivos.com', 'Av. 9 #100-45 Cali', '2025-08-29 00:29:39', '2025-08-29 00:29:39'),
(4, 'Fábrica de Botas', '940345678', '3003456789', 'proveedores@fabricadebotas.com', 'Cra 25 #80-20 Barranquilla', '2025-08-29 00:29:39', '2025-08-29 00:29:39'),
(5, 'Moda y Calzado', '950456789', '3154567890', 'compras@modaycalzado.com', 'Cl 15 #30-40 Bucaramanga', '2025-08-29 00:29:39', '2025-08-29 00:29:39');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rols`
--

CREATE TABLE `rols` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `rols`
--

INSERT INTO `rols` (`id`, `name`, `created_at`, `updated_at`) VALUES
(1, 'Administrador', '2025-08-28 14:35:34', '2025-08-28 14:35:34'),
(2, 'Vendedor', '2025-08-28 14:35:34', '2025-08-28 14:35:34'),
(3, 'Bodeguero', '2025-08-28 14:35:34', '2025-08-28 14:35:34');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sessions`
--

CREATE TABLE `sessions` (
  `id` varchar(255) NOT NULL,
  `user_id` bigint(20) UNSIGNED DEFAULT NULL,
  `ip_address` varchar(45) DEFAULT NULL,
  `user_agent` text DEFAULT NULL,
  `payload` longtext NOT NULL,
  `last_activity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subcategoria`
--

CREATE TABLE `subcategoria` (
  `id_sub` bigint(20) UNSIGNED NOT NULL,
  `nom_sub` varchar(255) NOT NULL,
  `cat_sub` bigint(20) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `subcategoria`
--

INSERT INTO `subcategoria` (`id_sub`, `nom_sub`, `cat_sub`, `created_at`, `updated_at`) VALUES
(1, 'Zapatos Casual Hombre', 1, '2025-08-29 00:33:58', '2025-08-29 00:33:58'),
(2, 'Zapatos Casual Mujer', 1, '2025-08-29 00:33:58', '2025-08-29 00:33:58'),
(3, 'Zapatos Deportivos Running', 2, '2025-08-29 00:33:58', '2025-08-29 00:33:58'),
(4, 'Zapatos Deportivos Basket', 2, '2025-08-29 00:33:58', '2025-08-29 00:33:58'),
(5, 'Botas de Montaña', 3, '2025-08-29 00:33:58', '2025-08-29 00:33:58'),
(6, 'Botas Urbanas', 3, '2025-08-29 00:33:58', '2025-08-29 00:33:58'),
(7, 'Sandalias Playa', 4, '2025-08-29 00:33:58', '2025-08-29 00:33:58'),
(8, 'Sandalias Formales', 4, '2025-08-29 00:33:58', '2025-08-29 00:33:58'),
(9, 'Zapatos Vestir Hombre', 5, '2025-08-29 00:33:58', '2025-08-29 00:33:58'),
(10, 'Zapatos Vestir Mujer', 5, '2025-08-29 00:33:58', '2025-08-29 00:33:58');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_docs`
--

CREATE TABLE `tipo_docs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_docs`
--

INSERT INTO `tipo_docs` (`id`, `name`, `created_at`, `updated_at`) VALUES
(1, 'Cédula de Ciudadanía', '2025-08-28 14:33:58', '2025-08-28 14:33:58'),
(2, 'Tarjeta de Identidad', '2025-08-28 14:33:58', '2025-08-28 14:33:58'),
(3, 'Cédula de Extranjería', '2025-08-28 14:33:58', '2025-08-28 14:33:58'),
(4, 'Pasaporte', '2025-08-28 14:33:58', '2025-08-28 14:33:58'),
(5, 'NIT', '2025-08-28 14:33:58', '2025-08-28 14:33:58');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `num_doc` varchar(255) NOT NULL,
  `nombres` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `num_tel` varchar(255) NOT NULL,
  `fec_nac` date NOT NULL,
  `password` varchar(255) NOT NULL,
  `tipodoc_id` bigint(20) UNSIGNED NOT NULL,
  `rol_id` bigint(20) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `num_doc`, `nombres`, `apellidos`, `direccion`, `email`, `num_tel`, `fec_nac`, `password`, `tipodoc_id`, `rol_id`, `created_at`, `updated_at`) VALUES
(1, '102659911', 'Edgar Felipe', 'Mosquera Rozo', 'Calle 36k sur #4-50 este mz-8 cs-4', 'felipe@gmail.com', '3164656676', '1999-10-04', '$2y$12$C/.Gsh4zVHZrJwTULVQFoeIsvVEUMh8qajU/5d1y5.KnxbFPAhF9a', 1, 1, '2025-04-11 11:41:22', '2025-04-18 01:45:48'),
(2, '1026599112', 'Breiner Gustavo', 'Rojas Sarabia', 'Cll 35 #43 - 54', 'breiner@gmail.com', '3124323565', '1997-06-17', '$2y$12$C/.Gsh4zVHZrJwTULVQFoeIsvVEUMh8qajU/5d1y5.KnxbFPAhF9a', 1, 2, '2025-04-16 09:28:22', '2025-04-16 09:28:22'),
(3, '1022345678', 'Juan Esteban', 'Martinez Portela', 'Cr 99 # 34-34 sur', 'juan@gmail.com', '3002345673', '2005-02-05', '$2y$12$C/.Gsh4zVHZrJwTULVQFoeIsvVEUMh8qajU/5d1y5.KnxbFPAhF9a', 1, 3, '2025-04-16 11:26:30', '2025-04-16 11:26:49'),
(4, '112987656', 'Ivan Mate', 'Garcia', 'Crr 33 #3-54', 'mateo@gmail.com', '3118978676', '2005-01-04', '$2y$12$C/.Gsh4zVHZrJwTULVQFoeIsvVEUMh8qajU/5d1y5.KnxbFPAhF9a', 1, 2, '2025-04-19 12:11:22', '2025-04-20 10:07:46');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre_cli` varchar(100) NOT NULL,
  `direccion_cli` varchar(50) NOT NULL,
  `correo_cli` varchar(50) DEFAULT NULL,
  `num_tel_cli` varchar(20) DEFAULT NULL,
  `num_doc_cli` varchar(20) DEFAULT NULL,
  `producto_id` bigint(20) UNSIGNED NOT NULL,
  `cantidad` int(11) NOT NULL,
  `vendedor_id` bigint(20) UNSIGNED NOT NULL,
  `estado_id` bigint(20) UNSIGNED NOT NULL DEFAULT 1,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id`, `nombre_cli`, `direccion_cli`, `correo_cli`, `num_tel_cli`, `num_doc_cli`, `producto_id`, `cantidad`, `vendedor_id`, `estado_id`, `fecha`, `created_at`, `updated_at`) VALUES
(2, 'María Gómez', 'Cra 10 #20-30', 'maria@gmail.com', '3209876543', '87654321', 2, 1, 2, 2, '2025-08-28 14:58:48', '2025-08-28 14:58:48', '2025-08-28 14:58:48'),
(3, 'Luis Ramírez', 'Av 5 #10-15', 'luis@gmail.com', '3112223344', '99887766', 3, 3, 1, 1, '2025-08-28 14:58:48', '2025-08-28 14:58:48', '2025-08-28 14:58:48');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cache`
--
ALTER TABLE `cache`
  ADD PRIMARY KEY (`key`);

--
-- Indices de la tabla `cache_locks`
--
ALTER TABLE `cache_locks`
  ADD PRIMARY KEY (`key`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle_ped`
--
ALTER TABLE `detalle_ped`
  ADD PRIMARY KEY (`iddet_ped`),
  ADD KEY `detalle_ped_det_p_mer_foreign` (`det_p_mer`),
  ADD KEY `detalle_ped_det_p_ped_foreign` (`det_p_ped`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`);

--
-- Indices de la tabla `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jobs_queue_index` (`queue`);

--
-- Indices de la tabla `job_batches`
--
ALTER TABLE `job_batches`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mercancia`
--
ALTER TABLE `mercancia`
  ADD PRIMARY KEY (`id_pro`),
  ADD KEY `mercancia_sub_mer_foreign` (`sub_mer`);

--
-- Indices de la tabla `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `password_reset_tokens`
--
ALTER TABLE `password_reset_tokens`
  ADD PRIMARY KEY (`email`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`idpedido`),
  ADD KEY `pedidos_ped_prov_foreign` (`ped_prov`),
  ADD KEY `pedidos_ped_user_foreign` (`ped_user`);

--
-- Indices de la tabla `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `personal_access_tokens_token_unique` (`token`),
  ADD KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`tokenable_type`,`tokenable_id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `proveedor_nit_unique` (`nit`),
  ADD UNIQUE KEY `proveedor_email_unique` (`email`);

--
-- Indices de la tabla `rols`
--
ALTER TABLE `rols`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sessions_user_id_index` (`user_id`),
  ADD KEY `sessions_last_activity_index` (`last_activity`);

--
-- Indices de la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  ADD PRIMARY KEY (`id_sub`),
  ADD KEY `subcategoria_cat_sub_foreign` (`cat_sub`);

--
-- Indices de la tabla `tipo_docs`
--
ALTER TABLE `tipo_docs`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuarios_num_doc_unique` (`num_doc`),
  ADD UNIQUE KEY `usuarios_email_unique` (`email`),
  ADD KEY `usuarios_tipodoc_id_foreign` (`tipodoc_id`),
  ADD KEY `usuarios_rol_id_foreign` (`rol_id`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `venta_producto_id_foreign` (`producto_id`),
  ADD KEY `venta_vendedor_id_foreign` (`vendedor_id`),
  ADD KEY `venta_estado_id_foreign` (`estado_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `detalle_ped`
--
ALTER TABLE `detalle_ped`
  MODIFY `iddet_ped` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `estados`
--
ALTER TABLE `estados`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `jobs`
--
ALTER TABLE `jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mercancia`
--
ALTER TABLE `mercancia`
  MODIFY `id_pro` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `idpedido` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `rols`
--
ALTER TABLE `rols`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  MODIFY `id_sub` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tipo_docs`
--
ALTER TABLE `tipo_docs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ped`
--
ALTER TABLE `detalle_ped`
  ADD CONSTRAINT `detalle_ped_det_p_mer_foreign` FOREIGN KEY (`det_p_mer`) REFERENCES `mercancia` (`id_pro`),
  ADD CONSTRAINT `detalle_ped_det_p_ped_foreign` FOREIGN KEY (`det_p_ped`) REFERENCES `pedidos` (`idpedido`);

--
-- Filtros para la tabla `mercancia`
--
ALTER TABLE `mercancia`
  ADD CONSTRAINT `mercancia_sub_mer_foreign` FOREIGN KEY (`sub_mer`) REFERENCES `subcategoria` (`id_sub`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ped_prov_foreign` FOREIGN KEY (`ped_prov`) REFERENCES `proveedor` (`nit`),
  ADD CONSTRAINT `pedidos_ped_user_foreign` FOREIGN KEY (`ped_user`) REFERENCES `usuarios` (`num_doc`);

--
-- Filtros para la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  ADD CONSTRAINT `subcategoria_cat_sub_foreign` FOREIGN KEY (`cat_sub`) REFERENCES `categorias` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_rol_id_foreign` FOREIGN KEY (`rol_id`) REFERENCES `rols` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `usuarios_tipodoc_id_foreign` FOREIGN KEY (`tipodoc_id`) REFERENCES `tipo_docs` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_estado_id_foreign` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `venta_producto_id_foreign` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `venta_vendedor_id_foreign` FOREIGN KEY (`vendedor_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
