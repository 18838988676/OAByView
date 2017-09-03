/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : system_oa

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-08-20 15:35:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK34cgwrwkelqr4huehalvmu9sk` (`parentId`),
  CONSTRAINT `FK34cgwrwkelqr4huehalvmu9sk` FOREIGN KEY (`parentId`) REFERENCES `t_department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '省', '', null);
INSERT INTO `t_department` VALUES ('2', '市', '', '1');
INSERT INTO `t_department` VALUES ('3', '县', '', '2');

-- ----------------------------
-- Table structure for t_forum
-- ----------------------------
DROP TABLE IF EXISTS `t_forum`;
CREATE TABLE `t_forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  `topicCount` int(11) DEFAULT NULL,
  `articleCount` int(11) DEFAULT NULL,
  `lastTopicId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sqasfsa8db8p3e0f5fl9n15h3` (`lastTopicId`),
  CONSTRAINT `FKiutppjtop7uw3eenjvy5w99uw` FOREIGN KEY (`lastTopicId`) REFERENCES `t_topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_forum
-- ----------------------------

-- ----------------------------
-- Table structure for t_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_privilege`;
CREATE TABLE `t_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfbl34byrvoimp5brbgbvpk5bp` (`parentId`),
  CONSTRAINT `FKfbl34byrvoimp5brbgbvpk5bp` FOREIGN KEY (`parentId`) REFERENCES `t_privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_privilege
-- ----------------------------
INSERT INTO `t_privilege` VALUES ('105', '系统管理', null, null);
INSERT INTO `t_privilege` VALUES ('106', '岗位管理', '/role_list', '105');
INSERT INTO `t_privilege` VALUES ('107', '部门管理', '/department_list', '105');
INSERT INTO `t_privilege` VALUES ('108', '用户管理', '/user_list', '105');
INSERT INTO `t_privilege` VALUES ('109', '岗位列表', '/role_list', '106');
INSERT INTO `t_privilege` VALUES ('110', '岗位删除', '/role_delete', '106');
INSERT INTO `t_privilege` VALUES ('111', '岗位添加', '/role_add', '106');
INSERT INTO `t_privilege` VALUES ('112', '岗位修改', '/role_edit', '106');
INSERT INTO `t_privilege` VALUES ('113', '部门列表', '/department_list', '107');
INSERT INTO `t_privilege` VALUES ('114', '部门删除', '/department_delete', '107');
INSERT INTO `t_privilege` VALUES ('115', '部门添加', '/department_add', '107');
INSERT INTO `t_privilege` VALUES ('116', '部门修改', '/department_edit', '107');
INSERT INTO `t_privilege` VALUES ('117', '用户列表', '/user_list', '108');
INSERT INTO `t_privilege` VALUES ('118', '用户删除', '/user_delete', '108');
INSERT INTO `t_privilege` VALUES ('119', '用户添加', '/user_add', '108');
INSERT INTO `t_privilege` VALUES ('120', '用户修改', '/user_edit', '108');
INSERT INTO `t_privilege` VALUES ('121', '初始化密码', '/user_initPassword', '108');
INSERT INTO `t_privilege` VALUES ('122', '网上交流', null, null);
INSERT INTO `t_privilege` VALUES ('123', '论坛管理', '/forumManager_list', '122');
INSERT INTO `t_privilege` VALUES ('124', '论坛', '/forum_list', '122');
INSERT INTO `t_privilege` VALUES ('125', '审批流转', null, null);
INSERT INTO `t_privilege` VALUES ('126', '审批流程管理', '/processDefinition_list', '125');
INSERT INTO `t_privilege` VALUES ('127', '申请模板管理', '/template_list', '125');
INSERT INTO `t_privilege` VALUES ('128', '起草申请', '/flow_templateList', '125');
INSERT INTO `t_privilege` VALUES ('129', '待我审批', '/flow_myTaskList', '125');
INSERT INTO `t_privilege` VALUES ('130', '我的申请查询', '/flow_myApplicationList', '125');

