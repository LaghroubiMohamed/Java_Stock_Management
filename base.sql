-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : jeu. 28 jan. 2021 à 18:50
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `javastock`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `login` varchar(35) COLLATE utf8_bin NOT NULL,
  `password` varchar(35) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `login`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `command`
--

CREATE TABLE `command` (
  `id` int(11) NOT NULL,
  `client` varchar(40) NOT NULL,
  `produit` varchar(40) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix` double NOT NULL,
  `prix_total` double NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `command`
--

INSERT INTO `command` (`id`, `client`, `produit`, `quantite`, `prix`, `prix_total`, `date`) VALUES
(1, 'tom', 'P1', 101, 1.2, 121.2, '2021-01-25 18:11:00'),
(2, 'tim', 'P1', 100, 1.2, 120, '2021-01-25 18:16:00'),
(3, 'med', 'FINAL', 200, 10, 2000, '2021-01-25 18:26:00'),
(4, 'med', 'FINAL', 201, 10, 2010, '2021-01-25 18:26:00'),
(5, '199', 'houssam', 201, 10, 2010, '2021-01-25 18:29:00'),
(6, 'final', 'FINAL', 200, 10, 2000, '2021-01-25 18:35:00'),
(7, 'hello', 'FINAL', 300, 10, 3000, '2021-01-25 18:40:00'),
(8, 'test', 'FINAL', 300, 10, 3000, '2021-01-25 18:43:00'),
(9, 'Client 1', 'PRODUCT 1', 200, 12.99, 2598, '2021-01-28 18:15:00');

-- --------------------------------------------------------

--
-- Structure de la table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `productName` varchar(35) COLLATE utf8_bin NOT NULL,
  `description` varchar(60) COLLATE utf8_bin NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix` float NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `products`
--

INSERT INTO `products` (`id`, `productName`, `description`, `quantite`, `prix`, `date`) VALUES
(30, 'P1', 'p1 desc', 550, 1.2, '2021-01-24 14:11:00'),
(31, 'P2', 'p2 desc', 50, 12.56, '2021-01-24 14:47:00'),
(32, 'P3', 'p3 desc', 100, 12.5, '2021-01-24 15:17:00'),
(33, 'P4', 'p4 desc', 20, 12, '2021-01-24 15:22:00'),
(35, 'P6', 'p6 description1', 700, 1.5, '2021-01-25 12:05:00'),
(36, 'FINAL', 'final desc1', 100, 10, '2021-01-25 18:25:00'),
(37, 'PRODUCT 1', 'product 1 description', 300, 12.99, '2021-03-28 16:30:00');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `command`
--
ALTER TABLE `command`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `command`
--
ALTER TABLE `command`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
