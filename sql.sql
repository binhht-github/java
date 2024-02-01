
CREATE DATABASE micro_db;
use micro_db;
CREATE TABLE `user`
(
  `id`         bigint(20) NOT NULL      AUTO_INCREMENT,
  `hp`   		int  NULL          DEFAULT NULL,
  `stamina`    int                  DEFAULT NULL,
  PRIMARY KEY (`id`)
);
