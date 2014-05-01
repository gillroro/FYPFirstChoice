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
-- Table structure for table `holiday`
--

DROP TABLE IF EXISTS `holiday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holiday` (
  `holiday_id` int(11) NOT NULL AUTO_INCREMENT,
  `date1` date DEFAULT NULL,
  `date2` date DEFAULT NULL,
  `date3` date DEFAULT NULL,
  `employeeName` varchar(45) DEFAULT NULL,
  `approved` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`holiday_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday`
--

LOCK TABLES `holiday` WRITE;
/*!40000 ALTER TABLE `holiday` DISABLE KEYS */;
INSERT INTO `holiday` VALUES (2,'2014-02-09','2014-03-02','2014-04-27','Jack','Awaiting'),(3,'2014-02-09','2014-05-20','2014-07-27','Mary','Awaiting'),(4,'2014-02-23','2014-06-22','2014-10-19','Aaron','Awaiting'),(5,'2014-02-16','2014-06-15','2014-07-20','Poppy','Awaiting'),(6,'2014-03-11','2014-03-25','2014-03-24','Megan','Awaiting'),(7,'2014-04-27','2014-06-01','2014-08-03','Sarah','Awaiting'),(8,'2014-04-14','2014-06-01','2014-07-27','Poppy','Approved'),(9,'2014-05-01','2014-06-05','2014-07-28','Vikki','Awaiting'),(10,'2014-05-03','2014-07-12','2014-10-11','Sarah','Approved'),(11,'2014-05-10','2014-07-19','2014-11-27','Sarah','Approved'),(12,'2014-05-11','2014-06-01','2014-07-06','Sarah','Approved'),(13,'2014-05-18','2014-06-01','2014-06-07','Sarah','Approved');
/*!40000 ALTER TABLE `holiday` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-02  0:25:02
