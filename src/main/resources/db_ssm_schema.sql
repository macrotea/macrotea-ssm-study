CREATE TABLE tb_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  addTime datetime DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ;