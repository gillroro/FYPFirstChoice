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
  `manager` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Gillian','Rowan','gillian','test','wicklow',45000,'manager',NULL),(7,'Sarah','Thornton','sarah','test','Dublin',28000,'employee',1),(13,'Mary','Regan','mary','test','Dublin',45000,'employee',1),(14,'Matthew','Ryan','matthew','test','Dublin',34000,'employee',1),(15,'Jack','Rowan','jrowan','test','Wicklow',123456,'employee',1),(16,'Sarah','Thornton','sarah123','test','Dublin',1234,'employee',1),(17,'Poppy','Doyle','poppy','test','Waterford',12345,'employee',1),(18,'Aaron','Turner','aaron','test','Dublin',1234,'employee',1),(19,'Mary','Matthews','mm','test','Dublin',2345,'employee',1),(20,'Andrew','R','andrew','Password','Dublin',2345,'employee',1),(22,'Megan','Murphy','megan','test','Dublin',1234,'employee',1),(23,'Mary','Regan','mary345','test','Dublin',12345,'employee',1);
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

-- Dump completed on 2014-04-21 20:11:51
