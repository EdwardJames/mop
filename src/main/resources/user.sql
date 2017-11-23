 CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `index_num_age` (`num`,`age`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;



CREATE TABLE `upload_picture_record` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `pic_name` varchar(32) CHARACTER SET latin1 NOT NULL COMMENT '图片名称',
  `title` varchar(60) CHARACTER SET latin1 DEFAULT NULL COMMENT '标题',
  `apartment_layout` smallint(6) NOT NULL COMMENT '户型  1.一居 2.二居 3.三居 4.四居 5.复式 6.别墅 7.公寓 8. loft 9.小户型',
  `style` smallint(6) DEFAULT NULL COMMENT '风格 1.简约 2.现代 3.中式 4.欧式 5.美式 6.田园 7.新古典  8.地中海 9.东南亚 10日式 11宜家 12北欧 13简欧 14巴洛克 15.复古 16.混搭',
  `area` smallint(6) NOT NULL COMMENT '面积',
  `label` smallint(6) NOT NULL COMMENT '0.正常 1.hot 2.最新',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  `upload_user` varchar(5) CHARACTER SET latin1 NOT NULL COMMENT '上传人',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `group_id` smallint(6) NOT NULL COMMENT '图片group',
  `space` smallint(6) NOT NULL COMMENT '空间：1.客厅 2.卧室 3.书房 4.卫生间 5.厨房 6.阳台 7.餐厅 8.玄关 9.过道 10.儿童房 11.衣帽间 ',
  `part` smallint(6) DEFAULT NULL COMMENT '局部：1.背景墙 2.吊顶 3.隔断 4.窗帘 5.飘窗 6.榻榻米 7.橱柜 8.博古架 9阁楼 10.隐形门 11.吧台 12.酒柜 13.鞋柜14.衣柜 15.窗户 16.相片墙 17.楼梯 18.窗台',
  `source` smallint(6) NOT NULL COMMENT '图片来源 0.网络 1.工地 ',
  `description` varchar(200) CHARACTER SET latin1 DEFAULT NULL COMMENT '图片描述',
  `location` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '地址',
  `image_path` text CHARACTER SET latin1 NOT NULL COMMENT '图片路径',
  `top_status` smallint(2) DEFAULT '0' COMMENT '是否为首页展示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片上传记录';