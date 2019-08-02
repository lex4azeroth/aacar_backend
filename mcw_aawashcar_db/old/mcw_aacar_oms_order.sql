-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: mcw_aacar
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
-- Table structure for table `oms_order`
--

DROP TABLE IF EXISTS `oms_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oms_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(45) NOT NULL COMMENT '格式 user_id + service_id + YYYYMMDDHHMMSS',
  `user_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `vehicle_id` int(11) NOT NULL,
  `detail_location` varchar(100) NOT NULL,
  `book_time` datetime NOT NULL,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `completed_time` datetime NOT NULL,
  `status_code` int(3) NOT NULL COMMENT '对应oms_order_status表中的status_code',
  `remarks` varchar(100) NOT NULL,
  `price` decimal(3,2) NOT NULL,
  `invoice_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否需要发票，暂时不支持，所以默认是false',
  `discounted_price` decimal(3,2) NOT NULL COMMENT '折后价',
  `province_id` int(11) NOT NULL DEFAULT '0',
  `county_id` int(11) NOT NULL DEFAULT '0',
  `city_id` int(11) NOT NULL DEFAULT '0',
  `district_id` int(11) NOT NULL DEFAULT '0',
  `resi_quart_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_service_id` (`service_id`),
  KEY `index_order_number` (`order_number`),
  KEY `index_price` (`price`),
  KEY `index_discounted_price` (`discounted_price`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-19  7:38:57
