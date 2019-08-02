-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 120.55.63.211    Database: mcw_aacar_crm
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `crm_r_member_user`
--

DROP TABLE IF EXISTS `crm_r_member_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_r_member_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `start_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '会员开始时间',
  `end_date` datetime NOT NULL COMMENT '会员结束时间',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_memberId` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_r_member_user`
--

LOCK TABLES `crm_r_member_user` WRITE;
/*!40000 ALTER TABLE `crm_r_member_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `crm_r_member_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_r_suite_user`
--

DROP TABLE IF EXISTS `crm_r_suite_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_r_suite_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `suite_id` int(11) NOT NULL,
  `start_date` datetime NOT NULL COMMENT '套餐开始时间',
  `end_date` datetime NOT NULL COMMENT '套餐结束时间',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_suite_id` (`suite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_r_suite_user`
--

LOCK TABLES `crm_r_suite_user` WRITE;
/*!40000 ALTER TABLE `crm_r_suite_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `crm_r_suite_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_r_user_uuid`
--

DROP TABLE IF EXISTS `crm_r_user_uuid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_r_user_uuid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '-100' COMMENT '-100 特指申请为洗车工单还未被审核的记录',
  `uuid` varchar(45) DEFAULT NULL,
  `open_id` varchar(45) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_r_user_uuid`
--

LOCK TABLES `crm_r_user_uuid` WRITE;
/*!40000 ALTER TABLE `crm_r_user_uuid` DISABLE KEYS */;
INSERT INTO `crm_r_user_uuid` VALUES (62,70,NULL,'oRQp75QkPNcALixkOobT9LweWqFQ','2018-08-04 04:19:57'),(63,69,NULL,'oEYhV4x3xE2dzfpC9tMM8uYtOkMM','2018-08-04 04:20:26'),(64,71,NULL,'oEYhV47nQd_-SiLjTJ-ZpBtIeTqo','2018-08-04 06:36:05'),(65,72,NULL,'oEYhV49NeQ8KVPzDKbspmKlZZZ_M','2018-08-05 03:48:39'),(66,73,NULL,'oRQp75XL-qAcJc26saCmu9h-wLT4','2018-08-07 01:13:50'),(67,74,NULL,'oEYhV4wYVD-kjG3Gf4X00NCD8xWQ','2018-08-07 01:15:12'),(68,75,NULL,'oEYhV4-X7MPYS50RCfl4uuI0FG8Q','2018-08-07 09:57:44'),(69,76,NULL,'oRQp75doG5g75kF3vLgSk4jPvsvU','2018-08-07 11:55:27'),(70,74,NULL,'oRQp75f-faU5-x-dYGyHVptJXdvo','2018-08-07 12:22:51'),(71,-100,NULL,'oRQp75UBY33edfdw3nh1tNuW2iQM','2018-08-08 02:53:38'),(72,-100,NULL,'oRQp75fh1Tdrv6U9XjWR4RwHIwQs','2018-08-13 05:44:15'),(73,77,NULL,'oEYhV41pDsmL0BiUiCjIQiv6StSI','2018-08-15 00:49:37'),(74,-100,NULL,'oRQp75SVA_hd5jHwTcPCQWJjlTKs','2018-08-15 01:14:07'),(75,-100,NULL,'oRQp75QXzZGZcVL0lbxiTzhSuzfU','2018-08-15 11:21:43'),(76,-100,NULL,'oRQp75TsWAhmAOSmxhb0Uj0sBfkI','2018-08-18 15:27:25'),(77,-100,NULL,'oRQp75f_erFq9nxFElQnZ_eoea-U','2018-08-23 09:01:29'),(78,-100,NULL,'oRQp75QJZen8kZIzrjnX8wXDfmB8','2018-08-24 02:41:35'),(79,-100,NULL,'oRQp75eWW9hAYfwLUFY4q9uGejyE','2018-08-27 08:26:43'),(80,-100,NULL,'oRQp75fzwCmE4kdoCwqH2F04fe0w','2018-08-28 23:01:11'),(81,-100,NULL,'oRQp75RIFXxsKB8mtQgDsrJYx-lo','2018-09-03 04:17:54');
/*!40000 ALTER TABLE `crm_r_user_uuid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_r_user_vehicle`
--

DROP TABLE IF EXISTS `crm_r_user_vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_r_user_vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `vehicle_id` int(11) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_vehicle_id` (`vehicle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_r_user_vehicle`
--

LOCK TABLES `crm_r_user_vehicle` WRITE;
/*!40000 ALTER TABLE `crm_r_user_vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `crm_r_user_vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_user`
--

DROP TABLE IF EXISTS `crm_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `worker_id` int(11) DEFAULT NULL,
  `nick_name` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `gender_id` tinyint(1) DEFAULT '0' COMMENT '0 - 默认 未知\n1 - 男\n2 - 女',
  `phone_number` varchar(45) NOT NULL,
  `age` tinyint(3) DEFAULT NULL,
  `detail_location` varchar(100) DEFAULT NULL,
  `province_id` int(11) NOT NULL DEFAULT '0' COMMENT '默认 上海',
  `county_id` tinyint(3) NOT NULL DEFAULT '0' COMMENT '默认 上海',
  `city_id` tinyint(3) NOT NULL DEFAULT '0' COMMENT '默认 上海',
  `district_id` tinyint(3) NOT NULL DEFAULT '0' COMMENT '默认 宝山区',
  `resi_quart_id` tinyint(3) NOT NULL DEFAULT '0' COMMENT '默认 大华',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_user`
--

LOCK TABLES `crm_user` WRITE;
/*!40000 ALTER TABLE `crm_user` DISABLE KEYS */;
INSERT INTO `crm_user` VALUES (69,0,'abc','a','bc',2,'13817255172',0,NULL,0,0,0,0,0,'2018-08-04 04:20:26','2018-08-23 11:52:59',1),(70,30,'bianyinhui','yinhui','bian',0,'18451035333',0,NULL,0,0,0,0,0,'2018-08-04 04:20:57','2018-08-04 04:20:57',1),(71,0,'222333','222','333',1,'18451035333',0,NULL,0,0,0,0,0,'2018-08-04 06:36:05','2018-08-26 13:22:22',1),(72,0,NULL,NULL,NULL,0,'18616332861',0,NULL,0,0,0,0,0,'2018-08-05 03:48:39','2018-08-05 03:48:39',1),(73,31,'洗车工莫','莫','洗车工',0,'15300861713',0,NULL,0,0,0,0,0,'2018-08-07 01:14:32','2018-08-07 01:14:32',1),(74,33,'MoJimmy','Jimmy','Mo',0,'13918409598',0,NULL,0,0,0,0,0,'2018-08-07 01:15:12','2018-08-07 01:15:12',1),(75,0,NULL,NULL,NULL,0,'18451035333',0,NULL,0,0,0,0,0,'2018-08-07 09:57:44','2018-08-07 09:57:44',1),(76,32,'zhuzhu','zhu','zhu',0,'13701783696',0,NULL,0,0,0,0,0,'2018-08-07 12:00:17','2018-08-07 12:00:17',1),(77,0,NULL,NULL,NULL,0,'15700069970',0,NULL,0,0,0,0,0,'2018-08-15 00:49:37','2018-08-15 00:49:37',1);
/*!40000 ALTER TABLE `crm_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-14 21:41:43
