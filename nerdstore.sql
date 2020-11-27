-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.30-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para trabalho_av2
CREATE DATABASE IF NOT EXISTS `trabalho_av2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `trabalho_av2`;

-- Copiando estrutura para tabela trabalho_av2.compra
CREATE TABLE IF NOT EXISTS `compra` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_USUARIO` int(11) NOT NULL,
  `ID_PRODUTO` int(11) NOT NULL,
  `DATACOMPRA` date NOT NULL,
  `QTD` int(11) NOT NULL,
  `VALORCOMPRA` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela trabalho_av2.compra: ~9 rows (aproximadamente)
DELETE FROM `compra`;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` (`ID`, `ID_USUARIO`, `ID_PRODUTO`, `DATACOMPRA`, `QTD`, `VALORCOMPRA`) VALUES
	(1, 6, 1, '2020-11-12', 1, 59),
	(2, 6, 2, '2020-11-12', 10, 599),
	(3, 6, 3, '2020-11-12', 5, 349.5),
	(4, 6, 3, '2020-11-12', 1, 69.9),
	(8, 6, 1, '2020-11-13', 12, 708),
	(9, 14, 1, '2020-11-13', 20, 1180),
	(10, 6, 1, '2020-11-14', 10, 590),
	(11, 17, 5, '2020-11-25', 5, 599.5),
	(12, 18, 1, '2020-11-27', 50, 2950);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;

-- Copiando estrutura para tabela trabalho_av2.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `PRECO` double NOT NULL,
  `DESCRICAO` varchar(100) NOT NULL,
  `URL_IMAGEM` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela trabalho_av2.produto: ~3 rows (aproximadamente)
DELETE FROM `produto`;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`ID`, `NOME`, `PRECO`, `DESCRICAO`, `URL_IMAGEM`) VALUES
	(1, 'Caneca Tom Super Mario Bros 2', 59, 'O encanador mais famoso dos games agora na caneca!', 'https://uploads.nerdstore.com.br/wp-content/uploads/2020/08/caneca-tom-super-mario-02-300x300.jpg'),
	(3, 'Camiseta Balboa Crossfit - Treinamento do Rocky', 69.9, 'Estampa inspirada no treinamento intenso de Rocky Balboa para se tornar um dos maiores lutadores!', 'https://uploads.nerdstore.com.br/wp-content/uploads/2020/09/Camiseta-Balboa-Crossfit-01.jpg'),
	(5, 'Cachecol da Turma da Mônica', 119.9, 'Venha fazer parte da turma da Mônica você também, compre já o cachecol da dentuça!', NULL);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

-- Copiando estrutura para tabela trabalho_av2.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(20) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `SENHA` varchar(50) NOT NULL,
  `TIPO` varchar(10) NOT NULL DEFAULT 'CLIENTE',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela trabalho_av2.usuario: ~5 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`ID`, `NOME`, `USERNAME`, `SENHA`, `TIPO`) VALUES
	(1, 'Administrador', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'ADMIN'),
	(6, 'Gabriel', 'gabrielsousa', 'e10adc3949ba59abbe56e057f20f883e', 'CLIENTE'),
	(14, 'Thiago', 'thiagosouza', 'c33367701511b4f6020ec61ded352059', 'CLIENTE'),
	(17, 'Lucas', 'lucasart', 'e10adc3949ba59abbe56e057f20f883e', 'CLIENTE'),
	(18, 'Thiago', 'thiagosousa', 'e10adc3949ba59abbe56e057f20f883e', 'CLIENTE');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
