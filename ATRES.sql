-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-12-2017 a las 19:23:29
-- Versión del servidor: 5.5.58-0ubuntu0.14.04.1
-- Versión de PHP: 5.5.9-1ubuntu4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `ATRES`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Departamentos`
--

CREATE TABLE IF NOT EXISTS `Departamentos` (
  `Id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `Departamento` varchar(30) NOT NULL,
  PRIMARY KEY (`Id_departamento`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `Departamentos`
--

INSERT INTO `Departamentos` (`Id_departamento`, `Departamento`) VALUES
(1, 'Casa'),
(2, 'Oficina'),
(3, 'Escuela');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Empleados`
--

CREATE TABLE IF NOT EXISTS `Empleados` (
  `Id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Ap_paterno` varchar(30) NOT NULL,
  `Ap_materno` varchar(30) NOT NULL,
  `Sexo` varchar(10) NOT NULL,
  `Edad` varchar(10) NOT NULL,
  `Usuario` varchar(30) NOT NULL,
  `Contrasenia` varchar(30) NOT NULL,
  `Id_tipo_empleado` int(11) DEFAULT NULL,
  `Id_sucursal` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_empleado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `Empleados`
--

INSERT INTO `Empleados` (`Id_empleado`, `Nombre`, `Ap_paterno`, `Ap_materno`, `Sexo`, `Edad`, `Usuario`, `Contrasenia`, `Id_tipo_empleado`, `Id_sucursal`) VALUES
(1, 'Jose', 'Castellanos', 'Ramos', 'Masculino', '20', 'JoseCR', 'josesito1', 1, 1),
(2, 'Esteban', 'Ortiz', 'Rodriguez', 'Masculino', '27', 'EOR27', 'hoy', 2, 2),
(4, 'Michelle', 'Allegretti', 'Rodriguez', 'Femenino', '20', 'Leon', 'Alle11', 1, 1),
(7, 'Mariela', 'Ruiz', 'Esparza', 'Femenino', '25', 'luna12', 'cielo1', 4, 2),
(8, 'Diego', 'Lainez', 'Rueda', 'Masculino', '27', 'mgm', '123', 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Productos`
--

CREATE TABLE IF NOT EXISTS `Productos` (
  `Id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Id_proveedor` int(11) DEFAULT NULL,
  `Id_departamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `Productos`
--

INSERT INTO `Productos` (`Id_producto`, `Nombre`, `Cantidad`, `Id_proveedor`, `Id_departamento`) VALUES
(3, 'Lupa', 50, 1, 3),
(4, 'Maceta', 15, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Proveedores`
--

CREATE TABLE IF NOT EXISTS `Proveedores` (
  `Id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Usuario` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  PRIMARY KEY (`Id_proveedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `Proveedores`
--

INSERT INTO `Proveedores` (`Id_proveedor`, `Nombre`, `Usuario`, `Password`) VALUES
(1, 'P&G', 'panda', 'mexico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Requisiciones`
--

CREATE TABLE IF NOT EXISTS `Requisiciones` (
  `Id_requisicion` int(11) NOT NULL AUTO_INCREMENT,
  `Cantidad` int(11) NOT NULL,
  `Status` int(11) DEFAULT NULL,
  `Id_producto` int(11) DEFAULT NULL,
  `Id_sucursal` int(11) DEFAULT NULL,
  `Id_empleado` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_requisicion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `Requisiciones`
--

INSERT INTO `Requisiciones` (`Id_requisicion`, `Cantidad`, `Status`, `Id_producto`, `Id_sucursal`, `Id_empleado`) VALUES
(1, 2, 1, 3, 2, 7),
(3, 20, 0, 4, 4, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Sucursales`
--

CREATE TABLE IF NOT EXISTS `Sucursales` (
  `Id_sucursal` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Calle` varchar(30) NOT NULL,
  `Numero` varchar(10) NOT NULL,
  `Colonia` varchar(30) NOT NULL,
  `Delegacion` varchar(30) NOT NULL,
  `Ciudad` varchar(30) NOT NULL,
  `Codigo Postal` varchar(10) NOT NULL,
  PRIMARY KEY (`Id_sucursal`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `Sucursales`
--

INSERT INTO `Sucursales` (`Id_sucursal`, `Nombre`, `Calle`, `Numero`, `Colonia`, `Delegacion`, `Ciudad`, `Codigo Postal`) VALUES
(1, 'Almacen', 'Benito Juarez', '5010', 'Xalostoc', 'Ecatepec', 'Estado de Mexico', '06523'),
(2, 'Norte', 'Montevideo', '1230', 'Lindavista', 'Gustavo A. Madero', 'Ciudad de Mexico', '12358'),
(3, 'Sur', 'Universidad', '850', 'Coyoacan', 'Coyoacan', 'Ciudad de Mexico', '01276'),
(4, 'Centro', 'Eje Central', '3400', 'Centro', 'Cuauhtemoc', 'Ciudad de Mexico', '04823');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Tipo_empleado`
--

CREATE TABLE IF NOT EXISTS `Tipo_empleado` (
  `Id_tipo_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(30) NOT NULL,
  PRIMARY KEY (`Id_tipo_empleado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `Tipo_empleado`
--

INSERT INTO `Tipo_empleado` (`Id_tipo_empleado`, `Tipo`) VALUES
(1, 'Gerente'),
(2, 'Gerente Sucursal'),
(3, 'Trabajador Almacen'),
(4, 'Trabajador Sucursal');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
