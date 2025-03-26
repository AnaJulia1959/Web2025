-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26/03/2025 às 01:01
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `spring`
--
CREATE DATABASE IF NOT EXISTS `spring` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `spring`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tabela truncada antes do insert `categoria`
--

TRUNCATE TABLE `categoria`;
--
-- Despejando dados para a tabela `categoria`
--

INSERT DELAYED IGNORE INTO `categoria` (`id`, `nome`) VALUES
(103, 'shrek');

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria_seq`
--

DROP TABLE IF EXISTS `categoria_seq`;
CREATE TABLE IF NOT EXISTS `categoria_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tabela truncada antes do insert `categoria_seq`
--

TRUNCATE TABLE `categoria_seq`;
--
-- Despejando dados para a tabela `categoria_seq`
--

INSERT DELAYED IGNORE INTO `categoria_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Estrutura para tabela `professor`
--

DROP TABLE IF EXISTS `professor`;
CREATE TABLE IF NOT EXISTS `professor` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tabela truncada antes do insert `professor`
--

TRUNCATE TABLE `professor`;
--
-- Despejando dados para a tabela `professor`
--

INSERT DELAYED IGNORE INTO `professor` (`id`, `email`, `nome`) VALUES
(1, 'email1@dominio.com', 'Professor 1'),
(2, 'email2@dominio.com', 'Professor 2'),
(3, 'email3@dominio.com', 'Professor 3'),
(4, 'email4@dominio.com', 'Professor 4'),
(5, 'email5@dominio.com', 'Professor 5');

-- --------------------------------------------------------

--
-- Estrutura para tabela `professor_seq`
--

DROP TABLE IF EXISTS `professor_seq`;
CREATE TABLE IF NOT EXISTS `professor_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tabela truncada antes do insert `professor_seq`
--

TRUNCATE TABLE `professor_seq`;
--
-- Despejando dados para a tabela `professor_seq`
--

INSERT DELAYED IGNORE INTO `professor_seq` (`next_val`) VALUES
(1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
