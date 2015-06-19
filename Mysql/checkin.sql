SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `checkin` ;
CREATE SCHEMA IF NOT EXISTS `checkin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `checkin` ;

-- -----------------------------------------------------
-- Table `checkin`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `checkin`.`user` (
  `iduser` SMALLINT NOT NULL,
  `matricula` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NULL,
  `senha_hash` VARCHAR(50) NOT NULL,
  `api_key_hash` VARCHAR(50) NOT NULL,
  UNIQUE INDEX `api_key_hash_UNIQUE` (`api_key_hash` ASC),
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `checkin`.`aula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `checkin`.`aula` (
  `id_aula` INT NOT NULL,
  `horario` VARCHAR(45) NOT NULL,
  `data` DATE NULL,
  `senhaAula` VARCHAR(45) NOT NULL,
  `status` CHAR NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_aula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `checkin`.`alunos_presentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `checkin`.`alunos_presentes` (
  `aula_id` INT NOT NULL,
  `user_matricula` INT NOT NULL,
  `status` CHAR NULL DEFAULT 0,
  PRIMARY KEY (`aula_id`, `user_matricula`),
  INDEX `fk_aula_has_user_user1_idx` (`user_matricula` ASC),
  CONSTRAINT `fk_aula_has_user_aula1`
    FOREIGN KEY (`aula_id`)
    REFERENCES `checkin`.`aula` (`id_aula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aula_has_user_user1`
    FOREIGN KEY (`user_matricula`)
    REFERENCES `checkin`.`user` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