-- ----------------------------
-- Table structure for t_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_reply`;
CREATE TABLE `t_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `postTime` datetime DEFAULT NULL,
  `ipAddr` varchar(255) DEFAULT NULL,
  `authorId` bigint(20) DEFAULT NULL,
  `topicId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK37b9iumamw83guv9njs51073t` (`authorId`),
  KEY `FK2pkpxbfargvdt42812x56p8sh` (`topicId`),
  CONSTRAINT `FK2pkpxbfargvdt42812x56p8sh` FOREIGN KEY (`topicId`) REFERENCES `t_topic` (`id`),
  CONSTRAINT `FK37b9iumamw83guv9njs51073t` FOREIGN KEY (`authorId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_reply
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '省长', '');
INSERT INTO `t_role` VALUES ('2', '市长', '');

-- ----------------------------
-- Table structure for t_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_role_privilege`;
CREATE TABLE `t_role_privilege` (
  `roleId` bigint(20) NOT NULL,
  `privilegeId` bigint(20) NOT NULL,
  PRIMARY KEY (`privilegeId`,`roleId`),
  KEY `FKil6p8g7lxstpuw9rjjvkofst9` (`roleId`),
  CONSTRAINT `FK6afqb0idlldi9mnynsbn7wgjs` FOREIGN KEY (`privilegeId`) REFERENCES `t_privilege` (`id`),
  CONSTRAINT `FKil6p8g7lxstpuw9rjjvkofst9` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_privilege
-- ----------------------------
INSERT INTO `t_role_privilege` VALUES ('1', '125');
INSERT INTO `t_role_privilege` VALUES ('1', '126');
INSERT INTO `t_role_privilege` VALUES ('1', '127');
INSERT INTO `t_role_privilege` VALUES ('1', '128');
INSERT INTO `t_role_privilege` VALUES ('1', '129');
INSERT INTO `t_role_privilege` VALUES ('1', '130');
INSERT INTO `t_role_privilege` VALUES ('2', '105');
INSERT INTO `t_role_privilege` VALUES ('2', '106');
INSERT INTO `t_role_privilege` VALUES ('2', '107');
INSERT INTO `t_role_privilege` VALUES ('2', '108');
INSERT INTO `t_role_privilege` VALUES ('2', '109');
INSERT INTO `t_role_privilege` VALUES ('2', '110');
INSERT INTO `t_role_privilege` VALUES ('2', '111');
INSERT INTO `t_role_privilege` VALUES ('2', '112');
INSERT INTO `t_role_privilege` VALUES ('2', '113');
INSERT INTO `t_role_privilege` VALUES ('2', '114');
INSERT INTO `t_role_privilege` VALUES ('2', '115');
INSERT INTO `t_role_privilege` VALUES ('2', '116');
INSERT INTO `t_role_privilege` VALUES ('2', '117');
INSERT INTO `t_role_privilege` VALUES ('2', '118');
INSERT INTO `t_role_privilege` VALUES ('2', '119');
INSERT INTO `t_role_privilege` VALUES ('2', '120');
INSERT INTO `t_role_privilege` VALUES ('2', '121');
INSERT INTO `t_role_privilege` VALUES ('2', '122');
INSERT INTO `t_role_privilege` VALUES ('2', '123');
INSERT INTO `t_role_privilege` VALUES ('2', '124');
INSERT INTO `t_role_privilege` VALUES ('2', '125');
INSERT INTO `t_role_privilege` VALUES ('2', '126');
INSERT INTO `t_role_privilege` VALUES ('2', '127');
INSERT INTO `t_role_privilege` VALUES ('2', '128');
INSERT INTO `t_role_privilege` VALUES ('2', '129');
INSERT INTO `t_role_privilege` VALUES ('2', '130');

-- ----------------------------
-- Table structure for t_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `postTime` datetime DEFAULT NULL,
  `ipAddr` varchar(255) DEFAULT NULL,
  `authorId` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `replyCount` int(11) DEFAULT NULL,
  `lastUpdateTime` datetime DEFAULT NULL,
  `forumId` bigint(20) DEFAULT NULL,
  `lastReplyId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4yc0copsk181kigbq4x8ro45j` (`lastReplyId`),
  KEY `FKbpua1g4ogstq6gv498jm2jtyr` (`authorId`),
  KEY `FKsqj3md0vsvk2wmpny5kwjljtc` (`forumId`),
  CONSTRAINT `FK5kdu0qf0q4ehqwlr85sst3pky` FOREIGN KEY (`lastReplyId`) REFERENCES `t_reply` (`id`),
  CONSTRAINT `FKbpua1g4ogstq6gv498jm2jtyr` FOREIGN KEY (`authorId`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKsqj3md0vsvk2wmpny5kwjljtc` FOREIGN KEY (`forumId`) REFERENCES `t_forum` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_topic
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `departmentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmfvb2bisqbpb1tpbvxhgt0hb2` (`departmentId`),
  CONSTRAINT `FKmfvb2bisqbpb1tpbvxhgt0hb2` FOREIGN KEY (`departmentId`) REFERENCES `t_department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('8', 'admin', 'admin', '超级管理员', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('9', '1', '1234', '1', '男', '1', '18838988676@163.com', '', '1');
INSERT INTO `t_user` VALUES ('10', '2', '1234', '2', null, '2', '2', '', '2');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`roleId`,`userId`),
  KEY `FK3sap2l8em49wuodlmy5nrc8wq` (`userId`),
  CONSTRAINT `FK3sap2l8em49wuodlmy5nrc8wq` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKaassx26gtc0n2e3xbk2fxn8yq` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('9', '1');
INSERT INTO `t_user_role` VALUES ('10', '2');
