CREATE TABLE `p_config_dict` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`code` VARCHAR(32)  DEFAULT NULL  COMMENT '编号',
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '名称',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

