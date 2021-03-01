-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 28, 2021 at 10:51 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `controle_ponto`
--

-- --------------------------------------------------------

--
-- Table structure for table `alocacao`
--

CREATE TABLE `alocacao` (
  `id` bigint(20) NOT NULL,
  `dia` datetime NOT NULL,
  `tempo` time NOT NULL,
  `nome_projeto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `alocacao`
--

INSERT INTO `alocacao` (`id`, `dia`, `tempo`, `nome_projeto`) VALUES
(1, '2021-02-28 18:40:30', '08:00:00', 'ACME Corporation');

-- --------------------------------------------------------

--
-- Table structure for table `momento`
--

CREATE TABLE `momento` (
  `id` bigint(20) NOT NULL,
  `data_hora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `momento`
--

INSERT INTO MOMENTO values (1, '2021-02-28 18:40:30');

-- --------------------------------------------------------

--
-- Table structure for table `registro`
--

CREATE TABLE `registro` (
  `id` bigint(20) NOT NULL,
  `dia` datetime DEFAULT NULL,
  `primeiro_horario` time DEFAULT NULL,
  `segundo_horario` time DEFAULT NULL,
  `terceiro_horario` time DEFAULT NULL,
  `quarto_horario` time DEFAULT NULL,
  `id_momento` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registro`
--

INSERT INTO `registro` (`id`, `dia`, `primeiro_horario`, `segundo_horario`, `terceiro_horario`, `quarto_horario`, `id_momento`) VALUES
(1, '2021-02-28 18:40:30', '08:00:00', '12:00:00', '13:00:00', '17:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `relatorio`
--

CREATE TABLE `relatorio` (
  `id` bigint(20) NOT NULL,
  `mes` varchar(255) NOT NULL,
  `horas_trabalhadas` varchar(255) NOT NULL,
  `horas_excedentes` varchar(255) NOT NULL,
  `horas_devidas` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alocacao`
--
ALTER TABLE `alocacao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `momento`
--
ALTER TABLE `momento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_momento` (`id_momento`);

--
-- Indexes for table `relatorio`
--
ALTER TABLE `relatorio`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alocacao`
--
ALTER TABLE `alocacao`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `registro`
--
ALTER TABLE `registro`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `relatorio`
--
ALTER TABLE `relatorio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `registro`
--
ALTER TABLE `registro`
  ADD CONSTRAINT `id_momento_registro` FOREIGN KEY (`id_momento`) REFERENCES `momento` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
