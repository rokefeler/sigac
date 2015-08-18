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
-- Table structure for table `tsecurityrollogin`
--

DROP TABLE IF EXISTS `tsecurityrollogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsecurityrollogin` (
  `id_RolLogin` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_RolLogin` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `estado_RolLogin` enum('ANULADO','VIGENTE','SUSPENDIDO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'VIGENTE',
  `fecha_RolLogin` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_RolLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Roles o Grupos de Seguridad Disponibles';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tsecurityrollogin`
--

LOCK TABLES `tsecurityrollogin` WRITE;
/*!40000 ALTER TABLE `tsecurityrollogin` DISABLE KEYS */;
INSERT INTO `tsecurityrollogin` VALUES (1,'COORDINADOR','VIGENTE','2015-08-18 04:24:00'),(2,'SECRETARIA','VIGENTE','2015-08-18 04:46:19'),(3,'ADMIN.NOTAS','VIGENTE','2015-08-18 04:46:32'),(4,'ADMINISTRATIVO','VIGENTE','2015-08-18 04:46:39'),(5,'DOCENTE','VIGENTE','2015-08-18 04:46:45'),(6,'ADMINISTRADOR','VIGENTE','2015-08-18 04:46:50');
/*!40000 ALTER TABLE `tsecurityrollogin` ENABLE KEYS */;
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
