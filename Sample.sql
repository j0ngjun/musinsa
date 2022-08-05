-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.9.1-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- musinsa 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `musinsa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `musinsa`;

-- 테이블 musinsa.product_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `product_info` (
  `product_key` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `category` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`product_key`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='상품 정보 테이블';

-- 테이블 데이터 musinsa.product_info:~72 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` (`product_key`, `brand`, `category`, `price`) VALUES
	(1, 'A', '상의', 11200),
	(2, 'A', '아우터', 5500),
	(3, 'A', '바지', 4200),
	(4, 'A', '스니커즈', 9000),
	(5, 'A', '가방', 2000),
	(6, 'A', '모자', 1700),
	(7, 'A', '양말', 1800),
	(8, 'A', '액세서리', 2300),
	(9, 'B', '상의', 10500),
	(10, 'B', '아우터', 5900),
	(11, 'B', '바지', 3800),
	(12, 'B', '스니커즈', 9100),
	(13, 'B', '가방', 2100),
	(14, 'B', '모자', 2000),
	(15, 'B', '양말', 2000),
	(16, 'B', '액세서리', 2200),
	(17, 'C', '상의', 10000),
	(18, 'C', '아우터', 6200),
	(19, 'C', '바지', 3300),
	(20, 'C', '스니커즈', 9200),
	(21, 'C', '가방', 2200),
	(22, 'C', '모자', 1900),
	(23, 'C', '양말', 2200),
	(24, 'C', '액세서리', 2100),
	(25, 'D', '상의', 10100),
	(26, 'D', '아우터', 5100),
	(27, 'D', '바지', 3000),
	(28, 'D', '스니커즈', 9500),
	(29, 'D', '가방', 2500),
	(30, 'D', '모자', 1500),
	(31, 'D', '양말', 2400),
	(32, 'D', '액세서리', 2000),
	(33, 'E', '상의', 10700),
	(34, 'E', '아우터', 5000),
	(35, 'E', '바지', 3800),
	(36, 'E', '스니커즈', 9900),
	(37, 'E', '가방', 2300),
	(38, 'E', '모자', 1800),
	(39, 'E', '양말', 2100),
	(40, 'E', '액세서리', 2100),
	(41, 'F', '상의', 11200),
	(42, 'F', '아우터', 7200),
	(43, 'F', '바지', 4000),
	(44, 'F', '스니커즈', 9300),
	(45, 'F', '가방', 2100),
	(46, 'F', '모자', 1600),
	(47, 'F', '양말', 2300),
	(48, 'F', '액세서리', 1900),
	(49, 'G', '상의', 10500),
	(50, 'G', '아우터', 5800),
	(51, 'G', '바지', 3900),
	(52, 'G', '스니커즈', 9000),
	(53, 'G', '가방', 2200),
	(54, 'G', '모자', 1700),
	(55, 'G', '양말', 2100),
	(56, 'G', '액세서리', 2000),
	(57, 'H', '상의', 10800),
	(58, 'H', '아우터', 6300),
	(59, 'H', '바지', 3100),
	(60, 'H', '스니커즈', 9700),
	(61, 'H', '가방', 2100),
	(62, 'H', '모자', 1600),
	(63, 'H', '양말', 2000),
	(64, 'H', '액세서리', 2000),
	(65, 'I', '상의', 11400),
	(66, 'I', '아우터', 6700),
	(67, 'I', '바지', 3200),
	(68, 'I', '스니커즈', 9500),
	(69, 'I', '가방', 2400),
	(70, 'I', '모자', 1700),
	(71, 'I', '양말', 1700),
	(72, 'I', '액세서리', 2400);
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
