-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2025 a las 05:33:56
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `beji`
--

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
(1, 'Hombre', '2025-10-04 00:26:23', '2025-10-04 00:26:23'),
(2, 'Mujer', '2025-10-04 00:38:00', '2025-10-04 00:38:00'),
(3, 'Hombre', '2025-11-13 21:07:03', '2025-11-13 21:07:03'),
(4, 'matrucs', '2025-11-27 01:25:38', '2025-11-27 01:25:38');

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

--
-- Volcado de datos para la tabla `detalle_ped`
--

INSERT INTO `detalle_ped` (`iddet_ped`, `cantidad`, `precio_uni`, `precio_tt`, `det_p_ped`, `det_p_mer`, `created_at`, `updated_at`) VALUES
(1, 4, 4100000.00, 16400000.00, 1, 1, '2025-11-25 20:21:21', '2025-11-25 20:21:21'),
(2, 14, 50000.00, 700000.00, 1, 3, '2025-11-25 20:21:21', '2025-11-25 20:21:21'),
(3, 12, 70000.00, 840000.00, 1, 2, '2025-11-25 20:21:21', '2025-11-25 20:21:21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id`, `nombre`, `created_at`, `updated_at`) VALUES
(1, 'Sin novedad', '2025-09-10 21:03:59', NULL),
(2, 'Devolucion de dinero', '2025-09-10 21:04:09', NULL),
(3, 'Cambio de producto', '2025-09-10 21:04:24', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_pedido`
--

CREATE TABLE `estado_pedido` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `estado_pedido`
--

INSERT INTO `estado_pedido` (`id`, `nombre`, `created_at`, `updated_at`) VALUES
(1, 'Solicitado', '2025-09-10 21:03:04', NULL),
(2, 'Despachado', '2025-09-10 21:03:11', NULL),
(3, 'En camino', '2025-09-10 21:03:18', NULL),
(4, 'Novedad', '2025-09-10 21:03:25', NULL),
(5, 'Sin novedad', '2025-09-10 21:03:31', NULL);

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
  `imagen` varchar(244) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `mercancia`
--

INSERT INTO `mercancia` (`id_pro`, `cantidad`, `nombre`, `talla`, `precio_venta`, `precio_compra`, `material`, `color`, `sub_mer`, `imagen`) VALUES
(1, 5, 'Adadis ng', 25, 5000000, 4100000, 'Cuero', 'blanco', 1, 'storage/mercancias/fq1dc8oRbmuoPBge0AmKIvivzlpP75wskICKo5Hs.jpg'),
(2, 48, 'zpt tok', 35, 450000, 70000, 'Plastico', 'Negro', 2, 'storage/mercancias/HPIotSvGQ4xYg3taRLtJKICndDtzQgcOGFdMWJb2.jpg'),
(3, 10, 'Camisa Nike', 12, 80000, 50000, 'Algodón', 'Blanco', 1, '/storage/mercancias/AKmYltcqzoPXRZ34nvX9rK5hfbDIlbnhFRX1DD8l.png'),
(12, 10, 'Camisa Nike', 12, 80000, 50000, 'Algodón', 'Blanco', 1, '/storage/mercancias/dcq2QMNBcN1n9vurov9Gi7nywf9MXODe5FHNp7Ts.png');

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

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`idpedido`, `fec_ped`, `ped_prov`, `ped_user`, `created_at`, `updated_at`) VALUES
(1, '2025-11-25', '412232344', '123456', '2025-11-25 20:21:21', '2025-11-25 20:21:21');

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
(1, 'PUMA-001', 50, '2025-11-26 20:39:33', '2025-11-26 20:39:33');

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
(1, 'Proveedor1', '232344', '3331234117', 'proveedor1@example.com', 'Cra 22 #15-47 Bogotá', '2025-09-10 21:01:45', NULL),
(2, 'Proveedor2', '12232344', '3031234117', 'proveedor2@example.com', 'Cra 22 #15-47 Bogotá', '2025-09-10 21:01:57', NULL),
(3, 'Proveedor3', '412232344', '3131234117', 'proveedor3@example.com', 'Cra 22 #15-47 Bogotá', '2025-09-10 21:02:10', NULL),
(4, 'Proveedor4', '112232344', '3131234117', 'proveedor4@example.com', 'Cra 22 #15-47 Bogotá', '2025-09-10 21:02:21', NULL),
(5, 'Proveedor5', '62232344', '3231234117', 'proveedor5@example.com', 'Cra 22 #15-47 Bogotá', '2025-09-10 21:02:35', NULL),
(17, 'Calzado Ejemplo SAS', '9701234567', '3104567890', 'contacto65@calzadosdeportivos.com', 'Av. 9 #65', '2025-11-26 18:17:00', '2025-11-26 18:46:39'),
(18, 'Calzado Ejemplo 1410', '11221410', '3104567890', 'contacto896@calzadosdeportivos.com', 'Av. 9 #896', '2025-11-26 18:41:09', '2025-11-26 18:45:37'),
(19, 'Calzado Ejemplo 1581', '11221581', '3104567890', 'calzado581@calzadoejemplo.com', 'Calle 1581', '2025-11-26 18:41:39', '2025-11-26 18:41:39'),
(20, 'Calzado Ejemplo 1707', '11221707', '3104567890', 'calzado707@calzadoejemplo.com', 'Calle 1707', '2025-11-26 18:42:07', '2025-11-26 18:42:07'),
(21, 'Calzado Ejemplo 1746', '11221746', '3104567890', 'calzado746@calzadoejemplo.com', 'Calle 1746', '2025-11-26 18:42:38', '2025-11-26 18:42:38'),
(22, 'Calzado Ejemplo 1762', '11221762', '3104567890', 'calzado762@calzadoejemplo.com', 'Calle 1762', '2025-11-26 18:43:11', '2025-11-26 18:43:11'),
(23, 'matrucs', '1031804159', '3123351988', 'bastar2909@gmail.com', 'cll 131b n92 a21', '2025-11-27 01:14:08', '2025-11-27 01:14:08');

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
(1, 'Administrador', '2025-09-11 02:34:29', '2025-09-11 02:34:29'),
(2, 'Vendedor', '2025-09-11 02:34:38', '2025-09-11 02:34:38'),
(3, 'Bodeguero', '2025-09-11 02:34:43', '2025-09-11 02:34:43');

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
(1, 'Deportivo', 1, '2025-10-04 00:26:38', '2025-10-04 00:26:38'),
(2, 'Botin', 2, '2025-10-04 00:38:18', '2025-10-04 00:38:18'),
(3, 'Deportivo', 1, '2025-11-13 21:07:17', '2025-11-13 21:07:17');

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
(1, 'Cedula ciudadania', '2025-09-11 02:35:05', '2025-09-11 02:35:05'),
(2, 'Tarjeta de identidad', '2025-09-11 02:35:17', '2025-09-11 02:35:17'),
(3, 'Pasaporte', '2025-09-11 02:35:23', '2025-09-11 02:35:23');

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
(1, '123456', 'Edgar Felipe', 'Mosquera', 'Calle 36', 'felipe@gmail.com', '123456', '1999-10-04', '$2y$12$6I91HICHPX4vEX/1abRA0.WniCiZYBTsqepnAPuRNU96LVRr3CTSG', 1, 1, '2025-09-11 02:35:45', '2025-11-04 18:12:30'),
(2, '1234567', 'Breiner Gustavo', 'Rojas', 'Calle 36', 'breiner@gmail.com', '1234567890', '1999-10-04', '$2y$12$Jzedbx6MFjL77Ndb/xocMeX1ydqge7BeeloXGJq53zR4NaHGrwuUG', 1, 2, '2025-09-11 02:52:11', '2025-11-25 20:18:18'),
(3, '12345679', 'Juan Esteban', 'Martinez Portela', 'Calle 36 k 34.50', 'juan@gmail.com', '1234567890', '1999-10-04', '$2y$12$aekPxQU6QjOaamZp20N7FebyWs8SGewpHV6HWjdwwUGmh6VpbMIpy', 1, 3, '2025-09-22 20:25:14', '2025-11-25 20:40:57'),
(6, '1121987654', 'Ivan Mateo', 'Garcia Giraldo', 'Cra 43', 'mateo@example.com', '3208340267', '2005-12-22', '$2a$10$VuQlH7r.r3J.qtlbOu4PVOvBgEGWgduGRJatCUsj2COQdWy1ne0Pu', 1, 2, '2025-09-22 20:26:36', '2025-09-22 20:26:36'),
(76, '11122233353', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com53', '3334445553', '2025-10-10', '$2y$12$KIeAOTrmirr9pD8Ys.Vp4eHgiG14XlyeS/YKif1wcyGk1K.Zi4Ht6', 1, 1, '2025-11-05 19:45:22', '2025-11-05 19:45:22'),
(96, '11122233398', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com98', '3334445553', '2025-10-10', '$2y$12$I6p7kbwSFs7XGZ7HSiZM4O0N4jwMsQwvCen1inZcgKahZjQO/H8Yq', 1, 1, '2025-11-06 20:39:56', '2025-11-06 20:39:56'),
(97, '11122233364', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com64', '3334445553', '2025-10-10', '$2y$12$T3UI/7/jyHw6SAyOqKfiJu/wwD2uGpRphydxA8kGlzHHjlI/punAK', 1, 1, '2025-11-06 20:41:45', '2025-11-06 20:41:45'),
(102, '11122233385', 'Probando', 'Lopez651', 'Calle 63 #32-23', 'pepito@gmail.com85', '3109875434', '2025-10-10', '$2y$12$7KCDVjYDHlexW/BG1A.2tuZza5PWxXQhbgZGR8v09EOnlXOfdBhTG', 1, 1, '2025-11-07 19:46:42', '2025-11-07 23:48:25'),
(119, '111222333391', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com391', '3334445553', '2025-10-10', '$2y$12$iKMuXAIgValI6AFVhFAZfeQo45YdwUUQL3XQfswdBkwle/AObwRSa', 1, 1, '2025-11-10 19:00:41', '2025-11-10 19:00:41'),
(120, '111222333205', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com205', '3334445553', '2025-10-10', '$2y$12$F3l7Oc/Saif9cZExR.OHCu2MhfkDNlHfL3p53fxkvVHQc1/LwA/vS', 1, 1, '2025-11-10 19:06:14', '2025-11-10 19:06:14'),
(121, '111222333678', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com678', '3334445553', '2025-10-10', '$2y$12$DG7JW1wk2SInEgurXo2mHeTmBUL6bEAV6zSS//BzQbpjlaSMr3/uC', 1, 1, '2025-11-10 19:43:52', '2025-11-10 19:43:52'),
(122, '111222333867', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com867', '3334445553', '2025-10-10', '$2y$12$9Ppw1LSExBnXuhVWbxqfgek2BXTAVv.4ZzY49VG.XFXESOjbJpe3O', 1, 1, '2025-11-10 20:43:24', '2025-11-10 20:43:24'),
(123, '111222333247', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com247', '3334445553', '2025-10-10', '$2y$12$Trs0io.GzIDuZ1Ub2t/A3u58zxS5KjwtgvG7/AjM3GntfDt0Xhc/y', 1, 1, '2025-11-10 20:43:57', '2025-11-10 20:43:57'),
(124, '111222333951', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com951', '3334445553', '2025-10-10', '$2y$12$k5MLo.Mm9nRON8SdSXUcNOYq4aJzWKULJDQKc17rFQkVmTMOxXgE.', 1, 1, '2025-11-10 20:44:43', '2025-11-10 20:44:43'),
(125, '11122233399', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com99', '3334445553', '2025-10-10', '$2y$12$YEJPK6e6zkSn5rdzBF21AuvvNzEra2DcxZOxiebqAAmknhLTmpPVa', 1, 1, '2025-11-10 21:03:43', '2025-11-10 21:03:43'),
(126, '111222333756', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com756', '3334445553', '2025-10-10', '$2y$12$8CaqUh8wLc4yV9FVM3O8QuleQpRo41VWVtW.Nhu9nvrwCsnmUIsjm', 1, 1, '2025-11-11 00:02:40', '2025-11-11 00:02:40'),
(127, '111222333653', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com653', '3334445553', '2025-10-10', '$2y$12$Db/34Fkv6fQVmKg9XL4cO.tac86d8kFJOSdqn0FhhQ2RrDLSeqEZS', 1, 1, '2025-11-11 18:10:42', '2025-11-11 18:10:42'),
(128, '11122233386', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com86', '3334445553', '2025-10-10', '$2y$12$E/JMtITJX/NGjE9b8gsUa.xpeVCRAuDRXtW3HAAMkJzf9eLLxdDO6', 1, 1, '2025-11-11 18:48:19', '2025-11-11 18:48:19'),
(129, '111222333893', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com893', '3334445553', '2025-10-10', '$2y$12$4HuypjBto8J2Yo8HlME4G.bR6SIZPRZxATGMMZ9rThwCnGOK3drXq', 1, 1, '2025-11-11 19:36:59', '2025-11-11 19:36:59'),
(130, '111222333113', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com113', '3334445553', '2025-10-10', '$2y$12$/NNDzFY8sBrgNlgxOw6BSODfGaO5UtNVFCyKCWwxM2JayUhfXJcLW', 1, 1, '2025-11-11 19:37:47', '2025-11-11 19:37:47'),
(131, '111222333583', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com583', '3334445553', '2025-10-10', '$2y$12$sADrnNrDpxdgH5Um.9vCZeTR.cvetIuITbt2JCL7jv9YAEyBSnu4.', 1, 1, '2025-11-11 20:56:02', '2025-11-11 20:56:02'),
(132, '111222333953', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com953', '3334445553', '2025-10-10', '$2y$12$uPAzBozFAeaiN5d41wJpXO0PbaRPCH7dVHSq/pnFez5Z9upetDKh2', 1, 1, '2025-11-12 18:51:43', '2025-11-12 18:51:43'),
(133, '111222333605', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com605', '3334445553', '2025-10-10', '$2y$12$l6UeOapQweNX73zDCaiMu.GqVqpIJv0sw1nsCT6PonXuIwjPnH1BO', 1, 1, '2025-11-12 18:54:36', '2025-11-12 18:54:36'),
(134, '11122233391', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com91', '3334445553', '2025-10-10', '$2y$12$bwXXL/NqZVbEjrDjqfpqNOnanIm4GUcPL7bV3TOH3VbnIPS0xsZNW', 1, 1, '2025-11-13 21:01:27', '2025-11-13 21:01:27'),
(135, '111222333766', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com766', '3334445553', '2025-10-10', '$2y$12$nho3MPwz6bdYPcm5lSE5T.bpvyhQA6XmC/TJxeE0lNg0jfMQVYeNa', 1, 1, '2025-11-13 21:22:10', '2025-11-13 21:22:10'),
(136, '111222333370', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com370', '3334445553', '2025-10-10', '$2y$12$gCTA4/g5L8OLOo5zDXRHgeyX3RhfZ/X8t7.vtGS8CZdIyiio.kWuq', 1, 1, '2025-11-13 21:22:57', '2025-11-13 21:22:57'),
(137, '111222333910', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com910', '3334445553', '2025-10-10', '$2y$12$s4JInkAdyADWaemjbR1Pteueah.SiJ/7r8DTpRPC/EYzXpHXPiuY.', 1, 1, '2025-11-26 02:26:00', '2025-11-26 02:26:00'),
(138, '111222333758', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com758', '3334445553', '2025-10-10', '$2y$12$8KBGL0DDJ2DSkgYfwAhse.yKUjlVXy0zMG4JFtsPUT.Z1IGQrhQEe', 1, 1, '2025-11-26 02:26:40', '2025-11-26 02:26:40'),
(139, '111222333148', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com148', '3334445553', '2025-10-10', '$2y$12$cnrFK2x9iqfSQ.HU8Atae.v/1jXLc1n8wGcp2GrIFnfsli0IC7q0q', 1, 1, '2025-11-26 18:02:23', '2025-11-26 18:02:23'),
(140, '111222333381', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com381', '3334445553', '2025-10-10', '$2y$12$JSYyioQcw72Qe84ivclzneV5mO9xyiYZNOtx22p4nAbV2MdSNThgG', 1, 1, '2025-11-26 18:04:03', '2025-11-26 18:04:03'),
(141, '111222333683', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com683', '3334445553', '2025-10-10', '$2y$12$isXxFCa4QyIjdjDWJUgm9O62M.tlNFTKwv66WEDvNBNozTb5iz.7C', 1, 1, '2025-11-26 18:04:43', '2025-11-26 18:04:43'),
(142, '111222333136', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com136', '3334445553', '2025-10-10', '$2y$12$tNqxdo6MDvmvNjX4lFpZieUW53LBYVOh5.Ewbl3dw/6v8GGmhXi/u', 1, 1, '2025-11-26 18:05:28', '2025-11-26 18:05:28'),
(143, '111222333385', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com385', '3334445553', '2025-10-10', '$2y$12$GEV7MpWg2Olte6Sn4TuZvuO.EqtrS45gmOGzipDq8eaBrziE.ISjO', 1, 1, '2025-11-26 18:08:19', '2025-11-26 18:08:19'),
(144, '111222333495', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com495', '3334445553', '2025-10-10', '$2y$12$WOKV/zlgMLoObFF2khFrDOAmoquqpz23LoByQFjvwhG26X.XCkkYq', 1, 1, '2025-11-26 18:09:25', '2025-11-26 18:09:25'),
(145, '111222333640', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com640', '3334445553', '2025-10-10', '$2y$12$oY90E6TivliXnC1L7LzDQuO5CCuOZMAlJ0GwEJCoivvcy4ysSggBu', 1, 1, '2025-11-26 18:10:31', '2025-11-26 18:10:31'),
(146, '111222333118', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com118', '3334445553', '2025-10-10', '$2y$12$N/QQ6RHGefPZu5t9YaxfkeIgEKxuBqwlA1udsyyUV/I/2WvhefAx.', 1, 1, '2025-11-26 18:11:48', '2025-11-26 18:11:48'),
(147, '11122233341', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com41', '3334445553', '2025-10-10', '$2y$12$hACALwrronc3xEFVG2HYT.oZToir60Kv88JLf40XnN.zxMZysaOeK', 1, 1, '2025-11-26 18:12:54', '2025-11-26 18:12:54'),
(148, '111222333239', 'Pepito', 'Perez', 'Cl 34 #32-2', 'pepito@gmail.com239', '3334445553', '2025-10-10', '$2y$12$S6oQXluG/VvKZbV9c6HraeCb/9MZ3m6fnUTfI8ye6EANvu/CIH2be', 1, 1, '2025-11-26 18:38:43', '2025-11-26 18:38:43');

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
(14, 'Mateo Garcia', 'Calle 100', 'mateo@test.com', '3015551111', '123456789', 1, 2, 2, 1, '2025-12-01 03:52:58', '2025-12-01 08:52:58', '2025-12-01 08:52:58'),
(15, 'Carlos Lopez', 'Calle 45 # 12-30', 'carlos@test.com', '3014455667', '987654321', 1, 3, 2, 1, '2025-12-01 04:02:58', '2025-12-01 08:02:58', '2025-12-01 08:02:58'),
(16, 'Laura Pérez', 'Carrera 9 # 20-15', 'laura@test.com', '3027788991', '1122334455', 1, 1, 2, 2, '2025-11-29 23:44:21', '2025-12-01 08:03:10', '2025-12-01 08:03:10'),
(17, 'Andrés Torres', 'Av. Central 101', 'andres@test.com', '3009988776', '5566778899', 1, 5, 2, 1, '2025-11-28 19:20:10', '2025-12-01 08:04:12', '2025-12-01 08:04:12'),
(18, 'Paula Gómez', 'Calle 80 # 50-22', 'paula@test.com', '3056677889', '1212121212', 1, 2, 2, 1, '2025-11-27 21:52:45', '2025-12-01 08:05:01', '2025-12-01 08:05:01'),
(19, 'Felipe Rojas', 'Transv. 30 # 10-12', 'felipe@test.com', '3042233445', '9988776655', 1, 4, 2, 2, '2025-11-26 16:33:29', '2025-12-01 08:06:15', '2025-12-01 08:06:15');

--
-- Índices para tablas volcadas
--

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
-- Indices de la tabla `estado_pedido`
--
ALTER TABLE `estado_pedido`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mercancia`
--
ALTER TABLE `mercancia`
  ADD PRIMARY KEY (`id_pro`),
  ADD KEY `mercancia_sub_mer_foreign` (`sub_mer`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`idpedido`),
  ADD KEY `pedidos_ped_prov_foreign` (`ped_prov`),
  ADD KEY `pedidos_ped_user_foreign` (`ped_user`);

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
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `detalle_ped`
--
ALTER TABLE `detalle_ped`
  MODIFY `iddet_ped` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `estado_pedido`
--
ALTER TABLE `estado_pedido`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `mercancia`
--
ALTER TABLE `mercancia`
  MODIFY `id_pro` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `idpedido` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `rols`
--
ALTER TABLE `rols`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  MODIFY `id_sub` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_docs`
--
ALTER TABLE `tipo_docs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=149;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

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
