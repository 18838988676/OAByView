/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : system_oa

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-08-25 00:39:38
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '111', '11111', null);
INSERT INTO `t_department` VALUES ('2', '77', '77', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_privilege
-- ----------------------------
INSERT INTO `t_privilege` VALUES ('1', '系统管理', null, null);
INSERT INTO `t_privilege` VALUES ('2', '岗位管理', '/role_list', '1');
INSERT INTO `t_privilege` VALUES ('3', '部门管理', '/department_list', '1');
INSERT INTO `t_privilege` VALUES ('4', '用户管理', '/user_list', '1');
INSERT INTO `t_privilege` VALUES ('5', '岗位列表', '/role_list', '2');
INSERT INTO `t_privilege` VALUES ('6', '岗位删除', '/role_delete', '2');
INSERT INTO `t_privilege` VALUES ('7', '岗位添加', '/role_add', '2');
INSERT INTO `t_privilege` VALUES ('8', '岗位修改', '/role_edit', '2');
INSERT INTO `t_privilege` VALUES ('9', '部门列表', '/department_list', '3');
INSERT INTO `t_privilege` VALUES ('10', '部门删除', '/department_delete', '3');
INSERT INTO `t_privilege` VALUES ('11', '部门添加', '/department_add', '3');
INSERT INTO `t_privilege` VALUES ('12', '部门修改', '/department_edit', '3');
INSERT INTO `t_privilege` VALUES ('13', '用户列表', '/user_list', '4');
INSERT INTO `t_privilege` VALUES ('14', '用户删除', '/user_delete', '4');
INSERT INTO `t_privilege` VALUES ('15', '用户添加', '/user_add', '4');
INSERT INTO `t_privilege` VALUES ('16', '用户修改', '/user_edit', '4');
INSERT INTO `t_privilege` VALUES ('17', '初始化密码', '/user_initPassword', '4');
INSERT INTO `t_privilege` VALUES ('18', '网上交流', null, null);
INSERT INTO `t_privilege` VALUES ('19', '论坛管理', '/forumManager_list', '18');
INSERT INTO `t_privilege` VALUES ('20', '论坛', '/forum_list', '18');
INSERT INTO `t_privilege` VALUES ('21', '审批流转', null, null);
INSERT INTO `t_privilege` VALUES ('22', '审批流程管理', '/processDefinition_list', '21');
INSERT INTO `t_privilege` VALUES ('23', '申请模板管理', '/template_list', '21');
INSERT INTO `t_privilege` VALUES ('24', '起草申请', '/flow_templateList', '21');
INSERT INTO `t_privilege` VALUES ('25', '待我审批', '/flow_myTaskList', '21');
INSERT INTO `t_privilege` VALUES ('26', '我的申请查询', '/flow_myApplicationList', '21');

-- ----------------------------
-- Table structure for t_privilege_copy
-- ----------------------------
DROP TABLE IF EXISTS `t_privilege_copy`;
CREATE TABLE `t_privilege_copy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfbl34byrvoimp5brbgbvpk5bp` (`parentId`),
  CONSTRAINT `t_privilege_copy_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `t_privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_privilege_copy
-- ----------------------------
INSERT INTO `t_privilege_copy` VALUES ('1', '系统管理', null, null);
INSERT INTO `t_privilege_copy` VALUES ('2', '岗位管理', '/role_list', '1');
INSERT INTO `t_privilege_copy` VALUES ('3', '部门管理', '/department_list', '1');
INSERT INTO `t_privilege_copy` VALUES ('4', '用户管理', '/user_list', '1');
INSERT INTO `t_privilege_copy` VALUES ('5', '岗位列表', '/role_list', '2');
INSERT INTO `t_privilege_copy` VALUES ('6', '岗位删除', '/role_delete', '2');
INSERT INTO `t_privilege_copy` VALUES ('7', '岗位添加', '/role_add', '2');
INSERT INTO `t_privilege_copy` VALUES ('8', '岗位修改', '/role_edit', '2');
INSERT INTO `t_privilege_copy` VALUES ('9', '部门列表', '/department_list', '3');
INSERT INTO `t_privilege_copy` VALUES ('10', '部门删除', '/department_delete', '3');
INSERT INTO `t_privilege_copy` VALUES ('11', '部门添加', '/department_add', '3');
INSERT INTO `t_privilege_copy` VALUES ('12', '部门修改', '/department_edit', '3');
INSERT INTO `t_privilege_copy` VALUES ('13', '用户列表', '/user_list', '4');
INSERT INTO `t_privilege_copy` VALUES ('14', '用户删除', '/user_delete', '4');
INSERT INTO `t_privilege_copy` VALUES ('15', '用户添加', '/user_add', '4');
INSERT INTO `t_privilege_copy` VALUES ('16', '用户修改', '/user_edit', '4');
INSERT INTO `t_privilege_copy` VALUES ('17', '初始化密码', '/user_initPassword', '4');
INSERT INTO `t_privilege_copy` VALUES ('18', '网上交流', null, null);
INSERT INTO `t_privilege_copy` VALUES ('19', '论坛管理', '/forumManager_list', '18');
INSERT INTO `t_privilege_copy` VALUES ('20', '论坛', '/forum_list', '18');
INSERT INTO `t_privilege_copy` VALUES ('21', '审批流转', null, null);
INSERT INTO `t_privilege_copy` VALUES ('22', '审批流程管理', '/processDefinition_list', '21');
INSERT INTO `t_privilege_copy` VALUES ('23', '申请模板管理', '/template_list', '21');
INSERT INTO `t_privilege_copy` VALUES ('24', '起草申请', '/flow_templateList', '21');
INSERT INTO `t_privilege_copy` VALUES ('25', '待我审批', '/flow_myTaskList', '21');
INSERT INTO `t_privilege_copy` VALUES ('26', '我的申请查询', '/flow_myApplicationList', '21');

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
INSERT INTO `t_role` VALUES ('1', '1', '1');
INSERT INTO `t_role` VALUES ('2', '2', '2');

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
INSERT INTO `t_role_privilege` VALUES ('1', '1');
INSERT INTO `t_role_privilege` VALUES ('1', '2');
INSERT INTO `t_role_privilege` VALUES ('1', '3');
INSERT INTO `t_role_privilege` VALUES ('1', '4');
INSERT INTO `t_role_privilege` VALUES ('1', '5');
INSERT INTO `t_role_privilege` VALUES ('1', '6');
INSERT INTO `t_role_privilege` VALUES ('1', '7');
INSERT INTO `t_role_privilege` VALUES ('1', '8');
INSERT INTO `t_role_privilege` VALUES ('1', '9');
INSERT INTO `t_role_privilege` VALUES ('1', '10');
INSERT INTO `t_role_privilege` VALUES ('1', '11');
INSERT INTO `t_role_privilege` VALUES ('1', '12');
INSERT INTO `t_role_privilege` VALUES ('1', '13');
INSERT INTO `t_role_privilege` VALUES ('1', '14');
INSERT INTO `t_role_privilege` VALUES ('1', '15');
INSERT INTO `t_role_privilege` VALUES ('1', '16');
INSERT INTO `t_role_privilege` VALUES ('1', '17');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '超级管理员', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('2', '1', '1', '1', '男', '1', '1', '1', '1');
INSERT INTO `t_user` VALUES ('3', '', null, '', null, '', '', '', '1');
INSERT INTO `t_user` VALUES ('4', '', null, '', null, '', '', '', '1');

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
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('4', '1');
INSERT INTO `t_user_role` VALUES ('4', '2');
