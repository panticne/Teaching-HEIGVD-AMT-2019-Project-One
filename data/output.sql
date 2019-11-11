-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: dbVol
-- ------------------------------------------------------
-- Server version	5.7.27

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
-- Table structure for table `avion`
--

DROP TABLE IF EXISTS `avion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `compagnie` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `avion` (`id`, `compagnie`, `type`) VALUES
(1, 'compagnie1', 'type1'),
(2, 'compagnie2', 'type2'),
(3, 'compagnie3', 'type3'),
(4, 'compagnie4', 'type4'),
(5, 'compagnie5', 'type5'),
(6, 'compagnie6', 'type6'),
(7, 'compagnie7', 'type7'),
(8, 'compagnie8', 'type8'),
(9, 'compagnie9', 'type9'),
(10, 'compagnie10', 'type10');

--
-- Dumping data for table `avion`
--

LOCK TABLES `avion` WRITE;
/*!40000 ALTER TABLE `avion` DISABLE KEYS */;
/*!40000 ALTER TABLE `avion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pilote`
--

DROP TABLE IF EXISTS `pilote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pilote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  `motdepasse` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `pilote` (`id`, `prenom`, `nom`, `pseudo`, `motdepasse`) VALUES
(1, 'prenom1', 'nom1', 'pseudo1', 'motdepasse1'),
(2, 'prenom2', 'nom2', 'pseudo2', 'motdepasse2'),
(3, 'prenom3', 'nom3', 'pseudo3', 'motdepasse3'),
(4, 'prenom4', 'nom4', 'pseudo4', 'motdepasse4'),
(5, 'prenom5', 'nom5', 'pseudo5', 'motdepasse5'),
(6, 'prenom6', 'nom6', 'pseudo6', 'motdepasse6'),
(7, 'prenom7', 'nom7', 'pseudo7', 'motdepasse7'),
(8, 'prenom8', 'nom8', 'pseudo8', 'motdepasse8'),
(9, 'prenom9', 'nom9', 'pseudo9', 'motdepasse9'),
(10, 'prenom10', 'nom10', 'pseudo10', 'motdepasse10');

--
-- Dumping data for table `pilote`
--

LOCK TABLES `pilote` WRITE;
/*!40000 ALTER TABLE `pilote` DISABLE KEYS */;
/*!40000 ALTER TABLE `pilote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trajet`
--

DROP TABLE IF EXISTS `trajet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trajet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depart` varchar(255) NOT NULL,
  `arrivee` varchar(255) NOT NULL,
  `duree` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `trajet` (`id`, `depart`, `arrivee`, `duree`) VALUES
(1, 'depart1', 'arrivee1', 7875),
(2, 'depart2', 'arrivee2', 544),
(3, 'depart3', 'arrivee3', 8396),
(4, 'depart4', 'arrivee4', 6403),
(5, 'depart5', 'arrivee5', 9887),
(6, 'depart6', 'arrivee6', 9782),
(7, 'depart7', 'arrivee7', 6014),
(8, 'depart8', 'arrivee8', 1817),
(9, 'depart9', 'arrivee9', 207),
(10, 'depart10', 'arrivee10', 5440);

--
-- Dumping data for table `trajet`
--

LOCK TABLES `trajet` WRITE;
/*!40000 ALTER TABLE `trajet` DISABLE KEYS */;
/*!40000 ALTER TABLE `trajet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vol`
--

DROP TABLE IF EXISTS `vol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pilote_id` int(11) NOT NULL,
  `avion_id` int(11) NOT NULL,
  `trajet_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vol_pilote_idx` (`pilote_id`),
  KEY `fk_vol_avion1_idx` (`avion_id`),
  KEY `fk_vol_trajet1_idx` (`trajet_id`),
  CONSTRAINT `fk_vol_avion1` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vol_pilote` FOREIGN KEY (`pilote_id`) REFERENCES `pilote` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vol_trajet1` FOREIGN KEY (`trajet_id`) REFERENCES `trajet` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `vol` (`id`, `pilote_id`, `avion_id`, `trajet_id`) VALUES
(1, 1, 7, 2),
(2, 2, 6, 4),
(3, 9, 2, 9),
(4, 10, 6, 10),
(5, 5, 1, 2),
(6, 10, 2, 4),
(7, 9, 3, 2),
(8, 3, 2, 9),
(9, 10, 8, 7),
(10, 10, 4, 9);

--
-- Dumping data for table `vol`
--

LOCK TABLES `vol` WRITE;
/*!40000 ALTER TABLE `vol` DISABLE KEYS */;
/*!40000 ALTER TABLE `vol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-09 14:53:10

