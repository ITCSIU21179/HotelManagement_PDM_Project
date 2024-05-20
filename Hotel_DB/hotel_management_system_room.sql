-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hotel_management_system
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `Room_id` int NOT NULL AUTO_INCREMENT,
  `Floor` tinyint NOT NULL,
  `Status` enum('occupied','empty') NOT NULL,
  `Type_name` varchar(45) NOT NULL,
  `Hotel_id` varchar(50) NOT NULL,
  PRIMARY KEY (`Room_id`),
  KEY `Hotel_id_idx` (`Hotel_id`),
  KEY `Type_name_idx` (`Type_name`),
  CONSTRAINT `Hotel_id` FOREIGN KEY (`Hotel_id`) REFERENCES `hotel` (`Hotel_id`),
  CONSTRAINT `Type_name` FOREIGN KEY (`Type_name`) REFERENCES `roomtype` (`Type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (102,1,'empty','Single','H1'),(103,1,'occupied','Single','H1'),(104,1,'empty','Single','H1'),(105,1,'empty','Single','H1'),(106,1,'empty','Single','H1'),(107,1,'empty','Single','H1'),(108,1,'empty','Single','H1'),(201,2,'occupied','Double','H1'),(202,2,'empty','Double','H1'),(203,2,'empty','Double','H1'),(204,2,'occupied','Double','H1'),(205,2,'empty','Double','H1'),(206,2,'empty','Double','H1'),(301,3,'empty','Family','H1'),(302,3,'empty','Family','H1'),(303,3,'empty','Family','H1'),(304,3,'empty','Family','H1'),(305,3,'occupied','Family','H1'),(401,4,'empty','Group','H1'),(402,4,'empty','Group','H1'),(403,4,'empty','Group','H1'),(404,4,'empty','Group','H1'),(999,5,'occupied','Luxury','H1');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-20 14:26:02
