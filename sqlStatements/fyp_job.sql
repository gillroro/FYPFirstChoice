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
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `JobId` int(11) NOT NULL AUTO_INCREMENT,
  `jobName` varchar(45) DEFAULT NULL,
  `Description` varchar(150) DEFAULT NULL,
  `department` varchar(70) DEFAULT NULL,
  `closing_date` date DEFAULT NULL,
  PRIMARY KEY (`JobId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (5,'Sales Supervisor','Sales Supervisor','Sales','2014-04-27'),(6,'Marketing Manager','Marketing Manager','Marketing','2014-05-27'),(7,'IT Consultant','IT Consultant','IT','2014-06-21'),(8,'IT Consultant','New IT Consultant Role','IT','2014-04-29'),(11,'Accounting Supervisor','Accounting Supervisor','Accounts','2014-04-28'),(12,'Graduate Recruitment Consultant','Graduate Recruitment Consultant','Human Resources','2014-06-22'),(13,'Recruitment Consultant','Recruitment Consultant','Human Resources','2014-05-23'),(14,'it','it','IT','2014-03-03'),(15,'Training Officer','Training Officer','Human Resources','2014-04-25'),(16,'IT Consultant','IT Consultant','IT','2014-04-26'),(17,'Accountant','Accountant','Accounts','2014-03-04'),(18,NULL,'Drink and drive','driver control','2014-04-02'),(19,NULL,'Test','Test','2014-07-12'),(20,NULL,'Test','Driver','2014-06-08'),(21,'Test','Test','Test','2014-05-10'),(22,'','','',NULL);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-27 22:40:47
