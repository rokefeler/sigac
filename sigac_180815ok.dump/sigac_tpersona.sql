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
-- Table structure for table `tpersona`
--

DROP TABLE IF EXISTS `tpersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tpersona` (
  `id_Persona` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `codanterior_Persona` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `nombres_Persona` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos_Persona` varchar(75) COLLATE utf8_spanish_ci NOT NULL,
  `fnac_Persona` date NOT NULL,
  `sexo_Persona` enum('FEMENINO','MASCULINO','EMPRESA') COLLATE utf8_spanish_ci DEFAULT 'FEMENINO',
  `direccion_Persona` varchar(160) COLLATE utf8_spanish_ci NOT NULL,
  `urbanizacion_Persona` varchar(70) COLLATE utf8_spanish_ci DEFAULT NULL,
  `referencia_Persona` varchar(120) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fijo_Persona` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `movil_Persona` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email_Persona` varchar(120) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idPaisIso_Persona` char(3) COLLATE utf8_spanish_ci,
  `idDistrito_Persona` char(6) COLLATE utf8_spanish_ci,
  `foto_Persona` varchar(256) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idcIden_Persona` varchar(15) COLLATE utf8_spanish_ci,
  `nrodoc_Persona` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `esAlumno_Persona` bit(1) DEFAULT NULL,
  `esDocente_Persona` bit(1) DEFAULT NULL,
  `esEmpleado_Persona` bit(1) DEFAULT NULL,
  `fecha_Persona` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `idLogin_Persona` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `estado_Persona` enum('ANULADO','VIGENTE','SUSPENDIDO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'VIGENTE',
  PRIMARY KEY (`id_Persona`),
  KEY `FK_tpersona_tpaisiso` (`idPaisIso_Persona`),
  KEY `FK_tpersona_tcodigo` (`idcIden_Persona`),
  KEY `FK_tpersona_tubigeodistrito` (`idDistrito_Persona`),
  CONSTRAINT `FK_tpersona_tcodigo` FOREIGN KEY (`idcIden_Persona`) REFERENCES `tcodigo` (`id_Codigo`),
  CONSTRAINT `FK_tpersona_tpaisiso` FOREIGN KEY (`idPaisIso_Persona`) REFERENCES `tpaisiso` (`id_PaisIso`),
  CONSTRAINT `FK_tpersona_tubigeodistrito` FOREIGN KEY (`idDistrito_Persona`) REFERENCES `tubigeodistrito` (`id_Distrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Alumnos, Docentes u Empleados del Sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tpersona`
--

LOCK TABLES `tpersona` WRITE;
/*!40000 ALTER TABLE `tpersona` DISABLE KEYS */;
INSERT INTO `tpersona` VALUES ('29657168','','JOSE ALBERTO','ROQUE CUTIPA','1975-11-10','MASCULINO','AV. AREQUIPA 701A','URB. JORGE CHAVEZ PAUCARPATA',NULL,NULL,'953655375','jroque@unsa.pe','PER','040112',NULL,'TDOC-0001','29657168','','','','2015-08-17 22:45:38','SYSTEM','VIGENTE');
/*!40000 ALTER TABLE `tpersona` ENABLE KEYS */;
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
