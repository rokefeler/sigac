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
-- Table structure for table `tsecuritylogin`
--

DROP TABLE IF EXISTS `tsecuritylogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsecuritylogin` (
  `id_Login` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `idPersona_Login` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `avatar_Login` varchar(256) COLLATE utf8_spanish_ci DEFAULT NULL,
  `esSuperuser_Login` tinyint(4) NOT NULL DEFAULT '0',
  `estado_Login` enum('ANULADO','VIGENTE','SUSPENDIDO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'VIGENTE',
  `fecha_Login` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `pwd_Login` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_Login`),
  KEY `FK_tsecuritylogin_tpersona` (`idPersona_Login`),
  CONSTRAINT `FK_tsecuritylogin_tpersona` FOREIGN KEY (`idPersona_Login`) REFERENCES `tpersona` (`id_Persona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Base de Usuarios que tienen Acceso al Sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tsecuritylogin`
--

LOCK TABLES `tsecuritylogin` WRITE;
/*!40000 ALTER TABLE `tsecuritylogin` DISABLE KEYS */;
INSERT INTO `tsecuritylogin` VALUES ('SYSTEM','29657168',NULL,1,'VIGENTE','2015-08-17 10:06:00','123');
/*!40000 ALTER TABLE `tsecuritylogin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-18  1:07:40
