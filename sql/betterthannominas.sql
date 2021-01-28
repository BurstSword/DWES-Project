-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-01-2021 a las 13:18:18
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `betterthannominas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
  `AdmId` int(20) DEFAULT NULL,
  `Mail` varchar(45) DEFAULT NULL,
  `Pwd` varchar(512) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE `categories` (
  `CatId` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `OrdId` int(11) NOT NULL,
  `vDate` date DEFAULT NULL,
  `Sent` int(11) DEFAULT NULL,
  `Restaurant` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productorders`
--

CREATE TABLE `productorders` (
  `ProdOrder` int(11) NOT NULL,
  `vOrder` int(11) DEFAULT NULL,
  `Product` int(11) DEFAULT NULL,
  `Units` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `ProdId` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Description` varchar(90) DEFAULT NULL,
  `Weight` double DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  `Category` int(11) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurant`
--

CREATE TABLE `restaurant` (
  `ResId` int(11) NOT NULL,
  `Mail` varchar(90) DEFAULT NULL,
  `Pwd` varchar(512) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `CP` int(11) DEFAULT NULL,
  `Country` int(45) DEFAULT NULL,
  `City` int(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`CatId`),
  ADD UNIQUE KEY `UN_CAT_NAME` (`Name`);

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrdId`),
  ADD KEY `Restaurant` (`Restaurant`);

--
-- Indices de la tabla `productorders`
--
ALTER TABLE `productorders`
  ADD PRIMARY KEY (`ProdOrder`),
  ADD KEY `Product` (`Product`),
  ADD KEY `vOrder` (`vOrder`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProdId`),
  ADD KEY `Category` (`Category`);

--
-- Indices de la tabla `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`ResId`),
  ADD UNIQUE KEY `UN_RES_MAIL` (`Mail`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Restaurant`) REFERENCES `restaurant` (`ResId`);

--
-- Filtros para la tabla `productorders`
--
ALTER TABLE `productorders`
  ADD CONSTRAINT `productorders_ibfk_1` FOREIGN KEY (`Product`) REFERENCES `products` (`ProdId`),
  ADD CONSTRAINT `productorders_ibfk_2` FOREIGN KEY (`vOrder`) REFERENCES `orders` (`OrdId`);

--
-- Filtros para la tabla `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`Category`) REFERENCES `categories` (`CatId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
