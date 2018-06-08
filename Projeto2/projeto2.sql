-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 07/06/2018 às 19h37min
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
CREATE DATABASE Projeto2;
USE Projeto2;
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `publicacao`
--

CREATE TABLE IF NOT EXISTS `publicacao` (
  `pub_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `pub_titulo` varchar(50) CHARACTER SET latin1 NOT NULL,
  `pub_texto` varchar(1000) CHARACTER SET latin1 DEFAULT NULL,
  `pub_arquivo` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `usu_codigo` int(11) NOT NULL,
  PRIMARY KEY (`pub_codigo`),
  KEY `fk_publicacao_usuario` (`usu_codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Extraindo dados da tabela `publicacao`
--

INSERT INTO `publicacao` (`pub_codigo`, `pub_titulo`, `pub_texto`, `pub_arquivo`, `usu_codigo`) VALUES
(16, 'Rick e Morty', 'Rick Sanchez é um cientista genial e alcoólatra que foi morar com a família de sua filha Beth, uma cirurgiã cardíaca de equinos. Ele divide seu tempo entre desenvolver projetos altamente tecnológicos em seu laboratório (garagem da casa de Beth) e levar seu neto de 14 anos Morty em aventuras perigosas e surreais pelo Multiverso. Combinados com tensões preexistentes dentro da família, esses eventos causam ao sensível Morty muito angústia em casa e na escola.', 'C:\\Users\\carol\\Faculdade\\Web\\Projeto2\\build\\web\\imagens\\rickemorty.jpg', 1),
(17, 'Bob Esponja', 'Bob Esponja Calça Quadrada é uma esponja do mar que mora em uma casa de abacaxi. Junto ao melhor amigo, Patrick Estrela, ele sempre tira a paciência do vizinho Lula Molusco. Bob Esponja trabalha no Siri Cascudo, para o Sr. Siriguejo.', 'C:\\Users\\carol\\Faculdade\\Web\\Projeto2\\build\\web\\imagens\\bobesponja.jpg', 1),
(18, 'O Incrivel Mundo de Gumball', 'O Incrível Mundo de Gumball é uma série de desenho animado britânico-americana criado por Ben Bocquelet para o Cartoon Network. A série gira em torno da vida de um gato azul de 12 anos de idade chamado Gumball Watterson e seu irmão adotivo e melhor amigo, Darwin Watterson. Juntos, eles causam confusões pela cidade de Elmore, acompanhados de sua irmã mais nova Anais e de seus pais Nicole e Richard.', 'C:\\Users\\carol\\Faculdade\\Web\\Projeto2\\build\\web\\imagensmundodegumball.jpg', 1);
-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `usu_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `usu_login` varchar(20) CHARACTER SET latin1 NOT NULL,
  `usu_senha` varchar(20) CHARACTER SET latin1 NOT NULL,
  `usu_nome` varchar(50) CHARACTER SET latin1 NOT NULL,
  `usu_email` varchar(50) CHARACTER SET latin1 NOT NULL,
  `usu_endereco` varchar(80) CHARACTER SET latin1 NOT NULL,
  `usu_adm` tinyint(1) NOT NULL,
  PRIMARY KEY (`usu_codigo`),
  UNIQUE KEY `usu_login` (`usu_login`),
  UNIQUE KEY `usu_email` (`usu_email`),
  KEY `usu_login_2` (`usu_login`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`usu_codigo`, `usu_login`, `usu_senha`, `usu_nome`, `usu_email`, `usu_endereco`, `usu_adm`) VALUES
(1, 'carol', 'senha', 'Carol', 'carol@gmail.com', 'Rua Carlos Gomes', 1),
(2, 'user', 'senha', 'Usuario', 'usuario@gmail.com', 'Rua Qualquer', 0),
(3, 'fulano', '123', 'fulano', 'fulano@fulano.com', 'rua alguma ai', 0),
(4, 'dsahkjdhasjk', 'djsahdkhasj', 'adnjasdh', 'dsahdkjash@jhadks', 'dsahdjsahd', 0),
(5, 'dhsahdjak', 'dsadhas', 'dsjadhasjk', 'sjhdjadh@dsakhdksaj.com', 'dsjhadkjas', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
