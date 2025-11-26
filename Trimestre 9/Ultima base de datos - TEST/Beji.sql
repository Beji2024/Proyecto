-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: beji
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Hombre','2025-10-04 00:26:23','2025-10-04 00:26:23'),(2,'Mujer','2025-10-04 00:38:00','2025-10-04 00:38:00'),(3,'Hombre','2025-11-13 21:07:03','2025-11-13 21:07:03');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ped`
--

DROP TABLE IF EXISTS `detalle_ped`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_ped` (
  `iddet_ped` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` tinyint(4) NOT NULL,
  `precio_uni` decimal(10,2) NOT NULL,
  `precio_tt` decimal(10,2) NOT NULL,
  `det_p_ped` bigint(20) unsigned NOT NULL,
  `det_p_mer` bigint(20) unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`iddet_ped`),
  KEY `detalle_ped_det_p_mer_foreign` (`det_p_mer`),
  KEY `detalle_ped_det_p_ped_foreign` (`det_p_ped`),
  CONSTRAINT `detalle_ped_det_p_mer_foreign` FOREIGN KEY (`det_p_mer`) REFERENCES `mercancia` (`id_pro`),
  CONSTRAINT `detalle_ped_det_p_ped_foreign` FOREIGN KEY (`det_p_ped`) REFERENCES `pedidos` (`idpedido`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ped`
--

LOCK TABLES `detalle_ped` WRITE;
/*!40000 ALTER TABLE `detalle_ped` DISABLE KEYS */;
INSERT INTO `detalle_ped` VALUES (1,4,4100000.00,16400000.00,1,1,'2025-11-25 20:21:21','2025-11-25 20:21:21'),(2,14,50000.00,700000.00,1,3,'2025-11-25 20:21:21','2025-11-25 20:21:21'),(3,12,70000.00,840000.00,1,2,'2025-11-25 20:21:21','2025-11-25 20:21:21');
/*!40000 ALTER TABLE `detalle_ped` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_pedido`
--

DROP TABLE IF EXISTS `estado_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado_pedido` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_pedido`
--

LOCK TABLES `estado_pedido` WRITE;
/*!40000 ALTER TABLE `estado_pedido` DISABLE KEYS */;
INSERT INTO `estado_pedido` VALUES (1,'Solicitado','2025-09-10 21:03:04',NULL),(2,'Despachado','2025-09-10 21:03:11',NULL),(3,'En camino','2025-09-10 21:03:18',NULL),(4,'Novedad','2025-09-10 21:03:25',NULL),(5,'Sin novedad','2025-09-10 21:03:31',NULL);
/*!40000 ALTER TABLE `estado_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_venta`
--

DROP TABLE IF EXISTS `estado_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado_venta` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_venta`
--

LOCK TABLES `estado_venta` WRITE;
/*!40000 ALTER TABLE `estado_venta` DISABLE KEYS */;
INSERT INTO `estado_venta` VALUES (1,'Sin novedad','2025-09-10 21:03:59',NULL),(2,'Devolucion de dinero','2025-09-10 21:04:09',NULL),(3,'Cambio de producto','2025-09-10 21:04:24',NULL);
/*!40000 ALTER TABLE `estado_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mercancia`
--

DROP TABLE IF EXISTS `mercancia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mercancia` (
  `id_pro` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` tinyint(4) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `talla` tinyint(4) NOT NULL,
  `precio_venta` double NOT NULL,
  `precio_compra` double NOT NULL,
  `material` varchar(30) NOT NULL,
  `color` varchar(20) NOT NULL,
  `sub_mer` bigint(20) unsigned NOT NULL,
  `imagen` varchar(244) DEFAULT NULL,
  PRIMARY KEY (`id_pro`),
  KEY `mercancia_sub_mer_foreign` (`sub_mer`),
  CONSTRAINT `mercancia_sub_mer_foreign` FOREIGN KEY (`sub_mer`) REFERENCES `subcategoria` (`id_sub`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mercancia`
--

LOCK TABLES `mercancia` WRITE;
/*!40000 ALTER TABLE `mercancia` DISABLE KEYS */;
INSERT INTO `mercancia` VALUES (1,5,'Adadis ng',25,5000000,4100000,'Cuero','blanco',1,'storage/mercancias/fq1dc8oRbmuoPBge0AmKIvivzlpP75wskICKo5Hs.jpg'),(2,48,'zpt tok',35,450000,70000,'Plastico','Negro',2,'storage/mercancias/HPIotSvGQ4xYg3taRLtJKICndDtzQgcOGFdMWJb2.jpg'),(3,10,'Camisa Nike',12,80000,50000,'Algodón','Blanco',1,'/storage/mercancias/AKmYltcqzoPXRZ34nvX9rK5hfbDIlbnhFRX1DD8l.png');
/*!40000 ALTER TABLE `mercancia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `idpedido` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fec_ped` date NOT NULL,
  `ped_prov` varchar(255) NOT NULL,
  `ped_user` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `pedidos_ped_prov_foreign` (`ped_prov`),
  KEY `pedidos_ped_user_foreign` (`ped_user`),
  CONSTRAINT `pedidos_ped_prov_foreign` FOREIGN KEY (`ped_prov`) REFERENCES `proveedor` (`nit`),
  CONSTRAINT `pedidos_ped_user_foreign` FOREIGN KEY (`ped_user`) REFERENCES `usuarios` (`num_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'2025-11-25','412232344','123456','2025-11-25 20:21:21','2025-11-25 20:21:21');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `referencia` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `nit` varchar(255) NOT NULL,
  `celular` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `proveedor_nit_unique` (`nit`),
  UNIQUE KEY `proveedor_email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Proveedor1','232344','3331234117','proveedor1@example.com','Cra 22 #15-47 Bogotá','2025-09-10 21:01:45',NULL),(2,'Proveedor2','12232344','3031234117','proveedor2@example.com','Cra 22 #15-47 Bogotá','2025-09-10 21:01:57',NULL),(3,'Proveedor3','412232344','3131234117','proveedor3@example.com','Cra 22 #15-47 Bogotá','2025-09-10 21:02:10',NULL),(4,'Proveedor4','112232344','3131234117','proveedor4@example.com','Cra 22 #15-47 Bogotá','2025-09-10 21:02:21',NULL),(5,'Proveedor5','62232344','3231234117','proveedor5@example.com','Cra 22 #15-47 Bogotá','2025-09-10 21:02:35',NULL),(17,'Calzado Ejemplo SAS','9701234567','3104567890','contacto65@calzadosdeportivos.com','Av. 9 #65','2025-11-26 18:17:00','2025-11-26 18:46:39'),(18,'Calzado Ejemplo 1410','11221410','3104567890','contacto896@calzadosdeportivos.com','Av. 9 #896','2025-11-26 18:41:09','2025-11-26 18:45:37'),(19,'Calzado Ejemplo 1581','11221581','3104567890','calzado581@calzadoejemplo.com','Calle 1581','2025-11-26 18:41:39','2025-11-26 18:41:39'),(20,'Calzado Ejemplo 1707','11221707','3104567890','calzado707@calzadoejemplo.com','Calle 1707','2025-11-26 18:42:07','2025-11-26 18:42:07'),(21,'Calzado Ejemplo 1746','11221746','3104567890','calzado746@calzadoejemplo.com','Calle 1746','2025-11-26 18:42:38','2025-11-26 18:42:38'),(22,'Calzado Ejemplo 1762','11221762','3104567890','calzado762@calzadoejemplo.com','Calle 1762','2025-11-26 18:43:11','2025-11-26 18:43:11');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rols`
--

DROP TABLE IF EXISTS `rols`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rols` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rols`
--

LOCK TABLES `rols` WRITE;
/*!40000 ALTER TABLE `rols` DISABLE KEYS */;
INSERT INTO `rols` VALUES (1,'Administrador','2025-09-11 02:34:29','2025-09-11 02:34:29'),(2,'Vendedor','2025-09-11 02:34:38','2025-09-11 02:34:38'),(3,'Bodeguero','2025-09-11 02:34:43','2025-09-11 02:34:43');
/*!40000 ALTER TABLE `rols` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcategoria`
--

DROP TABLE IF EXISTS `subcategoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subcategoria` (
  `id_sub` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nom_sub` varchar(255) NOT NULL,
  `cat_sub` bigint(20) unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_sub`),
  KEY `subcategoria_cat_sub_foreign` (`cat_sub`),
  CONSTRAINT `subcategoria_cat_sub_foreign` FOREIGN KEY (`cat_sub`) REFERENCES `categorias` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategoria`
--

LOCK TABLES `subcategoria` WRITE;
/*!40000 ALTER TABLE `subcategoria` DISABLE KEYS */;
INSERT INTO `subcategoria` VALUES (1,'Deportivo',1,'2025-10-04 00:26:38','2025-10-04 00:26:38'),(2,'Botin',2,'2025-10-04 00:38:18','2025-10-04 00:38:18'),(3,'Deportivo',1,'2025-11-13 21:07:17','2025-11-13 21:07:17');
/*!40000 ALTER TABLE `subcategoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_docs`
--

DROP TABLE IF EXISTS `tipo_docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_docs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_docs`
--

LOCK TABLES `tipo_docs` WRITE;
/*!40000 ALTER TABLE `tipo_docs` DISABLE KEYS */;
INSERT INTO `tipo_docs` VALUES (1,'Cedula ciudadania','2025-09-11 02:35:05','2025-09-11 02:35:05'),(2,'Tarjeta de identidad','2025-09-11 02:35:17','2025-09-11 02:35:17'),(3,'Pasaporte','2025-09-11 02:35:23','2025-09-11 02:35:23');
/*!40000 ALTER TABLE `tipo_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `num_doc` varchar(255) NOT NULL,
  `nombres` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `num_tel` varchar(255) NOT NULL,
  `fec_nac` date NOT NULL,
  `password` varchar(255) NOT NULL,
  `tipodoc_id` bigint(20) unsigned NOT NULL,
  `rol_id` bigint(20) unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuarios_num_doc_unique` (`num_doc`),
  UNIQUE KEY `usuarios_email_unique` (`email`),
  KEY `usuarios_tipodoc_id_foreign` (`tipodoc_id`),
  KEY `usuarios_rol_id_foreign` (`rol_id`),
  CONSTRAINT `usuarios_rol_id_foreign` FOREIGN KEY (`rol_id`) REFERENCES `rols` (`id`) ON DELETE CASCADE,
  CONSTRAINT `usuarios_tipodoc_id_foreign` FOREIGN KEY (`tipodoc_id`) REFERENCES `tipo_docs` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'123456','Edgar Felipe','Mosquera','Calle 36','felipe@gmail.com','123456','1999-10-04','$2y$12$6I91HICHPX4vEX/1abRA0.WniCiZYBTsqepnAPuRNU96LVRr3CTSG',1,1,'2025-09-11 02:35:45','2025-11-04 18:12:30'),(2,'1234567','Breiner Gustavo','Rojas','Calle 36','breiner@gmail.com','1234567890','1999-10-04','$2y$12$Jzedbx6MFjL77Ndb/xocMeX1ydqge7BeeloXGJq53zR4NaHGrwuUG',1,2,'2025-09-11 02:52:11','2025-11-25 20:18:18'),(3,'12345679','Juan Esteban','Martinez Portela','Calle 36 k 34.50','juan@gmail.com','1234567890','1999-10-04','$2y$12$aekPxQU6QjOaamZp20N7FebyWs8SGewpHV6HWjdwwUGmh6VpbMIpy',1,3,'2025-09-22 20:25:14','2025-11-25 20:40:57'),(6,'1121987654','Ivan Mateo','Garcia Giraldo','Cra 43','mateo@example.com','3208340267','2005-12-22','$2a$10$VuQlH7r.r3J.qtlbOu4PVOvBgEGWgduGRJatCUsj2COQdWy1ne0Pu',1,2,'2025-09-22 20:26:36','2025-09-22 20:26:36'),(76,'11122233353','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com53','3334445553','2025-10-10','$2y$12$KIeAOTrmirr9pD8Ys.Vp4eHgiG14XlyeS/YKif1wcyGk1K.Zi4Ht6',1,1,'2025-11-05 19:45:22','2025-11-05 19:45:22'),(96,'11122233398','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com98','3334445553','2025-10-10','$2y$12$I6p7kbwSFs7XGZ7HSiZM4O0N4jwMsQwvCen1inZcgKahZjQO/H8Yq',1,1,'2025-11-06 20:39:56','2025-11-06 20:39:56'),(97,'11122233364','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com64','3334445553','2025-10-10','$2y$12$T3UI/7/jyHw6SAyOqKfiJu/wwD2uGpRphydxA8kGlzHHjlI/punAK',1,1,'2025-11-06 20:41:45','2025-11-06 20:41:45'),(102,'11122233385','Probando','Lopez651','Calle 63 #32-23','pepito@gmail.com85','3109875434','2025-10-10','$2y$12$7KCDVjYDHlexW/BG1A.2tuZza5PWxXQhbgZGR8v09EOnlXOfdBhTG',1,1,'2025-11-07 19:46:42','2025-11-07 23:48:25'),(119,'111222333391','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com391','3334445553','2025-10-10','$2y$12$iKMuXAIgValI6AFVhFAZfeQo45YdwUUQL3XQfswdBkwle/AObwRSa',1,1,'2025-11-10 19:00:41','2025-11-10 19:00:41'),(120,'111222333205','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com205','3334445553','2025-10-10','$2y$12$F3l7Oc/Saif9cZExR.OHCu2MhfkDNlHfL3p53fxkvVHQc1/LwA/vS',1,1,'2025-11-10 19:06:14','2025-11-10 19:06:14'),(121,'111222333678','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com678','3334445553','2025-10-10','$2y$12$DG7JW1wk2SInEgurXo2mHeTmBUL6bEAV6zSS//BzQbpjlaSMr3/uC',1,1,'2025-11-10 19:43:52','2025-11-10 19:43:52'),(122,'111222333867','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com867','3334445553','2025-10-10','$2y$12$9Ppw1LSExBnXuhVWbxqfgek2BXTAVv.4ZzY49VG.XFXESOjbJpe3O',1,1,'2025-11-10 20:43:24','2025-11-10 20:43:24'),(123,'111222333247','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com247','3334445553','2025-10-10','$2y$12$Trs0io.GzIDuZ1Ub2t/A3u58zxS5KjwtgvG7/AjM3GntfDt0Xhc/y',1,1,'2025-11-10 20:43:57','2025-11-10 20:43:57'),(124,'111222333951','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com951','3334445553','2025-10-10','$2y$12$k5MLo.Mm9nRON8SdSXUcNOYq4aJzWKULJDQKc17rFQkVmTMOxXgE.',1,1,'2025-11-10 20:44:43','2025-11-10 20:44:43'),(125,'11122233399','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com99','3334445553','2025-10-10','$2y$12$YEJPK6e6zkSn5rdzBF21AuvvNzEra2DcxZOxiebqAAmknhLTmpPVa',1,1,'2025-11-10 21:03:43','2025-11-10 21:03:43'),(126,'111222333756','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com756','3334445553','2025-10-10','$2y$12$8CaqUh8wLc4yV9FVM3O8QuleQpRo41VWVtW.Nhu9nvrwCsnmUIsjm',1,1,'2025-11-11 00:02:40','2025-11-11 00:02:40'),(127,'111222333653','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com653','3334445553','2025-10-10','$2y$12$Db/34Fkv6fQVmKg9XL4cO.tac86d8kFJOSdqn0FhhQ2RrDLSeqEZS',1,1,'2025-11-11 18:10:42','2025-11-11 18:10:42'),(128,'11122233386','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com86','3334445553','2025-10-10','$2y$12$E/JMtITJX/NGjE9b8gsUa.xpeVCRAuDRXtW3HAAMkJzf9eLLxdDO6',1,1,'2025-11-11 18:48:19','2025-11-11 18:48:19'),(129,'111222333893','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com893','3334445553','2025-10-10','$2y$12$4HuypjBto8J2Yo8HlME4G.bR6SIZPRZxATGMMZ9rThwCnGOK3drXq',1,1,'2025-11-11 19:36:59','2025-11-11 19:36:59'),(130,'111222333113','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com113','3334445553','2025-10-10','$2y$12$/NNDzFY8sBrgNlgxOw6BSODfGaO5UtNVFCyKCWwxM2JayUhfXJcLW',1,1,'2025-11-11 19:37:47','2025-11-11 19:37:47'),(131,'111222333583','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com583','3334445553','2025-10-10','$2y$12$sADrnNrDpxdgH5Um.9vCZeTR.cvetIuITbt2JCL7jv9YAEyBSnu4.',1,1,'2025-11-11 20:56:02','2025-11-11 20:56:02'),(132,'111222333953','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com953','3334445553','2025-10-10','$2y$12$uPAzBozFAeaiN5d41wJpXO0PbaRPCH7dVHSq/pnFez5Z9upetDKh2',1,1,'2025-11-12 18:51:43','2025-11-12 18:51:43'),(133,'111222333605','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com605','3334445553','2025-10-10','$2y$12$l6UeOapQweNX73zDCaiMu.GqVqpIJv0sw1nsCT6PonXuIwjPnH1BO',1,1,'2025-11-12 18:54:36','2025-11-12 18:54:36'),(134,'11122233391','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com91','3334445553','2025-10-10','$2y$12$bwXXL/NqZVbEjrDjqfpqNOnanIm4GUcPL7bV3TOH3VbnIPS0xsZNW',1,1,'2025-11-13 21:01:27','2025-11-13 21:01:27'),(135,'111222333766','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com766','3334445553','2025-10-10','$2y$12$nho3MPwz6bdYPcm5lSE5T.bpvyhQA6XmC/TJxeE0lNg0jfMQVYeNa',1,1,'2025-11-13 21:22:10','2025-11-13 21:22:10'),(136,'111222333370','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com370','3334445553','2025-10-10','$2y$12$gCTA4/g5L8OLOo5zDXRHgeyX3RhfZ/X8t7.vtGS8CZdIyiio.kWuq',1,1,'2025-11-13 21:22:57','2025-11-13 21:22:57'),(137,'111222333910','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com910','3334445553','2025-10-10','$2y$12$s4JInkAdyADWaemjbR1Pteueah.SiJ/7r8DTpRPC/EYzXpHXPiuY.',1,1,'2025-11-26 02:26:00','2025-11-26 02:26:00'),(138,'111222333758','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com758','3334445553','2025-10-10','$2y$12$8KBGL0DDJ2DSkgYfwAhse.yKUjlVXy0zMG4JFtsPUT.Z1IGQrhQEe',1,1,'2025-11-26 02:26:40','2025-11-26 02:26:40'),(139,'111222333148','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com148','3334445553','2025-10-10','$2y$12$cnrFK2x9iqfSQ.HU8Atae.v/1jXLc1n8wGcp2GrIFnfsli0IC7q0q',1,1,'2025-11-26 18:02:23','2025-11-26 18:02:23'),(140,'111222333381','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com381','3334445553','2025-10-10','$2y$12$JSYyioQcw72Qe84ivclzneV5mO9xyiYZNOtx22p4nAbV2MdSNThgG',1,1,'2025-11-26 18:04:03','2025-11-26 18:04:03'),(141,'111222333683','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com683','3334445553','2025-10-10','$2y$12$isXxFCa4QyIjdjDWJUgm9O62M.tlNFTKwv66WEDvNBNozTb5iz.7C',1,1,'2025-11-26 18:04:43','2025-11-26 18:04:43'),(142,'111222333136','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com136','3334445553','2025-10-10','$2y$12$tNqxdo6MDvmvNjX4lFpZieUW53LBYVOh5.Ewbl3dw/6v8GGmhXi/u',1,1,'2025-11-26 18:05:28','2025-11-26 18:05:28'),(143,'111222333385','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com385','3334445553','2025-10-10','$2y$12$GEV7MpWg2Olte6Sn4TuZvuO.EqtrS45gmOGzipDq8eaBrziE.ISjO',1,1,'2025-11-26 18:08:19','2025-11-26 18:08:19'),(144,'111222333495','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com495','3334445553','2025-10-10','$2y$12$WOKV/zlgMLoObFF2khFrDOAmoquqpz23LoByQFjvwhG26X.XCkkYq',1,1,'2025-11-26 18:09:25','2025-11-26 18:09:25'),(145,'111222333640','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com640','3334445553','2025-10-10','$2y$12$oY90E6TivliXnC1L7LzDQuO5CCuOZMAlJ0GwEJCoivvcy4ysSggBu',1,1,'2025-11-26 18:10:31','2025-11-26 18:10:31'),(146,'111222333118','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com118','3334445553','2025-10-10','$2y$12$N/QQ6RHGefPZu5t9YaxfkeIgEKxuBqwlA1udsyyUV/I/2WvhefAx.',1,1,'2025-11-26 18:11:48','2025-11-26 18:11:48'),(147,'11122233341','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com41','3334445553','2025-10-10','$2y$12$hACALwrronc3xEFVG2HYT.oZToir60Kv88JLf40XnN.zxMZysaOeK',1,1,'2025-11-26 18:12:54','2025-11-26 18:12:54'),(148,'111222333239','Pepito','Perez','Cl 34 #32-2','pepito@gmail.com239','3334445553','2025-10-10','$2y$12$S6oQXluG/VvKZbV9c6HraeCb/9MZ3m6fnUTfI8ye6EANvu/CIH2be',1,1,'2025-11-26 18:38:43','2025-11-26 18:38:43');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_cli` varchar(100) NOT NULL,
  `direccion_cli` varchar(50) NOT NULL,
  `correo_cli` varchar(50) DEFAULT NULL,
  `num_tel_cli` varchar(20) DEFAULT NULL,
  `num_doc_cli` varchar(20) DEFAULT NULL,
  `producto_id` bigint(20) unsigned NOT NULL,
  `cantidad` int(11) NOT NULL,
  `vendedor_id` bigint(20) unsigned NOT NULL,
  `estado_id` bigint(20) unsigned NOT NULL DEFAULT 1,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `venta_producto_id_foreign` (`producto_id`),
  KEY `venta_vendedor_id_foreign` (`vendedor_id`),
  KEY `venta_estado_id_foreign` (`estado_id`),
  CONSTRAINT `venta_estado_id_foreign` FOREIGN KEY (`estado_id`) REFERENCES `estado_venta` (`id`) ON DELETE CASCADE,
  CONSTRAINT `venta_producto_id_foreign` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE CASCADE,
  CONSTRAINT `venta_vendedor_id_foreign` FOREIGN KEY (`vendedor_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-26  9:05:23
