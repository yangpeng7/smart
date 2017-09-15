/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- -----------------------------------------------------
-- Table `project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(64) NOT NULL,
    `picture_url` VARCHAR(256) DEFAULT NULL,
    `description` VARCHAR(128) NOT NULL,
    `download_url` VARCHAR(256) DEFAULT NULL,
    `tag` VARCHAR(32) NOT NULL,
    `languare` VARCHAR(128) NOT NULL,
    `create_time` DATETIME NOT NULL,
    `update_time` DATETIME NOT NULL,
    `user_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_project_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;

-- -----------------------------------------------------
-- Table `project_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_detail`;
CREATE TABLE `project_detail` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `description` TEXT NOT NULL,
    `project_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` INT(11) NOT NULL,
    `username` VARCHAR(64) DEFAULT NULL,
    `password` VARCHAR(128) DEFAULT NULL,
    `create_time` DATETIME DEFAULT NULL,
    `status_id` INT(10) UNSIGNED NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_user_status_id` FOREIGN KEY (`status_id`) REFERENCES `user_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;


-- -----------------------------------------------------
-- Table `user_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_status`;
CREATE TABLE `user_status` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `code` CHAR(32) NOT NULL,
    `description` CHAR(64) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_status_code` (`code`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;