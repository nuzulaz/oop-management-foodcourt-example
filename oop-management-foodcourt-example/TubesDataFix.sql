-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2018 at 02:01 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubes`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `idBooking` varchar(20) NOT NULL,
  `jmlPesan` varchar(20) NOT NULL,
  `tglBooking` date NOT NULL,
  `id_cust` int(20) NOT NULL,
  `noMeja` int(20) NOT NULL,
  `namaRestaurant` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`idBooking`, `jmlPesan`, `tglBooking`, `id_cust`, `noMeja`, `namaRestaurant`) VALUES
('1', '1', '2018-12-12', 1, 1, 'Icha Food'),
('2', '1', '2018-12-13', 1, 1, 'Icha Food');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `nama` varchar(20) NOT NULL,
  `id_cust` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`nama`, `id_cust`, `username`, `password`) VALUES
('sasa', '1', 'sasa', 'sasa'),
('12', '12', '12', '12'),
('farah', '2', 'farah', 'farah');

-- --------------------------------------------------------

--
-- Table structure for table `foodcourt_tabel`
--

CREATE TABLE `foodcourt_tabel` (
  `nama` varchar(20) NOT NULL,
  `id_foodcourt` varchar(20) NOT NULL,
  `lokasi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foodcourt_tabel`
--

INSERT INTO `foodcourt_tabel` (`nama`, `id_foodcourt`, `lokasi`) VALUES
('Kantin Cowo', 'FC12', 'Asrama Putra'),
('Kantin Cewe', 'FC13', 'Asrama Putri'),
('Kantin GKU', 'FC14', 'GKU'),
('Kantin Teknik', 'FC15', 'Fakultas Teknik'),
('Kantin Perpustakaan', 'FC16', 'Oplib');

-- --------------------------------------------------------

--
-- Table structure for table `meja`
--

CREATE TABLE `meja` (
  `noMeja` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_tabel`
--

CREATE TABLE `restaurant_tabel` (
  `nama` varchar(20) NOT NULL,
  `noToko` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `id_foodcourt` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restaurant_tabel`
--

INSERT INTO `restaurant_tabel` (`nama`, `noToko`, `status`, `id_foodcourt`) VALUES
('Icha Food', 'RS1', 'Delivery Off', 'FC12'),
('Mie Hot Plate', 'RS2', 'Delivery On', 'FC12'),
('Soto Ayam', 'RS3', 'Delivery On', 'FC13'),
('Soto Daging', 'RS4', 'Delivery Off', 'FC14');

-- --------------------------------------------------------

--
-- Table structure for table `tablefood`
--

CREATE TABLE `tablefood` (
  `Nama` varchar(25) NOT NULL,
  `Variant` varchar(25) NOT NULL,
  `Price` int(7) NOT NULL,
  `noToko` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tablefood`
--

INSERT INTO `tablefood` (`Nama`, `Variant`, `Price`, `noToko`) VALUES
('1', '1', 1, ''),
('23', '13', 132, 'Delivery Off'),
('312', '312', 312, 'RS1'),
('aewaew', 'wwe', 46, 'Delivery Off'),
('Ayam Katsu', '1', 16000, 'RS1'),
('Mie Hot Plate Ayam Rica', '1', 16000, 'RS2'),
('vtvu', 'wwe', 46, 'Delivery Off');

-- --------------------------------------------------------

--
-- Table structure for table `tablekurir`
--

CREATE TABLE `tablekurir` (
  `Nama` varchar(25) NOT NULL,
  `Age` varchar(10) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tablekurir`
--

INSERT INTO `tablekurir` (`Nama`, `Age`, `Gender`, `Address`) VALUES
('12', '32', 'Man', '32'),
('null', '1', 'Man', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tableparkir`
--

CREATE TABLE `tableparkir` (
  `Nopol` varchar(10) NOT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tableparkir`
--

INSERT INTO `tableparkir` (`Nopol`, `type`) VALUES
('1', 'Car');

-- --------------------------------------------------------

--
-- Table structure for table `viewbooking`
--

CREATE TABLE `viewbooking` (
  `NamaRestaurant` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `viewbooking`
--

INSERT INTO `viewbooking` (`NamaRestaurant`) VALUES
('Hoka Hoka Bento'),
('Icha Food'),
('Imperial Kitchen'),
('Mantap Fried Chicken'),
('Masakan Jawa'),
('Padang Mantap'),
('Raa Chaa'),
('Solaria'),
('Sunda Jawara'),
('Sushi Tei');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`idBooking`,`tglBooking`,`noMeja`),
  ADD KEY `id_cust` (`id_cust`),
  ADD KEY `no_meja` (`noMeja`),
  ADD KEY `tglBooking` (`tglBooking`,`noMeja`),
  ADD KEY `tglBooking_2` (`tglBooking`),
  ADD KEY `tglBooking_3` (`tglBooking`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_cust`);

--
-- Indexes for table `foodcourt_tabel`
--
ALTER TABLE `foodcourt_tabel`
  ADD PRIMARY KEY (`id_foodcourt`);

--
-- Indexes for table `meja`
--
ALTER TABLE `meja`
  ADD PRIMARY KEY (`noMeja`);

--
-- Indexes for table `restaurant_tabel`
--
ALTER TABLE `restaurant_tabel`
  ADD PRIMARY KEY (`noToko`),
  ADD KEY `id_foodcourt` (`id_foodcourt`);

--
-- Indexes for table `tablefood`
--
ALTER TABLE `tablefood`
  ADD PRIMARY KEY (`Nama`),
  ADD KEY `id_restaurant` (`noToko`);

--
-- Indexes for table `tablekurir`
--
ALTER TABLE `tablekurir`
  ADD PRIMARY KEY (`Nama`);

--
-- Indexes for table `tableparkir`
--
ALTER TABLE `tableparkir`
  ADD PRIMARY KEY (`Nopol`);

--
-- Indexes for table `viewbooking`
--
ALTER TABLE `viewbooking`
  ADD PRIMARY KEY (`NamaRestaurant`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
