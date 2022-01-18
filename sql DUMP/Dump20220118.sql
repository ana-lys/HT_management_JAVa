-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: connector
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `ca_lv`
--

DROP TABLE IF EXISTS `ca_lv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ca_lv` (
  `ID_Shift` int NOT NULL,
  `ID_Staff` int DEFAULT NULL,
  `ID_Manager` int DEFAULT NULL,
  `Monday` enum('Allday','Halfday','None') DEFAULT NULL,
  `Tuesday` enum('Allday','Halfday','None') DEFAULT NULL,
  `Wednesday` enum('Allday','Halfday','None') DEFAULT NULL,
  `Thursday` enum('Allday','Halfday','None') DEFAULT NULL,
  `Friday` enum('Allday','Halfday','None') DEFAULT NULL,
  `Saturday` enum('Allday','Halfday','None') DEFAULT NULL,
  `Sunday` enum('Allday','Halfday','None') DEFAULT NULL,
  `From_Date` date NOT NULL,
  `To_Date` date DEFAULT NULL,
  PRIMARY KEY (`ID_Shift`,`From_Date`),
  UNIQUE KEY `ID_shift_UNIQUE` (`ID_Shift`) /*!80000 INVISIBLE */,
  KEY `ID_employee` (`ID_Staff`) /*!80000 INVISIBLE */,
  KEY `ID_manager` (`ID_Manager`),
  CONSTRAINT `ID_Manager` FOREIGN KEY (`ID_Manager`) REFERENCES `quan_ly` (`ID_Manager`),
  CONSTRAINT `ID_Staff` FOREIGN KEY (`ID_Staff`) REFERENCES `nhan_vien` (`ID_Staff`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ca_lv`
--

LOCK TABLES `ca_lv` WRITE;
/*!40000 ALTER TABLE `ca_lv` DISABLE KEYS */;
/*!40000 ALTER TABLE `ca_lv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `don_dich_vu`
--

DROP TABLE IF EXISTS `don_dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `don_dich_vu` (
  `ID_Service_Order` int NOT NULL AUTO_INCREMENT,
  `ID_Contract` int NOT NULL,
  `ID_Service` int NOT NULL,
  `Date_Time_order` datetime NOT NULL,
  `Multiplier` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID_Service_Order`),
  UNIQUE KEY `id dich vu_UNIQUE` (`ID_Service_Order`) /*!80000 INVISIBLE */,
  KEY `ID_ServiceType` (`ID_Service`),
  KEY `ID_Contract` (`ID_Contract`),
  CONSTRAINT `don_dich_vu_ibfk_1` FOREIGN KEY (`ID_Contract`) REFERENCES `hop_dong` (`ID_Contract`),
  CONSTRAINT `ID_Service` FOREIGN KEY (`ID_Service`) REFERENCES `gia_dich_vu` (`ID_Service`)
) ENGINE=InnoDB AUTO_INCREMENT=1000016 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `don_dich_vu`
--

