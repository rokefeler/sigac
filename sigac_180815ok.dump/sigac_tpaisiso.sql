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
-- Table structure for table `tpaisiso`
--

DROP TABLE IF EXISTS `tpaisiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tpaisiso` (
  `id_PaisIso` char(3) COLLATE utf8_spanish_ci NOT NULL,
  `countryISO_A2_PaisIso` char(2) COLLATE utf8_spanish_ci NOT NULL,
  `countryISO_N3_PaisIso` char(3) COLLATE utf8_spanish_ci NOT NULL,
  `countryNameES_PaisIso` varchar(85) COLLATE utf8_spanish_ci NOT NULL,
  `countryNameEN_PaisIso` varchar(85) COLLATE utf8_spanish_ci DEFAULT NULL,
  `continent_PaisIso` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `phoneCode_PaisIso` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `languageCode_PaisIso` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `locales_PaisIso` varchar(75) COLLATE utf8_spanish_ci DEFAULT NULL,
  `currency_PaisIso` char(3) COLLATE utf8_spanish_ci DEFAULT NULL,
  `capital_PaisIso` varchar(44) COLLATE utf8_spanish_ci DEFAULT NULL,
  `latitude_PaisIso` decimal(18,6) DEFAULT NULL,
  `longitude_PaisIso` decimal(18,6) DEFAULT NULL,
  PRIMARY KEY (`id_PaisIso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla de Paises ISO';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tpaisiso`
--

LOCK TABLES `tpaisiso` WRITE;
/*!40000 ALTER TABLE `tpaisiso` DISABLE KEYS */;
INSERT INTO `tpaisiso` VALUES ('ABW','AW','533','ARUBA','ARUBA','NA','297','NL','NL-AW,ES,EN','AWG','ORANJESTAD',12.500000,-69.966700),('AFG','AF','004','AFGANISTÁN','AFGHANISTAN','AS','93','FA','FA-AF,PS,UZ-AF,TK','AFN','KABUL',33.000000,65.000000),('AGO','AO','024','ANGOLA','ANGOLA','AF','244','PT','PT-AO','AOA','LUANDA',-12.500000,18.500000),('AIA','AI','660','ANGUILA','ANGUILLA','NA','264','EN','EN-AI','XCD','THE VALLEY',18.250000,-63.166700),('ALA','AX','248','ISLAS AALAND','ÅLAND ISLANDS','EU','357','SV','SV-AX','EUR','MARIEHAMN',60.177002,19.915002),('ALB','AL','008','ALBANIA','ALBANIA','EU','355','SQ','SQ,EL','ALL','TIRANA',41.000000,20.000000),('AND','AD','020','ANDORRA','ANDORRA','EU','376','CA','CA,FR-AD,PT','EUR','ANDORRA LA VELLA',42.500000,1.500000),('ANT','AN','530','ANTILLAS NEERLANDESAS','NETHERLANDS ANTILLES','EU','599','NL','NL-AN,EN,ES','ANG','WILLEMSTAD',12.250000,-68.750000),('ARE','AE','784','EMIRATOS ÁRABES UNIDOS','UNITED ARAB EMIRATES','AS','971','AR','AR-AE,FA,EN,HI,UR','AED','ABU DHABI',24.000000,54.000000),('ARG','AR','032','ARGENTINA','ARGENTINA','SA','54','ES','ES-AR,EN,IT,DE,FR','ARS','BUENOS AIRES',-34.000000,-64.000000),('ARM','AM','051','ARMENIA','ARMENIA','AS','374','HY','HY','AMD','YEREVAN',40.000000,45.000000),('ASM','AS','016','SAMOA AMERICANA','AMERICAN SAMOA','OC','684','EN','EN-AS,SM,TO','USD','PAGO PAGO',-14.333300,-170.000000),('ATA','AQ','010','ANTÁRTIDA','ANTARCTICA','AN','672','EN',NULL,NULL,NULL,-90.000000,0.000000),('ATF','TF','260','TERRITORIOS AUSTRALES FRANCESES','FRENCH SOUTHERN TERRITORIES','AN',NULL,'FR','FR','EUR','FRENCH SOUTHERN TERRITORIES',-43.000000,67.000000),('ATG','AG','028','ANTIGUA Y BARBUDA','ANTIGUA AND BARBUDA','NA','1268','EN','EN-AG','XCD','SAINT JOHN\'S',17.050000,-61.800000),('AUS','AU','036','AUSTRALIA','AUSTRALIA','OC','61','EN','EN-AU','AUD','CANBERRA',-27.000000,133.000000),('AUT','AT','040','AUSTRIA','AUSTRIA','EU','43','DE','DE-AT,HR,HU,SL','EUR','VIENNA',47.333300,13.333300),('AZE','AZ','031','AZERBAIYÁN','AZERBAIJAN','AS','994','AZ','AZ,RU,HY','AZN','BAKU',40.500000,47.500000),('BDI','BI','108','BURUNDI','BURUNDI','AF','257','FR','FR-BI,RN','BIF','BUJUMBURA',-3.500000,30.000000),('BEL','BE','056','BÉLGICA','BELGIUM','EU','32','FR','NL-BE,FR-BE,DE-BE,WA','EUR','BRUSSELS',50.833300,4.000000),('BEN','BJ','204','BENÍN','BENIN','AF','229','FR','FR-BJ','XOF','PORTO-NOVO',9.500000,2.250000),('BFA','BF','854','BURKINA FASO','BURKINA FASO','AF','226','FR','FR-BF','XOF','OUAGADOUGOU',13.000000,-2.000000),('BGD','BD','050','BANGLADESH','BANGLADESH','AS','880','BN','BN-BD,EN','BDT','DHAKA',24.000000,90.000000),('BGR','BG','100','BULGARIA','BULGARIA','EU','359','BG','BG,TR-BG','EUR','SOFIA',43.000000,25.000000),('BHR','BH','048','BAHRÁIN','BAHRAIN','AS','973','AR','AR-BH,EN,FA,UR','BHD','MANAMA',26.000000,50.550000),('BHS','BS','044','BAHAMAS','BAHAMAS','NA','242','EN','EN-BS','BSD','NASSAU',24.250000,-76.000000),('BIH','BA','070','BOSNIA Y HERCEGOVINA','BOSNIA AND HERZEGOVINA','EU','387','BS','BS,HR-BA,SR-BA','BAM','SARAJEVO',44.000000,18.000000),('BLM','BL','652','SAN BARTOLOMÉ','SAINT BARTHÉLEMY','NA','590','FR','FR','EUR','GUSTAVIA',17.900513,-62.820587),('BLR','BY','112','BIELORRUSIA','BELARUS','EU','375','BE','BE,RU','BYR','MINSK',53.000000,28.000000),('BLZ','BZ','084','BELICE','BELIZE','SA','501','EN','EN-BZ,ES','BZD','BELMOPAN',17.250000,-88.750000),('BMU','BM','060','BERMUDAS','BERMUDA','NA','441','EN','EN-BM,PT','BMD','HAMILTON',32.333300,-64.750000),('BOL','BO','068','BOLIVIA','BOLIVIA','SA','591','ES','ES-BO,QU,AY','BOB','SUCRE',-17.000000,-65.000000),('BRA','BR','076','BRASIL','BRAZIL','SA','55','PT','PT-BRR,ES,EN,FR','BRL','BRASÍLIA',-10.000000,-55.000000),('BRB','BB','052','BARBADOS','BARBADOS','NA','246','EN','EN-BB','BBD','BRIDGETOWN',13.166700,-59.533300),('BRN','BN','096','BRUNÉI','BRUNEI DARUSSALAM','AS','673','MS','MS-BN,EN-BN','BND','BANDAR SERI BEGAWAN',4.500000,114.666700),('BTN','BT','064','BUTÁN','BHUTAN','AS','975','DZ','DZ','BTN','THIMPHU',27.500000,90.500000),('BVT','BV','074','ISLA BOUVET','BOUVET ISLAND','AN',NULL,'EN',NULL,'NOK','BOUVET ISLAND',-54.433300,3.400000),('BWA','BW','072','BOTSUANA','BOTSWANA','AF','267','EN','EN-BW,TN-BW','BWP','GABORONE',-22.000000,24.000000),('CAF','CF','140','REPÚBLICA CENTROAFRICANA','CENTRAL AFRICAN REPUBLIC','AF','236','FR','FR-CF,LN,KG','XAF','BANGUI',7.000000,21.000000),('CAN','CA','124','CANADÁ','CANADA','NA','1','EN','EN-CA,FR-CA','CAD','OTTAWA',60.000000,-95.000000),('CCK','CC','166','ISLAS COCOS','COCOS (KEELING) ISLANDS','AS','61','MS','MS-CC,EN','AUD','COCOS (KEELING) ISLANDS',-12.500000,96.833300),('CHE','CH','756','SUIZA','SWITZERLAND','EU','41','DE','DE-CH,FR-CH,IT-CH,RM','CHF','BERNE',47.000000,8.000000),('CHL','CL','152','CHILE','CHILE','SA','56','ES','ES-CL','CLP','SANTIAGO',-30.000000,-71.000000),('CHN','CN','156','CHINA','CHINA','AS','86','ZH','ZH-CN,YUE,WUU','CNY','BEIJING (PEKÍN)',36.916667,116.383333),('CIV','CI','384','COSTA DE MARFIL','CÔTE D\'IVOIRE','AF','225','FR','FR-CI','XOF','YAMOUSSOUKRO',8.000000,-5.000000),('CMR','CM','120','CAMERÚN','CAMEROON','AF','237','EN','EN-CM,FR-CM','XAF','YAOUNDÉ',6.000000,12.000000),('COD','CD','180','REPÚBLICA DEMOCRÁTICA DEL CONGO','DEMOCRATIC REPUBLIC OF THE CONGO','AF','243','FR','FR-CD,LN,KG','CDF','KINSHASA',-0.228021,15.827659),('COG','CG','178','REPÚBLICA DEL CONGO (BRAZZAVILLE)','REPUBLIC OF CONGO (BRAZZAVILLE)','AF','242','FR','FR-CG,KG,LN-CG','XAF','KINSHASA',-1.000000,15.000000),('COK','CK','184','ISLAS COOK','COOK ISLANDS','OC','682','EN','EN-CK,MI','NZD','AVARUA',-21.233300,-159.766700),('COL','CO','170','COLOMBIA','COLOMBIA','SA','57','ES','ES-CO','COP','BOGOTÁ',4.000000,-72.000000),('COM','KM','174','COMORAS','COMOROS','AF','269','AR','AR,FR-KM','KMF','MORONI',-12.166700,44.250000),('CPV','CV','132','CABO VERDE','CAPE VERDE','AF','238','PT','PT-CV','CVE','PRAIA',16.172473,-24.005127),('CRI','CR','188','COSTA RICA','COSTA RICA','SA','506','ES','ES-CR,EN','CRC','SAN JOSÉ',10.000000,-84.000000),('CUB','CU','192','CUBA','CUBA','NA','53','ES','ES-CU','CUP','HAVANA',21.500000,-80.000000),('CXR','CX','162','ISLA CHRISTMAS','CHRISTMAS ISLAND','AS','61','EN','EN,ZH,MS-CC','AUD','CHRISTMAS ISLAND',-10.500000,105.666700),('CYM','KY','136','ISLAS CAIMÁN','CAYMAN ISLANDS','NA','345','EN','EN-KY','KYD','GEORGE TOWN',19.500000,-80.500000),('CYP','CY','196','CHIPRE','CYPRUS','AS','357','EL','EL-CY,TR-CY,EN','EUR','NICOSIA',35.000000,33.000000),('CZE','CZ','203','REPÚBLICA CHECA','CZECH REPUBLIC','EU','42','CS','CS,SK','EUR','PRAGUE',49.750000,15.500000),('DEU','DE','276','ALEMANIA','GERMANY','EU','49','DE','DE','EUR','BERLIN',51.000000,9.000000),('DJI','DJ','262','YIBUTI','DJIBOUTI','AF','253','FR','FR-DJ,AR,SO-DJ,AA','DJF','DJIBOUTI',11.500000,43.000000),('DMA','DM','212','DOMINICA','DOMINICA','NA','767','EN','EN-DM','XCD','ROSEAU',15.416700,-61.333300),('DNK','DK','208','DINAMARCA','DENMARK','EU','45','DA','DA-DK,EN,FO,DE-DK','EUR','COPENHAGEN',56.000000,10.000000),('DOM','DO','214','REPÚBLICA DOMINICANA','DOMINICAN REPUBLIC','NA','809','ES','ES-DO','DOP','SANTO DOMINGO',19.000000,-70.666700),('DZA','DZ','012','ARGELIA','ALGERIA','AF','213','AR','AR-DZ','DZD','ALGIERS',28.000000,3.000000),('ECU','EC','218','ECUADOR','ECUADOR','SA','593','ES','ES-EC','USD','QUITO',-2.000000,-77.500000),('EGY','EG','818','EGIPTO','EGYPT','AF','20','AR','AR-EG,EN,FR','EGP','CAIRO',27.000000,30.000000),('ERI','ER','232','ERITREA','ERITREA','AF','291','AA','AA-ER,AR,TIG,KUN,TI-ER','ERN','ASMARA',15.000000,39.000000),('ESH','EH','732','SÁHARA OCCIDENTAL','WESTERN SAHARA','AF','212','AR','AR,MEY','MAD','EL AAIÚN',24.500000,-13.000000),('ESP','ES','724','ESPAÑA','SPAIN','EU','34','ES','ES-ES,CA,GL,EU','EUR','MADRID',40.000000,-4.000000),('EST','EE','233','ESTONIA','ESTONIA','EU','372','ET','ET,RU','EEK','TALLINN',59.000000,26.000000),('ETH','ET','231','ETIOPÍA','ETHIOPIA','AF','251','AM','AM,EN-ET,OM-ET,TI-ET,SO-ET,SID','ETB','ADDIS ABABA',8.000000,38.000000),('FIN','FI','246','FINLANDIA','FINLAND','EU','358','FI','FI-FI,SV-FI,SMN','EUR','HELSINKI',64.000000,26.000000),('FJI','FJ','242','FIYI','FIJI','OC','679','EN','EN-FJ,FJ','FJD','SUVA',-18.000000,175.000000),('FLK','FK','238','ISLAS MALVINAS','FALKLAND ISLANDS (MALVINAS)','SA','500','EN','EN-FK','FKP','STANLEY',-51.750000,-59.000000),('FRA','FR','250','FRANCIA','FRANCE','EU','33','FR','FR-FR,FRP,BR,CO,CA,EU','EUR','PARÍS',46.000000,2.000000),('FRO','FO','234','ISLAS FEROE','FAROE ISLANDS','EU','298','FO','FO,DA-FO','DKK','TÓRSHAVN',62.000000,-7.000000),('FSM','FM','583','MICRONESIA','MICRONESIA','AS','691','EN','EN-FM,CHK,PON,YAP,KOS,ULI,WOE,NKR,KPG','USD','PALIKIR',6.916700,158.250000),('GAB','GA','266','GABÓN','GABON','AF','241','FR','FR-GA','XAF','LIBREVILLE',-1.000000,11.750000),('GBR','GB','826','REINO UNIDO','UNITED KINGDOM','EU','44','EN','EN-GB,CY-GB,GD','GBP','KINSHASA',54.000000,-2.000000),('GEO','GE','268','GEORGIA','GEORGIA','AS','995','KA','KA,RU,HY,AZ','GEL','TBILISI',42.000000,43.500000),('GGY','GG','831','GUERNSEY','GUERNSEY','EU','30','EN','EN,FR','GBP','ST PETER PORT',49.465691,-2.585278),('GHA','GH','288','GHANA','GHANA','AF','233','EN','EN-GH,AK,EE,TW','GHS','ACCRA',8.000000,-2.000000),('GIB','GI','292','GIBRALTAR','GIBRALTAR','EU','350','EN','EN-GI,ES,IT,PT','GIP','GIBRALTAR',36.183300,-5.366700),('GIN','GN','324','GUINEA','GUINEA','AF','224','FR','FR-GN','GNF','CONAKRY',11.000000,-10.000000),('GLP','GP','312','GUADALUPE','GUADELOUPE','NA','590','FR','FR-GP','EUR','BASSE-TERRE',16.250000,-61.583300),('GMB','GM','270','GAMBIA','GAMBIA','AF','220','EN','EN-GM,MNK,WOF,WO,FF','GMD','BANJUL',13.466700,-16.566700),('GNB','GW','624','GUINEA-BISSAU','GUINEA-BISSAU','AF','245','PT','PT-GW,POV','XOF','BISSAU',12.000000,-15.000000),('GNQ','GQ','226','GUINEA ECUATORIAL','EQUATORIAL GUINEA','AF','240','ES','ES-GQ,FR','XAF','MALABO',2.000000,10.000000),('GRC','GR','300','GRECIA','GREECE','EU','30','EL','EL-GR,EN,FR','EUR','ATHENS',39.000000,22.000000),('GRD','GD','308','GRANADA','GRENADA','NA','473','EN','EN-GD','XCD','SAINT GEORGE\'S',12.116700,-61.666700),('GRL','GL','304','GROENLANDIA','GREENLAND','NA','299','KL','KL,DA-GL,EN','DKK','NUUK',72.000000,-40.000000),('GTM','GT','320','GUATEMALA','GUATEMALA','SA','502','ES','ES-GT','GTQ','CIUDAD DE GUATEMALA',15.500000,-90.250000),('GUF','GF','254','GUAYANA FRANCESA','FRENCH GUIANA','SA','594','FR','FR-GF','EUR','CAYENNE',4.000000,-53.000000),('GUM','GU','316','GUAM','GUAM','OC','671','EN','EN-GU,CH-GU','USD','HAGÅTÑA',13.466700,144.783300),('GUY','GY','328','GUYANA','GUYANA','SA','592','EN','EN-GY','GYD','GEORGETOWN',5.000000,-59.000000),('HKG','HK','344','HONG KONG','HONG KONG','AS','852','ZH','ZH-HK,YUE,ZH,EN','HKD','HONG KONG',22.250000,114.166700),('HMD','HM','334','ISLAS HEARD Y MCDONALD','HEARD ISLAND AND MCDONALD ISLANDS','AN',NULL,'EN',NULL,'AUD','HEARD ISLAND AND MCDONALD ISLANDS',-53.100000,72.516700),('HND','HN','340','HONDURAS','HONDURAS','SA','504','ES','ES-HN','HNL','TEGUCIGALPA',15.000000,-86.500000),('HRV','HR','191','CROACIA','CROATIA','EU','385','HR','HR-HR,SR','HRK','ZAGREB',45.166700,15.500000),('HTI','HT','332','HAITÍ','HAITI','NA','509','HT','HT,FR-HT','HTG','PORT-AU-PRINCE',19.000000,-72.416700),('HUN','HU','348','HUNGRÍA','HUNGARY','EU','36','HU','HU-HU','EUR','BUDAPEST',47.000000,20.000000),('IDN','ID','360','INDONESIA','INDONESIA','AS','62','ID','ID,EN,NL,JV','IDR','JAKARTA',-5.000000,120.000000),('IMN','IM','833','ISLA DE MAN','ISLE OF MAN','EU','28','EN','EN,GV','GBP','DOUGLAS, ISLE OF MAN',54.236107,-4.548056),('IND','IN','356','INDIA','INDIA','AS','91','TA','EN-IN,HI,BN,TE,MR,TA,UR,GU,ML,KN,OR,PA,AS,KS,SD,SA','INR','NEW DELHI',20.000000,77.000000),('IOT','IO','086','TERRITORIO BRITÁNICO DEL OCÉANO INDICO','BRITISH INDIAN OCEAN TERRITORY','EU','284','EN','EN-IO','USD','BRITISH INDIAN OCEAN TERRITORY',-6.000000,71.500000),('IRL','IE','372','IRLANDA','IRELAND','EU','353','EN','EN-IE,GA-IE','EUR','DUBLIN',53.000000,-8.000000),('IRN','IR','364','IRÁN','IRAN','AS','98','FA','FA-IR,KU','IRR','TEHRAN',32.000000,53.000000),('IRQ','IQ','368','IRAQ','IRAQ','AS','964','AR','AR-IQ,KU,HY','IQD','BAGHDAD',33.000000,44.000000),('ISL','IS','352','ISLANDIA','ICELAND','EU','354','IS','IS,EN,DE,DA,SV,NO','ISK','REYKJAVÍK',65.000000,-18.000000),('ISR','IL','376','ISRAEL','ISRAEL','AS','972','HE','HE,AR-IL,EN-IL,','ILS','JERUSALEM',31.500000,34.750000),('ITA','IT','380','ITALIA','ITALY','EU','39','IT','IT-IT,DE-IT,FR-IT,SL','EUR','ROME',42.833300,12.833300),('JAM','JM','388','JAMAICA','JAMAICA','NA','1','EN','EN-JM','JMD','KINGSTON',18.250000,-77.500000),('JEY','JE','832','JERSEY','JERSEY','EU','29','EN','EN,PT','GBP','SAINT HELIER',49.214439,-2.131250),('JOR','JO','400','JORDANIA','JORDAN','AS','962','AR','AR-JO,EN','JOD','AMMAN',31.000000,36.000000),('JPN','JP','392','JAPÓN','JAPAN','AS','81','JA','JA','JPY','TOKYO',36.000000,138.000000),('KAZ','KZ','398','KAZAJISTÁN','KAZAKHSTAN','AS','7','KK','KK,RU','KZT','ASTANA',48.000000,68.000000),('KEN','KE','404','KENIA','KENYA','AF','254','SW','EN-KE,SW-KE','KES','NAIROBI',1.000000,38.000000),('KGZ','KG','417','KIRGUIZISTÁN','KYRGYZSTAN','AS','7','KY','KY,UZ,RU','KGS','BISHKEK',41.000000,75.000000),('KHM','KH','116','CAMBOYA','CAMBODIA','AS','855','KM','KM,FR,EN','KHR','PHNOM PENH',13.000000,105.000000),('KIR','KI','296','KIRIBATI','KIRIBATI','OC','686','EN','EN-KI,GIL','AUD','SOUTH TARAWA',1.416700,173.000000),('KNA','KN','659','SAN CRISTÓBAL Y NIEVES','SAINT KITTS AND NEVIS','NA','869','EN','EN-KN','XCD','BASSETERRE',17.333300,-62.750000),('KOR','KR','410','COREA DEL SUR','SOUTH KOREA','AS','82','KO','KO-KR,EN','KRW','SEOUL',37.000000,127.500000),('KWT','KW','414','KUWAIT','KUWAIT','AS','965','AR','AR-KW,EN','KWD','KUWAIT CITY',29.500000,45.750000),('LAO','LA','418','LAOS','LAOS','AS','856','LO','LO,FR,EN','LAK','VIENTIANE',18.000000,105.000000),('LBN','LB','422','LÍBANO','LEBANON','AS','961','AR','AR-LB,FR-LB,EN,HY','LBP','BEIRUT',33.833300,35.833300),('LBR','LR','430','LIBERIA','LIBERIA','AF','231','EN','EN-LR','LRD','MONROVIA',6.500000,-9.500000),('LBY','LY','434','LIBIA','LIBYA','AF','218','AR','AR-LY,IT,EN','LYD','TRIPOLI',25.000000,17.000000),('LCA','LC','662','SANTA LUCÍA','SAINT LUCIA','NA','758','EN','EN-LC','XCD','CASTRIES',13.883300,-61.133300),('LIE','LI','438','LIECHTENSTEIN','LIECHTENSTEIN','EU','41','DE','DE-LI','CHF','VADUZ',47.142095,9.548492),('LKA','LK','144','SRI LANKA','SRI LANKA','AS','94','SI','SI,TA,EN','LKR','SRI JAYEWARDENEPURA KOTTE',7.000000,81.000000),('LSO','LS','426','LESOTO','LESOTHO','AF','266','EN','EN-LS,ST,ZU,XH','LSL','MASERU',-29.500000,28.500000),('LTU','LT','440','LITUANIA','LITHUANIA','EU','370','LT','LT,RU,PL','LTL','VILNIUS',56.000000,24.000000),('LUX','LU','442','LUXEMBURGO','LUXEMBOURG','EU','352','FR','FR-LU,LB,DE-LU','EUR','LUXEMBOURG',49.750000,6.166700),('LVA','LV','428','LETONIA','LATVIA','EU','371','LV','LV,RU,LT','LVL','RIGA',57.000000,25.000000),('MAC','MO','446','MACAO','MACAO','AS','853','ZH','ZH,ZH-MO','MOP','MACAU',22.166700,113.550000),('MAF','MF','663','SAN MARTÍN','SAINT MARTIN','NA','590','FR','FR','EUR','MARIGOT',42.859860,19.226074),('MAR','MA','504','MARRUECOS','MOROCCO','AF','212','AR','AR-MA,FR','MAD','RABAT',32.000000,-5.000000),('MCO','MC','492','MÓNACO','MONACO','EU','337','FR','FR-MC,EN,IT','EUR','MONACO',43.733300,7.400000),('MDA','MD','498','MOLDAVIA','MOLDOVA','EU','373','RO','RO,RU,GAG,TR','MDL','CHISINAU',47.000000,29.000000),('MDG','MG','450','MADAGASCAR','MADAGASCAR','AF','261','FR','FR-MG,MG','MGA','ANTANANARIVO',-20.000000,47.000000),('MDV','MV','462','MALDIVAS','MALDIVES','AS','960','DI','DV,EN','MVR','MALÉ',3.250000,73.000000),('MEX','MX','484','MÉXICO','MEXICO','NA','52','ES','ES-MX','MXP','MEXICO CITY',23.000000,-102.000000),('MHL','MH','584','ISLAS MARSHALL','MARSHALL ISLANDS','OC','692','MH','MH,EN-MH','USD','MAJURO',9.000000,168.000000),('MKD','MK','807','MACEDONIA','MACEDONIA','EU','389','MK','MK,SQ,TR,RMM,SR','MKD','SKOPJE',41.833300,22.000000),('MLI','ML','466','MALÍ','MALI','AF','223','FR','FR-ML,BM','XOF','BAMAKO',17.000000,-4.000000),('MLT','MT','470','MALTA','MALTA','EU','356','MT','MT,EN-MT','EUR','VALLETTA',35.833300,14.583300),('MMR','MM','104','BIRMANIA','MYANMAR','AS','95','MY','MY','MMK','NAYPYIDAW',22.000000,98.000000),('MNE','ME','499','MONTENEGRO','MONTENEGRO','AS','381','SR','SR,HU,BS,SQ,HR,ROM','EUR','PODGORICA',42.859860,19.226074),('MNG','MN','496','MONGOLIA','MONGOLIA','AS','976','MO','MN,RU','MNT','ULAANBAATAR',46.000000,105.000000),('MNP','MP','580','ISLAS MARIANAS DEL NORTE','NORTHERN MARIANA ISLANDS','OC','670','FI','FIL,TL,ZH,CH-MP,EN-MP','USD','SAIPAN',15.200000,145.750000),('MOZ','MZ','508','MOZAMBIQUE','MOZAMBIQUE','AF','258','PT','PT-MZ,VMW','MZN','MAPUTO',-18.250000,35.000000),('MRT','MR','478','MAURITANIA','MAURITANIA','AF','222','AR','AR-MR,FUC,SNK,FR,MEY,WO','MRO','NOUAKCHOTT',20.000000,-12.000000),('MSR','MS','500','MONTSERRAT','MONTSERRAT','NA','1','EN','EN-MS','XCD','PLYMOUTH',16.750000,-62.200000),('MTQ','MQ','474','MARTINICA','MARTINIQUE','NA','596','FR','FR-MQ','EUR','FORT-DE-FRANCE',14.666700,-61.000000),('MUS','MU','480','MAURICIO','MAURITIUS','AF','230','EN','EN-MU,BHO,FR','MUR','PORT LOUIS',-20.283300,57.550000),('MWI','MW','454','MALAUI','MALAWI','AF','265','NY','NY,YAO,TUM,SWK','MWK','LILONGWE',-13.500000,34.000000),('MYS','MY','458','MALASIA','MALAYSIA','AS','60','MS','MS-MY,EN,ZH,TA,TE,ML,PA,TH','MYR','KUALA LUMPUR',2.500000,112.500000),('MYT','YT','175','MAYOTTE','MAYOTTE','AF','269','FR','FR-YT','EUR','MAMOUDZOU',-12.833300,45.166700),('NAM','NA','516','NAMIBIA','NAMIBIA','AF','264','EN','EN-NA,AF,DE,HZ,NAQ','NAD','WINDHOEK',-22.000000,17.000000),('NCL','NC','540','NUEVA CALEDONIA','NEW CALEDONIA','OC','687','FR','FR-NC','XPF','NOUMÉA',-21.500000,165.500000),('NER','NE','562','NÍGER','NIGER','AF','227','FR','FR-NE,HA,KR,DJE','XOF','NIAMEY',16.000000,8.000000),('NFK','NF','574','ISLA NORFOLK','NORFOLK ISLAND','OC','672','EN','EN-NF','AUD','KINGSTON',-29.033300,167.950000),('NGA','NG','566','NIGERIA','NIGERIA','AF','234','EN','EN-NG,HA,YO,IG,FF','NGN','ABUJA',10.000000,8.000000),('NIC','NI','558','NICARAGUA','NICARAGUA','SA','505','ES','ES-NI,EN','NIO','MANAGUA',13.000000,-85.000000),('NIU','NU','570','NIUE','NIUE','OC','683','NI','NIU,EN-NU','NZD','ALOFI',-19.033300,-169.866700),('NLD','NL','528','HOLANDA (PAÍSES BAJOS)','NETHERLANDS','EU','31','NL','NL-NL,FY-NL','EUR','AMSTERDAM',52.500000,5.750000),('NOR','NO','578','NORUEGA','NORWAY','EU','47','NO','NO,NB,NN','NOK','OSLO',62.000000,10.000000),('NPL','NP','524','NEPAL','NEPAL','AS','977','NE','NE,EN','NPR','KATHMANDU',28.000000,84.000000),('NRU','NR','520','NAURU','NAURU','OC','674','NA','NA,EN-NR','AUD','YAREN',-0.533300,166.916700),('NZL','NZ','554','NUEVA ZELANDA','NEW ZEALAND','OC','64','EN','EN-NZ,MI','NZD','WELLINGTON',-41.000000,174.000000),('OMN','OM','512','OMÁN','OMAN','AS','968','AR','AR-OM,EN,BAL,UR','OMR','MUSCAT',21.000000,57.000000),('PAK','PK','586','PAKISTÁN','PAKISTAN','AS','92','UR','UR-PK,EN-PK,PA,SD,PS,BRH','PKR','ISLAMABAD',30.000000,70.000000),('PAN','PA','591','PANAMÁ','PANAMA','SA','507','ES','ES-PA,EN','PAB','PANAMA CITY',9.000000,-80.000000),('PCN','PN','612','ISLAS PITCAIRN','PITCAIRN ISLANDS','OC',NULL,'EN','EN-PN','NZD','ADAMSTOWN',-24.703615,-127.439308),('PER','PE','604','PERÚ','PERU','SA','51','ES','ES-PE,QU,AY','PEN','LIMA',-10.000000,-76.000000),('PHL','PH','608','FILIPINAS','PHILIPPINES','AS','63','EN','TL,EN-PH,FIL','PHP','MANILA',13.000000,122.000000),('PLW','PW','585','PALAOS','PALAU','OC','680','PW','PAU,SOV,EN-PW,TOX,JA,FIL,ZH','USD','MELEKEOK',7.500000,134.500000),('PNG','PG','598','PAPÚA-NUEVA GUINEA','PAPUA NEW GUINEA','OC','675','EN','EN-PG,HO,MEU,TPI','PGK','PORT MORESBY',-6.000000,147.000000),('POL','PL','616','POLONIA','POLAND','EU','48','PL','PL','EUR','WARSAW',52.000000,20.000000),('PRI','PR','630','PUERTO RICO','PUERTO RICO','NA','1','ES','EN-PR,ES-PR','USD','SAN JUAN',18.250000,-66.500000),('PRK','KP','408','COREA DEL NORTE','NORTH KOREA','AS','850','KO','KO-KP','KPW','PYONGYANG',40.000000,127.000000),('PRT','PT','620','PORTUGAL','PORTUGAL','EU','351','PT','PT-PT,MWL','EUR','LISBOA',39.500000,-8.000000),('PRY','PY','600','PARAGUAY','PARAGUAY','SA','595','ES','ES-PY,GN','PYG','ASUNCIÓN',-23.000000,-58.000000),('PSE','PS','275','PALESTINA','PALESTINIAN TERRITORY','AS','970','AR','AR-PS','ILS','EAST JERUSALEM',31.785700,35.200700),('PYF','PF','258','POLINESIA FRANCESA','FRENCH POLYNESIA','OC','689','FR','FR-PF,TY','XPF','PAPEETE',-15.000000,-140.000000),('QAT','QA','634','QATAR','QATAR','AS','974','AR','AR-QA,ES','QAR','DOHA',25.500000,51.250000),('REU','RE','638','REUNIÓN','RÉUNION','AF','262','FR','FR-RE','EUR','SAINT-DENIS',-21.100000,55.600000),('ROU','RO','642','RUMANIA','ROMANIA','EU','40','RO','RO,HU,ROM','RON','BUCHAREST',46.000000,25.000000),('RUS','RU','643','RUSIA','RUSSIAN FEDERATION','EU','7','RU','RU-RU','RUB','MOSCOW',60.000000,100.000000),('RWA','RW','646','RUANDA','RWANDA','AF','250','RW','RW,EN-RW,FR-RW,SW','RWF','KIGALI',-2.000000,30.000000),('SAU','SA','682','ARABIA SAUDÍ','SAUDI ARABIA','AS','966','AR','AR-SA','SAR','RIYADH',25.000000,45.000000),('SDN','SD','736','SUDÁN','SUDAN','AF','249','AR','AR-SD,EN,FIA','SDG','KHARTOUM',15.000000,30.000000),('SEN','SN','686','SENEGAL','SENEGAL','AF','221','FR','FR-SN,WO,FUC,MNK','XOF','DAKAR',14.000000,-14.000000),('SGP','SG','702','SINGAPUR','SINGAPORE','AS','65','ZH','CMN,EN-SG,MS-SG,TA-SG,ZH-SG','SGD','SINGAPORE',1.366700,103.800000),('SGS','GS','239','ISLAS GEORGIA DEL SUR Y SANDWICH DEL SUR','SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS','AN','995','EN','EN','GBP','SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS',-54.500000,-37.000000),('SHN','SH','654','SANTA HELENA','SAINT HELENA, ASCENSION AND TRISTAN DA CUNHA','AF','290','EN','EN-SH','SHP','JAMESTOWN',-15.933300,-5.700000),('SJM','SJ','744','SVALBARD Y JAN MAYEN','SVALBARD AND JAN MAYEN','EU','47','NO','NO,RU','NOK','LONGYEARBYEN',78.000000,20.000000),('SLB','SB','090','ISLAS SALOMÓN','SOLOMON ISLANDS','OC','677','EN','EN-SB,TPI','SBD','HONIARA',-8.000000,159.000000),('SLE','SL','694','SIERRA LEONA','SIERRA LEONE','AF','232','EN','EN-SL,MEN,TEM','SLL','FREETOWN',8.500000,-11.500000),('SLV','SV','222','EL SALVADOR','EL SALVADOR','SA','503','ES','ES-SV','USD','SAN SALVADOR',13.833300,-88.916700),('SMR','SM','674','SAN MARINO','SAN MARINO','EU','378','IT','IT-SM','EUR','CITTÀ DI SAN MARINO',43.936967,12.462616),('SOM','SO','706','SOMALIA','SOMALIA','AF','252','SO','SO-SO,AR-SO,IT,EN-SO','SOS','MOGADISHU',10.000000,49.000000),('SPM','PM','666','SAN PEDRO Y MIQUELÓN','SAINT PIERRE AND MIQUELON','NA','508','FR','FR-PM','EUR','SAINT-PIERRE',46.833300,-56.333300),('SRB','RS','688','SERBIA','SERBIA','AS','381','SR','SR,HU,BS,ROM','RSD','BELGRADE',44.000000,21.000000),('STP','ST','678','SANTO TOMÉ Y PRÍNCIPE','SÃO TOMÉ AND PRÍNCIPE','AF','239','PT','PT-ST','STD','SÃO TOMÉ',1.000000,7.000000),('SUR','SR','740','SURINAM','SURINAME','SA','597','NL','NL-SR,EN,SRN,HNS,JV','SRD','PARAMARIBO',4.000000,-56.000000),('SVK','SK','703','ESLOVAQUIA','SLOVAKIA','EU','42','SK','SK,HU','EUR','BRATISLAVA',48.666700,19.500000),('SVN','SI','705','ESLOVENIA','SLOVENIA','EU','386','SL','SL,SH','EUR','LJUBLJANA',46.000000,15.000000),('SWE','SE','752','SUECIA','SWEDEN','EU','46','SV','SV-SE,SE,SMA,FI-SE','EUR','STOCKHOLM',62.000000,15.000000),('SWZ','SZ','748','SUAZILANDIA','SWAZILAND','AF','268','EN','EN-SZ,SS-SZ','SZL','MBABANE',-26.500000,31.500000),('SYC','SC','690','SEYCHELLES','SEYCHELLES','AF','248','EN','EN-SC,FR-SC','SCR','VICTORIA',-4.583300,55.666700),('SYR','SY','760','SIRIA','SYRIAN ARAB REPUBLIC','AS','963','SY','AR-SY,KU,HY,ARC,FR,EN','SYP','DAMASCUS',35.000000,38.000000),('TCA','TC','796','ISLAS TURCAS Y CAICOS','TURKS AND CAICOS ISLANDS','NA','649','EN','EN-TC','USD','COCKBURN TOWN',21.750000,-71.583300),('TCD','TD','148','CHAD','CHAD','AF','235','FR','FR-TD,AR-TD,SRE','XAF','N\'DJAMENA',15.000000,19.000000),('TGO','TG','768','TOGO','TOGO','AF','228','FR','FR-TG,EE,HNA,KBP,DAG,HA','XOF','LOMÉ',8.000000,1.166700),('THA','TH','764','TAILANDIA','THAILAND','AS','66','TH','TH,EN','THB','BANGKOK',15.000000,100.000000),('TJK','TJ','762','TAYIKISTÁN','TAJIKISTAN','AS','7','TG','TG,RU','TJS','DUSHANBE',39.000000,71.000000),('TKL','TK','772','TOKELAU','TOKELAU','OC','690','TK','TKL,EN-TK','NZD',NULL,-9.000000,-172.000000),('TKM','TM','795','TURKMENISTÁN','TURKMENISTAN','AS','993','TK','TK,RU,UZ','TMT','ASHGABAT',40.000000,60.000000),('TLS','TL','626','TIMOR ORIENTAL','EAST TIMOR','OC','670','TE','TET,PT-TL,ID,EN','USD','DILI',-8.874217,125.727539),('TON','TO','776','TONGA','TONGA','OC','676','TO','TO,EN-TO','TOP','NUKU?ALOFA',-20.000000,-175.000000),('TTO','TT','780','TRINIDAD Y TOBAGO','TRINIDAD AND TOBAGO','NA','868','EN','EN-TT,HNS,FR,ES,ZH','TTD','PORT OF SPAIN',11.000000,-61.000000),('TUN','TN','788','TÚNEZ','TUNISIA','AF','216','AR','AR-TN,FR','TND','TUNIS',34.000000,9.000000),('TUR','TR','792','TURQUÍA','TURKEY','EU','90','TR','TR-TR,KU,DIQ,AZ,AV','TRY','ANKARA',39.000000,35.000000),('TUV','TV','798','TUVALU','TUVALU','OC','688','TV','TVL,EN,SM,GIL','AUD','FUNAFUTI',-8.000000,178.000000),('TWN','TW','158','TAIWÁN','TAIWAN','AS','886','CH','ZH-TW,ZH,NAN,HAK','TWD','DILI',23.500000,121.000000),('TZA','TZ','834','TANZANIA','TANZANIA','AF','255','SW','SW-TZ,EN,AR','TZS','DODOMA',-6.000000,35.000000),('UGA','UG','800','UGANDA','UGANDA','AF','256','EN','EN-UG,LG,SW,AR','UGX','KAMPALA',1.000000,32.000000),('UKR','UA','804','UCRANIA','UKRAINE','EU','380','UK','UK,RU-UA,ROM,PL,HU','UAH','KIEV',49.000000,32.000000),('UMI','UM','581','ISLAS MENORES ALEJADAS DE LOS ESTADOS UNIDOS','UNITED STATES MINOR OUTLYING ISLANDS','NA','340','EN','EN-UM','USD',NULL,19.283300,166.600000),('URY','UY','858','URUGUAY','URUGUAY','SA','598','ES','ES-UY','UYU','MONTEVIDEO',-33.000000,-56.000000),('USA','US','840','ESTADOS UNIDOS','UNITED STATES','NA','1','EN','EN-US,ES-US,HAW','USD','WASHINGTON, D.C.',38.000000,-97.000000),('UZB','UZ','860','UZBEKISTÁN','UZBEKISTAN','AS','7','UZ','UZ,RU,TG','UZS','TASHKENT',41.000000,64.000000),('VAT','VA','336','EL VATICANO','VATICAN CITY STATE (HOLY SEE)','EU','379','LA','LA,IT,FR','EUR','CITTÀ DEL VATICANO',41.903171,12.452917),('VCT','VC','670','SAN VICENTE Y LAS GRANADINAS','SAINT VINCENT AND THE GRENADINES','NA','809','EN','EN-VC,FR','XCD','KINGSTOWN',13.250000,-61.200000),('VEN','VE','862','VENEZUELA','VENEZUELA','SA','58','ES','ES-VE','VEF','CARACAS',8.000000,-66.000000),('VGB','VG','092','ISLAS VÍRGENES BRITÁNICAS','VIRGIN ISLANDS, BRITISH','NA','1340','EN','EN-VG','USD','ROAD TOWN',18.500000,-64.500000),('VIR','VI','850','ISLAS VÍRGENES AMERICANAS','US VIRGIN ISLANDS','NA','340','EN','EN-VI','USD','CHARLOTTE AMALIE',18.333300,-64.833300),('VNM','VN','704','VIETNAM','VIET NAM','AS','84','VI','VI,EN,FR,ZH,KM','VND','HANOI',16.000000,106.000000),('VUT','VU','548','VANUATU','VANUATU','OC','678','BI','BI,EN-VU,FR-VU','VUV','PORT VILA',-16.000000,167.000000),('WLF','WF','876','WALLIS Y FUTUNA','WALLIS AND FUTUNA','OC','681','WL','WLS,FUD,FR-WF','XPF','MATA-UTU',-13.300000,-176.200000),('WSM','WS','882','SAMOA','SAMOA','OC','685','SM','SM,EN-WS','WST','APIA',-13.583300,-172.333300),('XKX','XK','000','KOSOVO','KOSOVO','EU',NULL,'SH',NULL,NULL,'PRIŠTINA',42.602636,20.902977),('YEM','YE','887','YEMEN','YEMEN','AS','967','AR','AR-YE','YER','SANA\'A',15.000000,48.000000),('ZAF','ZA','710','SUDÁFRICA','SOUTH AFRICA','AF','27','EN','ZU,XH,AF,NSO,EN-ZA,TN,ST,TS','ZAR','PRETORIA',-28.883160,25.334473),('ZMB','ZM','894','ZAMBIA','ZAMBIA','AF','260','EN','EN-ZM,BEM,LOZ,LUN,LUE,NY,TOI','ZMK','LUSAKA',-15.000000,30.000000),('ZWE','ZW','716','ZIMBABUE','ZIMBABWE','AF','263','EN','EN-ZW,SN,NR,ND','ZWL','HARARE',-20.000000,30.000000);
/*!40000 ALTER TABLE `tpaisiso` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-18  1:07:38