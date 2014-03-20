CREATE TABLE `fyp`.`project` (
  `project_id` INT NOT NULL AUTO_INCREMENT,
  `projectName` VARCHAR(45) NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  `department` VARCHAR(45) NULL,
  PRIMARY KEY (`project_id`));
  
CREATE TABLE `fyp`.`project_member` (
  `idproject_member` INT NOT NULL AUTO_INCREMENT,
  `project_id` INT NULL,
  `employee_id` INT NULL,
  PRIMARY KEY (`idproject_member`),
  INDEX `employee_id_idx` (`employee_id` ASC),
  INDEX `project_id_idx` (`project_id` ASC),
  CONSTRAINT `project_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `fyp`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `employee_id`
    FOREIGN KEY (`employee_id`)
    REFERENCES `fyp`.`employee` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);