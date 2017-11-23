-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2017 at 08:56 AM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tugas_akhir`
--

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id` int(11) NOT NULL,
  `id_kelas` int(11) NOT NULL,
  `hari` varchar(10) NOT NULL,
  `jam_masuk` time NOT NULL,
  `jam_keluar` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id`, `id_kelas`, `hari`, `jam_masuk`, `jam_keluar`) VALUES
(1, 1, 'Senin', '08:00:00', '10:00:00'),
(2, 1, 'Selasa', '08:00:00', '10:00:00'),
(3, 2, 'Kamis', '09:00:00', '10:00:00'),
(4, 2, 'Jumat', '08:00:00', '10:00:00'),
(5, 3, 'Selasa', '08:00:00', '10:00:00'),
(6, 4, 'Rabu', '08:00:00', '10:00:00'),
(7, 5, 'Rabu', '09:00:00', '10:00:00'),
(8, 5, 'Jumat', '08:00:00', '10:00:00'),
(9, 6, 'Senin', '08:00:00', '10:00:00'),
(10, 6, 'Rabu', '12:00:00', '13:00:00'),
(11, 7, 'Kamis', '09:00:00', '10:00:00'),
(12, 7, 'Jumat', '08:00:00', '10:00:00'),
(13, 8, 'Selasa', '08:00:00', '10:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id` int(11) NOT NULL,
  `nama_kelas` varchar(50) NOT NULL,
  `id_matkul` int(11) NOT NULL,
  `dosen` varchar(30) NOT NULL,
  `ruangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id`, `nama_kelas`, `id_matkul`, `dosen`, `ruangan`) VALUES
(1, 'Sister A', 1, 'Harry Budi Santoso, Phd', 'R. 2303'),
(2, 'Sister B', 1, 'Harry Budi Santoso, Phd', 'R. 2301'),
(3, 'Sister C', 1, 'Harry Budi Santoso, Phd', 'R. 2302'),
(4, 'APAP A', 2, 'Qorib Munajat', 'R. 2302'),
(5, 'APAP B', 2, 'Samuel Louvan', 'R. 2301'),
(6, 'APAP C', 2, 'Qorib Munajat', 'R. 2303'),
(7, 'Anaperancis A', 3, 'Nur Fitriah', 'R. 2301'),
(8, 'Anaperancis B', 3, 'Nur Fitriah', 'R. 2304'),
(9, 'Anaperancis C', 3, 'Zainal Arifin', 'R. 2303'),
(10, 'Manpro TI A', 3, 'Ave Pinem', 'R. 2305'),
(11, 'Manpro TI B', 3, 'Indra Budi', 'R. 2303'),
(12, 'DDP A', 3, 'Hadaiq Rolis S', 'R. 2302'),
(13, 'DDP B', 3, 'Hadaiq Rolis S', 'R. 2301'),
(14, 'DDP C', 3, 'Alfan Farizki', 'R. 2305'),
(15, 'DDP D', 3, 'Denny', 'R. 2304'),
(16, 'DDP E', 3, 'Lim Yohanes', 'R. 2302'),
(17, 'PPSI A', 3, 'Iik Wilarso', 'R. 2301'),
(18, 'PPSI B', 3, 'Joshua Suherman', 'R. 2307');

-- --------------------------------------------------------

--
-- Table structure for table `link_student_kuri`
--

CREATE TABLE `link_student_kuri` (
  `id_student` int(11) NOT NULL,
  `id_kuri` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `link_student_kuri`
--

INSERT INTO `link_student_kuri` (`id_student`, `id_kuri`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 2),
(7, 3),
(8, 2),
(9, 1),
(10, 1),
(11, 1),
(12, 2),
(13, 1),
(14, 1),
(15, 3),
(16, 4),
(17, 2),
(18, 1),
(19, 2),
(20, 1),
(21, 2),
(22, 1);

-- --------------------------------------------------------

--
-- Table structure for table `term`
--

CREATE TABLE `term` (
  `id` int(11) NOT NULL,
  `nomor` varchar(20) NOT NULL,
  `tgl_irs_start` date NOT NULL,
  `tgl_irs_end` date NOT NULL,
  `isi_irs_start` date NOT NULL,
  `isi_irs_end` date NOT NULL,
  `term_type` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `term`
--

INSERT INTO `term` (`id`, `nomor`, `tgl_irs_start`, `tgl_irs_end`, `isi_irs_start`, `isi_irs_end`, `term_type`) VALUES
(1, '2014/2015', '2015-02-02', '2015-06-01', '2015-02-02', '2015-02-13', 2),
(2, '2015/2016', '2015-06-10', '2015-08-01', '2015-06-10', '2015-06-23', 3),
(3, '2015/2016', '2015-08-30', '2015-12-20', '2015-08-30', '2015-09-10', 1),
(4, '2015/2016', '2016-02-02', '2016-06-01', '2016-02-02', '2016-02-13', 2),
(5, '2016/2017', '2016-06-10', '2016-08-01', '2016-06-10', '2016-06-23', 3),
(6, '2016/2017', '2016-08-30', '2016-12-20', '2016-08-30', '2016-09-10', 1),
(7, '2016/2017', '2017-02-02', '2017-06-01', '2017-02-02', '2017-02-13', 2),
(8, '2017/2018', '2017-06-10', '2017-08-01', '2017-06-10', '2017-06-23', 3),
(9, '2017/2018', '2017-08-30', '2017-12-20', '2017-08-30', '2017-09-10', 1),
(10, '2017/2018', '2018-02-02', '2018-06-01', '2017-02-02', '2018-02-13', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nik` varchar(15) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nik`, `username`, `password`) VALUES
(1, '21390123213123', 'hafizh', '7189f7b76cb1610e499a1a5f046b7861'),
(2, '21390123213124', 'may.iffah', 'e00cf25ad42683b3df678c61f42c6bda'),
(3, '21390123213125', 'sandar', 'c84258e9c39059a89ab77d846ddab909'),
(4, '21390123213126', 'amesh', '8073e5a8dbd05ea8984295c722c8ec05'),
(5, '21390123213127', 'admin', '21232f297a57a5a743894a0e4a801fc3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `link_student_kuri`
--
ALTER TABLE `link_student_kuri`
  ADD PRIMARY KEY (`id_student`,`id_kuri`);

--
-- Indexes for table `term`
--
ALTER TABLE `term`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `kelas`
--
ALTER TABLE `kelas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `term`
--
ALTER TABLE `term`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
