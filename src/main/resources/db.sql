CREATE TABLE `t_share_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) NOT NULL,
  `value` varchar(1000) NOT NULL,
  `is_delete` tinyint(1) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_idx` (`key`) USING BTREE COMMENT 'key索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分享信息表';