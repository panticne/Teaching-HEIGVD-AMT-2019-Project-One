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
  `prenom` VARCHAR(255) NOT NULL,
  `nom` VARCHAR(255) NOT NULL,
  `pseudo` VARCHAR(255) NOT NULL,
  `motdepasse` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
);


-- -----------------------------------------------------
-- Table `dbVol`.`avion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbVol`.`avion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `compagnie` VARCHAR(255) NOT NULL,
  `type` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
 );


-- -----------------------------------------------------
-- Table `dbVol`.`trajet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbVol`.`trajet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `depart` VARCHAR(255) NOT NULL,
  `arrivee` VARCHAR(255) NOT NULL,
  `duree` INT NOT NULL,
  PRIMARY KEY (`id`)
);


-- -----------------------------------------------------
-- Table `dbVol`.`vol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbVol`.`vol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pilote_id` INT NOT NULL,
  `avion_id` INT NOT NULL,
  `trajet_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vol_pilote_idx` (`pilote_id` ASC) ,
  INDEX `fk_vol_avion1_idx` (`avion_id` ASC) ,
  INDEX `fk_vol_trajet1_idx` (`trajet_id` ASC) ,
  CONSTRAINT `fk_vol_pilote`
    FOREIGN KEY (`pilote_id`)
    REFERENCES `dbVol`.`pilote` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vol_avion1`
    FOREIGN KEY (`avion_id`)
    REFERENCES `dbVol`.`avion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vol_trajet1`
    FOREIGN KEY (`trajet_id`)
    REFERENCES `dbVol`.`trajet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
