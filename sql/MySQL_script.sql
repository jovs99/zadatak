CREATE TABLE `sequencesdb`.`sequence` (
  `seqId` int(11) NOT NULL AUTO_INCREMENT,
  `submitted_by` varchar(45) NOT NULL,
  `purpose` varchar(45) NOT NULL,
  `date_created` datetime NOT NULL,
  PRIMARY KEY (`seqId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
