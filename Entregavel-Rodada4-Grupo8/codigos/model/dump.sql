-- MySQL dump 10.15  Distrib 10.0.14-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: VoceAluga
-- ------------------------------------------------------
-- Server version	10.0.14-MariaDB-log

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
  `formaPagamento` varchar(45) DEFAULT NULL,
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
INSERT INTO `Aluguel` VALUES ('423cea17-03f3-4c96-8cbf-b4b19ae6f0ce','f53c11b5-7583-49b1-9fb9-ce7879274c24','d3eef38f-b82f-4371-9087-b302ff389606','2014-12-03','2014-12-05','','6c1e8d45-4dd8-4c80-88b5-949332bce63e','Débito'),('9e799267-62c4-4c87-a355-284eba974558','02094a10-9955-4965-9692-56320948cc57','4143ad70-db96-47bd-b829-c306c22c0246','2014-12-01','2014-12-03','','1405fb73-8162-45d7-81d1-9d2890af9ed5','Crédito em 6 vezes'),('c671372f-ee01-4fff-b31e-78435c08d84b','b9d30a89-99e7-4bb7-9729-29db4d9f1069','0302a91b-0768-4f18-9070-383d256d968c','2014-12-01','2014-12-04','','dbb742f3-6f99-402d-808e-1b70fabffcb4','Crédito em 5 vezes'),('c8c07144-7d2b-4310-afa2-99ac1f99fe85','e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','0302a91b-0768-4f18-9070-383d256d968c','2014-12-01','2014-12-04','','f9f6548e-3d69-41c3-afd3-28f5c4e4a47d','Débito');
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
  `preco` decimal(50,2) DEFAULT NULL,
  `diaria` decimal(50,2) DEFAULT NULL,
  `vendido` varchar(45) NOT NULL,
  `formaPagamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`carro_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Carro`
--

LOCK TABLES `Carro` WRITE;
/*!40000 ALTER TABLE `Carro` DISABLE KEYS */;
INSERT INTO `Carro` VALUES ('02094a10-9955-4965-9692-56320948cc57','Fusca','FSC-1234',2014,'2014-12-02','Volks','false',6000.00,100.00,'true','Débito'),('226c015a-b641-4f35-bee5-7e63fa9926e1','adasd','daadasd',2014,'2014-04-27','adasd','false',121.00,123.00,'true','Crédito em 4 vezes'),('46583143-85e5-4a77-be06-bbde15f52f94','Ka','PLC-4567',2014,'2014-10-02','Ford','false',567.00,778.00,'true','Débito'),('512a77a2-97e5-486e-bc0e-a01bf2eabec9','Focus','FCK-1234',2014,'2014-11-24','Ford','false',1234.00,123.00,'true',NULL),('51c3a10d-36fa-4ed0-bb21-239f45a40b83','Teste','TES-1234',2014,'2014-11-24','Teste','false',234224.00,234.00,'true','Crédito em 3 vezes'),('557706fd-da9c-4cfa-9161-a7a54410a1ce','Fusion','GKJ-8754',2014,'2014-09-24','Ford','true',6000.00,300.00,'false',NULL),('a6a2ee7c-0e1d-4063-939b-77d6ec17a99d','Teste','TST-1234',2014,'2014-11-26','Marca Teste','true',99999.00,666.00,'false',NULL),('b3440c56-7558-41d0-9c7a-10e8556459d8','Uno','YUT-8678',2014,'2014-09-16','Fiat','false',5000.00,100.00,'true',NULL),('b9d30a89-99e7-4bb7-9729-29db4d9f1069','Sandero','XYZ-9876',2014,'2014-09-02','Renault','true',5000.00,200.00,'false',NULL),('d14baca7-50c2-4b6a-aed9-7b97814caaea','Fusion','HJK-4566',2014,'2014-09-24','Ford','false',NULL,NULL,'false',NULL),('e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','Doblo','ABC-1234',2014,'2014-09-29','Fiat','true',50000.00,100.00,'false',NULL),('e55217d6-16a3-46f2-b855-7d10bd8f1396','Ka','DGD-5676',2014,'2014-09-15','Ford','true',NULL,NULL,'false',NULL),('f1b84807-7635-11e4-9a8d-7ce9d3d7fde5','Veiculo Indisponivel','IND-1234',2014,'2014-09-15','Marca Indisponivel','false',6000.00,600.00,'false',NULL),('f53c11b5-7583-49b1-9fb9-ce7879274c24','Palio','PLO-1234',2014,'2014-12-02','Fiat','true',4000.00,100.00,'false','');
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
  `num_Filial` int(11) NOT NULL,
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
INSERT INTO `Filial` VALUES ('52b9b82b-7341-11e4-becf-7ce9d3d7fde5','f8b3cb2b-378c-42fd-91b7-7ac4fd61e838','Filial 01',1);
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
  `justificativa` varchar(300) DEFAULT NULL,
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
INSERT INTO `ListaNegra` VALUES ('8f2e688f-07a7-49d2-9991-e8c7cd56b49e','d013af35-29ac-4c4d-9185-313af1d8be87',NULL);
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
INSERT INTO `Pessoa` VALUES ('0302a91b-0768-4f18-9070-383d256d968c','Pessoa Teste','444444','23423','23424','A','44444444','pessoa@teste.com'),('0db70fb0-9c8b-41d8-b69e-d8715ac3c24b','Cliente Teste','11111111111','32423','234234','A','88888888','cliente@email.com'),('4143ad70-db96-47bd-b829-c306c22c0246','Fernando','555555','34543','24234','A','44445555','fernando@gmail.com'),('b6098f6e-8b0a-4385-924c-1f507b3c6496','Sildenir','876876','797987','876876','A','56565656','sildenir@email.com'),('d013af35-29ac-4c4d-9185-313af1d8be87','Carlos','0809809','879879','0897897','A','90909090','carlos@gmail.com'),('d064ae37-bf36-43d8-b499-518dc5a4f993','Bla','123456','43324','32424','A','23423456','bla@email.com'),('d3eef38f-b82f-4371-9087-b302ff389606','Lucas','222222','34545','43534','A','33334444','lucas@email.com'),('d85c73ea-d226-4b6c-a5d5-5926fc289a23','Cliente','434534','4545','34555','A','34343434','cliente@email.com'),('dd175750-0df6-402e-8412-635703437c94','Diego','99988','53553','5345','A','78787878','diego@email.com'),('eb9ab5f9-75b8-4079-a4ea-45344ec8a973','Carlos Gordo','123123','123123','1231231','A','56565656','carlos@gordo.com'),('f8b3cb2b-378c-42fd-91b7-7ac4fd61e838','Gerente','23123','324234','34234','A','23343434','gerente@filial.com');
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
INSERT INTO `Reserva` VALUES ('1405fb73-8162-45d7-81d1-9d2890af9ed5','4143ad70-db96-47bd-b829-c306c22c0246','02094a10-9955-4965-9692-56320948cc57','2014-12-01','2014-12-03','\0'),('24ae4ce2-dad8-4f0c-9852-eb30afb3aa84','dd175750-0df6-402e-8412-635703437c94','e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','2014-11-27','2014-11-29','\0'),('33ef0c89-75d0-431b-981b-068bf1a4a6db','eb9ab5f9-75b8-4079-a4ea-45344ec8a973','46583143-85e5-4a77-be06-bbde15f52f94','2014-10-28','2014-10-29','\0'),('4bd096d3-20c6-4f38-b8ec-c17d8013086d','eb9ab5f9-75b8-4079-a4ea-45344ec8a973','e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','2014-11-24','2014-11-26','\0'),('59250fc6-5f22-4bc5-b757-b63b4888db05','d064ae37-bf36-43d8-b499-518dc5a4f993','512a77a2-97e5-486e-bc0e-a01bf2eabec9','2014-11-26','2014-11-28','\0'),('6c1e8d45-4dd8-4c80-88b5-949332bce63e','d3eef38f-b82f-4371-9087-b302ff389606','f53c11b5-7583-49b1-9fb9-ce7879274c24','2014-12-03','2014-12-05','\0'),('77e27c9b-7810-4e4b-902f-4ec0ce8a492f','d013af35-29ac-4c4d-9185-313af1d8be87','e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','2014-10-01','2014-10-02','\0'),('a3c53bdf-180d-4573-9892-d612364b951a','dd175750-0df6-402e-8412-635703437c94','b9d30a89-99e7-4bb7-9729-29db4d9f1069','2014-10-28','2014-10-29','\0'),('c16a245a-345f-471f-bf2b-8ddf55166471','b6098f6e-8b0a-4385-924c-1f507b3c6496','51c3a10d-36fa-4ed0-bb21-239f45a40b83','2014-11-03','2014-11-06','\0'),('cfd5850c-44dc-4fb6-8339-43b716c7a1a3','4143ad70-db96-47bd-b829-c306c22c0246','b9d30a89-99e7-4bb7-9729-29db4d9f1069','2014-12-24','2014-12-26','\0'),('dbb742f3-6f99-402d-808e-1b70fabffcb4','0302a91b-0768-4f18-9070-383d256d968c','b9d30a89-99e7-4bb7-9729-29db4d9f1069','2014-12-01','2014-12-04','\0'),('e05e9147-ffcb-44be-bcef-2f0dab1eb820','b6098f6e-8b0a-4385-924c-1f507b3c6496','51c3a10d-36fa-4ed0-bb21-239f45a40b83','2014-11-04','2014-11-07','\0'),('f3904848-6bc2-4947-8954-8ea75926f0b0','d064ae37-bf36-43d8-b499-518dc5a4f993','a6a2ee7c-0e1d-4063-939b-77d6ec17a99d','2014-11-26','2014-11-27','\0'),('f5042f4f-2bd8-4fdb-8b5e-da2e252ea68b','eb9ab5f9-75b8-4079-a4ea-45344ec8a973','e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','2014-11-10','2014-11-14','\0'),('f9f6548e-3d69-41c3-afd3-28f5c4e4a47d','0302a91b-0768-4f18-9070-383d256d968c','e1dbd1c7-f36d-4919-97e9-ddbe5d06caa5','2014-12-01','2014-12-04','\0');
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

-- Dump completed on 2014-12-02 16:18:29
