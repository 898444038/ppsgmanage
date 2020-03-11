CREATE TABLE `p_activity_calendar` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`start_date` datetime  DEFAULT NULL  COMMENT '开始时间',
`end_date` datetime  DEFAULT NULL  COMMENT '结束时间',
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '活动名称',
`content` TEXT  DEFAULT NULL  COMMENT '活动内容',
`expire` TINYINT(1)  DEFAULT NULL  COMMENT '是否过期',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