LOCK TABLES `don_dich_vu` WRITE;
/*!40000 ALTER TABLE `don_dich_vu` DISABLE KEYS */;
INSERT INTO `don_dich_vu` VALUES (1000001,10004,14,'2022-01-18 18:26:53',2),(1000002,10004,15,'2022-01-18 19:01:11',1),(1000003,10004,15,'2022-01-18 19:01:18',4),(1000004,10002,12,'2022-01-18 19:24:07',1),(1000005,10002,21,'2022-01-18 19:24:17',2),(1000006,10006,12,'2022-01-18 19:24:24',4),(1000007,10009,15,'2022-01-18 19:44:01',3),(1000008,10009,13,'2022-01-18 19:44:05',3),(1000009,10009,14,'2022-01-18 19:45:57',3),(1000010,10008,14,'2022-01-18 19:46:09',3),(1000011,10007,14,'2022-01-18 19:46:10',3),(1000012,10001,14,'2022-01-18 19:46:12',3),(1000013,10006,23,'2022-01-18 19:46:51',6),(1000014,10009,12,'2022-01-18 19:58:20',2),(1000015,10009,21,'2022-01-18 22:44:24',1);
/*!40000 ALTER TABLE `don_dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gia_dich_vu`
--

DROP TABLE IF EXISTS `gia_dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gia_dich_vu` (
  `ID_Service` int NOT NULL,
  `Description` varchar(45) NOT NULL,
  `Service_Price` int NOT NULL,
  `From_Date` date NOT NULL,
  `To_Date` date DEFAULT NULL,
  PRIMARY KEY (`ID_Service`,`From_Date`),
  KEY `fr Date` (`From_Date`) /*!80000 INVISIBLE */,
  KEY `to Date` (`To_Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gia_dich_vu`
--

LOCK TABLES `gia_dich_vu` WRITE;
/*!40000 ALTER TABLE `gia_dich_vu` DISABLE KEYS */;
INSERT INTO `gia_dich_vu` VALUES (11,'Vodka',100,'2001-01-01',NULL),(12,'Teiquila',255,'2001-01-01','2020-12-31'),(12,'Teiquila',275,'2021-01-01',NULL),(13,'Coke',30,'2001-01-01',NULL),(14,'Fanta',40,'2001-01-01','2022-01-01'),(14,'Fanta',45,'2022-01-01',NULL),(15,'Sprite',55,'2001-01-01',NULL),(21,'FruitBasket',60,'2001-01-01',NULL),(22,'BloodyMary',75,'2001-01-01',NULL),(23,'MidNIghtPulse',80,'2001-01-01',NULL);
/*!40000 ALTER TABLE `gia_dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gia_phong`
--

DROP TABLE IF EXISTS `gia_phong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gia_phong` (
  `Room_Class` enum('Queen','King','Deluxe','Classic','Single') NOT NULL,
  `Room_Price` int NOT NULL,
  `Room_Deposit` int NOT NULL,
  `From_Date` date NOT NULL,
  `To_Date` date DEFAULT NULL,
  PRIMARY KEY (`Room_Class`,`From_Date`),
  KEY `from` (`From_Date`) /*!80000 INVISIBLE */,
  KEY `to` (`To_Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gia_phong`
--

LOCK TABLES `gia_phong` WRITE;
/*!40000 ALTER TABLE `gia_phong` DISABLE KEYS */;
INSERT INTO `gia_phong` VALUES ('Queen',1200,650,'2021-01-01','2021-02-01'),('Queen',2200,1200,'2021-02-02','2021-02-14'),('Queen',2500,1400,'2021-02-15','2022-01-15'),('Queen',2400,1200,'2022-01-15',NULL),('King',2500,2000,'2022-01-02','2022-01-15'),('King',3000,2000,'2022-01-16',NULL),('Deluxe',2000,1000,'2021-01-01',NULL),('Classic',1000,600,'2021-01-01','2021-05-31'),('Classic',1050,625,'2021-06-01',NULL),('Single',700,500,'2021-01-01','2021-05-31'),('Single',750,525,'2021-06-01',NULL);
/*!40000 ALTER TABLE `gia_phong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hop_dong`
--

DROP TABLE IF EXISTS `hop_dong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hop_dong` (
  `ID_Contract` int NOT NULL AUTO_INCREMENT,
  `ID_Room` int NOT NULL,
  `ID_KH` int NOT NULL,
  `Date_CheckIn` date NOT NULL,
  `Date_CheckOut` date NOT NULL,
  `Date_Payment` date DEFAULT NULL,
  `Status` enum('OnGoing','Finished','Booked') NOT NULL DEFAULT 'OnGoing',
  PRIMARY KEY (`ID_Contract`),
  KEY `ID_KH` (`ID_KH`) /*!80000 INVISIBLE */,
  KEY `ID_ROOM` (`ID_Room`) /*!80000 INVISIBLE */,
  CONSTRAINT `hop_dong_ibfk_1` FOREIGN KEY (`ID_Room`) REFERENCES `phong` (`ID_Room`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ID_KH` FOREIGN KEY (`ID_KH`) REFERENCES `khach_hang` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10014 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hop_dong`
--

LOCK TABLES `hop_dong` WRITE;
/*!40000 ALTER TABLE `hop_dong` DISABLE KEYS */;
INSERT INTO `hop_dong` VALUES (10001,101,2500,'2021-12-20','2021-12-25','2021-12-25','Finished'),(10002,102,2501,'2021-12-25','2021-12-30',NULL,'OnGoing'),(10003,105,2502,'2022-01-04','2022-01-05',NULL,'OnGoing'),(10004,104,2501,'2022-02-01','2022-02-06',NULL,'OnGoing'),(10006,107,2501,'2022-01-04','2022-01-07',NULL,'OnGoing'),(10007,106,2500,'2022-03-04','2022-03-10',NULL,'OnGoing'),(10008,102,2500,'2022-03-04','2022-03-10',NULL,'OnGoing'),(10009,105,2502,'2022-02-02','2022-02-05',NULL,'OnGoing'),(10010,105,2503,'2022-01-01','2022-01-05',NULL,'OnGoing'),(10011,109,2503,'2022-01-01','2022-01-05',NULL,'OnGoing'),(10012,104,2503,'2022-01-01','2022-01-05',NULL,'OnGoing'),(10013,102,2502,'2022-01-04','2022-01-06',NULL,'OnGoing');
/*!40000 ALTER TABLE `hop_dong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khach_hang` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  `Creditcard` varchar(15) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Citizen_id` varchar(15) NOT NULL,
  `Date_contacted` date NOT NULL,
  `Accompany` int NOT NULL,
  `Photo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `Citizen_id_UNIQUE` (`Citizen_id`),
  UNIQUE KEY `Phone_UNIQUE` (`Phone`),
  UNIQUE KEY `Creditcard_UNIQUE` (`Creditcard`)
) ENGINE=InnoDB AUTO_INCREMENT=2522 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` VALUES (2500,'Ho Van Hoang','0154323235','13464121113','36 hoang hoa tham','01234567849','2021-12-18',1,NULL),(2501,'Tran Thang','013146461','6416311231','2 ho tung mau','01334567849','2021-10-01',2,NULL),(2502,'Trinh Xuan Thanh','0465672235','68687121113','35 Ngu Trong Phong Thu','02564547849','2021-10-12',3,NULL),(2503,'Ha CHINH QUY','4654212','6855461113','36 hoang thuong','01544567849','2021-11-16',3,NULL),(2504,'Ha Tuyen Quang','014452235','685464121113','36 hoang thao','02564567849','2021-10-12',2,NULL),(2505,'Tran Van Cong','03416434217','46461313111','23 tam hoang','01133866679','2021-12-15',5,NULL),(2506,'Ly Xuan Son ','0341345641','46455348111','26 giai phong','03246755549','2021-12-12',3,NULL),(2507,'Tran Xuan Hoa','0232411444','4954954554','34 chi thanh','04534456849','2021-11-13',3,NULL),(2508,'LE TUAN','0145666461','245211231','3 tran cao','02634567849','2021-09-12',4,NULL),(2509,'Lmao Lsay','0544146461','6513511231','26 doi can','03224567849','2021-10-01',1,NULL),(2510,'YVAn Chuck','039411233','340304333','26 dyen hoa','04165415641','2021-10-03',2,NULL),(2512,'CHÂU TINH TINH','0154545621','0231984777','36 Hong Kong','012012456565','2021-12-15',2,NULL),(2513,'Doãn Chí Bình','015664744652','013121144541','23 Hồ Thuyền Quang','02156646411','2021-09-14',2,NULL),(2515,'Nguễn Văn Hân','06150615061','01260126012','651 Giải Phóng','016164674741','2021-12-15',1,NULL),(2516,'Giàng A Sử','0123131348644','151165145451','23 Nguyễn Trãi','01541564654','2021-12-15',1,NULL),(2521,'Jay-Z','013168421241','021315215111','24 GayVill Street','0161141641','2022-01-11',1,NULL);
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khu_vuc`
--

DROP TABLE IF EXISTS `khu_vuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khu_vuc` (
  `ID_Sector` int NOT NULL AUTO_INCREMENT,
  `ID_Manager` int NOT NULL,
  `From_Date` date NOT NULL,
  `To_Date` date DEFAULT NULL,
  PRIMARY KEY (`ID_Sector`,`From_Date`),
  KEY `ManagerID` (`ID_Manager`),
  CONSTRAINT `managerID` FOREIGN KEY (`ID_Manager`) REFERENCES `quan_ly` (`ID_Manager`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khu_vuc`
--

LOCK TABLES `khu_vuc` WRITE;
/*!40000 ALTER TABLE `khu_vuc` DISABLE KEYS */;
INSERT INTO `khu_vuc` VALUES (1,1001,'2021-01-01',NULL),(2,1001,'2021-01-01',NULL);
/*!40000 ALTER TABLE `khu_vuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_vien` (
  `ID_Staff` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Phone` varchar(45) NOT NULL,
  `Age` int DEFAULT NULL,
  `Class` enum('Cleaner','Reservationist','Security') DEFAULT NULL,
  `Photos` varchar(45) DEFAULT NULL,
  `ID_Sector` int NOT NULL,
  PRIMARY KEY (`ID_Staff`),
  KEY `Sector_ID` (`ID_Sector`),
  CONSTRAINT `sector_ID` FOREIGN KEY (`ID_Sector`) REFERENCES `khu_vuc` (`ID_Sector`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phong`
--

DROP TABLE IF EXISTS `phong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phong` (
  `ID_Room` int NOT NULL AUTO_INCREMENT,
  `ID_Sector` int NOT NULL,
  `Room_Class` enum('Queen','King','Deluxe','Classic','Single') NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `Ready` int DEFAULT '1',
  `Photo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_Room`),
  UNIQUE KEY `ID_Room_UNIQUE` (`ID_Room`),
  KEY `Room_Class` (`Room_Class`) /*!80000 INVISIBLE */,
  KEY `SectorID` (`ID_Sector`),
  CONSTRAINT `Room_Class` FOREIGN KEY (`Room_Class`) REFERENCES `gia_phong` (`Room_Class`),
  CONSTRAINT `SectorID` FOREIGN KEY (`ID_Sector`) REFERENCES `khu_vuc` (`ID_Sector`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phong`
--

LOCK TABLES `phong` WRITE;
/*!40000 ALTER TABLE `phong` DISABLE KEYS */;
INSERT INTO `phong` VALUES (101,1,'Queen','abcd',1,NULL),(102,1,'Deluxe','abcd',1,NULL),(103,1,'King',NULL,1,NULL),(104,1,'Single','abcd',1,NULL),(105,1,'Classic','abcd',1,NULL),(106,2,'Single',NULL,1,NULL),(107,2,'Deluxe',NULL,1,NULL),(108,2,'Classic',NULL,1,NULL),(109,2,'King','2 3 5',1,NULL),(110,2,'Queen','456',1,NULL);
/*!40000 ALTER TABLE `phong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quan_ly`
--

DROP TABLE IF EXISTS `quan_ly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quan_ly` (
  `ID_Manager` int NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Phone` varchar(45) NOT NULL,
  `Age` int DEFAULT NULL,
  `Class` enum('Chief','Sector','TeamLeader') NOT NULL DEFAULT 'Sector',
  `Photos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_Manager`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quan_ly`
--

LOCK TABLES `quan_ly` WRITE;
/*!40000 ALTER TABLE `quan_ly` DISABLE KEYS */;
INSERT INTO `quan_ly` VALUES (1001,'Ana Lys','02345678',4,'Chief',NULL);
/*!40000 ALTER TABLE `quan_ly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan_dn`
--

DROP TABLE IF EXISTS `tai_khoan_dn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan_dn` (
  `Acc_ID` int NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(45) NOT NULL,
  `Pass_Word` varchar(45) NOT NULL,
  `Acc_Rank` enum('Owner','Manager','Employee') NOT NULL DEFAULT 'Employee',
  `ID_Staff` int DEFAULT NULL,
  `ID_Manager` int DEFAULT NULL,
  PRIMARY KEY (`Acc_ID`),
  UNIQUE KEY `Acc_ID_UNIQUE` (`Acc_ID`),
  UNIQUE KEY `User_name_UNIQUE` (`User_Name`),
  KEY `ID_Staff` (`ID_Staff`),
  KEY `IDManager_idx` (`ID_Manager`),
  CONSTRAINT `IDManager` FOREIGN KEY (`ID_Manager`) REFERENCES `quan_ly` (`ID_Manager`),
  CONSTRAINT `IDStaff` FOREIGN KEY (`ID_Staff`) REFERENCES `nhan_vien` (`ID_Staff`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan_dn`
--

LOCK TABLES `tai_khoan_dn` WRITE;
/*!40000 ALTER TABLE `tai_khoan_dn` DISABLE KEYS */;
INSERT INTO `tai_khoan_dn` VALUES (101,'AnaLys','Test1','Owner',NULL,NULL),(102,'Employee','Test2','Employee',NULL,NULL),(103,'admin','admin','Employee',NULL,NULL);
/*!40000 ALTER TABLE `tai_khoan_dn` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-18 23:32:44
