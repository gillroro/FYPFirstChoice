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
-- Table structure for table `appraisal`
--

DROP TABLE IF EXISTS `appraisal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appraisal` (
  `AppraisalId` int(11) NOT NULL AUTO_INCREMENT,
  `employeeName` varchar(45) DEFAULT NULL,
  `accomplishments` varchar(200) DEFAULT NULL,
  `barriers` varchar(200) DEFAULT NULL,
  `improvements` varchar(200) DEFAULT NULL,
  `performance` varchar(200) DEFAULT NULL,
  `attendance` varchar(45) DEFAULT NULL,
  `respect` varchar(45) DEFAULT NULL,
  `projectDetails` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`AppraisalId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appraisal`
--

LOCK TABLES `appraisal` WRITE;
/*!40000 ALTER TABLE `appraisal` DISABLE KEYS */;
INSERT INTO `appraisal` VALUES (3,'Poppy','Assumed leadership position in the video products division which had been experiencing slow sales and negative profitability from initial product launch.','Divergent goals',' I reduced my workload substantially and I was able to use this spare time to help my manager with his financial reporting','Financial Skills','Very Good','Average Respect for others','Completion Project was completed on the 14/4.'),(4,'Jack','Video products sales increased from $50,000 to 100,000 in just 4 months and continually grew unit sales by 20% each year from 2000 to 2005.','Lack of support','Being a reliable source for your department leader and seeing opportunities for your department to improve ','Leadership Skills','Excellent','Very Respectful','Completion Project was completed by the team as a whole'),(5,'Mary','Helped the company save money or reduce costs','None of the team seemed to appreciate why a plan was useful.','Share ideas with context and a clear path for implementation for the leader to evaluate','Development Skills','Excellent','Very Respectful','Incompletion of project due to poor requirements'),(6,'Sarah','Implemented processes that save time or increase work productivity','Divergent goals',' I reduced my workload substantially and I was able to use this spare time to help my manager with his financial reporting','Financial Skills','Very Good','Very Respectful','Completion Project was completed by the team as a whole'),(7,'Aaron','Improved company\'s competitive advantage in the marketplace','None of the team seemed to appreciate why a plan was useful.','Share ideas with context and a clear path for implementation for the leader to evaluate','Better Communication Skills','Very Good','Very Respectful','Incompletion of project due to poor staff morale'),(8,'Sarah','Enhanced corporate image or building company\'s reputation in its industry','Lack of support','Improved my communication skills ','Better Communication Skills','Average','Average Respect for others','Incompletion of project due to poor requirements'),(9,'Poppy','Made money for the company','All the team members were feeling pressure to make progress as time was short','Being a reliable source for your department leader and seeing opportunities for your department to improve ','Development Skills','Excellent','Average Respect for others','Completion Project was completed by the team as a whole'),(10,'Poppy','Introduced new marketing initiatives','Divergent goals','Improved my communication skills ','Software Development Skills','Excellent','Very Respectful','Incompletion of project due to poor requirements'),(11,'Poppy','helped the company form strategic alliances with regional distributors and vendors','Problems were not noticed by senior managers','Improved my communication skills ','Talent Acquistion Skills','Excellent','Poor Respect for Others','Completion Project was completed by the team as a whole'),(13,'Poppy','Helped the company save money or reduce costs','None of the team seemed to appreciate why a plan was useful.',' I reduced my workload substantially and I was able to use this spare time to help my manager with his financial reporting','Leadership Skills','Average','Poor Respect for Others','Completion Project was completed by the team on the 29/3/14'),(14,'Vikki','Enhanced corporate image or building company\'s reputation in its industry','Lack of support','Share ideas with context and a clear path for implementation for the leader to evaluate','Better Reporting  Skills','Excellent','Very Respectful','Completion my project assignment was completed to the best of my ability');
/*!40000 ALTER TABLE `appraisal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-02  0:25:03
