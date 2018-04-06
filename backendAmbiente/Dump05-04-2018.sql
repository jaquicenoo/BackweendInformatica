-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: monitoreoambiente
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `estacion`
--

DROP TABLE IF EXISTS `estacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacion` (
  `idEstacion` int(11) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Longitud` decimal(20,10) DEFAULT NULL,
  `Latitud` decimal(20,10) DEFAULT NULL,
  `Altura` decimal(20,10) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idEstacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacion`
--

LOCK TABLES `estacion` WRITE;
/*!40000 ALTER TABLE `estacion` DISABLE KEYS */;
INSERT INTO `estacion` VALUES (1,'alcala',-74.0660407000,4.7243365000,2670.7000000000,'cra 20 No.140 - 33'),(2,'Chapinero',-74.0660207000,4.7243765000,2670.7000000000,'cra 16 No.45 - 17');
/*!40000 ALTER TABLE `estacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicion`
--

DROP TABLE IF EXISTS `medicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicion` (
  `idMedicion` int(11) NOT NULL AUTO_INCREMENT,
  `idSensor` int(11) DEFAULT NULL,
  `Fecha` datetime DEFAULT NULL,
  `DatoObtenido` decimal(20,10) DEFAULT NULL,
  `Hora` time DEFAULT NULL,
  PRIMARY KEY (`idMedicion`),
  KEY `idSensor_idx` (`idSensor`),
  CONSTRAINT `idSensor` FOREIGN KEY (`idSensor`) REFERENCES `sensor` (`idSensor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicion`
--

LOCK TABLES `medicion` WRITE;
/*!40000 ALTER TABLE `medicion` DISABLE KEYS */;
INSERT INTO `medicion` VALUES (9,1,'2018-04-04 00:00:00',50.2000000000,'01:00:00'),(10,1,'2018-04-04 00:00:00',55.2000000000,'02:00:00'),(11,1,'2018-04-04 00:00:00',58.2000000000,'03:00:00'),(12,1,'2018-04-04 00:00:00',53.2000000000,'04:00:00'),(13,2,'2018-04-04 00:00:00',50.2000000000,'01:00:00'),(14,2,'2018-04-04 00:00:00',55.2000000000,'02:00:00'),(15,2,'2018-04-04 00:00:00',58.2000000000,'03:00:00'),(16,2,'2018-04-04 00:00:00',53.2000000000,'04:00:00'),(17,3,'2018-04-04 00:00:00',50.2000000000,'01:00:00'),(18,3,'2018-04-04 00:00:00',55.2000000000,'02:00:00'),(19,3,'2018-04-04 00:00:00',58.2000000000,'03:00:00'),(20,3,'2018-04-04 00:00:00',53.2000000000,'04:00:00'),(21,4,'2018-04-04 00:00:00',50.2000000000,'01:00:00'),(22,4,'2018-04-04 00:00:00',55.2000000000,'02:00:00'),(23,4,'2018-04-04 00:00:00',58.2000000000,'03:00:00'),(24,4,'2018-04-04 00:00:00',53.2000000000,'04:00:00');
/*!40000 ALTER TABLE `medicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor`
--

DROP TABLE IF EXISTS `sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensor` (
  `idSensor` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Unidades` varchar(45) DEFAULT NULL,
  `idEstacion` int(11) DEFAULT NULL,
  `idTipoSensor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSensor`),
  KEY `idTipoSensor_idx` (`idTipoSensor`),
  KEY `idEstacion_idx` (`idEstacion`),
  CONSTRAINT `idEstacion` FOREIGN KEY (`idEstacion`) REFERENCES `estacion` (`idEstacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idTipoSensor` FOREIGN KEY (`idTipoSensor`) REFERENCES `tiposensor` (`idTipoSensor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor`
--

LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
INSERT INTO `sensor` VALUES (1,'CO2_RX56','ppm',1,1),(2,'NO2_RX56','ppm',1,2),(3,'CO2_RX56','ppm',2,1),(4,'NO2_RX56','ppm',2,2);
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposensor`
--

DROP TABLE IF EXISTS `tiposensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposensor` (
  `idTipoSensor` int(11) NOT NULL,
  `TipoSensor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoSensor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposensor`
--

LOCK TABLES `tiposensor` WRITE;
/*!40000 ALTER TABLE `tiposensor` DISABLE KEYS */;
INSERT INTO `tiposensor` VALUES (1,'CO2'),(2,'NO2'),(3,'Ruido'),(4,'Temperatura'),(5,'PM10');
/*!40000 ALTER TABLE `tiposensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'monitoreoambiente'
--
/*!50003 DROP PROCEDURE IF EXISTS `getAllMedicionesByEstaciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllMedicionesByEstaciones`(in _idestacion int)
BEGIN
     SELECT 
        S.idSensor,
        Ts.TipoSensor,
        M.Fecha,
        M.Hora,
        M.DatoObtenido,
        S.Unidades
    FROM
        estacion AS E
            JOIN
        sensor AS S ON E.idEstacion = S.idEstacion
            JOIN
        medicion AS M ON M.idSensor = S.idSensor
            JOIN
        tiposensor AS Ts on S.idTipoSensor = Ts.idTipoSensor
        WHERE E.idEstacion = _idestacion
        ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSensoresByEstaciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSensoresByEstaciones`(in _idestacion int)
BEGIN
    SELECT 
        S.idSensor,
        S.Nombre,
        Ts.tipoSensor,
        S.Unidades
    FROM
        estacion AS E
            JOIN
        sensor AS S ON E.idEstacion = S.idEstacion
            JOIN
        tiposensor AS Ts on S.idTipoSensor = Ts.idTipoSensor 
        Where E.idEstacion = _idestacion
        ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllTipoSensoresByEstaciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllTipoSensoresByEstaciones`(in _idestacion int)
BEGIN
    SELECT 
         Ts.tipoSensor
    FROM
        estacion AS E
            JOIN
        sensor AS S ON E.idEstacion = S.idEstacion
            JOIN
        tiposensor AS Ts on S.idTipoSensor = Ts.idTipoSensor 
        Where E.idEstacion = _idestacion
        ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEstaciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEstaciones`()
BEGIN
    SELECT 
       *
    FROM
        estacion
        ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-05  9:59:04
