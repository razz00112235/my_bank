-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: tcg_bank
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `customer_amount_data`
--

DROP TABLE IF EXISTS `customer_amount_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_amount_data` (
  `c_id` int DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `trans_type` varchar(50) DEFAULT NULL,
  `remain_amount` float DEFAULT NULL,
  `amount_date_time` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_amount_data`
--

LOCK TABLES `customer_amount_data` WRITE;
/*!40000 ALTER TABLE `customer_amount_data` DISABLE KEYS */;
INSERT INTO `customer_amount_data` VALUES (1,5000,'CR',5000,'16-03-2023 09:47:33'),(1,15000,'CR',20000,'16-03-2023 09:47:46'),(1,1000,'DR',19000,'16-03-2023 09:47:58'),(2,2000,'Send By TCG1000001',2000,'16-03-2023 10:16:37'),(1,2000,'Send By TCG1000001',17000,'16-03-2023 10:16:37'),(3,0,'Open Ac',0,'16-03-2023 10:22:11'),(1,1000000,'CR',1017000,'16-03-2023 10:23:15'),(1,1000,'CR',1018000,'16-03-2023 10:23:35'),(1,1000,'CR',1019000,'16-03-2023 10:26:00'),(3,10000,'CR',10000,'16-03-2023 10:29:04'),(3,2000000,'CR',2010000,'16-03-2023 10:29:22'),(1,10000,'DR',1009000,'16-03-2023 10:29:44'),(3,100,'DR',2009900,'16-03-2023 10:32:01'),(1,900,'Send By TCG1000003',1009900,'16-03-2023 10:32:22'),(3,900,'Send By TCG1000003',2009000,'16-03-2023 10:32:22'),(1,5000,'Send By TCG1000003',1014900,'16-03-2023 10:33:05'),(3,5000,'Send By TCG1000003',2004000,'16-03-2023 10:33:05'),(1,1000,'Send By TCG1000003',1015900,'16-03-2023 10:35:11'),(3,1000,'Send By TCG1000003',2003000,'16-03-2023 10:35:11'),(1,500,'Send By TCG1000003',1016400,'16-03-2023 10:40:48'),(3,500,'Send By TCG1000003',2002500,'16-03-2023 10:40:48'),(1,200,'Send By TCG1000003',1016600,'16-03-2023 10:42:38'),(3,200,'Send By TCG1000003',2002300,'16-03-2023 10:42:38'),(3,100,'CR',2002400,'16-03-2023 10:42:55'),(3,50,'DR',2002350,'16-03-2023 10:43:02'),(1,150,'Send By TCG1000003',1016750,'16-03-2023 10:43:16'),(3,150,'Send By TCG1000003',2002200,'16-03-2023 10:43:16'),(1,100,'Send By TCG1000003',1016850,'16-03-2023 10:46:32'),(3,100,'Send By TCG1000003',2002100,'16-03-2023 10:46:32'),(1,100,'Send By TCG1000003',1016950,'16-03-2023 10:46:46'),(3,100,'Send By TCG1000003',2002000,'16-03-2023 10:46:46'),(3,5000,'CR',2007000,'16-03-2023 10:48:35'),(3,3000,'DR',2004000,'16-03-2023 10:48:42'),(1,100,'Send By TCG1000003',1017050,'16-03-2023 10:50:28'),(3,100,'Send By TCG1000003',2003900,'16-03-2023 10:50:28'),(1,200,'Send By TCG1000003',1017250,'16-03-2023 10:54:06'),(3,200,'Send By TCG1000003',2003700,'16-03-2023 10:54:06'),(3,50,'CR',2003750,'16-03-2023 10:54:19'),(4,0,'Open Ac',0,'16-03-2023 10:59:11'),(4,10000,'CR',10000,'16-03-2023 11:00:01'),(4,5000,'CR',15000,'16-03-2023 11:00:19'),(4,100,'DR',14900,'16-03-2023 11:00:25'),(1,500,'Send To TCG1000001',1017750,'16-03-2023 11:00:46'),(4,500,'Send To TCG1000001',14400,'16-03-2023 11:00:46'),(1,500,'CR',1018250,'16-03-2023 11:41:12'),(1,120,'CR',1018370,'16-03-2023 11:50:57'),(5,0,'Open Ac',0,'16-03-2023 15:17:58');
/*!40000 ALTER TABLE `customer_amount_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_data`
--

DROP TABLE IF EXISTS `customer_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_data` (
  `customer_id` int DEFAULT NULL,
  `c_fistname` varchar(50) DEFAULT NULL,
  `c_lastname` varchar(50) DEFAULT NULL,
  `c_fname` varchar(50) DEFAULT NULL,
  `c_mname` varchar(50) DEFAULT NULL,
  `c_address` varchar(300) DEFAULT NULL,
  `c_city` varchar(50) DEFAULT NULL,
  `c_state` varchar(100) DEFAULT NULL,
  `c_mail` varchar(100) DEFAULT NULL,
  `c_pan` varchar(20) DEFAULT NULL,
  `c_phone` varchar(20) DEFAULT NULL,
  `account_type` varchar(100) DEFAULT NULL,
  `user_account_no` varchar(30) DEFAULT NULL,
  `account_create_date` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_data`
--

LOCK TABLES `customer_data` WRITE;
/*!40000 ALTER TABLE `customer_data` DISABLE KEYS */;
INSERT INTO `customer_data` VALUES (1,'Nyasa','Yadav','Meghraj Yadav','Annu','jagatpura	','Jaipur','Rajasthan','meghrajyadav.yadav20@gmail.com','123456','9079039554','Current Account','TCG1000001',NULL),(2,'Ramkishor','Yadav','Sardarmal','Banarsi','jaipur','jaipur','rajasthan','ramkishoreyadav1994@gmail.com','123456','9782465768','Current Account','TCG1000002','14-03-2023 11:51:16'),(3,'Karmpal','Kumar','Mahendra Singh','Taskor Devi','Chirawa','Chirawa','Rajasthan','karmpalkumar20@gmail.com','123456','7742603594','Saving Account','TCG1000003','16-03-2023 10:22:11'),(4,'Mahendra','Yadav','Gangaram','Bhagwati','chomu','jaipur','rajasthan','mkyadav125@gmail.com','123456','9024072451','Saving Account','TCG1000004','16-03-2023 10:59:11'),(5,'demo','demo','demo','dmo','demo','sfs','sf','meghrajyadav.yadav201@gmail.com','123456','123456','Saving Account','TCG1000005','16-03-2023 15:17:58');
/*!40000 ALTER TABLE `customer_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_login_data`
--

DROP TABLE IF EXISTS `customer_login_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_login_data` (
  `customer_id` int DEFAULT NULL,
  `c_mail` varchar(50) DEFAULT NULL,
  `c_pass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_login_data`
--

LOCK TABLES `customer_login_data` WRITE;
/*!40000 ALTER TABLE `customer_login_data` DISABLE KEYS */;
INSERT INTO `customer_login_data` VALUES (1,'meghrajyadav.yadav20@gmail.com','122351'),(2,'ramkishoreyadav1994@gmail.com','250478'),(3,'karmpalkumar20@gmail.com','615328'),(4,'mkyadav125@gmail.com','93516'),(5,'meghrajyadav.yadav201@gmail.com','869806');
/*!40000 ALTER TABLE `customer_login_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-16 15:38:23
