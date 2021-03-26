-- MySQL dump 10.13  Distrib 5.7.33, for Linux (x86_64)
--
-- Host: localhost    Database: auproject
-- ------------------------------------------------------
-- Server version	5.7.33-0ubuntu0.18.04.1

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `ans_id` int(11) NOT NULL AUTO_INCREMENT,
  `answer_body` text,
  `correct` bit(1) NOT NULL,
  `ques_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `votes` int(11) NOT NULL,
  PRIMARY KEY (`ans_id`),
  KEY `FKtkjfjceq84qkwkixv8mh5tif9` (`ques_id`),
  KEY `FK68tbcw6bunvfjaoscaj851xpb` (`user_id`),
  CONSTRAINT `FK68tbcw6bunvfjaoscaj851xpb` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKtkjfjceq84qkwkixv8mh5tif9` FOREIGN KEY (`ques_id`) REFERENCES `question` (`ques_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (2,'If a football game was lopsided at halftime, wouldn\'t it be ethical to call the game? Since chess has a resigning option, I do not consider any move as unethical. I consider an opponent who does not resign in a hopeless position as someone who deserves to be tortured, and it allows me to practice technique. So promote to all knights and practice the unusual mate.',_binary '\0',1,4,0),(3,'Celery is an asynchronous task queue based on distributed message passing. Task queues are used as a strategy to distribute the workload between threads/machines. In this tutorial I will explain how to install and setup Celery + RabbitMQ to execute asynchronous in a Django application. To work with Celery, we also need to install RabbitMQ because Celery requires an external solution to send and receive messages. Those solutions are called message brokers. Currently, Celery supports RabbitMQ, Redis, and Amazon SQS as message broker solutions.',_binary '\0',3,3,0),(4,'In this post, you will see small piece of code but really effective and useful. That is how to get URL Parameters using jQuery. Now days every server language provide direct method to get the URL parameters but this is not straight forward with jQuery.',_binary '\0',4,2,0),(6,'Android keeps one active connection to Google servers, but it doesn\'t use much power or data, because no traffic is sent along it until something sends a Google Cloud Messaging (GCM) message to an app on your phone. There\'s only one connection on the phone, used by all apps: installing a new app that uses GCM doesn\'t add any extra load. The first step in GCM is that a third-party server (such as an email server) sends a request to Google\'s GCM server. This server then sends the message to your device, through that open connection. The Android system looks at the message to determine which app it\'s for, and starts that app. The app must have registered with Android to use GCM, and it must have the relevant permission. When the app starts, it might create a notification straight away with the data from the message. GCM messages are very limited in size, so the app might instead open a normal connection to the third-party server to get more information (for example, downloading the headers of new emails).',_binary '\0',5,1,0),(7,'Let is declared by a coach or a player if there is no coach. It is used to halt play',_binary '\0',6,1,-1);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_body` text,
  `ans_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK2md1vioaqfcau5jr6d9umllva` (`ans_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
  CONSTRAINT `FK2md1vioaqfcau5jr6d9umllva` FOREIGN KEY (`ans_id`) REFERENCES `answer` (`ans_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ques_keywords`
--

DROP TABLE IF EXISTS `ques_keywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ques_keywords` (
  `ques_keywords_id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(255) DEFAULT NULL,
  `ques_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ques_keywords_id`),
  KEY `FKqv7mv41kl38w26x7e9yc3btkx` (`ques_id`),
  CONSTRAINT `FKqv7mv41kl38w26x7e9yc3btkx` FOREIGN KEY (`ques_id`) REFERENCES `question` (`ques_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ques_keywords`
--

LOCK TABLES `ques_keywords` WRITE;
/*!40000 ALTER TABLE `ques_keywords` DISABLE KEYS */;
INSERT INTO `ques_keywords` VALUES (1,'chess',1),(2,'checkmate',1),(3,'ethic',1),(4,'connected component',2),(5,'game',2),(6,'two pass',2),(7,'bit scan',2),(8,'Django',3),(9,'celery',3),(10,'RabbitMQ',3),(11,'centos',3),(12,'error',3),(13,'configuration',3),(14,'url parameter',4),(15,'jQuery',4),(16,'javascript',4),(17,'Android',5),(18,'push notification',5),(19,'Google',5),(20,'polling',5),(21,'let',6),(22,'terminology',6),(23,'badminton',6),(24,'chess',7),(25,'women',7),(26,'future',7),(27,'chess',8),(28,'tactics',8);
/*!40000 ALTER TABLE `ques_keywords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `ques_id` int(11) NOT NULL AUTO_INCREMENT,
  `body` text,
  `marked` bit(1) NOT NULL,
  `title` text,
  `topic_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ques_id`),
  KEY `FK9h1t7swdq9eej6qf9yxtc8g9w` (`topic_id`),
  KEY `FK4ekrlbqiybwk8abhgclfjwnmc` (`user_id`),
  CONSTRAINT `FK4ekrlbqiybwk8abhgclfjwnmc` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK9h1t7swdq9eej6qf9yxtc8g9w` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'If you are leading a game, is it ethical to capture your opponent pieces one by one or go straight for checkmate?',_binary '\0','When you are winning, is it ethical to not go for a checkmate right away?',6,2),(2,'A long time ago, I made a game in which a sort of connected-component labeling is required to implement AI part. I used the two-pass algorithm unknowingly at that time. Recently, I got to know that I can make them faster using bit-scan based method instead. It uses 1-bit-per-pixel data as input, instead of typical bytes-per-pixel input. Then it finds every linear chunks in each scan-lines using BSF instruction.',_binary '\0','Is this connected-component labeling algorithm new?',2,1),(3,'Answers to this question are eligible for a +50 reputation bounty. Alvaro Bataller is looking for an answer from a reputable source. I am using Django and Celery with RabbitMQ as the message broker. While developing in Windows I installed RabbitMQ and configured Celery inside Django. When running Celery inside my development Windows machine everything works correctly and tasks are being executed as expected. Now I am trying to deploy the app inside a Centos7 machine. Does anyone know why this is happening? How can I get Celery to work correctly with RabbitMQ inside of Centos7?',_binary '\0','Django and Celery error when using RabbitMQ in Centos Bounty expires in 2 days.',4,3),(4,'I have seen lots of jQuery examples where parameter size and name are unknown. My URL is only going to ever have 1 string. I just want to detect if sent exists?',_binary '\0','How to get URL parameter using jQuery or plain JavaScript?',3,3),(5,'How has Google implemented their push notification feature? Does it work through polling done by a service running in the background or in a different way?',_binary '\0','How does push notification technology work on Android?',3,4),(6,'I have been playing for a while now, but I encountered this term just now',_binary '\0','What is a LET in Badminton?',1,4),(7,'demo title',_binary '\0','Do you think that in the future we will see a woman as a World Champion?',6,1),(8,'I want to compete in the 2021 finals and I just know the basics',_binary '\0','How much tactics per day should I do?',6,4);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'badminton'),(2,'algorithm'),(3,'technology'),(4,'framework'),(5,'psychiatry'),(6,'chess');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'acprealms@gmail.com','1234','https://i.ibb.co/mc1D229/1.jpg','Parth Modhvadia'),(2,'amcoc123@gmail.com','1234','https://i.ibb.co/DKDWFTq/Screenshot-716.png','Nisarg Shah'),(3,'amundra6@gmail.com','1234','https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg','Sakshi Bansal'),(4,'amcoc1234@gmail.com','1234','https://i.ibb.co/5vMpxqZ/Screenshot-715.png','Ashit Mundra'),(5,'sumanto.pal@accolitedigital.com','$2a$10$UNPwuM7WFT.Z3N64NhGHKuq2DZAcpFvWoT2glW6NgE3Xv5cpeZz8y','https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg','XYX');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_answer`
--

DROP TABLE IF EXISTS `user_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_answer` (
  `user_ans_id` int(11) NOT NULL AUTO_INCREMENT,
  `mark` bit(1) DEFAULT NULL,
  `ans_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_ans_id`),
  KEY `FKq0nx6m9e92c1lae8gk2vaq9ou` (`ans_id`),
  KEY `FK7kw17ur9w2egkc51xua3yh0ux` (`user_id`),
  CONSTRAINT `FK7kw17ur9w2egkc51xua3yh0ux` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKq0nx6m9e92c1lae8gk2vaq9ou` FOREIGN KEY (`ans_id`) REFERENCES `answer` (`ans_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_answer`
--

LOCK TABLES `user_answer` WRITE;
/*!40000 ALTER TABLE `user_answer` DISABLE KEYS */;
INSERT INTO `user_answer` VALUES (1,_binary '',7,2),(2,_binary '',7,3),(3,_binary '\0',7,4),(4,_binary '\0',7,5),(5,_binary '\0',7,NULL);
/*!40000 ALTER TABLE `user_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_topic`
--

DROP TABLE IF EXISTS `user_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_topic` (
  `user_topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_topic_id`),
  KEY `FKrbbt9w8w48w4pl7dv0lh3om0v` (`topic_id`),
  KEY `FKdc8ayjtjsav1ahruawdrcsdr3` (`user_id`),
  CONSTRAINT `FKdc8ayjtjsav1ahruawdrcsdr3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKrbbt9w8w48w4pl7dv0lh3om0v` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_topic`
--

LOCK TABLES `user_topic` WRITE;
/*!40000 ALTER TABLE `user_topic` DISABLE KEYS */;
INSERT INTO `user_topic` VALUES (2,6,4),(3,4,3),(4,3,1),(5,1,1),(7,3,2),(8,1,2),(9,1,3),(10,1,4),(11,1,5),(12,2,5),(13,3,5),(14,4,5),(15,5,5),(16,6,5);
/*!40000 ALTER TABLE `user_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'auproject'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-16 19:17:21
