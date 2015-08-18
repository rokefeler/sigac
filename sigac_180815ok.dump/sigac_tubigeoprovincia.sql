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
-- Table structure for table `tubigeoprovincia`
--

DROP TABLE IF EXISTS `tubigeoprovincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tubigeoprovincia` (
  `id_Provincia` char(4) COLLATE utf8_spanish_ci NOT NULL,
  `idDepartamento_Provincia` char(2) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_Provincia` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_Provincia`),
  KEY `fk_provincia_departamento` (`idDepartamento_Provincia`),
  CONSTRAINT `FK_tubigeoprovincia_tubigeodepartamento` FOREIGN KEY (`idDepartamento_Provincia`) REFERENCES `tubigeodepartamento` (`id_Departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Provincias segun INEI';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tubigeoprovincia`
--

LOCK TABLES `tubigeoprovincia` WRITE;
/*!40000 ALTER TABLE `tubigeoprovincia` DISABLE KEYS */;
INSERT INTO `tubigeoprovincia` VALUES ('0000','00','NINGUNO'),('0101','01','CHACHAPOYAS'),('0102','01','BAGUA'),('0103','01','BONGARA'),('0104','01','CONDORCANQUI'),('0105','01','LUYA'),('0106','01','RODRIGUEZ DE MENDOZA'),('0107','01','UTCUBAMBA'),('0201','02','HUARAZ'),('0202','02','AIJA'),('0203','02','ANTONIO RAYMONDI'),('0204','02','ASUNCION'),('0205','02','BOLOGNESI'),('0206','02','CARHUAZ'),('0207','02','CARLOS FERMIN FITZCARRALD'),('0208','02','CASMA'),('0209','02','CORONGO'),('0210','02','HUARI'),('0211','02','HUARMEY'),('0212','02','HUAYLAS'),('0213','02','MARISCAL LUZURIAGA'),('0214','02','OCROS'),('0215','02','PALLASCA'),('0216','02','POMABAMBA'),('0217','02','RECUAY'),('0218','02','SANTA'),('0219','02','SIHUAS'),('0220','02','YUNGAY'),('0301','03','ABANCAY'),('0302','03','ANDAHUAYLAS'),('0303','03','ANTABAMBA'),('0304','03','AYMARAES'),('0305','03','COTABAMBAS'),('0306','03','CHINCHEROS'),('0307','03','GRAU'),('0401','04','AREQUIPA'),('0402','04','CAMANA'),('0403','04','CARAVELI'),('0404','04','CASTILLA'),('0405','04','CAYLLOMA'),('0406','04','CONDESUYOS'),('0407','04','ISLAY'),('0408','04','LA UNIÒN'),('0501','05','HUAMANGA'),('0502','05','CANGALLO'),('0503','05','HUANCA SANCOS'),('0504','05','HUANTA'),('0505','05','LA MAR'),('0506','05','LUCANAS'),('0507','05','PARINACOCHAS'),('0508','05','PÀUCAR DEL SARA SARA'),('0509','05','SUCRE'),('0510','05','VICTOR FAJARDO'),('0511','05','VILCAS HUAMAN'),('0601','06','CAJAMARCA'),('0602','06','CAJABAMBA'),('0603','06','CELENDIN'),('0604','06','CHOTA'),('0605','06','CONTUMAZA'),('0606','06','CUTERVO'),('0607','06','HUALGAYOC'),('0608','06','JAEN'),('0609','06','SAN IGNACIO'),('0610','06','SAN MARCOS'),('0611','06','SAN MIGUEL'),('0612','06','SAN PABLO'),('0613','06','SANTA CRUZ'),('0701','07','PROV. CONST. DEL CALLAO'),('0801','08','CUSCO'),('0802','08','ACOMAYO'),('0803','08','ANTA'),('0804','08','CALCA'),('0805','08','CANAS'),('0806','08','CANCHIS'),('0807','08','CHUMBIVILCAS'),('0808','08','ESPINAR'),('0809','08','LA CONVENCION'),('0810','08','PARURO'),('0811','08','PAUCARTAMBO'),('0812','08','QUISPICANCHI'),('0813','08','URUBAMBA'),('0901','09','HUANCAVELICA'),('0902','09','ACOBAMBA'),('0903','09','ANGARAES'),('0904','09','CASTROVIRREYNA'),('0905','09','CHURCAMPA'),('0906','09','HUAYTARA'),('0907','09','TAYACAJA'),('1001','10','HUANUCO'),('1002','10','AMBO'),('1003','10','DOS DE MAYO'),('1004','10','HUACAYBAMBA'),('1005','10','HUAMALIES'),('1006','10','LEONCIO PRADO'),('1007','10','MARAÑON'),('1008','10','PACHITEA'),('1009','10','PUERTO INCA'),('1010','10','LAURICOCHA '),('1011','10','YAROWILCA '),('1101','11','ICA '),('1102','11','CHINCHA '),('1103','11','NAZCA '),('1104','11','PALPA '),('1105','11','PISCO '),('1201','12','HUANCAYO '),('1202','12','CONCEPCION '),('1203','12','CHANCHAMAYO '),('1204','12','JAUJA '),('1205','12','JUNIN '),('1206','12','SATIPO '),('1207','12','TARMA '),('1208','12','YAULI '),('1209','12','CHUPACA '),('1301','13','TRUJILLO '),('1302','13','ASCOPE '),('1303','13','BOLIVAR '),('1304','13','CHEPEN '),('1305','13','JULCAN '),('1306','13','OTUZCO '),('1307','13','PACASMAYO '),('1308','13','PATAZ '),('1309','13','SANCHEZ CARRION '),('1310','13','SANTIAGO DE CHUCO '),('1311','13','GRAN CHIMU '),('1312','13','VIRU '),('1401','14','CHICLAYO '),('1402','14','FERREÑAFE '),('1403','14','LAMBAYEQUE '),('1501','15','LIMA '),('1502','15','BARRANCA '),('1503','15','CAJATAMBO '),('1504','15','CANTA '),('1505','15','CAÑETE '),('1506','15','HUARAL '),('1507','15','HUAROCHIRI '),('1508','15','HUAURA '),('1509','15','OYON '),('1510','15','YAUYOS '),('1601','16','MAYNAS '),('1602','16','ALTO AMAZONAS '),('1603','16','LORETO '),('1604','16','MARISCAL RAMON CASTILLA '),('1605','16','REQUENA '),('1606','16','UCAYALI '),('1607','16','DATEM DEL MARAÑON '),('1608','16','PUTUMAYO'),('1701','17','TAMBOPATA '),('1702','17','MANU '),('1703','17','TAHUAMANU '),('1801','18','MARISCAL NIETO '),('1802','18','GENERAL SANCHEZ CERRO '),('1803','18','ILO '),('1901','19','PASCO '),('1902','19','DANIEL ALCIDES CARRION '),('1903','19','OXAPAMPA '),('2001','20','PIURA '),('2002','20','AYABACA '),('2003','20','HUANCABAMBA '),('2004','20','MORROPON '),('2005','20','PAITA '),('2006','20','SULLANA '),('2007','20','TALARA '),('2008','20','SECHURA '),('2101','21','PUNO '),('2102','21','AZANGARO '),('2103','21','CARABAYA '),('2104','21','CHUCUITO '),('2105','21','EL COLLAO '),('2106','21','HUANCANE '),('2107','21','LAMPA '),('2108','21','MELGAR '),('2109','21','MOHO '),('2110','21','SAN ANTONIO DE PUTINA '),('2111','21','SAN ROMAN '),('2112','21','SANDIA '),('2113','21','YUNGUYO '),('2201','22','MOYOBAMBA '),('2202','22','BELLAVISTA '),('2203','22','EL DORADO '),('2204','22','HUALLAGA '),('2205','22','LAMAS '),('2206','22','MARISCAL CACERES '),('2207','22','PICOTA '),('2208','22','RIOJA '),('2209','22','SAN MARTIN '),('2210','22','TOCACHE '),('2301','23','TACNA '),('2302','23','CANDARAVE '),('2303','23','JORGE BASADRE '),('2304','23','TARATA '),('2401','24','TUMBES '),('2402','24','CONTRALMIRANTE VILLAR '),('2403','24','ZARUMILLA '),('2501','25','CORONEL PORTILLO '),('2502','25','ATALAYA '),('2503','25','PADRE ABAD '),('2504','25','PURUS');
/*!40000 ALTER TABLE `tubigeoprovincia` ENABLE KEYS */;
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
