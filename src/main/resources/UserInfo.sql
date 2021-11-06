CREATE TABLE USER (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL,
  `pass_word` varchar(50) NOT NULL,
  `create_date` timestamp NOT NULL,
  `create_user` varchar(50) NOT NULL,
  `update_date` timestamp NOT NULL,
  `update_user` varchar(50) NOT NULL,
  `comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;