CREATE DATABASE  IF NOT EXISTS `VoceAluga` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `VoceAluga`;
-- MySQL dump 10.15  Distrib 10.0.13-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: VoceAluga
-- ------------------------------------------------------
-- Server version	10.0.13-MariaDB-log

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
-- Table structure for table `Aluguel`
--

DROP TABLE IF EXISTS `Aluguel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Aluguel` (
  `aluguel_oid` varchar(45) NOT NULL,
  `carro_oid` varchar(45) NOT NULL,
  `pessoa_oid` varchar(45) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `pago` bit(1) NOT NULL,
  `reserva_oid` varchar(45) NOT NULL,
  PRIMARY KEY (`aluguel_oid`),
  KEY `fk_Aluguel_Carro_idx` (`carro_oid`),
  KEY `fk_Aluguel_Pessoa_idx` (`pessoa_oid`),
  KEY `fk_Aluguel_Reserva_idx` (`reserva_oid`),
  CONSTRAINT `fk_Aluguel_Carro` FOREIGN KEY (`carro_oid`) REFERENCES `Carro` (`carro_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluguel_Pessoa` FOREIGN KEY (`pessoa_oid`) REFERENCES `Pessoa` (`pessoa_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluguel_Reserva` FOREIGN KEY (`reserva_oid`) REFERENCES `Reserva` (`reserva_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Carro`
--

DROP TABLE IF EXISTS `Carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Carro` (
  `carro_oid` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `placa` varchar(45) NOT NULL,
  `ano` int(4) NOT NULL,
  `ultimaManutencao` date DEFAULT NULL,
  `marca` varchar(45) NOT NULL,
  `disponivel` varchar(45) NOT NULL,
  `preco` decimal(6,2) DEFAULT NULL,
  `diaria` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`carro_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Filial`
--

DROP TABLE IF EXISTS `Filial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Filial` (
  `filial_oid` varchar(45) NOT NULL,
  `pessoa_oid` varchar(45) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`filial_oid`),
  KEY `fk_Filial_Gerente_idx` (`pessoa_oid`),
  CONSTRAINT `fk_Filial_Gerente` FOREIGN KEY (`pessoa_oid`) REFERENCES `Pessoa` (`pessoa_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `GrupoCarro`
--

DROP TABLE IF EXISTS `GrupoCarro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GrupoCarro` (
  `grupoCarro_oid` int(11) NOT NULL,
  `total` int(11) DEFAULT NULL,
  `disponiveis` int(11) DEFAULT NULL,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`grupoCarro_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ListaNegra`
--

DROP TABLE IF EXISTS `ListaNegra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ListaNegra` (
  `listaNegra_oid` varchar(45) NOT NULL,
  `pessoa_oid` varchar(45) NOT NULL,
  PRIMARY KEY (`listaNegra_oid`),
  KEY `fk_ListaNegra_Pessoa_idx` (`pessoa_oid`),
  CONSTRAINT `fk_ListaNegra_Pessoa` FOREIGN KEY (`pessoa_oid`) REFERENCES `Pessoa` (`pessoa_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Manutencao`
--

DROP TABLE IF EXISTS `Manutencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Manutencao` (
  `manutencao_oid` varchar(45) NOT NULL,
  `filal_oid` varchar(45) NOT NULL,
  `carro_oid` varchar(45) NOT NULL,
  PRIMARY KEY (`manutencao_oid`),
  KEY `fk_Manutencao_Filial_idx` (`filal_oid`),
  KEY `fk_Manutencao_Carro_idx` (`carro_oid`),
  CONSTRAINT `fk_Manutencao_Filial` FOREIGN KEY (`filal_oid`) REFERENCES `Filial` (`filial_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Manutencao_Carro` FOREIGN KEY (`carro_oid`) REFERENCES `Carro` (`carro_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Perfil`
--

DROP TABLE IF EXISTS `Perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Perfil` (
  `perfil_oid` int(11) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`perfil_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Permissao`
--

DROP TABLE IF EXISTS `Permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Permissao` (
  `permissao_oid` varchar(45) NOT NULL,
  `perfil_oid` varchar(45) NOT NULL,
  `pessoa_oid` varchar(45) NOT NULL,
  PRIMARY KEY (`permissao_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Pessoa`
--

DROP TABLE IF EXISTS `Pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pessoa` (
  `pessoa_oid` varchar(45) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cpf` varchar(12) NOT NULL,
  `rg` varchar(10) NOT NULL,
  `carteira` varchar(10) DEFAULT NULL,
  `categoriaCarteira` char(1) DEFAULT NULL,
  `telefone` varchar(8) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pessoa_oid`),
  UNIQUE KEY `pessoa_oid_UNIQUE` (`pessoa_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Reserva`
--

DROP TABLE IF EXISTS `Reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reserva` (
  `reserva_oid` varchar(45) NOT NULL,
  `pessoa_oid` varchar(45) NOT NULL,
  `carro_oid` varchar(45) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `pagoAntecipado` bit(1) NOT NULL,
  PRIMARY KEY (`reserva_oid`),
  KEY `fk_Reserva_Pessoa_idx` (`pessoa_oid`),
  KEY `fk_Reserva_Carro_idx` (`carro_oid`),
  CONSTRAINT `fk_Reserva_Pessoa` FOREIGN KEY (`pessoa_oid`) REFERENCES `Pessoa` (`pessoa_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Carro` FOREIGN KEY (`carro_oid`) REFERENCES `Carro` (`carro_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

-- Dump completed on 2014-09-16 17:06:04
