-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28/04/2024 às 17:28
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `farmacia`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `entrada`
--

CREATE TABLE `entrada` (
  `ide` bigint(20) NOT NULL,
  `preco` varchar(100) NOT NULL,
  `qtd` int(11) DEFAULT NULL,
  `dataentrada` datetime DEFAULT NULL,
  `caducidade` date DEFAULT NULL,
  `idp` bigint(20) DEFAULT NULL,
  `idf` bigint(20) DEFAULT NULL,
  `codigo_barra` varchar(20) DEFAULT NULL,
  `valor_compra` double NOT NULL,
  `lucro` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idf` bigint(20) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `genero` enum('MASCULINO','FEMENINO') DEFAULT NULL,
  `tel` varchar(100) DEFAULT NULL,
  `bi` varchar(100) DEFAULT NULL,
  `estado` enum('activo','não activo') NOT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `senha` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `idp` bigint(20) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `categoria` varchar(60) DEFAULT NULL,
  `idf` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `venda`
--

CREATE TABLE `venda` (
  `idv` bigint(20) NOT NULL,
  `qtdrequerida` int(11) DEFAULT NULL,
  `totalCompra` int(11) DEFAULT NULL,
  `datavenda` date DEFAULT NULL,
  `fatura` varchar(22) DEFAULT NULL,
  `idp` bigint(20) DEFAULT NULL,
  `idf` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura stand-in para view `ventrada`
-- (Veja abaixo para a visão atual)
--
CREATE TABLE `ventrada` (
`CODIGO_PRODUTO` bigint(20)
,`CODIGO_ENTRADA` bigint(20)
,`MEDICAMENTO` varchar(200)
,`DESCRICAO` varchar(255)
,`CATEGORIA` varchar(60)
,`PRECO` varchar(100)
,`QUANTIDADE` int(11)
,`DATA_ENTRADA` datetime
,`CADUCIDADE` date
,`CODIGO_BARRA` varchar(20)
,`VALOR_COMPR` double
,`LUCRO` double
,`CODIGO_FUNCIONARIO` bigint(20)
,`NOME_FUNCIONARIO` varchar(100)
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para view `vvenda`
-- (Veja abaixo para a visão atual)
--
CREATE TABLE `vvenda` (
`datavenda` date
,`idf` bigint(20)
,`codigop` bigint(20)
,`codigov` bigint(20)
,`nome` varchar(200)
,`descricao` varchar(255)
,`categoria` varchar(60)
,`quantidade` int(11)
,`totalcompra` int(11)
,`fatura` varchar(22)
,`nomef` varchar(100)
,`preco` varchar(100)
);

-- --------------------------------------------------------

--
-- Estrutura para view `ventrada`
--
DROP TABLE IF EXISTS `ventrada`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ventrada`  AS SELECT `p`.`idp` AS `CODIGO_PRODUTO`, `e`.`ide` AS `CODIGO_ENTRADA`, `p`.`nome` AS `MEDICAMENTO`, `p`.`descricao` AS `DESCRICAO`, `p`.`categoria` AS `CATEGORIA`, `e`.`preco` AS `PRECO`, `e`.`qtd` AS `QUANTIDADE`, `e`.`dataentrada` AS `DATA_ENTRADA`, `e`.`caducidade` AS `CADUCIDADE`, `e`.`codigo_barra` AS `CODIGO_BARRA`, `e`.`valor_compra` AS `VALOR_COMPR`, `e`.`lucro` AS `LUCRO`, `f`.`idf` AS `CODIGO_FUNCIONARIO`, `f`.`nome` AS `NOME_FUNCIONARIO` FROM ((`entrada` `e` join `funcionario` `f` on(`e`.`idf` = `f`.`idf`)) join `produto` `p` on(`e`.`idp` = `p`.`idp`)) ;

-- --------------------------------------------------------

--
-- Estrutura para view `vvenda`
--
DROP TABLE IF EXISTS `vvenda`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vvenda`  AS SELECT `v`.`datavenda` AS `datavenda`, `f`.`idf` AS `idf`, `p`.`idp` AS `codigop`, `v`.`idv` AS `codigov`, `p`.`nome` AS `nome`, `p`.`descricao` AS `descricao`, `p`.`categoria` AS `categoria`, `v`.`qtdrequerida` AS `quantidade`, `v`.`totalCompra` AS `totalcompra`, `v`.`fatura` AS `fatura`, `f`.`nome` AS `nomef`, `e`.`preco` AS `preco` FROM (((`venda` `v` join `produto` `p` on(`v`.`idp` = `p`.`idp`)) join `funcionario` `f` on(`v`.`idf` = `f`.`idf`)) join `entrada` `e` on(`p`.`idp` = `e`.`idp`)) ;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`ide`),
  ADD UNIQUE KEY `idp_2` (`idp`),
  ADD KEY `idp` (`idp`),
  ADD KEY `idf` (`idf`);

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idf`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idp`),
  ADD KEY `idf` (`idf`);

--
-- Índices de tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`idv`),
  ADD KEY `idf` (`idf`),
  ADD KEY `idp` (`idp`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `entrada`
--
ALTER TABLE `entrada`
  MODIFY `ide` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idf` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `idp` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `venda`
--
ALTER TABLE `venda`
  MODIFY `idv` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `entrada_ibfk_1` FOREIGN KEY (`idp`) REFERENCES `produto` (`idp`),
  ADD CONSTRAINT `entrada_ibfk_2` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`);

--
-- Restrições para tabelas `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`);

--
-- Restrições para tabelas `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`idf`) REFERENCES `funcionario` (`idf`) ON UPDATE CASCADE,
  ADD CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`idp`) REFERENCES `produto` (`idp`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
