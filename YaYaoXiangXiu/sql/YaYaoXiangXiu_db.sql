-- MySQL dump 10.13  Distrib 5.6.21, for Win64 (x86_64)
--
-- Host: localhost    Database: YaYaoXiangXiu_db
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `admin_tb`
--

DROP TABLE IF EXISTS `admin_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AdminType` int(11) DEFAULT NULL,
  `AdminName` varchar(12) DEFAULT NULL,
  `LoginName` varchar(12) DEFAULT NULL,
  `LoginPwd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_tb`
--

LOCK TABLES `admin_tb` WRITE;
/*!40000 ALTER TABLE `admin_tb` DISABLE KEYS */;
INSERT INTO `admin_tb` VALUES (1,1,'商品管理员','shangpin','7cl29cprjcl9i'),(2,2,'会员管理员','huiyuan','7cl29cprjcl9i'),(3,3,'订单管理员','dingdan','7cl29cprjcl9i'),(4,4,'系统管理员','nieyue','3hd1jmemanctmm2ea7cdr58dph'),(6,1,'聂跃','nieyue1','7cl29cprjcl9i'),(97,2,'聂跃','nieyue2','7cl29cprjcl9i'),(98,3,'聂跃','nieyue3','7cl29cprjcl9i'),(99,2,'聂跃11','nieyue11','7cl29cprjcl9i'),(147,4,'ny','nieyue4','7cl29cprjcl9i'),(164,1,'聂跃','nieyue124','7cl29cprjcl9i');
/*!40000 ALTER TABLE `admin_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_tb`
--

DROP TABLE IF EXISTS `cart_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Money` double DEFAULT NULL,
  `CartStatus` int(11) DEFAULT NULL,
  `MemberID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK210BA3EDBA2427B1` (`MemberID`),
  CONSTRAINT `FK210BA3EDBA2427B1` FOREIGN KEY (`MemberID`) REFERENCES `member_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_tb`
--

LOCK TABLES `cart_tb` WRITE;
/*!40000 ALTER TABLE `cart_tb` DISABLE KEYS */;
INSERT INTO `cart_tb` VALUES (82,1998,1,1),(84,13600,1,1),(85,0,0,3),(92,388,1,1),(94,0,0,1);
/*!40000 ALTER TABLE `cart_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartselectedmer_tb`
--

DROP TABLE IF EXISTS `cartselectedmer_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartselectedmer_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Number` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Money` double NOT NULL,
  `cartID` int(11) DEFAULT NULL,
  `orderID` int(11) DEFAULT NULL,
  `merchandiseID` int(11) DEFAULT NULL,
  `OrderStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK599B9C6E3258FBD` (`cartID`),
  KEY `FK599B9C6E9D039FB0` (`orderID`),
  KEY `FK599B9C6E4EA1A93F` (`merchandiseID`),
  CONSTRAINT `FK599B9C6E3258FBD` FOREIGN KEY (`cartID`) REFERENCES `cart_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK599B9C6E4EA1A93F` FOREIGN KEY (`merchandiseID`) REFERENCES `merchandise_tb` (`ID`),
  CONSTRAINT `FK599B9C6E9D039FB0` FOREIGN KEY (`orderID`) REFERENCES `orders_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartselectedmer_tb`
--

LOCK TABLES `cartselectedmer_tb` WRITE;
/*!40000 ALTER TABLE `cartselectedmer_tb` DISABLE KEYS */;
INSERT INTO `cartselectedmer_tb` VALUES (11,3,666,1998,82,11,2,1),(14,2,6800,13600,84,13,14,1),(27,1,388,388,92,20,23,1);
/*!40000 ALTER TABLE `cartselectedmer_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_tb`
--

DROP TABLE IF EXISTS `category_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CateName` varchar(40) DEFAULT NULL,
  `CateDesc` longtext,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_tb`
--

LOCK TABLES `category_tb` WRITE;
/*!40000 ALTER TABLE `category_tb` DISABLE KEYS */;
INSERT INTO `category_tb` VALUES (1,'双面绣','湘绣双面绣知名越来越高！'),(2,'单面绣','湘绣单面绣技艺真的会有飞速发展！'),(3,'小绣','湘绣小绣价值不可估量！'),(11,'sdf多少','sadfsdaf');
/*!40000 ALTER TABLE `category_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_tb`
--

DROP TABLE IF EXISTS `comment_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(60) DEFAULT NULL,
  `Content` longtext,
  `CommentDate` varchar(19) DEFAULT NULL,
  `AnswerContent` longtext,
  `AnswerDate` varchar(19) DEFAULT NULL,
  `MemberID` int(11) DEFAULT NULL,
  `AdminID` int(11) DEFAULT NULL,
  `MerchandiseID` int(11) DEFAULT NULL,
  `ExclusiveCustomID` int(11) DEFAULT NULL,
  `memberCommentIndex` int(11) DEFAULT NULL,
  `adminCommentIndex` int(11) DEFAULT NULL,
  `merchandiseCommentIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK3597F44EBA2427B1` (`MemberID`),
  KEY `FK3597F44EAD702F7` (`ExclusiveCustomID`),
  KEY `FK3597F44EFC7833D7` (`AdminID`),
  KEY `FK3597F44E4EA1A93F` (`MerchandiseID`),
  CONSTRAINT `FK3597F44E4EA1A93F` FOREIGN KEY (`MerchandiseID`) REFERENCES `merchandise_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK3597F44EAD702F7` FOREIGN KEY (`ExclusiveCustomID`) REFERENCES `exclusivecustom_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK3597F44EBA2427B1` FOREIGN KEY (`MemberID`) REFERENCES `member_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK3597F44EFC7833D7` FOREIGN KEY (`AdminID`) REFERENCES `admin_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_tb`
--

LOCK TABLES `comment_tb` WRITE;
/*!40000 ALTER TABLE `comment_tb` DISABLE KEYS */;
INSERT INTO `comment_tb` VALUES (20,'好评!','sdf ','2015-09-21 10:08:19',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(21,'中评!','sd ','2015-09-21 10:08:40',NULL,NULL,1,NULL,6,NULL,NULL,NULL,NULL),(24,'好评!','撒地方','2015-09-21 18:31:21',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(25,'好评!','是打发 ','2015-09-21 18:31:31',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(26,'中评!','萨芬的','2015-09-21 18:31:49',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(27,'差评!','是打发','2015-09-21 18:31:55',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(28,'好评!','阿道夫','2015-09-21 18:32:02',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(29,'好评!','富士达','2015-09-21 18:32:09',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(30,'中评!','萨芬的','2015-09-21 18:32:18',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(31,'好评!','是打发','2015-09-21 18:32:24',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(32,'差评!','四方达','2015-09-21 18:32:29',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(33,'中评!','是打发','2015-09-21 18:32:36',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(34,'好评!','地方撒','2015-09-21 18:36:42',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(35,'中评!','是打发','2015-09-21 18:36:49',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(36,'好评!','sdaf sd','2015-09-21 20:37:42',NULL,NULL,1,NULL,6,NULL,NULL,NULL,NULL),(37,'中评!','sadf ','2015-09-21 20:37:49',NULL,NULL,1,NULL,6,NULL,NULL,NULL,NULL),(38,'好评!','ssdfa ','2015-09-21 20:37:59',NULL,NULL,1,NULL,6,NULL,NULL,NULL,NULL),(39,'好评!','sdaf ','2015-09-21 20:38:05',NULL,NULL,1,NULL,6,NULL,NULL,NULL,NULL),(40,NULL,'第三方','2015-09-22 14:08:17',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(41,NULL,'的','2015-09-22 14:08:24',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(42,NULL,'撒 ','2015-09-22 14:08:28',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(43,NULL,'大方 ','2015-09-22 14:08:33',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(44,NULL,'撒地方四大 ','2015-09-22 14:08:37',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(45,NULL,'是打发倒萨','2015-09-22 14:08:41',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(46,NULL,'是打发','2015-09-22 14:08:52',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(47,NULL,'是打发','2015-09-22 14:08:57',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(48,NULL,'是打发','2015-09-22 14:09:02',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(49,NULL,'撒地方','2015-09-22 14:09:06',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(50,NULL,'是打发','2015-09-22 14:09:10',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(51,NULL,'电话','2015-09-22 14:09:15',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(52,NULL,'程序','2015-09-22 14:09:19',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(53,NULL,'阿斯钢 ','2015-09-22 14:09:22',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(54,NULL,'大方','2015-09-22 14:09:26',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(55,'好评!','撒 ','2015-09-22 14:09:49',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(56,'好评!','是打发','2015-09-22 14:09:53',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(57,NULL,'的份上','2015-09-22 14:09:57',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(58,'差评!','国防生的','2015-09-22 14:10:03',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(59,'差评!','是打发','2015-09-22 14:10:08',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(60,NULL,'是打发','2015-09-22 15:15:44',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(61,NULL,'很高','2015-09-22 15:15:49',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(62,NULL,'好看','2015-09-22 15:15:53',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(63,NULL,'环境和大哥 ','2015-09-22 15:15:57',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(64,NULL,'好','2015-09-22 15:16:00',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(65,NULL,'  大方 ','2015-09-22 15:16:04',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(66,NULL,'放','2015-09-22 15:16:08',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(67,NULL,'四大','2015-09-22 15:16:12',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(68,NULL,'规划','2015-09-22 15:16:17',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(69,NULL,'的份上','2015-09-22 15:16:20',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(70,NULL,'撒地方','2015-09-22 15:16:24',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(71,NULL,'幸存者v','2015-09-22 15:16:29',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(72,NULL,'程序','2015-09-22 15:16:33',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(73,NULL,'肉体','2015-09-22 15:16:37',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(74,NULL,'与','2015-09-22 15:16:41',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(75,NULL,'分解','2015-09-22 15:16:49',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(76,NULL,'啊 ','2015-09-22 15:16:54',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(77,NULL,'对方是个','2015-09-22 15:16:58',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(78,NULL,'撒地方','2015-09-22 15:22:44',NULL,NULL,1,NULL,6,NULL,NULL,NULL,NULL),(79,NULL,'撒的','2015-09-22 15:22:49',NULL,NULL,1,NULL,6,NULL,NULL,NULL,NULL),(81,NULL,'撒地方','2015-09-22 15:22:57',NULL,NULL,1,NULL,6,NULL,NULL,NULL,NULL),(82,NULL,'是打发','2015-09-23 09:03:00',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(83,'中评!','是打发','2015-09-23 09:03:06',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(84,'中评!','是打发','2015-09-23 09:03:11',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(85,'中评!','是打发','2015-09-23 09:03:17',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(86,NULL,'四大放','2015-09-23 09:03:22',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(87,'中评!','暗室逢灯','2015-09-23 09:03:28',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(88,NULL,'是打风格发','2015-09-23 09:03:57',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(89,NULL,'的双方各','2015-09-23 09:04:02',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(90,NULL,'阿斯蒂芬','2015-09-23 09:04:10',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(91,NULL,'爱上','2015-09-23 09:04:14',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(92,NULL,'FDH ','2015-09-23 09:04:19',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(93,NULL,'SAFD ','2015-09-23 09:04:23',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(94,NULL,'是打发','2015-09-23 09:04:27',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(95,NULL,' ','2015-09-23 09:04:31',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(96,NULL,'爱的方式','2015-09-23 09:04:37',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(98,'中评!','sdf ','2015-09-23 15:00:34',NULL,NULL,1,NULL,14,NULL,NULL,NULL,NULL),(99,'好评!','大法师','2015-09-23 15:00:42',NULL,NULL,1,NULL,14,NULL,NULL,NULL,NULL),(116,'好评!','sadfsda','2015-11-19 21:35:57',NULL,NULL,1,NULL,2,NULL,NULL,NULL,NULL),(117,NULL,'sdf ','2015-11-19 21:38:45',NULL,NULL,1,NULL,NULL,24,NULL,NULL,NULL),(118,'好评!','dasf ','2015-11-19 21:46:15',NULL,NULL,1,NULL,23,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `comment_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consignee_tb`
--

DROP TABLE IF EXISTS `consignee_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consignee_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ReceiptName` varchar(20) DEFAULT NULL,
  `TelePhone` varchar(15) DEFAULT NULL,
  `CellPhone` varchar(15) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Zip` varchar(10) DEFAULT NULL,
  `MemberID` int(11) NOT NULL,
  `consigneeIndex` int(11) DEFAULT NULL,
  `HasOrder` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKC099E38EBA2427B1` (`MemberID`),
  CONSTRAINT `FKC099E38EBA2427B1` FOREIGN KEY (`MemberID`) REFERENCES `member_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consignee_tb`
--

LOCK TABLES `consignee_tb` WRITE;
/*!40000 ALTER TABLE `consignee_tb` DISABLE KEYS */;
INSERT INTO `consignee_tb` VALUES (7,'聂跃','1234567','15111336587','湖南 长沙 长沙市  长房时代城4#1301','415000',1,NULL,1),(11,'张三','15111336587','','湖南 长沙 长沙市  实得分','',1,NULL,1),(21,'','','','湖南 长沙 长沙市  ','',1,NULL,0);
/*!40000 ALTER TABLE `consignee_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exclusivecustom_tb`
--

DROP TABLE IF EXISTS `exclusivecustom_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exclusivecustom_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CustomCategory` varchar(10) DEFAULT NULL,
  `CustomName` varchar(12) DEFAULT NULL,
  `CustomDate` varchar(20) DEFAULT NULL,
  `CustomPhone` varchar(15) DEFAULT NULL,
  `CustomPicture` varchar(100) DEFAULT NULL,
  `CustomDetails` longtext,
  `CustomOrderNumber` varchar(16) DEFAULT NULL,
  `MemberID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKE22258FEBA2427B1` (`MemberID`),
  CONSTRAINT `FKE22258FEBA2427B1` FOREIGN KEY (`MemberID`) REFERENCES `member_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exclusivecustom_tb`
--

LOCK TABLES `exclusivecustom_tb` WRITE;
/*!40000 ALTER TABLE `exclusivecustom_tb` DISABLE KEYS */;
INSERT INTO `exclusivecustom_tb` VALUES (24,'湘绣定制','张建华','2015-11-19 21:34:56','15111336587','customPicture/QQ图片20151026163855.jpg','sadf','20151119213456d',1);
/*!40000 ALTER TABLE `exclusivecustom_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_tb`
--

DROP TABLE IF EXISTS `member_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LoginName` varchar(12) DEFAULT NULL,
  `LoginPwd` varchar(45) DEFAULT NULL,
  `MemberName` varchar(20) DEFAULT NULL,
  `Sex` varchar(4) DEFAULT NULL,
  `RegDate` varchar(19) DEFAULT NULL,
  `LastDate` varchar(19) DEFAULT NULL,
  `LoginTimes` int(11) DEFAULT NULL,
  `EMail` varchar(30) DEFAULT NULL,
  `IsLogin` int(11) DEFAULT NULL,
  `MemberlevelID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK5000AA33649D864D` (`MemberlevelID`),
  CONSTRAINT `FK5000AA33649D864D` FOREIGN KEY (`MemberlevelID`) REFERENCES `memberlevel_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_tb`
--

LOCK TABLES `member_tb` WRITE;
/*!40000 ALTER TABLE `member_tb` DISABLE KEYS */;
INSERT INTO `member_tb` VALUES (1,'nieyue','7cl29cprjcl9i','聂跃re','男','2015-08-06 18:02:29','2015-11-20 09:53:55',512,'278076304@qq.com',1,1),(2,'nieyue1','7cl29cprjcl9i','地方','男','2015-08-06 18:06:12','2015-10-27 11:53:04',4,'278086304@qq.com',0,1),(3,'nieyue3','7cl29cprjcl9i','ni','女','2015-10-08 11:30:22','2015-10-08 11:30:23',1,'278086304@qq.com',1,1),(35,'nieyuea23','7cl29cprjcl9i','地方','男','2015-10-20 18:30:36','2015-10-20 18:30:36',0,'278076304@qq.com',0,1);
/*!40000 ALTER TABLE `member_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberlevel_tb`
--

DROP TABLE IF EXISTS `memberlevel_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memberlevel_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LevelName` varchar(20) DEFAULT NULL,
  `Favourable` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberlevel_tb`
--

LOCK TABLES `memberlevel_tb` WRITE;
/*!40000 ALTER TABLE `memberlevel_tb` DISABLE KEYS */;
INSERT INTO `memberlevel_tb` VALUES (1,'普通会员',100),(2,'青铜会员',95),(3,'白银会员',90),(4,'黄金会员',85),(5,'钻石会员',80);
/*!40000 ALTER TABLE `memberlevel_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchandise_tb`
--

DROP TABLE IF EXISTS `merchandise_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `merchandise_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MerName` varchar(40) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `SPrice` double DEFAULT NULL,
  `MerModel` varchar(40) DEFAULT NULL,
  `Picture` varchar(100) DEFAULT NULL,
  `MerDesc` longtext,
  `Manufacturer` varchar(60) DEFAULT NULL,
  `LeaveFactoryDate` varchar(19) DEFAULT NULL,
  `Special` int(11) DEFAULT NULL,
  `CategoryID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKB8D2646A88A012F9` (`CategoryID`),
  CONSTRAINT `FKB8D2646A88A012F9` FOREIGN KEY (`CategoryID`) REFERENCES `category_tb` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchandise_tb`
--

LOCK TABLES `merchandise_tb` WRITE;
/*!40000 ALTER TABLE `merchandise_tb` DISABLE KEYS */;
INSERT INTO `merchandise_tb` VALUES (1,'花开富贵',666,NULL,'绣片直径30cm','merchandisePicture/embroideryDetails/1.jpg','花开富贵我中国传统吉祥图案之一，代表了人们对美满幸福生活、富有和高贵的向往。花开富贵图里有时会看到蝙蝠，因为蝙蝠的“蝠”和“富”谐音。',NULL,NULL,0,1),(2,'虎高瞻远瞩',666,NULL,'绣片直径30cm','merchandisePicture/embroideryDetails/2.jpg','虎的崇拜应源自楚文化中对虎的图腾崇拜。虎一直受到举足轻重崇拜，据考证，虎的形象在古羌戎族也有出现，但在中国西南地区最为流行。新石器时代良渚文化中的玉琮的兽面和殷商青铜器上的兽面都与虎的形象相似，直到今天中国的彝族、白族、布依族、土家族等民族仍称虎是其祖先。汉代人把虎看作是森林之王。白虎是五百年才能变白的虎，是神物，而且仙人往往也乘虎升天。是镇西之兽。自汉代以后虎一直成为劳动人民喜爱的保护神，而没有成为帝王的象征，经过漫长的历史演化与发展，崇虎的文化意识，已成为中华民族的共同的文化观念。',NULL,NULL,0,1),(3,'荣华富贵',666,NULL,'绣片直径30cm','merchandisePicture/embroideryDetails/3.jpg','荣华富贵是汉族传统吉祥纹样。同“富贵荣华”。家富，位贵而荣显者为富贵荣华。《李峤汾阴行》：“山川满目泪沾衣，富贵荣华能几时”。纹饰以芙蓉花、牡丹为主组成，“蓉”与“荣”同音，花即华，牡丹为花中王，旧称富贵花。以此寓意富贵荣显。',NULL,NULL,0,1),(4,'风景图',666,NULL,'绣片直径30cm','merchandisePicture/embroideryDetails/4.jpg','旅行之意义并不是告诉别人“这里我来过”。是一种改变。旅行会改变人的气质，让人的目光变得更加长远。在旅途中，你会看到不同的人有不同的习惯，你才能了解到，并不是每个人都按照你的方式在生活。这样，人的心胸才会变得更宽广；这样，我们才会以更好的心态去面对自己的生活。',NULL,NULL,0,1),(5,'花篮',666,NULL,'绣片直径30cm','merchandisePicture/embroideryDetails/5.jpg','装花所用的篮子，或以篮为容器制作成的插花，是社交、礼仪场合最常用的花卉装饰形式之一，用于开业、致庆、迎宾、会议、生日、婚礼及丧葬等场合。尺寸有大有小，造型有单面观及四面观的，有规则式的扇面形、辐射形、椭圆形及不规则的L形、新月形等。有提梁，便于携带。',NULL,NULL,0,1),(6,'百花齐放',666,NULL,'绣片直径30cm','merchandisePicture/embroideryDetails/6.jpg','“百家争鸣，百花齐放”,毛泽东第一次明确地把“百花齐放，百家争鸣”作为繁荣社会主义科学文化的方针提出来，是在1956年4月28日中央政治局扩大会议上。他说：“艺术问题上的百花齐放，学术问题上的百家争鸣，我看应该成为我们的方针。同时也是社会稳定，政治清明，人民安居乐业的可喜景象。',NULL,NULL,0,1),(7,'松鹤延年',1288,NULL,'绣片直径35cm','merchandisePicture/embroideryBoutique_3/1.jpg','人们都希望青春永驻、健康长寿。因此，以青春长驻、健康长寿为题材的吉祥图画，在民间流传相当广泛。“松鹤长春图”则是大家最喜闻乐见的吉祥图案之一。',NULL,NULL,0,1),(8,'喜上树梢',1288,NULL,'绣片直径35cm','merchandisePicture/embroideryBoutique_3/2.jpg','枯枝迎春展笑容，喜上树梢挂红灯。 络绎游人树下望，缤纷花雨飘天空。寓意好事将近，福运来临。',NULL,NULL,0,1),(9,'荣华富贵',1288,NULL,'绣片直径35cm','merchandisePicture/embroideryBoutique_3/3.jpg','荣华富贵是汉族传统吉祥纹样。同“富贵荣华”。家富，位贵而荣显者为富贵荣华。《李峤汾阴行》：“山川满目泪沾衣，富贵荣华能几时”。纹饰以芙蓉花、牡丹为主组成，“蓉”与“荣”同音，花即华，牡丹为花中王，旧称富贵花。以此寓意富贵荣显。',NULL,NULL,0,1),(10,'花开富贵',1288,NULL,'绣片直径35cm','merchandisePicture/embroideryBoutique_3/4.jpg','花开富贵我中国传统吉祥图案之一，代表了人们对美满幸福生活、富有和高贵的向往。花开富贵图里有时会看到蝙蝠，因为蝙蝠的“蝠”和“富”谐音。',NULL,NULL,0,1),(11,'爱晚亭',1288,NULL,'绣片直径35cm','merchandisePicture/embroideryBoutique_3/5.jpg','爱晚亭，位于湖南省岳麓山下清风峡中，始建于1792年，名字来源于杜牧的《山行》。与醉翁亭、湖心亭、陶然亭并称中国四大名亭，是革命活动胜地，为省级文物保护单位。亭形为重檐八柱，琉璃碧瓦，亭角飞翘，自远处观之似凌空欲飞状。内为丹漆园柱，外檐四石柱为花岗岩，亭中彩绘藻井，东西两面亭棂悬以红底鎏金“爱晚亭”，是由当时的湖南大学校长李达专函请毛泽东所书手迹而制。',NULL,NULL,0,1),(12,'虎',1288,NULL,'绣片直径35cm','merchandisePicture/embroideryBoutique_3/6.jpg','虎的崇拜应源自楚文化中对虎的图腾崇拜。虎一直受到举足轻重崇拜，据考证，虎的形象在古羌戎族也有出现，但在中国西南地区最为流行。新石器时代良渚文化中的玉琮的兽面和殷商青铜器上的兽面都与虎的形象相似，直到今天中国的彝族、白族、布依族、土家族等民族仍称虎是其祖先。汉代人把虎看作是森林之王。白虎是五百年才能变白的虎，是神物，而且仙人往往也乘虎升天。是镇西之兽。自汉代以后虎一直成为劳动人民喜爱的保护神，而没有成为帝王的象征，经过漫长的历史演化与发展，崇虎的文化意识，已成为中华民族的共同的文化观念。',NULL,NULL,0,1),(13,'报春图',6800,NULL,'宽1.86m长0.8m','merchandisePicture/embroideryBoutique_2/1.jpg',NULL,NULL,NULL,0,2),(14,'鹊华秋色',6800,NULL,'宽1.94m长0.9m ','merchandisePicture/embroideryBoutique_2/2.jpg',NULL,NULL,NULL,0,2),(15,'满春园',6800,NULL,'宽1.86m长0.8m','merchandisePicture/embroideryBoutique_2/3.jpg',NULL,NULL,NULL,0,2),(16,'清明上河图',6800,NULL,'宽1.94m长0.9m ','merchandisePicture/embroideryBoutique_2/4.jpg',NULL,NULL,NULL,0,2),(17,'花开富贵',6800,NULL,'宽1.94m长0.9m','merchandisePicture/embroideryDetails/7.jpg',NULL,NULL,NULL,0,2),(18,'毛主席头像',666,NULL,'绣片直径30cm','merchandisePicture/embroideryDetails/8.jpg',NULL,NULL,NULL,0,2),(19,'荷塘清趣',666,NULL,'绣片直径30cm','merchandisePicture/embroideryDetails/9.jpg',NULL,NULL,NULL,0,2),(20,'金色年华',666,NULL,'绣片直径30cm','merchandisePicture/embroideryDetails/10.jpg',NULL,NULL,NULL,0,2),(21,'大吉大利',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryBoutique_1/1.jpg',NULL,NULL,NULL,0,3),(22,'蜻蜓戏荷',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryBoutique_1/2.jpg',NULL,NULL,NULL,0,3),(23,'鹤立峰岩',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryBoutique_1/3.jpg',NULL,NULL,NULL,0,3),(24,'马到成功',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryBoutique_1/4.jpg',NULL,NULL,NULL,0,3),(25,'国宝熊猫',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryBoutique_1/5.jpg',NULL,NULL,NULL,0,3),(26,'雪胎梅骨',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryDetails/11.jpg',NULL,NULL,NULL,0,3),(27,'花开富贵',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryDetails/12.jpg',NULL,NULL,NULL,0,3),(28,'秋宝图',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryDetails/13.jpg',NULL,NULL,NULL,0,3),(29,'荣华富贵',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryDetails/14.jpg',NULL,NULL,NULL,0,3),(30,'国宝熊猫',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryDetails/15.jpg',NULL,NULL,NULL,0,3),(31,'年年有余',388,NULL,'内圆直径25cm总高(含框)47cm总宽(含框)37cm','merchandisePicture/embroideryDetails/16.jpg',NULL,NULL,NULL,0,3),(34,'是',44,NULL,'说的','说的',NULL,NULL,NULL,0,NULL),(35,'爱上',333,NULL,'撒','/merchandisePicture/embroideryDetails/1447400896今日头条.jpg',NULL,NULL,NULL,NULL,11);
/*!40000 ALTER TABLE `merchandise_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_tb`
--

DROP TABLE IF EXISTS `orders_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders_tb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OrderNumber` varchar(20) DEFAULT NULL,
  `OrderDate` varchar(19) DEFAULT NULL,
  `ConsigneeID` int(11) NOT NULL,
  `MemberID` int(11) NOT NULL,
  `CartID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKE8B6EA08BA2427B1` (`MemberID`),
  KEY `FKE8B6EA083258FBD` (`CartID`),
  KEY `FKE8B6EA08E7E877` (`ConsigneeID`),
  CONSTRAINT `FKE8B6EA083258FBD` FOREIGN KEY (`CartID`) REFERENCES `cart_tb` (`ID`),
  CONSTRAINT `FKE8B6EA08BA2427B1` FOREIGN KEY (`MemberID`) REFERENCES `member_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKE8B6EA08E7E877` FOREIGN KEY (`ConsigneeID`) REFERENCES `consignee_tb` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_tb`
--

LOCK TABLES `orders_tb` WRITE;
/*!40000 ALTER TABLE `orders_tb` DISABLE KEYS */;
INSERT INTO `orders_tb` VALUES (11,'20150918151953','2015-09-18 15:19:53',7,1,82),(13,'20150923150022','2015-09-23 15:00:22',7,1,84),(20,'20151104145407','2015-11-04 14:54:07',7,1,92);
/*!40000 ALTER TABLE `orders_tb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-20 10:27:19
