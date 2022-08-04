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
  `brand` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `category` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='상품 정보 테이블';

-- 테이블 데이터 musinsa.product_info:~72 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` (`brand`, `category`, `price`) VALUES
	('A', '상의', 11200),
	('A', '아우터', 5500),
	('A', '바지', 4200),
	('A', '스니커즈', 9000),
	('A', '가방', 2000),
	('A', '모자', 1700),
	('A', '양말', 1800),
	('A', '액세서리', 2300),
	('B', '상의', 10500),
	('B', '아우터', 5900),
	('B', '바지', 3800),
	('B', '스니커즈', 9100),
	('B', '가방', 2100),
	('B', '모자', 2000),
	('B', '양말', 2000),
	('B', '액세서리', 2200),
	('C', '상의', 10000),
	('C', '아우터', 6200),
	('C', '바지', 3300),
	('C', '스니커즈', 9200),
	('C', '가방', 2200),
	('C', '모자', 1900),
	('C', '양말', 2200),
	('C', '액세서리', 2100),
	('D', '상의', 10100),
	('D', '아우터', 5100),
	('D', '바지', 3000),
	('D', '스니커즈', 9500),
	('D', '가방', 2500),
	('D', '모자', 1500),
	('D', '양말', 2400),
	('D', '액세서리', 2000),
	('E', '상의', 10700),
	('E', '아우터', 5000),
	('E', '바지', 3800),
	('E', '스니커즈', 9900),
	('E', '가방', 2300),
	('E', '모자', 1800),
	('E', '양말', 2100),
	('E', '액세서리', 2100),
	('F', '상의', 11200),
	('F', '아우터', 7200),
	('F', '바지', 4000),
	('F', '스니커즈', 9300),
	('F', '가방', 2100),
	('F', '모자', 1600),
	('F', '양말', 2300),
	('F', '액세서리', 1900),
	('G', '상의', 10500),
	('G', '아우터', 5800),
	('G', '바지', 3900),
	('G', '스니커즈', 9000),
	('G', '가방', 2200),
	('G', '모자', 1700),
	('G', '양말', 2100),
	('G', '액세서리', 2000),
	('H', '상의', 10800),
	('H', '아우터', 6300),
	('H', '바지', 3100),
	('H', '스니커즈', 9700),
	('H', '가방', 2100),
	('H', '모자', 1600),
	('H', '양말', 2000),
	('H', '액세서리', 2000),
	('I', '상의', 11400),
	('I', '아우터', 6700),
	('I', '바지', 3200),
	('I', '스니커즈', 9500),
	('I', '가방', 2400),
	('I', '모자', 1700),
	('I', '양말', 1700),
	('I', '액세서리', 2400);
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
