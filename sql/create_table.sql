# 用户表
CREATE TABLE `users` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `username` varchar(255) DEFAULT NULL COMMENT '用户名',
    `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
    `user_following_json` varchar(1024) DEFAULT NULL COMMENT '关注用户',
    `nickname` varchar(255) DEFAULT NULL COMMENT '用户昵称',
    `role` tinyint(4) NOT NULL DEFAULT '0' COMMENT '身份, 0游客;1用户;2管理',
    `avatar` varchar(1024) DEFAULT NULL COMMENT '用户头像',
    `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
    `phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
    `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
    `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态, 0未激活;1已激活',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

# 帖子表
CREATE TABLE `post` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '帖子id',
    `title` varchar(255) DEFAULT NULL COMMENT '帖子标题',
    `content` text COMMENT '帖子内容',
    `user_id` bigint NOT NULL COMMENT '作者ID，外键关联用户表',
    `category_id` bigint NOT NULL COMMENT '分类ID',
    `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '帖子状态，0正常，1删除',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `user_id` (`user_id`),
    KEY `category_id` (`category_id`),
    CONSTRAINT `post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='帖子表';

# 用户帖子表
CREATE TABLE `User_Post` (
    `post_id` bigint NOT NULL COMMENT '用户帖子表id',
    `user_id` bigint NOT NULL COMMENT '用户ID',
    `title` varchar(255) DEFAULT NULL COMMENT '帖子标题',
    `content` text COMMENT '帖子内容',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `like_count` bigint NOT NULL DEFAULT '0' COMMENT '帖子点赞数',
    `view_count` bigint NOT NULL DEFAULT '0' COMMENT '帖子浏览数',
    `reply_count` bigint NOT NULL DEFAULT '0' COMMENT '帖子回复数',
    PRIMARY KEY (`post_id`,`user_id`),
    CONSTRAINT `User_Post_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
    CONSTRAINT `User_Post_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户帖子表';

# 标签表
CREATE TABLE `tag` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '标签id',
    `name` varchar(255) NOT NULL COMMENT '标签名称',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签表';

# 帖子标签表
CREATE TABLE `postTag` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `post_id` bigint NOT NULL COMMENT '帖子id，外键 ，关联帖子表',
    `tag_id` bigint NOT NULL COMMENT '标签id，外键 ，关联标签表',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='帖子标签表';

# 分类表
CREATE TABLE `category` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类id',
    `name` varchar(255) NOT NULL COMMENT '分类名称',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分类表';

# 评论表
CREATE TABLE `comment` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '评论ID，主键',
    `user_id` bigint NOT NULL COMMENT '作者ID，外键关联用户表',
    `post_id` bigint NOT NULL COMMENT '帖子ID，外键关联帖子表',
    `parent_id` bigint DEFAULT NULL COMMENT '父评论ID，表示该评论是回复哪条评论的',
    `content` text NOT NULL COMMENT '评论内容',
    `status` tinyint NOT NULL DEFAULT '0' COMMENT '评论状态，0表示正常，1表示删除',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `fk_comment_author_id` (`user_id`),
    KEY `fk_comment_post_id` (`post_id`),
    KEY `fk_comment_parent_id` (`parent_id`),
    CONSTRAINT `fk_comment_author_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_comment_post_id` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

