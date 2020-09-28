
-- Copiando estrutura do banco de dados para nicks
CREATE DATABASE IF NOT EXISTS `nicks`;
USE `nicks`;

-- Copiando estrutura para tabela nicks.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;



-- Copiando estrutura para tabela nicks.nick
CREATE TABLE IF NOT EXISTS `nick` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `nick` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


