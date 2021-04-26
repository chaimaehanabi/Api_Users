-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 26 avr. 2021 à 03:36
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.15

SET
SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET
time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `chaimae`
--

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur`
(
    `id`             bigint(20) NOT NULL,
    `email`          varchar(255) DEFAULT NULL,
    `nom_entreprise` varchar(255) DEFAULT NULL,
    `prenom`         varchar(255) DEFAULT NULL,
    `address`        varchar(255) DEFAULT NULL,
    `nom`            varchar(255) DEFAULT NULL,
    `pwd`            varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `nom_entreprise`, `prenom`, `address`, `nom`, `pwd`)
VALUES (1, 'cahimae@gmail.com', 'marjane', 'hanabi', NULL, 'cahaimae', NULL),
       (2, 'safae@gmail.com', 'dev', 'tazi', NULL, 'safae', NULL),
       (3, 'safae@gmail.com', 'dell', 'barrada', NULL, 'sara', NULL),
       (4, 'admin1@gmail.com', 'dell', 'Mehdi', 'casa', 'Tahiri', '123'),
       (5, 'Admin2@gmail.com', 'intercallp', 'samiri', 'marrakech', 'ahmed', '123'),
       (6, 'Admin3@gmail.com', 'OCP', 'BARRADA', 'marrakech', 'sanaae', '123');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
    ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
