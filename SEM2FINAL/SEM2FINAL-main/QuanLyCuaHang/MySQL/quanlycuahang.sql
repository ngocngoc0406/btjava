-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 20, 2022 at 06:21 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlycuahang`
--

-- --------------------------------------------------------

--
-- Table structure for table `ct_hd`
--

CREATE TABLE `ct_hd` (
  `mahd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `masp` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tensp` varchar(40) CHARACTER SET utf8 NOT NULL,
  `dvtinh` varchar(20) CHARACTER SET utf8 NOT NULL,
  `soluongban` int(11) NOT NULL,
  `dongiaban` float NOT NULL,
  `thanhtien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ct_hd`
--

INSERT INTO `ct_hd` (`mahd`, `masp`, `tensp`, `dvtinh`, `soluongban`, `dongiaban`, `thanhtien`) VALUES
('HD20210610003', '7UP', 'Nước ngọt có ga 7 Up', 'Chai', 2, 7000, 14000),
('HD20210610003', 'BCPS2', 'P/S bài chải cho bé', 'Cái', 1, 10000, 10000),
('HD20210610003', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 1, 305000, 305000),
('HD20210610004', '7UP', 'Nước ngọt có ga 7 Up', 'Chai', 3, 7000, 21000),
('HD20210610004', 'BCPS2', 'P/S bài chải cho bé', 'Cái', 1, 10000, 10000),
('HD20210610004', 'DASPL', 'Dầu ăn Simply 2l', 'Chai', 1, 86000, 86000),
('HD20210610004', 'PEP', 'Pepsi', 'Chai', 1, 8000, 8000),
('HD20210610005', 'PEP', 'Pepsi', 'Chai', 2, 8000, 16000),
('HD20210610005', 'STH1', 'Sữa TH TrueMilk', 'Hộp', 3, 6000, 18000),
('HD20210610005', 'TX0D', 'Trà xanh 0 độ', 'Chai', 2, 8000, 16000),
('HD20210610006', '7UP', 'Nước ngọt có ga 7 Up', 'Chai', 1, 7000, 7000),
('HD20210610006', 'BCPR', 'Bàn chải Premier', 'Cái', 1, 15000, 15000),
('HD20210610006', 'NB1C', 'Nước tăng Number One chanh ', 'Chai', 5, 10000, 50000),
('HD20210610006', 'STH1', 'Sữa TH TrueMilk', 'Hộp', 10, 6000, 60000),
('HD20210610006', 'VED1', 'Vedan 1kg', 'Bịch', 1, 48000, 48000),
('HD20210610007', 'BCPS2', 'P/S bài chải cho bé', 'Cái', 8, 10000, 80000),
('HD20210610007', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 1, 305000, 305000),
('HD20210610007', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 1, 120000, 120000),
('HD20210610007', 'DAMZ2', 'Dầu ăn Mezan 2l', 'Chai', 1, 65000, 65000),
('HD20210610007', 'DNHI', 'Nước mắm Đệ Nhị', 'Chai', 1, 15000, 15000),
('HD20210610008', 'HNK', 'Thùng bia Heineken 24 lon', 'Thùng', 1, 405000, 405000),
('HD20210610008', 'OMA', 'Thùng mì Omachi 30 gói các hương vị', 'Thùng', 1, 150000, 150000),
('HD20210610008', 'TX0D', 'Trà xanh 0 độ', 'Chai', 1, 8000, 8000),
('HD20210610009', 'DASPL', 'Dầu ăn Simply 2l', 'Chai', 1, 86000, 86000),
('HD20210610009', 'OMA', 'Thùng mì Omachi 30 gói các hương vị', 'Thùng', 1, 150000, 150000),
('HD20210610009', 'OREO2', 'Bánh Oreo hộp giấy', 'Hộp', 2, 25000, 50000),
('HD20210610009', 'PEP', 'Pepsi', 'Chai', 2, 8000, 16000),
('HD20210610009', 'SIZZI', 'Sữa Izzi 180ml', 'Hộp', 6, 7000, 42000),
('HD20210610010', 'BCX1', 'Bột chiên xù 100g', 'Gói', 1, 10000, 10000),
('HD20210610010', 'DANT', 'Dầu ăn Neptune 1l', 'Chai', 1, 42000, 42000),
('HD20210610010', 'OREO1', 'Bánh Oreo loại thỏi', 'Gói', 1, 14000, 14000),
('HD20210610010', 'SFAMI', 'Sữa Fami 200ml', 'Hộp', 7, 7000, 49000),
('HD20210610010', 'TX0D', 'Trà xanh 0 độ', 'Chai', 1, 8000, 8000),
('HD20210610010', 'VED1', 'Vedan 1kg', 'Bịch', 2, 48000, 96000),
('HD20210610012', '7UP', 'Nước ngọt có ga 7 Up', 'Chai', 2, 7000, 14000),
('HD20210610012', 'BCPR', 'Bàn chải Premier', 'Cái', 2, 15000, 30000),
('HD20210610012', 'BCX1', 'Bột chiên xù 100g', 'Gói', 1, 10000, 10000),
('HD20210610013', '7UP', 'Nước ngọt có ga 7 Up', 'Chai', 2, 7000, 14000),
('HD20210610013', 'DASPL', 'Dầu ăn Simply 2l', 'Chai', 2, 86000, 172000),
('HD20210610013', 'VED1', 'Vedan 1kg', 'Bịch', 1, 48000, 48000),
('HD20210610014', '333', 'Bia 333 1 thùng 24 lon', 'Thùng', 1, 255000, 255000),
('HD20210610014', 'BCPS1', 'P/S chải sạch sâu', 'Cái', 5, 20000, 100000),
('HD20210614001', '333', 'Bia 333 1 thùng 24 lon', 'Thùng', 1, 255000, 255000),
('HD20210614001', 'BCPS2', 'P/S bài chải cho bé', 'Cái', 2, 10000, 20000),
('HD20210614001', 'DAMZ2', 'Dầu ăn Mezan 2l', 'Chai', 1, 65000, 65000),
('HD20210614001', 'SIZZI', 'Sữa Izzi 180ml', 'Hộp', 6, 7000, 14000),
('HD20210614001', 'SOL', 'Bánh Solite cuộn dâu và lá dứa', 'Hộp', 1, 50000, 50000),
('HD20210617001', '7UP', 'Nước ngọt có ga 7 Up', 'Chai', 1, 7000, 7000),
('HD20210617001', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 3, 120000, 360000),
('HD20210617001', 'HNMG', 'Hạt nêm Magi 900g', 'Bịch', 2, 55000, 110000),
('HD20210618001', '333', 'Bia 333 1 thùng 24 lon', 'Thùng', 1, 255000, 255000),
('HD20210618001', '7UP', 'Nước ngọt có ga 7 Up', 'Chai', 1, 7000, 7000),
('HD20210618001', 'BCPR', 'Bàn chải Premier', 'Cái', 1, 15000, 15000),
('HD20210620001', '333', 'Bia 333 1 thùng 24 lon', 'Thùng', 1, 255000, 255000),
('HD20210620001', 'BCPR', 'Bàn chải Premier', 'Cái', 1, 15000, 15000),
('HD20210620001', 'DASPL', 'Dầu ăn Simply 2l', 'Chai', 1, 86000, 86000),
('HD20210620003', 'BCPS1', 'P/S chải sạch sâu', 'Cái', 1, 20000, 20000),
('HD20210620003', 'BCPS2', 'P/S bài chải cho bé', 'Cái', 1, 10000, 10000),
('HD20210620003', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 1, 305000, 305000),
('HD20210620004', '7UP', 'Nước ngọt có ga 7 Up', 'Chai', 1, 7000, 7000),
('HD20210620004', 'BCPS2', 'P/S bài chải cho bé', 'Cái', 1, 10000, 10000),
('HD20210620004', 'DAMZ1', 'Dầu ăn Mezan 1l', 'Chai', 1, 38000, 38000),
('HD20210620005', 'BCPS1', 'P/S chải sạch sâu', 'Cái', 1, 20000, 20000),
('HD20210620005', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 1, 305000, 305000),
('HD20210620005', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 1, 120000, 120000),
('HD20210620006', '333', 'Bia 333 1 thùng 24 lon', 'Thùng', 1, 255000, 255000),
('HD20210620006', 'BCX1', 'Bột chiên xù 100g', 'Gói', 2, 10000, 20000),
('HD20210620008', 'DNHI', 'Nước mắm Đệ Nhị', 'Chai', 2, 15000, 30000),
('HD20210620008', 'MLT', 'Thùng mì Lẩu Thái 30 gói ', 'Thùng', 2, 165000, 330000),
('HD20210620009', '7UP', 'Nước ngọt có ga 7 Up', 'Chai', 1, 7000, 7000),
('HD20210620009', 'BCPS1', 'P/S chải sạch sâu', 'Cái', 1, 20000, 20000),
('HD20210620010', 'TX0D', 'Trà xanh 0 độ', 'Chai', 2, 8000, 16000),
('HD20210620010', 'VED1', 'Vedan 1kg', 'Bịch', 1, 48000, 48000),
('HD20210620011', 'SIZZI', 'Sữa Izzi 180ml', 'Hộp', 1, 7000, 7000),
('HD20210620011', 'SOL', 'Bánh Solite cuộn dâu và lá dứa', 'Hộp', 4, 50000, 200000),
('HD20210620012', 'NB1C', 'Nước tăng Number One chanh ', 'Chai', 3, 10000, 30000),
('HD20210620012', 'OMA', 'Thùng mì Omachi 30 gói các hương vị', 'Thùng', 4, 150000, 600000),
('HD20210620013', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 1, 305000, 305000),
('HD20210620013', 'DAMZ1', 'Dầu ăn Mezan 1l', 'Chai', 2, 38000, 76000),
('HD20210621001', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 1, 305000, 305000),
('HD20210621001', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 3, 120000, 360000),
('HD20210621002', 'PEP', 'Pepsi', 'Chai', 3, 8000, 24000),
('HD20210621002', 'VED04', 'Vedan 400g', 'Bịch', 3, 22000, 66000),
('HD20210621003', '7UP', 'Nước ngọt có ga 7 Up', 'Chai', 2, 7000, 14000),
('HD20210621003', 'BCPS1', 'P/S chải sạch sâu', 'Cái', 2, 20000, 40000),
('HD20210621004', 'HHAO', 'Thùng mì Hảo Hảo 30 gói ', 'Thùng', 4, 95000, 380000),
('HD20210621004', 'HNMG', 'Hạt nêm Magi 900g', 'Bịch', 1, 55000, 55000),
('HD20210621004', 'SFAMI', 'Sữa Fami 200ml', 'Hộp', 4, 7000, 28000),
('HD20210621005', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 2, 120000, 240000),
('HD20210621005', 'DANT', 'Dầu ăn Neptune 1l', 'Chai', 4, 42000, 168000),
('HD20210621006', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 3, 305000, 915000),
('HD20210621006', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 3, 120000, 360000),
('HD20210623001', 'DAMZ2', 'Dầu ăn Mezan 2l', 'Chai', 2, 65000, 130000),
('HD20210623001', 'HHAO', 'Thùng mì Hảo Hảo 30 gói ', 'Thùng', 1, 95000, 95000),
('HD20210623001', 'HNMG', 'Hạt nêm Magi 900g', 'Bịch', 2, 55000, 110000),
('HD20210627001', 'DAKD', 'Dầu ăn Kiddy', 'Chai', 1, 36000, 36000),
('HD20210627001', 'DNHAT', 'Nam Ngư Đệ Nhất', 'Chai', 1, 36000, 36000),
('HD20210627001', 'HHAO', 'Thùng mì Hảo Hảo 30 gói ', 'Thùng', 1, 95000, 95000),
('HD20210627001', 'NB1C', 'Nước tăng Number One chanh ', 'Chai', 1, 10000, 10000),
('HD20210629001', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 1, 120000, 120000),
('HD20210629001', 'DHMG', 'Dầu hào Magi 500g', 'Bịch', 1, 21000, 21000),
('HD20210629002', 'BCPS1', 'P/S chải sạch sâu', 'Cái', 1, 20000, 20000),
('HD20210629002', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 1, 305000, 305000),
('HD20210630001', 'DHMG', 'Dầu hào Magi 500g', 'Bịch', 1, 21000, 21000),
('HD20210630001', 'NTMG', 'Nước tương Magi', 'Chai', 1, 15000, 15000),
('HD20210702001', 'BCX1', 'Bột chiên xù 100g', 'Gói', 2, 10000, 20000),
('HD20210702001', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 1, 120000, 120000),
('HD20210706001', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 1, 305000, 305000),
('HD20210706001', 'DHMG', 'Dầu hào Magi 500g', 'Bịch', 1, 21000, 21000),
('HD20210707001', 'DHMG', 'Dầu hào Magi 500g', 'Bịch', 1, 21000, 21000),
('HD20210707001', 'DNHAT', 'Nam Ngư Đệ Nhất', 'Chai', 1, 36000, 36000),
('HD20210709001', 'DAKD', 'Dầu ăn Kiddy', 'Chai', 1, 36000, 36000),
('HD20210709001', 'DNHAT', 'Nam Ngư Đệ Nhất', 'Chai', 1, 36000, 36000),
('HD20210709002', 'BCPS1', 'P/S chải sạch sâu', 'Cái', 1, 20000, 20000),
('HD20210709002', 'BCX1', 'Bột chiên xù 100g', 'Gói', 2, 10000, 20000),
('HD20210711001', 'BCPS1', 'P/S chải sạch sâu', 'Cái', 1, 20000, 20000),
('HD20210711001', 'DAMZ2', 'Dầu ăn Mezan 2l', 'Chai', 1, 65000, 65000),
('HD20210714001', 'DAMZ2', 'Dầu ăn Mezan 2l', 'Chai', 1, 65000, 65000),
('HD20210714001', 'NB1C', 'Nước tăng Number One chanh ', 'Chai', 3, 10000, 30000),
('HD20210714002', 'BCPS2', 'P/S bài chải cho bé', 'Cái', 1, 10000, 10000),
('HD20210714002', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 1, 120000, 120000),
('HD20210714002', 'DAKD', 'Dầu ăn Kiddy', 'Chai', 2, 36000, 72000),
('HD20210717001', 'BCPS2', 'P/S bài chải cho bé', 'Cái', 1, 10000, 10000),
('HD20210717001', 'HHAO', 'Thùng mì Hảo Hảo 30 gói ', 'Thùng', 1, 95000, 95000),
('HD20210717001', 'HNK', 'Thùng bia Heineken 24 lon', 'Thùng', 3, 405000, 1215000),
('HD20220620001', 'TX0D', 'Trà xanh 0 độ', 'Chai', 2, 8000, 16000),
('HD20220620001', 'VED04', 'Vedan 400g', 'Bịch', 3, 22000, 66000),
('HD20220620001', 'VED1', 'Vedan 1kg', 'Bịch', 1, 48000, 48000),
('HD20220620002', '333', 'Bia 333 1 thùng 24 lon', 'Thùng', 1, 255000, 255000),
('HD20220620002', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 1, 120000, 120000),
('HD20220620002', 'HNK', 'Thùng bia Heineken 24 lon', 'Thùng', 1, 405000, 405000),
('HD20220620002', 'NTMG', 'Nước tương Magi', 'Chai', 1, 15000, 15000),
('HD20220620003', '333', 'Bia 333 1 thùng 24 lon', 'Thùng', 1, 255000, 255000),
('HD20220620003', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 1, 305000, 305000),
('HD20220620003', 'COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 1, 120000, 120000),
('HD20220620003', 'DANT', 'Dầu ăn Neptune 1l', 'Chai', 1, 42000, 42000);

-- --------------------------------------------------------

--
-- Table structure for table `ct_pn`
--

CREATE TABLE `ct_pn` (
  `mapn` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `masp` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tensp` varchar(40) CHARACTER SET utf8 NOT NULL,
  `dvtinh` varchar(20) CHARACTER SET utf8 NOT NULL,
  `soluongnhap` int(11) NOT NULL,
  `dongianhap` float NOT NULL,
  `thanhtien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ct_pn`
