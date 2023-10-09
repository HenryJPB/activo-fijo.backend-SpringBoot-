-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: localhost    Database: ACTIVO
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activo_dat`
--

DROP TABLE IF EXISTS `activo_dat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activo_dat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo_activo` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `codigo_ubic` varchar(255) DEFAULT NULL,
  `imagen` mediumblob,
  `nro_compra` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `vida_util` int DEFAULT NULL,
  `valor_inicial` float DEFAULT NULL,
  `valor_rescate` float DEFAULT NULL,
  `valor_libro` float DEFAULT NULL,
  `depre_anual` float DEFAULT NULL,
  `depre_acum` float DEFAULT NULL,
  `observacion` varchar(255) DEFAULT NULL,
  `desincorporado` tinyint DEFAULT '0',
  `grupo` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_activo` (`codigo_activo`) USING BTREE,
  KEY `codigo_ubic` (`codigo_ubic`) USING BTREE,
  CONSTRAINT `fk_activo_ubicacion` FOREIGN KEY (`codigo_ubic`) REFERENCES `ubicacion_dat` (`codigo_ubic`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `adicion_dat`
--

DROP TABLE IF EXISTS `adicion_dat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adicion_dat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo_activo` varchar(15) NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `vida_util` int DEFAULT '0',
  `valor_adicion` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_adicion_activo` (`codigo_activo`),
  CONSTRAINT `fk_adicion_activo` FOREIGN KEY (`codigo_activo`) REFERENCES `activo_dat` (`codigo_activo`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `articulo_dat`
--

DROP TABLE IF EXISTS `articulo_dat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulo_dat` (
  `codigo_articulo` varchar(10) NOT NULL,
  `depre_acum` float DEFAULT NULL,
  `depre_anual` float DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `desincorporado` tinyint DEFAULT NULL,
  `imagen` tinyblob,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `nro_compra` varchar(255) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `valor_inicial` float DEFAULT NULL,
  `valor_libro` float DEFAULT NULL,
  `valor_rescate` float DEFAULT NULL,
  `vida_util` tinyint DEFAULT NULL,
  `codigo_ubic` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo_articulo`),
  UNIQUE KEY `UK_i2omo7wxb1m5rpe5wv0p0ss3` (`codigo_ubic`),
  CONSTRAINT `FKrnrs75pbwpqfdhvsb2hobqrg3` FOREIGN KEY (`codigo_ubic`) REFERENCES `ubicacion_dat` (`codigo_ubic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contacto_dat`
--

DROP TABLE IF EXISTS `contacto_dat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacto_dat` (
  `codigo` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `empleado_dat`
--

DROP TABLE IF EXISTS `empleado_dat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_dat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(20) NOT NULL,
  `email` varchar(150) NOT NULL,
  `fecha_nac` datetime(6) DEFAULT NULL,
  `nombre_completo` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pw1je8u0yx6wipds23paijsbq` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupo_dat`
--

DROP TABLE IF EXISTS `grupo_dat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupo_dat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `cuenta_cargo` varchar(255) DEFAULT NULL,
  `cuenta_abono` varchar(255) DEFAULT NULL,
  `tipo_activo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ubicacion_dat`
--

DROP TABLE IF EXISTS `ubicacion_dat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ubicacion_dat` (
  `codigo_ubic` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`codigo_ubic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-09 17:38:33
