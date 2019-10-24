CREATE SCHEMA IF NOT EXISTS `dbVol` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema planeproject
-- -----------------------------------------------------
USE `dbVol` ;

-- -----------------------------------------------------
-- Table `dbVol`.`pilote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbVol`.`pilote` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(255) NOT NULL,
  `lastname` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
);


-- -----------------------------------------------------
-- Table `dbVol`.`Avion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbVol`.`Avion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Compagnie` VARCHAR(255) NOT NULL,
  `Type` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
 );


-- -----------------------------------------------------
-- Table `dbVol`.`Trajet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbVol`.`Trajet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `depart` VARCHAR(255) NOT NULL,
  `arrivee` VARCHAR(255) NOT NULL,
  `duree` INT NOT NULL,
  PRIMARY KEY (`id`)
);


-- -----------------------------------------------------
-- Table `dbVol`.`Vol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbVol`.`Vol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pilote_id` INT NOT NULL,
  `Avion_id` INT NOT NULL,
  `Trajet_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Vol_pilote_idx` (`pilote_id` ASC) ,
  INDEX `fk_Vol_Avion1_idx` (`Avion_id` ASC) ,
  INDEX `fk_Vol_Trajet1_idx` (`Trajet_id` ASC) ,
  CONSTRAINT `fk_Vol_pilote`
    FOREIGN KEY (`pilote_id`)
    REFERENCES `dbVol`.`pilote` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vol_Avion1`
    FOREIGN KEY (`Avion_id`)
    REFERENCES `dbVol`.`Avion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vol_Trajet1`
    FOREIGN KEY (`Trajet_id`)
    REFERENCES `dbVol`.`Trajet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
