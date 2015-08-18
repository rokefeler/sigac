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
-- Table structure for table `tubigeodepartamento`
--

DROP TABLE IF EXISTS `tubigeodepartamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tubigeodepartamento` (
  `id_Departamento` char(2) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_Departamento` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_Departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Departamentos segun INEI';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tubigeodepartamento`
--

LOCK TABLES `tubigeodepartamento` WRITE;
/*!40000 ALTER TABLE `tubigeodepartamento` DISABLE KEYS */;
INSERT INTO `tubigeodepartamento` VALUES ('00','NINGUNO'),('01','AMAZONAS'),('02','ANCASH'),('03','APURIMAC'),('04','AREQUIPA'),('05','AYACUCHO'),('06','CAJAMARCA'),('07','PROV. CONST. DEL CALLAO'),('08','CUSCO'),('09','HUANCAVELICA'),('10','HUANUCO'),('11','ICA'),('12','JUNIN'),('13','LA LIBERTAD'),('14','LAMBAYEQUE'),('15','LIMA'),('16','LORETO'),('17','MADRE DE DIOS'),('18','MOQUEGUA'),('19','PASCO'),('20','PIURA'),('21','PUNO'),('22','SAN MARTIN'),('23','TACNA'),('24','TUMBES'),('25','UCAYALI');
/*!40000 ALTER TABLE `tubigeodepartamento` ENABLE KEYS */;
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
