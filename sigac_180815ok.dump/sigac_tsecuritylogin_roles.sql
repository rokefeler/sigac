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
-- Table structure for table `tsecuritylogin_roles`
--

DROP TABLE IF EXISTS `tsecuritylogin_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsecuritylogin_roles` (
  `id_Login` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `id_RolLogin` int(11) NOT NULL,
  KEY `FK_tsecuritylogin_roles_tsecuritylogin` (`id_Login`),
  KEY `FK_tsecuritylogin_roles_tsecurityrollogin` (`id_RolLogin`),
  CONSTRAINT `FK_tsecuritylogin_roles_tsecuritylogin` FOREIGN KEY (`id_Login`) REFERENCES `tsecuritylogin` (`id_Login`),
  CONSTRAINT `FK_tsecuritylogin_roles_tsecurityrollogin` FOREIGN KEY (`id_RolLogin`) REFERENCES `tsecurityrollogin` (`id_RolLogin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Roles de Seguridad asignados a cada Usuario que puede acceder al Sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tsecuritylogin_roles`
--

LOCK TABLES `tsecuritylogin_roles` WRITE;
/*!40000 ALTER TABLE `tsecuritylogin_roles` DISABLE KEYS */;
INSERT INTO `tsecuritylogin_roles` VALUES ('SYSTEM',1),('SYSTEM',6);
/*!40000 ALTER TABLE `tsecuritylogin_roles` ENABLE KEYS */;
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
