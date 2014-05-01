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
  `Description` varchar(300) DEFAULT NULL,
  `department` varchar(70) DEFAULT NULL,
  `closing_date` date DEFAULT NULL,
  PRIMARY KEY (`JobId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (5,'Sales Supervisor','Sales Supervisor','Sales','2014-04-27'),(6,'Marketing Manager','The successful candidate will have previous experience in a marketing role of managing the full marketing mix and delivering creative campaigns through-the-line. Extensive experience of digital marketing is important.','Marketing','2014-05-27'),(7,'IT Consultant','Seeking an experienced IT consultant 10 years + to be involved in the implementation of several finance based systems. ','IT','2014-06-21'),(8,'IT Consultant','Seeking an experienced IT consultant 10 years + to be involved in the implementation of several finance based systems. ','IT','2014-04-29'),(11,'Audit Senior','This is an excellent opportunity to work with a broad range of clients and further your experience in the industry','Accounts','2014-04-28'),(12,'Human Resources Manager','Responsible for all aspects of the Human Resources function, while contributing to the overall achievement of business goals and to the profitability of the company through the monitoring of recruitment and labour turnover','Human Resources','2014-06-22'),(13,'Recruitment Consultant','The ideal candidate will be a self motivated, ambitious person who can work without guidance.','Human Resources','2014-05-23'),(14,'Junior QA Analyst','The QA & Testing Senior Analyst will participate in the hands on test creation, manual analysis and reporting of functional and non-functional testing activities.  The QA & Testing Senior Analyst will work on tasks identified in the testing strategy and plan.','QA','2014-03-03'),(15,'Training Specialist','You will ideally be coming from an IT Training background, but really, if you have strong corporate training experience, across other disciplines, you will absolutely be considered as you will be given the support to assimilate.','Human Resources','2014-04-25'),(16,'IT Consultant','The role offers the successful candidate the opportunity to continue to build on their existing IT skills and add strategic business-focused consulting skills, enabling them to operate at a more senior level and add greater value. ','IT','2014-04-26'),(17,'Fund Accountant','Evaluates and reconciles funds including mutual, commingled, and collective for production of client month-end reports or for daily valuation. Verifies transactions, audits income reports within scheduled timeframes and resolves exceptions on a daily basis for fund accounts.','Accounts','2014-03-04'),(19,'Business & Pricing Analyst','Develop management information to deliver insightful business analysis','Analysis','2014-07-12'),(20,'Network Analyst','The Network Analyst will be accountable for entry monitoring of payments platform. The scope includes hardware, operating systems, network, security and payments platform and batches associated with payments. ','IT','2014-06-08'),(21,'Pmo Project Manager',' The successful candidate will work across the organisation and will participate in developing, designing, and delivering process improvement.','Project Management','2014-05-10'),(23,'Java Software Engineer','You will be working within their tools team developing a specific cloud based translation management system in order to assist their development teams manage the continuous localisation process required to meet the company agile development needs.','IT','2014-06-07'),(43,'Business Development Manager','The organisation is looking to expand its sales team and explore new business opportunities','Sales','2014-06-07');
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

-- Dump completed on 2014-05-02  0:24:56
