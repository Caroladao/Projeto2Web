-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 04/06/2018 às 06h16min
-- Versão do Servidor: 5.5.20
-- Versão do PHP: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `projeto2`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `publicacao`
--

CREATE TABLE IF NOT EXISTS `publicacao` (
  `pub_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `pub_titulo` varchar(50) NOT NULL,
  `pub_texto` varchar(500) DEFAULT NULL,
  `pub_arquivo` varchar(50) DEFAULT NULL,
  `usu_codigo` int(11) NOT NULL,
  PRIMARY KEY (`pub_codigo`),
  KEY `fk_publicacao_usuario` (`usu_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `usu_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `usu_login` varchar(20) NOT NULL,
  `usu_senha` varchar(20) NOT NULL,
  `usu_nome` varchar(50) NOT NULL,
  `usu_email` varchar(50) NOT NULL,
  `usu_endereco` varchar(80) NOT NULL,
  `usu_adm` tinyint(1) NOT NULL,
  PRIMARY KEY (`usu_codigo`),
  UNIQUE KEY `usu_login` (`usu_login`),
  UNIQUE KEY `usu_email` (`usu_email`),
  KEY `usu_login_2` (`usu_login`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`usu_codigo`, `usu_login`, `usu_senha`, `usu_nome`, `usu_email`, `usu_endereco`, `usu_adm`) VALUES
(1, 'carol', 'senha', 'Carol', 'carol@gmail.com', 'Rua Carlos Gomes', 1),
(2, 'user', 'senha', 'Usuario', 'usuario@gmail.com', 'Rua Qualquer', 0);

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `publicacao`
--
ALTER TABLE `publicacao`
  ADD CONSTRAINT `fk_publicacao_usuario` FOREIGN KEY (`usu_codigo`) REFERENCES `usuario` (`usu_codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
