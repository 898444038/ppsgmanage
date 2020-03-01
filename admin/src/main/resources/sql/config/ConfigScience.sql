CREATE TABLE `p_config_science` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`level` INTEGER(11)  DEFAULT NULL  COMMENT '级别',
`code` VARCHAR(32)  DEFAULT NULL  COMMENT '编号',
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '名称',
`force_rate` DECIMAL(10,2)  DEFAULT NULL  COMMENT '武力加成百分比',
`intellect_rate` DECIMAL(10,2)  DEFAULT NULL  COMMENT '智力加成百分比',
`troops_rate` DECIMAL(10,2)  DEFAULT NULL  COMMENT '兵力加成百分比',
`self_hurt` DECIMAL(10,2)  DEFAULT NULL  COMMENT '自身兵种伤害加成',
`self_hurt_desc` VARCHAR(32)  DEFAULT NULL  COMMENT '自身兵种伤害加成描述',
`restraint_hurt` DECIMAL(10,2)  DEFAULT NULL  COMMENT '针对兵种伤害加成',
`restraint_hurt_desc` VARCHAR(32)  DEFAULT NULL  COMMENT '针对兵种伤害加成描述',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

