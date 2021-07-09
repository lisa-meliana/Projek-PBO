-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2021 at 12:19 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gudang`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `KodeBarang` varchar(100) NOT NULL,
  `NamaBarang` varchar(100) NOT NULL,
  `Stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`KodeBarang`, `NamaBarang`, `Stok`) VALUES
('00001', 'Susu Dancow', 900),
('00002', 'Sun Pisang', 2700),
('00003', 'Minyak Bimoli 1 L', 1100);

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `No` int(11) NOT NULL,
  `KodePetugas` varchar(50) NOT NULL,
  `KodeBarang` varchar(100) NOT NULL,
  `Tanggal` date NOT NULL,
  `JumlahKeluar` int(11) NOT NULL,
  `JumlahMasuk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`No`, `KodePetugas`, `KodeBarang`, `Tanggal`, `JumlahKeluar`, `JumlahMasuk`) VALUES
(8, '001', '00003', '2021-07-07', 0, 200),
(9, '001', '00002', '2021-07-07', 300, 0),
(10, '002', '00003', '2021-07-07', 0, 400),
(11, '002', '00001', '2021-07-07', 100, 0);

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `KodePetugas` varchar(50) NOT NULL,
  `NamaLengkap` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Alamat` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`KodePetugas`, `NamaLengkap`, `Password`, `Alamat`) VALUES
('001', 'Tono', 'tono', 'Solo'),
('002', 'Tina', 'tina', 'Jogja');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`KodeBarang`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`No`),
  ADD KEY `KodePetugas` (`KodePetugas`),
  ADD KEY `KodeBarang` (`KodeBarang`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`KodePetugas`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`KodeBarang`) REFERENCES `barang` (`KodeBarang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`KodePetugas`) REFERENCES `petugas` (`KodePetugas`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
