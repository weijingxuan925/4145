-- MySQL dump 10.14  Distrib 5.5.68-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: flame
-- ------------------------------------------------------
-- Server version	5.5.68-MariaDB

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `cate_name` varchar(100) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (7,'dengxinyi');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `comment_content` text,
  `comment_parent` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `author_name` varchar(255) DEFAULT NULL,
  `author_email` varchar(255) DEFAULT NULL,
  `author_avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (12,'我也想养个邓欣怡',0,14,'2023-02-18','邓欣怡的爹','jn728702@dal.ca','https://eu.ui-avatars.com/api/?background=random&length=1&rounded=true&bold=true&name=邓欣怡的爹'),(13,'bab',0,14,'2023-02-18','wjx','123','https://eu.ui-avatars.com/api/?background=random&length=1&rounded=true&bold=true&name=wjx');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `post_content` longtext,
  `post_status` int(11) DEFAULT NULL,
  `post_summary` varchar(2000) DEFAULT NULL,
  `post_thumbnail` varchar(255) DEFAULT NULL,
  `post_title` varchar(255) DEFAULT NULL,
  `post_views` bigint(20) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (14,'<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n<p>好想养一只小狗 我要是有一个自己的小狗就好了 ?<img src=\"http://20.92.118.84/upload/2023/2/8562c8801a324788a5fabd956308de3e.jpg\" alt=\"\" width=\"600\" height=\"600\" /></p>\n</body>\n</html>',1,'好想养一只小狗 我要是有一个自己的小狗就好了 ?','/upload/2023/2/f1d4c08b97304e69948a342e40cf30b8.jpg','好想养一只小狗',0,NULL),(16,'<!DOCTYPE html>\n<html>\n<head>\n</head>\n<body>\n<p style=\"text-align: center;\">测试文章链接</p>\n<p style=\"text-align: center;\"><strong><a title=\"百度一下\" href=\"http://www.baidu.com/\">百度一下</a></strong></p>\n<p style=\"text-align: center;\"><strong><a title=\"百度一下\" href=\"http://www.baidu.com/\"><img src=\"http://20.92.118.84/upload/2023/2/47c6ca5489644721aae5e9ff5a0909ea.png\" alt=\"\" width=\"290\" height=\"174\" /></a></strong></p>\n</body>\n</html>',1,'测试文章链接百度一下','/upload/2023/2/d67c6ab486a84a9e8343900aa6676077.png','测试链接',0,NULL);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_category_ref`
--

DROP TABLE IF EXISTS `post_category_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_category_ref` (
  `post_id` bigint(20) NOT NULL COMMENT '文章ID',
  `cate_id` bigint(20) NOT NULL COMMENT '分类ID',
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKatntuqmrfdi01vecyyi24arus` (`cate_id`),
  KEY `post_id` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_category_ref`
--

LOCK TABLES `post_category_ref` WRITE;
/*!40000 ALTER TABLE `post_category_ref` DISABLE KEYS */;
INSERT INTO `post_category_ref` VALUES (1,1,7),(2,1,8),(3,2,9),(4,1,10),(5,1,11),(6,2,12),(7,1,13),(8,1,14),(9,1,15),(10,1,16),(11,1,17),(12,1,18),(13,1,19),(14,7,20),(15,7,21),(16,7,23);
/*!40000 ALTER TABLE `post_category_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_tag_ref`
--

DROP TABLE IF EXISTS `post_tag_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_tag_ref` (
  `post_id` bigint(20) NOT NULL COMMENT '文章ID',
  `tag_id` bigint(20) NOT NULL COMMENT '标签ID',
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_tag_ref`
--

LOCK TABLES `post_tag_ref` WRITE;
/*!40000 ALTER TABLE `post_tag_ref` DISABLE KEYS */;
INSERT INTO `post_tag_ref` VALUES (1,1,11),(1,3,12),(2,1,13),(2,4,14),(3,2,15),(4,1,16),(5,1,17),(5,5,18),(6,2,19),(7,1,20),(8,1,21),(8,6,22),(9,1,23),(9,7,24),(10,1,25),(11,1,26),(11,8,27),(12,1,28),(13,1,29),(13,9,30),(13,10,31),(14,11,32);
/*!40000 ALTER TABLE `post_tag_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `tag_name` varchar(100) NOT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (11,'daily');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `user_desc` varchar(255) DEFAULT NULL COMMENT '个人签名',
  `user_display_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `user_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `user_pass` varchar(255) DEFAULT NULL COMMENT '密码：md5加盐多次',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'/upload/2023/2/fb6d323766bd452b90d69541b7624a47.jpg','This is dengxinyi','dundun','dxy@gmail.com','dundun','123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-19  1:42:54
