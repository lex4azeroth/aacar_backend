-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: mcw_aacar_prom
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Table structure for table `prom_coupon`
--

DROP TABLE IF EXISTS `prom_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prom_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `coupon_type` int(1) NOT NULL COMMENT '0 - 免费券，1 - 减价券，2 - 折扣券',
  `value` decimal(4,2) NOT NULL COMMENT '对应不同类型的优惠券，该值的意义不同。免费券一律为0，减价券可以是5.00，10.00，20.00等，折扣券一律表示百分比，比如10.00表示9折',
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `duration` varchar(45) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `index_coupon_type` (`coupon_type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prom_coupon`
--

LOCK TABLES `prom_coupon` WRITE;
/*!40000 ALTER TABLE `prom_coupon` DISABLE KEYS */;
INSERT INTO `prom_coupon` VALUES (1,'免费券','完全免费',0,0.00,1,'2017-06-30 07:42:31','1'),(2,'减十元','减十元',1,10.00,1,'2018-06-30 07:44:19','1'),(3,'9折券','通用9折',2,10.00,1,'2018-06-30 07:44:59','6'),(4,'金牌8折','金牌会员独享',2,20.00,1,'2018-07-21 04:04:33','12'),(5,'银牌9折','银牌会员独享',2,10.00,1,'2018-07-21 04:04:33','12'),(6,'铜牌9.5折','铜牌会员独享',2,5.00,1,'2018-07-21 04:04:33','12');
/*!40000 ALTER TABLE `prom_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prom_points`
--

DROP TABLE IF EXISTS `prom_points`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prom_points` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_points` decimal(5,2) NOT NULL COMMENT '用户的积分',
  `exchange_rate` decimal(3,2) NOT NULL DEFAULT '1.00' COMMENT '人民币兑换积分的汇率如果这里是1，那么就是1元人名币兑换1分，如果是2，就是2元人名币兑换1分',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_user_points` (`user_points`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用户积分';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prom_points`
--

LOCK TABLES `prom_points` WRITE;
/*!40000 ALTER TABLE `prom_points` DISABLE KEYS */;
/*!40000 ALTER TABLE `prom_points` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prom_promotion`
--

DROP TABLE IF EXISTS `prom_promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prom_promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1' COMMENT '促销全是否有效',
  `price` decimal(7,2) NOT NULL COMMENT '优惠券购买价格',
  `duration` int(11) NOT NULL DEFAULT '12' COMMENT '有效时间，月为单位，默认12个月',
  `vehicle_type_id` int(11) DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_duration` (`duration`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prom_promotion`
--

LOCK TABLES `prom_promotion` WRITE;
/*!40000 ALTER TABLE `prom_promotion` DISABLE KEYS */;
INSERT INTO `prom_promotion` VALUES (1,'A套餐','外观精洗+内饰精洗',1,500.00,12,4,'2018-06-30 07:36:41','2018-09-27 14:34:05'),(2,'B套餐','外观精洗+汽车养护蜡',1,260.00,12,4,'2018-06-30 07:39:01','2018-09-27 14:34:05'),(3,'C套餐','10次外观普洗+1次全车洗',1,200.00,12,4,'2018-07-29 02:23:10','2018-09-27 14:34:05'),(4,'D套餐','20次标准洗+2次打蜡',1,700.00,12,4,'2018-09-27 14:45:15','2018-09-27 14:45:15'),(5,'E套餐','20次标准洗+4次养护蜡+外观精洗+内饰精洗',1,1220.00,12,4,'2018-09-27 14:46:20','2018-09-27 14:46:20');
/*!40000 ALTER TABLE `prom_promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prom_promotion_transaction`
--

DROP TABLE IF EXISTS `prom_promotion_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prom_promotion_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `promotion_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `price` decimal(5,2) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `paied` tinyint(4) NOT NULL DEFAULT '0',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prom_promotion_transaction`
--

LOCK TABLES `prom_promotion_transaction` WRITE;
/*!40000 ALTER TABLE `prom_promotion_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `prom_promotion_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prom_promotion_weixin_transaction`
--

DROP TABLE IF EXISTS `prom_promotion_weixin_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prom_promotion_weixin_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `promotion_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `appid` varchar(45) NOT NULL,
  `attach` varchar(45) DEFAULT NULL,
  `bank_type` varchar(45) DEFAULT NULL,
  `fee_type` varchar(45) DEFAULT NULL,
  `is_subscribe` varchar(45) DEFAULT NULL,
  `mch_id` varchar(45) DEFAULT NULL,
  `nonce_str` varchar(45) DEFAULT NULL,
  `openid` varchar(45) DEFAULT NULL,
  `out_trade_no` varchar(45) DEFAULT NULL,
  `result_code` varchar(45) DEFAULT NULL,
  `return_code` varchar(45) DEFAULT NULL,
  `sign` varchar(45) DEFAULT NULL,
  `sub_mch_id` varchar(45) DEFAULT NULL,
  `time_end` varchar(45) DEFAULT NULL,
  `total_fee` varchar(45) DEFAULT NULL,
  `trade_type` varchar(45) DEFAULT NULL,
  `transaction_id` varchar(45) DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prom_promotion_weixin_transaction`
--

LOCK TABLES `prom_promotion_weixin_transaction` WRITE;
/*!40000 ALTER TABLE `prom_promotion_weixin_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `prom_promotion_weixin_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prom_r_promotion_service`
--

DROP TABLE IF EXISTS `prom_r_promotion_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prom_r_promotion_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `promotion_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_promotion_id` (`promotion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prom_r_promotion_service`
--

LOCK TABLES `prom_r_promotion_service` WRITE;
/*!40000 ALTER TABLE `prom_r_promotion_service` DISABLE KEYS */;
INSERT INTO `prom_r_promotion_service` VALUES (1,1,2,1,'2018-07-21 08:27:55'),(2,1,5,1,'2018-07-21 08:27:55'),(3,2,4,1,'2018-07-21 08:27:55'),(4,2,5,1,'2018-07-21 08:27:55'),(5,3,1,10,'2018-07-21 08:27:55'),(6,3,7,1,'2018-07-21 08:27:55'),(7,4,3,20,'2018-07-21 08:27:55'),(8,4,4,2,'2018-10-11 15:35:45'),(9,5,3,20,'2018-10-11 15:35:45'),(10,5,4,4,'2018-10-11 15:35:45'),(11,5,2,1,'2018-10-11 15:35:45'),(12,5,5,1,'2018-10-11 15:35:45');
/*!40000 ALTER TABLE `prom_r_promotion_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prom_r_user_consume_service`
--

DROP TABLE IF EXISTS `prom_r_user_consume_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prom_r_user_consume_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '一旦用户购买了套餐/会员，只要设计服务级别的消费，就需要生成对应的记录',
  `user_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `promotion_id` int(11) NOT NULL,
  `consumed_count` int(11) NOT NULL COMMENT '促销对应服务的已使用的次数',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_user_promotion_service` (`user_id`,`promotion_id`,`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prom_r_user_consume_service`
--

LOCK TABLES `prom_r_user_consume_service` WRITE;
/*!40000 ALTER TABLE `prom_r_user_consume_service` DISABLE KEYS */;
INSERT INTO `prom_r_user_consume_service` VALUES (16,77,2,1,0,'2018-10-13 06:39:56'),(17,77,7,3,0,'2018-10-13 06:39:56'),(18,77,5,1,0,'2018-10-13 06:55:18'),(19,77,1,3,0,'2018-10-13 06:55:18');
/*!40000 ALTER TABLE `prom_r_user_consume_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prom_r_user_coupon`
--

DROP TABLE IF EXISTS `prom_r_user_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prom_r_user_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `coupon_id` int(11) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_coupon_id` (`coupon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prom_r_user_coupon`
--

LOCK TABLES `prom_r_user_coupon` WRITE;
/*!40000 ALTER TABLE `prom_r_user_coupon` DISABLE KEYS */;
INSERT INTO `prom_r_user_coupon` VALUES (14,77,1,'2018-10-20 11:58:59',1),(15,77,4,'2018-10-20 11:58:59',1);
/*!40000 ALTER TABLE `prom_r_user_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prom_r_user_promotion`
--

DROP TABLE IF EXISTS `prom_r_user_promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prom_r_user_promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `promotion_id` int(11) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_promotion_id` (`promotion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prom_r_user_promotion`
--

LOCK TABLES `prom_r_user_promotion` WRITE;
/*!40000 ALTER TABLE `prom_r_user_promotion` DISABLE KEYS */;
INSERT INTO `prom_r_user_promotion` VALUES (34,77,1,'2018-10-13 12:30:49',1),(35,77,3,'2018-10-13 12:30:49',1);
/*!40000 ALTER TABLE `prom_r_user_promotion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-20 23:10:43
