-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2026 at 05:29 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbsistemaescolar`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_aluno`
--

CREATE TABLE `tb_aluno` (
  `pk_rgm` char(8) NOT NULL,
  `cpf` char(13) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `data_nasc` date NOT NULL,
  `email` varchar(40) NOT NULL,
  `numero` char(14) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `municipio` varchar(20) NOT NULL,
  `uf` enum('AC','AL','AP','AM','BA','CE','DF','ES','GO','MA','MT','MS','MG','PA','PB','PR','PE','PI','RJ','RN','RS','RO','RR','SC','SP','SE','TO') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_curso`
--

CREATE TABLE `tb_curso` (
  `fk_rgm` char(8) NOT NULL,
  `pk_curso` enum('Analise e desenvolvimento de sistemas','Ciencia da computação','','') NOT NULL,
  `campus` enum('Tatuape','Villa-Lobos','EAD','') NOT NULL,
  `periodo` enum('Matutino','Vespertino','Noturno','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_notas`
--

CREATE TABLE `tb_notas` (
  `fk_rgm` char(8) NOT NULL,
  `disciplina` enum('Programação Orientada a Objeto','Banco de dados','Programação WEB','Programação de Computadores','Modelagem de Dados','Sistemas Operacionais','Engenharia de Software','Computação em Nuvem','Análise e Projeto de Sistemas','Modelagem de Negócios e Requisitos') NOT NULL,
  `semestre` enum('1º','2º','3º','4º','5º','6º','7º','8º') NOT NULL,
  `nota` enum('0','0,5','1','1,5','2','2,5','3','3,5','4','4,5','5','5,5','6','6,5','7','7,5','8','8,5','9','9,5','10') NOT NULL,
  `faltas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_aluno`
--
ALTER TABLE `tb_aluno`
  ADD PRIMARY KEY (`pk_rgm`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Indexes for table `tb_curso`
--
ALTER TABLE `tb_curso`
  ADD PRIMARY KEY (`fk_rgm`,`pk_curso`);

--
-- Indexes for table `tb_notas`
--
ALTER TABLE `tb_notas`
  ADD PRIMARY KEY (`fk_rgm`,`disciplina`,`semestre`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_curso`
--
ALTER TABLE `tb_curso`
  ADD CONSTRAINT `tb_curso_ibfk_1` FOREIGN KEY (`fk_rgm`) REFERENCES `tb_aluno` (`pk_rgm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_notas`
--
ALTER TABLE `tb_notas`
  ADD CONSTRAINT `tb_notas_ibfk_1` FOREIGN KEY (`fk_rgm`) REFERENCES `tb_aluno` (`pk_rgm`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
