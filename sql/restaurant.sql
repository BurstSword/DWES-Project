-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-02-2021 a las 19:05:19
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
-- Base de datos: `restaurant`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categories`
--

INSERT INTO `categories` (`id`, `description`, `name`) VALUES
(1, 'Dairy Products', 'Dairy'),
(2, 'Tables, Desks, office stuff in general', 'Furniture'),
(3, 'Drinks and stuff', 'Drinks');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `sent` int(11) NOT NULL,
  `v_date` date DEFAULT NULL,
  `restaurant_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `orders`
--

INSERT INTO `orders` (`id`, `sent`, `v_date`, `restaurant_id`) VALUES
(58, 0, '2021-02-13', 1),
(59, 0, '2021-02-13', 1),
(60, 0, '2021-02-13', 1),
(61, 0, '2021-02-13', 1),
(62, 0, '2021-02-14', 1),
(63, 0, '2021-02-23', 2),
(64, 0, '2021-02-23', 2),
(65, 0, '2021-02-23', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `description`, `name`, `price`, `stock`, `weight`, `category_id`) VALUES
(1, 'Nice milk', 'Milk', 5, 40, 5, 1),
(2, 'Nice desk', 'Desk', 8, 30, 142, 2),
(3, 'Smelly, but tasty', 'Emmental Cheese', 8, 335, 2, 1),
(4, 'Comfortable and small', 'Office chair', 40, 338, 15, 2),
(5, 'Fresh!', 'Just water', 2, 348, 3, 3),
(6, 'A bit Iugh', 'Cruzcampo', 2, 346, 4, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products_orders`
--

CREATE TABLE `products_orders` (
  `units` int(11) DEFAULT NULL,
  `orders_id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `products_orders`
--

INSERT INTO `products_orders` (`units`, `orders_id`, `products_id`) VALUES
(4, 64, 2),
(1, 64, 4),
(5, 64, 5),
(7, 64, 6),
(6, 65, 1),
(6, 65, 2),
(7, 65, 3),
(5, 65, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurant`
--

CREATE TABLE `restaurant` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `cp` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `restaurant`
--

INSERT INTO `restaurant` (`id`, `address`, `city`, `country`, `cp`, `mail`, `pwd`) VALUES
(2, 'C/Apruebame Javi anda', 'Sevilla', 'España', '41006', 'Javi@mail', '12345678'),
(3, 'C/ En serio, por favor apruébame', 'Sevilla', 'España', '41006', 'Olga@mail', '12345678');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_t8o6pivur7nn124jehx7cygw5` (`name`) USING HASH;

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi7hgjxhw21nei3xgpe4nnpenh` (`restaurant_id`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`);

--
-- Indices de la tabla `products_orders`
--
ALTER TABLE `products_orders`
  ADD PRIMARY KEY (`orders_id`,`products_id`),
  ADD KEY `FK7eya6uyonr8hx842qwm22uw6c` (`products_id`);

--
-- Indices de la tabla `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_t53ntj514u734ef17u5s37ral` (`mail`) USING HASH;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
