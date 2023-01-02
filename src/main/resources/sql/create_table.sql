create database home_family;

CREATE TABLE `family_information`
(
    `id`                 bigint(20)   NOT NULL AUTO_INCREMENT,
    `family_id`          varchar(255) NOT NULL DEFAULT '' COMMENT '家庭ID',
    `family_name`        varchar(255) NOT NULL DEFAULT '' COMMENT '家庭名称',
    `family_description` text COMMENT '家庭描述',
    `is_delete`             int          NOT NULL DEFAULT 0 COMMENT '是否删除，0-否，1-是',
    `create_time`        datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`        datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_family_id` (`family_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '家庭信息';


create table `family_member_information`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `user_id`     varchar(255) NOT NULL DEFAULT '' COMMENT '成员ID',
    `nickname`    varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
    `username`    varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
    `appellation` varchar(255) NOT NULL DEFAULT '' COMMENT '称谓',
    `score`       bigint(20)   NOT NULL DEFAULT 0 COMMENT '积分',
    `family_id`   varchar(255) NOT NULL DEFAULT '' COMMENT '家庭ID',
    `is_delete`      int          NOT NULL DEFAULT 0 COMMENT '是否删除，0-否，1-是',
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '家庭成员信息';

create table `family_member_score_detail`
(
    `id`                 bigint(20)   NOT NULL AUTO_INCREMENT,
    `user_id`            varchar(255) NOT NULL DEFAULT '' COMMENT '成员ID',
    `change_description` varchar(512) NOT NULL DEFAULT '' COMMENT '积分变动描述',
    `work_user_id`       varchar(255) NOT NULL DEFAULT '' COMMENT '工作成员ID',
    `score`              bigint(20)   NOT NULL DEFAULT 0 COMMENT '积分',
    `is_delete`             int          NOT NULL DEFAULT 0 COMMENT '是否删除，0-否，1-是',
    `create_time`        datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`        datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '家庭成员积分变动明细';