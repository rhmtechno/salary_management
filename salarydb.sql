-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2021 at 04:57 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `salarydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `benifits_sequence`
--

CREATE TABLE `benifits_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `benifits_sequence`
--

INSERT INTO `benifits_sequence` (`next_val`) VALUES
(1),
(3);

-- --------------------------------------------------------

--
-- Table structure for table `benifits_tbl`
--

CREATE TABLE `benifits_tbl` (
  `benifit_id` bigint(20) NOT NULL,
  `benifit_name` varchar(255) DEFAULT NULL,
  `benifite_rate` float NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `is_active` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `benifits_tbl`
--

INSERT INTO `benifits_tbl` (`benifit_id`, `benifit_name`, `benifite_rate`, `create_date`, `is_active`) VALUES
(1, 'House rent', 20, '2021-05-20 12:24:17', 1),
(2, 'Medical allowance', 15, '2021-05-20 12:24:45', 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee_bank_tbl`
--

CREATE TABLE `employee_bank_tbl` (
  `accid` bigint(20) NOT NULL,
  `creation_date` date DEFAULT NULL,
  `acc_name` varchar(255) DEFAULT NULL,
  `acc_type` varchar(255) DEFAULT NULL,
  `accnumber` varchar(255) DEFAULT NULL,
  `bank_branch` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `curr_bal` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee_bank_tbl`
--

INSERT INTO `employee_bank_tbl` (`accid`, `creation_date`, `acc_name`, `acc_type`, `accnumber`, `bank_branch`, `bank_name`, `curr_bal`) VALUES
(1, '2021-05-19', 'Md.Rakibul Hasan', 'saving', '1238174', 'savar', 'Dutch bangla', 653400),
(2, '2021-05-19', 'Md.Rafin Hasan', 'saving', '721339', 'dhaka', 'dutch Bangla bank ltd', 418500),
(3, '2021-05-19', 'Md.abul Bashar', 'current', '788455875', 'uttara', 'dutch Bangla bank ltd', 324000),
(4, '2021-05-19', 'srikanta saha', 'saving', '988554485', 'uttara', 'dutch Bangla bank ltd', 324000),
(5, '2021-05-19', 'akash mahmud', 'saving', '54877554', 'dhanmondi', 'dutch Bangla bank ltd', 229500),
(6, '2021-05-19', 'hossain mahmud', 'saving', '9854575', 'dhanmondi', 'dutch Bangla bank ltd', 229500),
(7, '2021-05-19', 'ariful islam', 'saving', '8745584', 'dhanmondi', 'dutch Bangla bank ltd', 135000),
(8, '2021-05-19', 'sojol islam', 'saving', '54788547', 'dhanmondi', 'dutch Bangla bank ltd', 135000),
(9, '2021-05-19', 'rezaul karim', 'saving', '8899877', 'dhanmondi', 'dutch Bangla bank ltd', 40500),
(10, '2021-05-19', 'Al mamun', 'saving', '4555985', 'dhanmondi', 'dutch Bangla bank ltd', 40500);

-- --------------------------------------------------------

--
-- Table structure for table `employee_tbl`
--

CREATE TABLE `employee_tbl` (
  `emp_id` bigint(20) NOT NULL,
  `emp_address` varchar(255) DEFAULT NULL,
  `salary_grade` bigint(20) DEFAULT NULL,
  `emp_mobile` varchar(255) DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `fk_acc_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee_tbl`
--

INSERT INTO `employee_tbl` (`emp_id`, `emp_address`, `salary_grade`, `emp_mobile`, `emp_name`, `fk_acc_id`) VALUES
(1000, 'Singair,Manikganj', 1, '01710550690', 'Md.Rakibul Hasan', 1),
(1001, 'Singair,Manikganj', 2, '01838009000', 'Md.Rafin Hasan', 2),
(1002, 'nikunja,khilkhet', 3, '01685545662', 'Md.abul Bashar', 3),
(1003, 'nikunja,khilkhet', 3, '01687455884', 'srikanta saha', 4),
(1004, 'Lalmatia,Dhanmondi', 4, '01911556685', 'akash mahmud', 5),
(1005, 'shankar,Dhanmondi', 4, '01671524589', 'hossain mahmud', 6),
(1006, 'polton,Dhaka', 5, '01711548754', 'ariful islam', 7),
(1007, 'motijil,Dhaka', 5, '01864125145', 'sojol islam', 8),
(1008, 'framgate,Dhaka', 6, '01716400500', 'rezaul karim', 9),
(1009, 'gulshan,Dhaka', 6, '017115114225', 'Al mamun', 10);

-- --------------------------------------------------------

--
-- Table structure for table `emp_bank_sequence`
--

CREATE TABLE `emp_bank_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp_bank_sequence`
--

INSERT INTO `emp_bank_sequence` (`next_val`) VALUES
(1),
(11);

-- --------------------------------------------------------

--
-- Table structure for table `emp_sequence`
--

CREATE TABLE `emp_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp_sequence`
--

INSERT INTO `emp_sequence` (`next_val`) VALUES
(1000),
(1010);

-- --------------------------------------------------------

--
-- Table structure for table `grade_sequence`
--

CREATE TABLE `grade_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grade_sequence`
--

INSERT INTO `grade_sequence` (`next_val`) VALUES
(19);

-- --------------------------------------------------------

--
-- Table structure for table `grade_tbl`
--

CREATE TABLE `grade_tbl` (
  `id_pk_key` bigint(20) NOT NULL,
  `basic_amount` float NOT NULL,
  `gradeid` bigint(20) NOT NULL,
  `gradename` varchar(255) DEFAULT NULL,
  `house_rent` float NOT NULL,
  `medical_allowance` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grade_tbl`
--

INSERT INTO `grade_tbl` (`id_pk_key`, `basic_amount`, `gradeid`, `gradename`, `house_rent`, `medical_allowance`) VALUES
(18, 34000, 1, 'grade one', 20, 15),
(17, 29000, 2, 'grade two', 20, 15),
(16, 24000, 3, 'grade three', 20, 15),
(15, 19000, 4, 'grade four', 20, 15),
(14, 14000, 5, 'grade five', 20, 15),
(13, 9000, 6, 'grade six', 20, 15);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `benifits_tbl`
--
ALTER TABLE `benifits_tbl`
  ADD PRIMARY KEY (`benifit_id`);

--
-- Indexes for table `employee_bank_tbl`
--
ALTER TABLE `employee_bank_tbl`
  ADD PRIMARY KEY (`accid`);

--
-- Indexes for table `employee_tbl`
--
ALTER TABLE `employee_tbl`
  ADD PRIMARY KEY (`emp_id`),
  ADD KEY `FKib0oa5184sjtrvfa9bwbl438p` (`fk_acc_id`);

--
-- Indexes for table `grade_tbl`
--
ALTER TABLE `grade_tbl`
  ADD PRIMARY KEY (`id_pk_key`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
