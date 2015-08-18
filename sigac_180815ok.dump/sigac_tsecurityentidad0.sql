-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sigac
-- ------------------------------------------------------
-- Server version	5.6.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tsecurityentidad0`
--

DROP TABLE IF EXISTS `tsecurityentidad0`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsecurityentidad0` (
  `id_entidad` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id Autogenerado',
  `nombre` varchar(35) NOT NULL COMMENT 'Nombre de la Entidad o Proceso',
  PRIMARY KEY (`id_entidad`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='Entidades, Formularios o Procesos que tiene el Sistema Actual - Modificado solo por Desarrollador y/o Encargado';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tsecurityentidad0`
--

LOCK TABLES `tsecurityentidad0` WRITE;
/*!40000 ALTER TABLE `tsecurityentidad0` DISABLE KEYS */;
INSERT INTO `tsecurityentidad0` VALUES (1,'FmPersonal'),(2,'FmPrograma'),(3,'FprOrdenDePago'),(4,'FprGeneraTransfer'),(5,'FmGrupoCurso'),(6,'FmParametros'),(7,'FprFactura'),(8,'FprProcesarCdpg'),(9,'FrptGruposMatriculas'),(10,'FrptPagosVarios'),(11,'FphCambioGrupo'),(12,'FrptBoletaNotasAlumno'),(13,'FrptImprimirFacturas'),(14,'FprUnirCodigos'),(15,'FprIngresoNotas'),(16,'FprInscripcionenLote'),(17,'FprFacturarPagos'),(18,'FrptFacturacion'),(19,'FprOrdenDePagoReserva');
/*!40000 ALTER TABLE `tsecurityentidad0` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-18  1:07:39