--

INSERT INTO `ct_pn` (`mapn`, `masp`, `tensp`, `dvtinh`, `soluongnhap`, `dongianhap`, `thanhtien`) VALUES
('PN20210709001', 'BCX1', 'Bột chiên xù 100g', 'Gói', 50, 10000, 500000),
('PN20210709001', 'BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 15, 290000, 4350000),
('PN20210709002', 'DAKD', 'Dầu ăn Kiddy', 'Chai', 40, 33000, 1320000),
('PN20210709002', 'DASPL', 'Dầu ăn Simply 2l', 'Chai', 20, 83000, 1660000),
('PN20210710001', 'BCPS1', 'P/S chải sạch sâu', 'Cái', 50, 15000, 750000),
('PN20210710001', 'DNHAT', 'Nam Ngư Đệ Nhất', 'Chai', 40, 33000, 1320000),
('PN20210710001', 'HNMG', 'Hạt nêm Magi 900g', 'Bịch', 40, 52000, 2080000),
('PN20210711001', 'DANT', 'Dầu ăn Neptune 1l', 'Chai', 10, 38000, 380000),
('PN20210711001', 'DHMG', 'Dầu hào Magi 500g', 'Bịch', 20, 19000, 380000),
('PN20210714001', 'VED04', 'Vedan 400g', 'Bịch', 25, 18000, 450000),
('PN20210714001', 'VED1', 'Vedan 1kg', 'Bịch', 20, 44000, 880000),
('PN20210714001', 'VED2', 'Vedan 2kg', 'Bịch', 20, 87000, 1740000),
('PN20220620001', 'AQUA', 'Aquafina 500ml', 'Chai', 180, 3500, 630000);

--
-- Triggers `ct_pn`
--
DELIMITER $$
CREATE TRIGGER `trg_updateSLT_after_addPN` AFTER INSERT ON `ct_pn` FOR EACH ROW BEGIN
	UPDATE san_pham
    SET soluong = soluong + new.soluongnhap
    where masp = new.masp;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_updateSLT_after_deletePN` AFTER DELETE ON `ct_pn` FOR EACH ROW BEGIN
	DECLARE today INT(11) DEFAULT -1;
    SELECT (DATE(NOW())-ngaynhap) into today From phieu_nhap
    where mapn=old.mapn;
	if today<='7' then
		UPDATE san_pham
		SET soluong = soluong - old.soluongnhap
		where masp = old.masp;
    end if;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don`
--

CREATE TABLE `hoa_don` (
  `mahd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tonggiaban` float NOT NULL,
  `ngayban` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hoa_don`
--

INSERT INTO `hoa_don` (`mahd`, `tonggiaban`, `ngayban`) VALUES
('HD20210610003', 329000, '2021-06-10'),
('HD20210610004', 125000, '2021-06-10'),
('HD20210610005', 50000, '2021-06-10'),
('HD20210610006', 180000, '2021-06-10'),
('HD20210610007', 585000, '2021-06-10'),
('HD20210610008', 563000, '2021-06-10'),
('HD20210610009', 344000, '2021-06-10'),
('HD20210610010', 219000, '2021-06-10'),
('HD20210610012', 54000, '2021-06-10'),
('HD20210610013', 234000, '2021-06-10'),
('HD20210610014', 355000, '2021-06-10'),
('HD20210614001', 432000, '2021-06-14'),
('HD20210617001', 477000, '2021-06-17'),
('HD20210618001', 277000, '2021-06-18'),
('HD20210620001', 356000, '2021-06-20'),
('HD20210620003', 335000, '2021-06-20'),
('HD20210620004', 65000, '2021-06-20'),
('HD20210620005', 485000, '2021-06-20'),
('HD20210620006', 275000, '2021-06-20'),
('HD20210620008', 360000, '2021-06-20'),
('HD20210620009', 27000, '2021-06-20'),
('HD20210620010', 64000, '2021-06-20'),
('HD20210620011', 207000, '2021-06-20'),
('HD20210620012', 630000, '2021-06-20'),
('HD20210620013', 381000, '2021-06-20'),
('HD20210621001', 665000, '2021-06-21'),
('HD20210621002', 90000, '2021-06-21'),
('HD20210621003', 54000, '2021-06-21'),
('HD20210621004', 463000, '2021-06-21'),
('HD20210621005', 408000, '2021-06-21'),
('HD20210621006', 1275000, '2021-06-21'),
('HD20210623001', 335000, '2021-06-23'),
('HD20210627001', 177000, '2021-06-27'),
('HD20210629001', 141000, '2021-06-29'),
('HD20210629002', 325000, '2021-06-29'),
('HD20210630001', 36000, '2021-06-30'),
('HD20210702001', 140000, '2021-07-02'),
('HD20210706001', 326000, '2021-07-06'),
('HD20210707001', 57000, '2021-07-07'),
('HD20210709001', 72000, '2021-07-09'),
('HD20210709002', 40000, '2021-07-09'),
('HD20210711001', 85000, '2021-07-11'),
('HD20210714001', 95000, '2021-07-14'),
('HD20210714002', 202000, '2021-07-14'),
('HD20210717001', 1320000, '2021-07-17'),
('HD20220620001', 130000, '2022-06-20'),
('HD20220620002', 795000, '2022-06-20'),
('HD20220620003', 722000, '2022-06-20');

-- --------------------------------------------------------

--
-- Table structure for table `phieu_nhap`
--

CREATE TABLE `phieu_nhap` (
  `mapn` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tonggianhap` float NOT NULL,
  `ngaynhap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `phieu_nhap`
--

INSERT INTO `phieu_nhap` (`mapn`, `tonggianhap`, `ngaynhap`) VALUES
('PN20210709001', 4850000, '2022-07-09'),
('PN20210709002', 2980000, '2021-07-09'),
('PN20210710001', 4150000, '2021-07-10'),
('PN20210711001', 760000, '2021-07-11'),
('PN20210714001', 3070000, '2021-07-14'),
('PN20220620001', 630000, '2022-06-20');

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

CREATE TABLE `san_pham` (
  `masp` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tensp` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dvtinh` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongiaban` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `san_pham`
--

INSERT INTO `san_pham` (`masp`, `tensp`, `dvtinh`, `soluong`, `dongiaban`) VALUES
('333', 'Bia 333 1 thùng 24 lon', 'Thùng', 40, 255000),
('7UP', 'Nước ngọt có ga 7 Up', 'Chai', 58, 7000),
('AQUA', 'Aquafina 500ml', 'Chai', 330, 5000),
('Bat1', 'Pin con thỏ AAA', 'Viên', 400, 2500),
('BCPR', 'Bàn chải Premier', 'Cái', 50, 15000),
('BCPS1', 'P/S chải sạch sâu', 'Cái', 55, 20000),
('BCPS2', 'P/S bài chải cho bé', 'Cái', 37, 10000),
('BCX1', 'Bột chiên xù 100g', 'Gói', 60, 10000),
('BSG', 'Thùng bia Sài Gòn 24 lon', 'Thùng', 35, 305000),
('COSY', 'Bánh Cosy thập cẩm 630g', 'Hộp', 39, 120000),
('DACL', 'Dầu ăn Cái Lân 1l ', 'Chai', 32, 29000),
('DAKD', 'Dầu ăn Kiddy', 'Chai', 51, 36000),
('DAMZ1', 'Dầu ăn Mezan 1l', 'Chai', 30, 38000),
('DAMZ2', 'Dầu ăn Mezan 2l', 'Chai', 30, 65000),
('DANT', 'Dầu ăn Neptune 1l', 'Chai', 28, 42000),
('DASPL', 'Dầu ăn Simply 2l', 'Chai', 68, 86000),
('DHMG', 'Dầu hào Magi 500g', 'Bịch', 36, 21000),
('DNHAT', 'Nam Ngư Đệ Nhất', 'Chai', 52, 36000),
('DNHI', 'Nước mắm Đệ Nhị', 'Chai', 48, 15000),
('HHAO', 'Thùng mì Hảo Hảo 30 gói ', 'Thùng', 22, 95000),
('HNK', 'Thùng bia Heineken 24 lon', 'Thùng', 17, 405000),
('HNMG', 'Hạt nêm Magi 900g', 'Bịch', 52, 55000),
('MLT', 'Thùng mì Lẩu Thái 30 gói ', 'Thùng', 20, 165000),
('NB1C', 'Nước tăng Number One chanh ', 'Chai', 21, 10000),
('NTMG', 'Nước tương Magi', 'Chai', 49, 15000),
('OMA', 'Thùng mì Omachi 30 gói các hương vị', 'Thùng', 15, 150000),
('OREO1', 'Bánh Oreo loại thỏi', 'Gói', 30, 14000),
('OREO2', 'Bánh Oreo hộp giấy', 'Hộp', 40, 25000),
('PEP', 'Pepsi', 'Chai', 20, 8000),
('SFAMI', 'Sữa Fami 200ml', 'Hộp', 80, 7000),
('SIZZI', 'Sữa Izzi 180ml', 'Hộp', 25, 7000),
('SOL', 'Bánh Solite cuộn dâu và lá dứa', 'Hộp', 40, 50000),
('STH1', 'Sữa TH TrueMilk', 'Hộp', 80, 6000),
('TX0D', 'Trà xanh 0 độ', 'Chai', 25, 8000),
('VED04', 'Vedan 400g', 'Bịch', 40, 22000),
('VED1', 'Vedan 1kg', 'Bịch', 35, 48000),
('VED2', 'Vedan 2kg', 'Bịch', 35, 91000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ct_hd`
--
ALTER TABLE `ct_hd`
  ADD PRIMARY KEY (`mahd`,`masp`),
  ADD KEY `masp` (`masp`);

--
-- Indexes for table `ct_pn`
--
ALTER TABLE `ct_pn`
  ADD PRIMARY KEY (`mapn`,`masp`),
  ADD KEY `masp` (`masp`);

--
-- Indexes for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`mahd`);

--
-- Indexes for table `phieu_nhap`
--
ALTER TABLE `phieu_nhap`
  ADD PRIMARY KEY (`mapn`);

--
-- Indexes for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD PRIMARY KEY (`masp`),
  ADD UNIQUE KEY `masp_UNIQUE` (`masp`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ct_hd`
--
ALTER TABLE `ct_hd`
  ADD CONSTRAINT `ct_hd_ibfk_1` FOREIGN KEY (`mahd`) REFERENCES `hoa_don` (`mahd`),
  ADD CONSTRAINT `ct_hd_ibfk_2` FOREIGN KEY (`masp`) REFERENCES `san_pham` (`masp`);

--
-- Constraints for table `ct_pn`
--
ALTER TABLE `ct_pn`
  ADD CONSTRAINT `ct_pn_ibfk_1` FOREIGN KEY (`mapn`) REFERENCES `phieu_nhap` (`mapn`),
  ADD CONSTRAINT `ct_pn_ibfk_2` FOREIGN KEY (`masp`) REFERENCES `san_pham` (`masp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
