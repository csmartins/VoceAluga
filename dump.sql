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
-- Dumping data for table `Aluguel`
--

LOCK TABLES `Aluguel` WRITE;
/*!40000 ALTER TABLE `Aluguel` DISABLE KEYS */;
/*!40000 ALTER TABLE `Aluguel` ENABLE KEYS */;
UNLOCK TABLES;

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
  `preco` decimal(10,2) DEFAULT NULL,
  `diaria` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`carro_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Carro`
--

LOCK TABLES `Carro` WRITE;
/*!40000 ALTER TABLE `Carro` DISABLE KEYS */;
INSERT INTO `Carro` VALUES ('46583143-85e5-4a77-be06-bbde15f52f94','Ka','PLC-4567',2014,'2014-10-02','Ford','true',567.00,778.00),('51c3a10d-36fa-4ed0-bb21-239f45a40b83','Teste','TES-1234',2014,'2014-09-10','Teste','true',234224.00,234.00),('557706fd-da9c-4cfa-9161-a7a54410a1ce','Fusion','GKJ-8754',2014,'2014-09-24','Ford','true',NULL,NULL),('a6a2ee7c-0e1d-4063-939b-77d6ec17a99d','Teste','TST-1234',2014,'2014-09-17','Marca Teste','true',99999.00,666.00),('b3440c56-7558-41d0-9c7a-10e8556459d8','Uno','YUT-8678',2014,'2014-09-16','Fiat','false',NULL,NULL),('b9d30a89-99e7-4bb7-9729-29db4d9f1069','Sandero','XYZ-9876',2014,'2014-09-02','Renault','true',NULL,NULL),('d14baca7-50c2-4b6a-aed9-7b97814caaea','Fusion','HJK-4566',2014,'2014-09-24','Ford','false',NULL,NULL),('e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','Doblo','ABC-1234',2014,'2014-09-29','Fiat','true',50000.00,100.00),('e55217d6-16a3-46f2-b855-7d10bd8f1396','Ka','DGD-5676',2014,'2014-09-15','Ford','false',NULL,NULL);
/*!40000 ALTER TABLE `Carro` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `Filial`
--

LOCK TABLES `Filial` WRITE;
/*!40000 ALTER TABLE `Filial` DISABLE KEYS */;
/*!40000 ALTER TABLE `Filial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GrupoCarro`
--

DROP TABLE IF EXISTS `GrupoCarro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GrupoCarro` (
  `grupoCarro_oid` varchar(45) NOT NULL DEFAULT '',
  `total` int(11) DEFAULT NULL,
  `disponiveis` int(11) DEFAULT NULL,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`grupoCarro_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GrupoCarro`
--

LOCK TABLES `GrupoCarro` WRITE;
/*!40000 ALTER TABLE `GrupoCarro` DISABLE KEYS */;
/*!40000 ALTER TABLE `GrupoCarro` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `ListaNegra`
--

LOCK TABLES `ListaNegra` WRITE;
/*!40000 ALTER TABLE `ListaNegra` DISABLE KEYS */;
/*!40000 ALTER TABLE `ListaNegra` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `fk_Manutencao_Carro` FOREIGN KEY (`carro_oid`) REFERENCES `Carro` (`carro_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Manutencao_Filial` FOREIGN KEY (`filal_oid`) REFERENCES `Filial` (`filial_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Manutencao`
--

LOCK TABLES `Manutencao` WRITE;
/*!40000 ALTER TABLE `Manutencao` DISABLE KEYS */;
/*!40000 ALTER TABLE `Manutencao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Perfil`
--

DROP TABLE IF EXISTS `Perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Perfil` (
  `perfil_oid` varchar(45) NOT NULL DEFAULT '',
  `descricao` varchar(255) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`perfil_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Perfil`
--

LOCK TABLES `Perfil` WRITE;
/*!40000 ALTER TABLE `Perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `Perfil` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `Permissao`
--

LOCK TABLES `Permissao` WRITE;
/*!40000 ALTER TABLE `Permissao` DISABLE KEYS */;
/*!40000 ALTER TABLE `Permissao` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `Pessoa`
--

LOCK TABLES `Pessoa` WRITE;
/*!40000 ALTER TABLE `Pessoa` DISABLE KEYS */;
INSERT INTO `Pessoa` VALUES ('0','Lucas Balabram','11111111111','',NULL,NULL,NULL,NULL),('003f553b-1765-49f1-831b-a8b1698ad0d6','Ana Mel da Cohab','12345678','11111111','11111','A','11111111','emaildaanamel@email.com'),('1','asdasd','123123','213123','12312313','A','12121212','adasd@adasda.com'),('1093714981','Lucas ','213123123','123123','123123','B','11112222','lucas@gmail.com'),('1495706053','Carlos Eduardo','111111111','11111111','11111111','A','11111111','carlos@gmail.com'),('1729401304','carlos','23132123','123123132','123123123','A','23232323','aadasd@aasdasd.com'),('1893793160','asdasd','123123','121313','123123','A','12121212','adasda@asasd.com'),('301777035','fernando','12121212','1121212','2121212','C','12121212','dasd@asdasd.com'),('56760153','Elisa','986780','57667','57567','A','78787878','elisa@email.com'),('676100635','blablabla','123123','1231231','132123','A','12121212','adasd@asdas.com'),('b6098f6e-8b0a-4385-924c-1f507b3c6496','Sildenir','876876','797987','876876','A','56565656','sildenir@email.com'),('d013af35-29ac-4c4d-9185-313af1d8be87','Carlos','0809809','879879','0897897','A','90909090','carlos@gmail.com'),('dd175750-0df6-402e-8412-635703437c94','Diego','99988','53553','5345','A','78787878','diego@email.com'),('eb9ab5f9-75b8-4079-a4ea-45344ec8a973','Carlos Gordo','123123','123123','1231231','A','56565656','carlos@gordo.com');
/*!40000 ALTER TABLE `Pessoa` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `fk_Reserva_Carro` FOREIGN KEY (`carro_oid`) REFERENCES `Carro` (`carro_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Pessoa` FOREIGN KEY (`pessoa_oid`) REFERENCES `Pessoa` (`pessoa_oid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reserva`
--

LOCK TABLES `Reserva` WRITE;
/*!40000 ALTER TABLE `Reserva` DISABLE KEYS */;
INSERT INTO `Reserva` VALUES ('7584e34c-3047-4f7d-a335-f3566b093ac6','b6098f6e-8b0a-4385-924c-1f507b3c6496','46583143-85e5-4a77-be06-bbde15f52f94','2014-10-02','2014-10-10','\0'),('77e27c9b-7810-4e4b-902f-4ec0ce8a492f','d013af35-29ac-4c4d-9185-313af1d8be87','e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','2014-10-01','2014-10-02','\0'),('839aa6f0-3c5d-463a-ae89-4546d0d06c12','56760153','557706fd-da9c-4cfa-9161-a7a54410a1ce','2014-10-01','2014-10-02','\0'),('943c97ee-050b-47eb-8ed5-9e434c93aa56','dd175750-0df6-402e-8412-635703437c94','e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','2014-10-02','2014-10-10','\0'),('b66536f2-ac03-4373-b38a-fc8d555d2720','301777035','e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','2014-10-01','2014-10-02','\0'),('d1ab581e-114e-428d-8e15-708e5867552e','301777035','e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','2014-10-01','2014-10-02','\0');
/*!40000 ALTER TABLE `Reserva` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-21 14:00:23
