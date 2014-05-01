CREATE DATABASE  IF NOT EXISTS `fyp` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fyp`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: fyp
-- ------------------------------------------------------
-- Server version	5.1.50-community

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `user_type` varchar(45) NOT NULL DEFAULT 'employee',
  `manager` varchar(50) DEFAULT NULL,
  `bonus` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Gillian','Rowan','gillianrowan','test','123 Yellow Lane, Wicklow',45000,'manager',NULL,NULL),(7,'Sarah','Thornton','sarahthornton','test','Kevin Street, Dublin City',28000,'employee','Gillian',NULL),(13,'Mary','Regan','maryregan','test','Dundrum Town Centre, Dublin',45000,'manager','Gillian',NULL),(14,'Matthew','Ryan','matthewryan','test','South Circular Road, Dublin',34000,'employee','Gillian',4500),(15,'Jack','Rowan','jackrowan','test','1 Castle Field Wicklow',123456,'employee','Gillian',NULL),(17,'Poppy','Doyle','poppydoyle','test','Dublin Road, Carlow',12345,'employee','Gillian',3750),(18,'Aaron','Turner','aaronturner','test','Phoneix Park, Dublin City',1234,'employee','Gillian',1000),(20,'Andrew','Rice','andrewrice','test','108, Dublin',2345,'employee','Mary',NULL),(22,'Megan M','Murphy','meganmurphy','test','The Beacon, Sandyford',35000,'employee','Mary',NULL),(24,'Ronan','Sharkey','ronansharkey','test','Rathfarnam, Dublin',30000,'employee','Mary',NULL),(27,'Vikki','Rowan','vikkirowan','test','24 Crinion Park Wicklow Town',25000,'employee','Gillian',3750),(29,'Ian','Wisely','ianwisely','test','145 Dublin Heights, Dublin',30000,'employee','Gillian',NULL),(30,'Myles','Rowan','mylesrowan','test','Main Street, Wicklow',23000,'employee','Gillian',NULL),(31,'Megan','Maguire','meganmaguire','test','Aungier Street Dublin ',12345,'employee','Gillian',NULL),(32,'Olive','Maguire','olivemaguire','test','Maynooth, Kildare',12345,'employee','Gillian',NULL),(33,'Linda','Chen','lindachen','Password','123 Henry Street, Dublin City',34000,'employee','Gillian',NULL),(34,'Fiona ','Brosnan','fionabrosnan','test','Tallaght, Dublin',40000,'employee','Mary',NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-02  0:24:59
