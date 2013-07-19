-- phpMyAdmin SQL Dump
-- version 3.5.8.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-05-2013 a las 05:34:29
-- Versión del servidor: 5.5.31
-- Versión de PHP: 5.4.14

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `Consultorio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `idadmin` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `tratamiento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idadmin`),
  UNIQUE KEY `idadmin_UNIQUE` (`idadmin`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`idadmin`, `nombre`, `apellido`, `username`, `password`, `tratamiento`) VALUES
(1, 'Raúl', 'Gonzáles Leal', 'raul', 'consultorio', 'Dr.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE IF NOT EXISTS `historial` (
  `id_paciente` bigint(20) NOT NULL,
  `fechaConsulta` varchar(50) NOT NULL,
  `padActual` varchar(50) NOT NULL,
  `examenLab` varchar(50) NOT NULL,
  `examenImg` varchar(50) NOT NULL,
  `tratamiento` varchar(50) NOT NULL,
  `comentarios` text NOT NULL,
  `fechaSeguimiento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`id_paciente`, `fechaConsulta`, `padActual`, `examenLab`, `examenImg`, `tratamiento`, `comentarios`, `fechaSeguimiento`) VALUES
(1, '25/4/2013', 'Dolor Garganta, Posible Gripe', 'no', 'no', 'Analgésico, Controlado', 'No habra seguimiento', ''),
(1, '28/5/2013', 'Infeción Garganta', 'no', 'no', 'Antibiotico, Controlado', 'nada', ''),
(1, '03/05/2013', 'Dolor Cabeza', 'no', 'no', 'Paracetamol', 'Ninguno', '04/12/1910'),
(1, '03/05/2013', 'bdg', 'dfb', 'fb', 'fb', 'bfd', '04/12/1910'),
(1, '03/05/2013', 'kj', 'hkjh', 'kjh', 'kjh', 'kkjhkjh', '4/6/2013'),
(5, '03/05/2013', 'Tos', 'NO', 'NO', '2 cucharaditas de jarabe de miel de abeja', 'Debe cuidarse del frio', '6/5/2013'),
(6, '03/05/2013', 'Jaquecas continuas', 'NO', 'NO', 'No hacer tarea y guardar reposo. Tomar Analgesicos', 'Su pagina esta chida', '22/5/2013'),
(1, '06/05/2013', 'dolor de brazo', 'no', 'no', 'Analgesico	', 'cojnevonoinoinvwwwwwwwwwwwwwwwwwwwwwwwwwwroinwoinvwvoinweiovn', '9/5/2013'),
(6, '06/05/2013', 'kjsdkjh', 'kjhkjh', 'kjhkjh', 'kkjbkjb', 'jhkjh', '7/8/2013'),
(1, '07/05/2013', 'ifvbwiu', 'biub', 'iub', 'iu	bi	ub	iu', 'i	bi	ub', '8/6/2013'),
(5, '18/05/2013', 'Malestar Estomacal', 'no', 'no', 'Treda 100mg Tabletas', 'Recordar que es una cada 6 horas', '20/5/2013'),
(0, '19/05/2013', '', '', '', '', '', '2/2/2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nopatologicos`
--

CREATE TABLE IF NOT EXISTS `nopatologicos` (
  `id_paciente` bigint(20) unsigned NOT NULL,
  `ginecologico` text NOT NULL,
  `peso` double NOT NULL,
  `talla` double NOT NULL,
  `tiposangre` varchar(5) NOT NULL,
  `freccard` double NOT NULL,
  `tensionArt` double NOT NULL,
  `frecresp` double NOT NULL,
  `otronopat` text NOT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `nopatologicos`
--

INSERT INTO `nopatologicos` (`id_paciente`, `ginecologico`, `peso`, `talla`, `tiposangre`, `freccard`, `tensionArt`, `frecresp`, `otronopat`) VALUES
(1, 'N/A', 100, 40, 'B+', 64, 120.8, 24, 'Nada'),
(2, 'Regla(Irregular)', 59, 9, 'A+', 120, 22, 76, 'N/A'),
(3, 'N/A', 200, 50, 'O-', 200, 100, 5, 'N/A'),
(4, 'n/a', 85, 38, 'B+', 33, 787, 78, 'N/A'),
(5, 'N/A', 75, 180, 'O-', 120.7, 26, 70, 'Pos aah'),
(6, 'N/A', 68, 175, 'O+', 80.12, 72, 58, 'N/A'),
(7, 'N/A', 61, 28, 'AB-', 120.8, 0, 72, 'NADA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido1` varchar(30) CHARACTER SET latin1 NOT NULL,
  `apellido2` varchar(30) CHARACTER SET latin1 NOT NULL,
  `sexo` tinyint(1) NOT NULL,
  `estadoCivil` varchar(20) CHARACTER SET latin1 NOT NULL,
  `ocupacion` varchar(30) CHARACTER SET latin1 NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `movil` bigint(20) NOT NULL,
  `email` varchar(30) CHARACTER SET latin1 NOT NULL,
  `FechaNac` varchar(30) CHARACTER SET latin1 NOT NULL,
  `edad` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`id`, `nombre`, `apellido1`, `apellido2`, `sexo`, `estadoCivil`, `ocupacion`, `telefono`, `movil`, `email`, `FechaNac`, `edad`) VALUES
(1, 'Miguel Marin', 'Salinas', 'Sanchez', 1, 'Soltero', 'Estudiante', 83592311, 8115780151, 'm.mslns27@gmail.com', '27/1/1994', 19),
(2, 'Andrea Lizbeth', 'Rojas', 'Hernandez', 0, 'Soltera', 'Estudiante', 83403812, 8114813953, 'arojas_hdz@hotmail.com', '4/5/1993', 20),
(3, 'Pedro', 'Pirez', 'Perez', 1, 'Casado', 'Taxista', 89926570, 811123345, 'pedropirez@gmail.com', '4/5/1990', 23),
(4, 'Francisco', 'Lopez', 'Ramirez', 1, 'Soltero', 'Comerciante', 87766554, 8113456789, 'paco@aol.mx', '30/7/1985', 27),
(5, 'Brandon C', 'Villalobos', 'Martinez', 1, 'Soltero', 'Estudiante', 81234567, 81100112233, 'brandonc@hotmail.com', '26/1/1994', 19),
(6, 'Rafael', 'Torres', 'Teista', 1, 'Soltero', 'Estudiante', 12345678, 8114187095, 'rafa_tazz@hotmail.com', '16/6/1994', 18),
(7, 'MARCO', 'URREA', 'GONZALEZ', 0, 'SOLTERO', 'PROGRAMADOR', 123456789, 8765432124, 'MARCO.URREA@GMAIL.COM', '17/9/1993', 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patologicos`
--

CREATE TABLE IF NOT EXISTS `patologicos` (
  `id_paciente` bigint(20) unsigned NOT NULL,
  `diabetes` tinyint(1) NOT NULL,
  `hipertension` tinyint(1) NOT NULL,
  `tabaquismo` tinyint(1) NOT NULL,
  `alcoholismo` tinyint(1) NOT NULL,
  `otroPat` text NOT NULL,
  `alergiaMed` text NOT NULL,
  `alergiaSus` text NOT NULL,
  `alergiaAl` text NOT NULL,
  `otraAlergia` text NOT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `patologicos`
--

INSERT INTO `patologicos` (`id_paciente`, `diabetes`, `hipertension`, `tabaquismo`, `alcoholismo`, `otroPat`, `alergiaMed`, `alergiaSus`, `alergiaAl`, `otraAlergia`) VALUES
(1, 0, 0, 0, 1, 'Nada', 'Ninguno', 'Ninguna	', 'Ninguno', 'N/A'),
(2, 0, 0, 0, 0, 'Hipotirodismo', 'N/A', 'N/A', 'N/A', 'N/A'),
(3, 1, 0, 0, 1, 'N/A', 'N/A', 'N/A', 'N/A', 'N/A'),
(4, 1, 0, 0, 1, 'Nada', 'nada', 'nada', 'nada', 'N/A'),
(5, 0, 0, 0, 0, 'N/A', 'Ninguno', 'Ninguna', 'Pizza de don Cangrejo', 'N/A'),
(6, 0, 0, 0, 0, 'N/A', 'No tiene', 'No tiene', 'No tiene', 'N/A'),
(7, 0, 0, 0, 0, 'BRONQUITIS', 'NADA', 'NO', 'NO', 'MUGRE');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
