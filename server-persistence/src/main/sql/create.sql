DROP SCHEMA IF EXISTS `scheisse` ;
CREATE SCHEMA IF NOT EXISTS `scheisse` DEFAULT CHARACTER SET utf8 ;
USE `scheisse` ;

-- -----------------------------------------------------
-- Table `scheisse`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scheisse`.`user` ;

CREATE TABLE IF NOT EXISTS `scheisse`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `passwordHash` TEXT NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `experience` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `id_UNIQUE` ON `scheisse`.`user` (`id` ASC);

CREATE UNIQUE INDEX `username_UNIQUE` ON `scheisse`.`user` (`username` ASC);

CREATE UNIQUE INDEX `email_UNIQUE` ON `scheisse`.`user` (`email` ASC);


-- -----------------------------------------------------
-- Table `scheisse`.`contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scheisse`.`contact` ;

CREATE TABLE IF NOT EXISTS `scheisse`.`contact` (
  `owner` INT(11) NOT NULL,
  `accotiatedWith` INT(11) NOT NULL,
  PRIMARY KEY (`owner`, `accotiatedWith`),
  CONSTRAINT `fk_contact_associatedWith`
    FOREIGN KEY (`accotiatedWith`)
    REFERENCES `scheisse`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contact_owner`
    FOREIGN KEY (`owner`)
    REFERENCES `scheisse`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_contact_associatedWith_idx` ON `scheisse`.`contact` (`accotiatedWith` ASC);


-- -----------------------------------------------------
-- Table `scheisse`.`inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scheisse`.`inventory` ;

CREATE TABLE IF NOT EXISTS `scheisse`.`inventory` (
  `user` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `size` INT(11) NULL DEFAULT '20',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_inventory_user`
    FOREIGN KEY (`user`)
    REFERENCES `scheisse`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `userId_UNIQUE` ON `scheisse`.`inventory` (`user` ASC);

CREATE UNIQUE INDEX `id_UNIQUE` ON `scheisse`.`inventory` (`id` ASC);


-- -----------------------------------------------------
-- Table `scheisse`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scheisse`.`item` ;

CREATE TABLE IF NOT EXISTS `scheisse`.`item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `price` INT(11) NOT NULL DEFAULT '0',
  `name` VARCHAR(50) NOT NULL,
  `attack` INT(11) NOT NULL DEFAULT '0',
  `armor` INT(11) NOT NULL DEFAULT '0',
  `maxStackAmount` INT(11) NOT NULL DEFAULT '1',
  `minLevel` INT(11) NOT NULL DEFAULT '1',
  `types` INT(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `item_UNIQUE` ON `scheisse`.`item` (`id` ASC);

CREATE UNIQUE INDEX `name_UNIQUE` ON `scheisse`.`item` (`name` ASC);


-- -----------------------------------------------------
-- Table `scheisse`.`shopRequest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scheisse`.`shopRequest` ;

CREATE TABLE IF NOT EXISTS `scheisse`.`shopRequest` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `itemId` INT(11) NOT NULL,
  `amount` INT(11) NOT NULL,
  `singlePrice` INT(11) NOT NULL,
  `buy` BIT(1) NOT NULL,
  `timestamp` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_shopRequest_item`
    FOREIGN KEY (`itemId`)
    REFERENCES `scheisse`.`item` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shopRequest_user`
    FOREIGN KEY (`userId`)
    REFERENCES `scheisse`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `id_UNIQUE` ON `scheisse`.`shopRequest` (`id` ASC);

CREATE INDEX `fk_shopRequest_user_idx` ON `scheisse`.`shopRequest` (`userId` ASC);

CREATE INDEX `fk_shopRequest_item_idx` ON `scheisse`.`shopRequest` (`itemId` ASC);


-- -----------------------------------------------------
-- Table `scheisse`.`shopTransaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scheisse`.`shopTransaction` ;

CREATE TABLE IF NOT EXISTS `scheisse`.`shopTransaction` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `buy` BIT(1) NOT NULL,
  `userId` INT(11) NOT NULL,
  `itemId` INT(11) NOT NULL,
  `amount` INT(11) NOT NULL,
  `singlePrice` INT(11) NOT NULL,
  `timestamp` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_shopTransaction_item`
    FOREIGN KEY (`itemId`)
    REFERENCES `scheisse`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shopTransaction_user`
    FOREIGN KEY (`userId`)
    REFERENCES `scheisse`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `id_UNIQUE` ON `scheisse`.`shopTransaction` (`id` ASC);

CREATE INDEX `fk_shopTransaction_user_idx` ON `scheisse`.`shopTransaction` (`userId` ASC);

CREATE INDEX `fk_shopTransaction_item_idx` ON `scheisse`.`shopTransaction` (`itemId` ASC);


-- -----------------------------------------------------
-- Table `scheisse`.`slot`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scheisse`.`slot` ;

CREATE TABLE IF NOT EXISTS `scheisse`.`slot` (
  `inventory` INT(11) NOT NULL,
  `item` INT(11) NOT NULL,
  `amount` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_slot_inventory`
    FOREIGN KEY (`inventory`)
    REFERENCES `scheisse`.`inventory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_slot_item`
    FOREIGN KEY (`item`)
    REFERENCES `scheisse`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `id_UNIQUE` ON `scheisse`.`slot` (`id` ASC);

CREATE INDEX `fk_inventory_item_item_idx` ON `scheisse`.`slot` (`item` ASC);

CREATE INDEX `fk_slot_inventory_idx` ON `scheisse`.`slot` (`inventory` ASC);
