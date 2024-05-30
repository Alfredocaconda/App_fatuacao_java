bb-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: farmacia
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada` (
  `ide` bigint(20) NOT NULL AUTO_INCREMENT,
  `preco` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `qtd` int(11) DEFAULT NULL,
  `dataentrada` datetime DEFAULT NULL,
  `caducidade` date DEFAULT NULL,
  `idp` bigint(20) DEFAULT NULL,
  `idf` bigint(20) DEFAULT NULL,
  `codigo_barra` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ide`),
  UNIQUE KEY `idp_2` (`idp`),
  KEY `idp` (`idp`),
  KEY `idf` (`idf`),
  CONSTRAINT `entrada_ibfk_1` FOREIGN KEY (`idp`) REFERENCES `produto` (`idp`),
  CONSTRAINT `entrada_ibfk_2` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,'100',95,'2023-03-25 22:23:26','2023-03-25',3,1,'555555555'),(2,'100',96,'2023-03-25 22:24:05','2023-03-25',1,1,'99999999'),(4,'100',105,'2023-03-25 22:24:30','2023-03-25',2,1,'8888888888'),(5,'100',9,'2023-03-25 22:25:18','2023-03-29',4,1,'777662');
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `idf` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `genero` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tel` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bi` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cargo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `estado` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `usuario` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `senha` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idf`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'PROGRAMADOR','MASCULINO','935460590','212345BA098','GERENTE','ACTIVO','PROGRAMADOR','PROGRAMADOR'),(2,'alfredo binji','MASCULINO','298358','23467','TECNICO','ACTIVO','alfredo','alfredo');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idp` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `categoria` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idf` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idp`),
  KEY `idf` (`idf`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'METRO','250MG','COMPRIMIDO',1),(2,'DOLAREM','250MG','COMPRIMIDO',1),(3,'DOLAREM','250MG','XAROPE',1),(4,'PARACETAMOR','200MG','COMPRIMIDO',1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rastreioe`
--

DROP TABLE IF EXISTS `rastreioe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rastreioe` (
  `idR` bigint(20) NOT NULL AUTO_INCREMENT,
  `qtdencontrada` int(11) DEFAULT NULL,
  `qtdadicionada` int(11) DEFAULT NULL,
  `qtdtotal` int(11) DEFAULT NULL,
  `dataactualizacao` datetime DEFAULT NULL,
  `tipo` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idp` bigint(20) DEFAULT NULL,
  `idf` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idR`),
  KEY `idp` (`idp`),
  KEY `idf` (`idf`),
  CONSTRAINT `rastreioe_ibfk_1` FOREIGN KEY (`idp`) REFERENCES `produto` (`idp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rastreioe_ibfk_2` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rastreioe`
--

LOCK TABLES `rastreioe` WRITE;
/*!40000 ALTER TABLE `rastreioe` DISABLE KEYS */;
/*!40000 ALTER TABLE `rastreioe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `idv` bigint(20) NOT NULL AUTO_INCREMENT,
  `qtdrequerida` int(11) DEFAULT NULL,
  `totalCompra` int(11) DEFAULT NULL,
  `datavenda` date DEFAULT NULL,
  `fatura` varchar(22) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idp` bigint(20) DEFAULT NULL,
  `idf` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idv`),
  KEY `idf` (`idf`),
  KEY `idp` (`idp`),
  CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`) ON UPDATE CASCADE,
  CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`idp`) REFERENCES `produto` (`idp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,1,100,'2023-03-25','20230325212056',1,1),(2,1,100,'2023-03-25','20230325212125',3,1),(3,1,100,'2023-03-25','20230325212149',3,1),(4,1,100,'2023-03-25','20230325212149',3,1),(5,2,200,'2023-03-25','20230325224253',2,1),(6,2,200,'2023-03-25','20230325224253',1,1),(7,5,500,'2023-03-25','20230325224329',2,1),(8,1,100,'2023-03-25','20230325224429',4,1),(9,2,200,'2023-03-25','20230325224429',3,1),(10,4,400,'2023-03-25','20230325232834',2,1);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `ventrada`
--

DROP TABLE IF EXISTS `ventrada`;
/*!50001 DROP VIEW IF EXISTS `ventrada`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `ventrada` (
  `CATEGORIA` tinyint NOT NULL,
  `DESCRICAO` tinyint NOT NULL,
  `CODIGOP` tinyint NOT NULL,
  `PRECO` tinyint NOT NULL,
  `codigo` tinyint NOT NULL,
  `medicamento` tinyint NOT NULL,
  `quantidade` tinyint NOT NULL,
  `dataE` tinyint NOT NULL,
  `caducidade` tinyint NOT NULL,
  `funcionario` tinyint NOT NULL,
  `codigof` tinyint NOT NULL,
  `codigo_barra` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vvenda`
--

DROP TABLE IF EXISTS `vvenda`;
/*!50001 DROP VIEW IF EXISTS `vvenda`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vvenda` (
  `datavenda` tinyint NOT NULL,
  `idf` tinyint NOT NULL,
  `codigop` tinyint NOT NULL,
  `codigov` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `descricao` tinyint NOT NULL,
  `categoria` tinyint NOT NULL,
  `quantidade` tinyint NOT NULL,
  `totalcompra` tinyint NOT NULL,
  `fatura` tinyint NOT NULL,
  `nomef` tinyint NOT NULL,
  `preco` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `ventrada`
--

/*!50001 DROP TABLE IF EXISTS `ventrada`*/;
/*!50001 DROP VIEW IF EXISTS `ventrada`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ventrada` AS select `p`.`categoria` AS `CATEGORIA`,`p`.`descricao` AS `DESCRICAO`,`p`.`idp` AS `CODIGOP`,`e`.`preco` AS `PRECO`,`e`.`ide` AS `codigo`,`p`.`nome` AS `medicamento`,`e`.`qtd` AS `quantidade`,`e`.`dataentrada` AS `dataE`,`e`.`caducidade` AS `caducidade`,`f`.`nome` AS `funcionario`,`f`.`idf` AS `codigof`,`e`.`codigo_barra` AS `codigo_barra` from ((`entrada` `e` join `produto` `p` on(`e`.`idp` = `p`.`idp`)) join `funcionario` `f` on(`e`.`idf` = `f`.`idf`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vvenda`
--

/*!50001 DROP TABLE IF EXISTS `vvenda`*/;
/*!50001 DROP VIEW IF EXISTS `vvenda`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vvenda` AS select `v`.`datavenda` AS `datavenda`,`f`.`idf` AS `idf`,`p`.`idp` AS `codigop`,`v`.`idv` AS `codigov`,`p`.`nome` AS `nome`,`p`.`descricao` AS `descricao`,`p`.`categoria` AS `categoria`,`v`.`qtdrequerida` AS `quantidade`,`v`.`totalCompra` AS `totalcompra`,`v`.`fatura` AS `fatura`,`f`.`nome` AS `nomef`,`e`.`preco` AS `preco` from (((`venda` `v` join `produto` `p` on(`v`.`idp` = `p`.`idp`)) join `funcionario` `f` on(`v`.`idf` = `f`.`idf`)) join `entrada` `e` on(`p`.`idp` = `e`.`idp`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-05 15:07:12
