/*
Navicat MySQL Data Transfer

Source Server         : zyy
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : qau

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-08-06 14:20:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(20) DEFAULT NULL,
  `stu_name` varchar(10) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `clzss` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('23', '023', '赵雯雯', '18', '男', '软件三班');
INSERT INTO `t_student` VALUES ('38', '032', '张艳艳', '22', '女', '质保一班');
INSERT INTO `t_student` VALUES ('3', '003', '张武', '22', '男', '软件一班');
INSERT INTO `t_student` VALUES ('25', '006', '赵云', '18', '男', '物联三班');
INSERT INTO `t_student` VALUES ('26', '007', '王现涛', '18', '男', '云计算二班');
INSERT INTO `t_student` VALUES ('39', '022', ' 王文涛', '12', '男', '大数据三班');

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(30) DEFAULT NULL,
  `salary` varchar(30) DEFAULT NULL,
  `clzss` varchar(30) DEFAULT NULL,
  `institusion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('6', '张艳艳', '11111', '海洋', '园艺学院');
INSERT INTO `t_teacher` VALUES ('22', '赵云', '666666', '云计算', ' 理学与信息科学学院');
INSERT INTO `t_teacher` VALUES ('27', '钱王生', '666666', '软件三班', '理学与信息科学学院');
INSERT INTO `t_teacher` VALUES ('34', '王现涛', '99999', '软件二班', '理学与信息科学学院');
INSERT INTO `t_teacher` VALUES ('35', ' 王文文', '6666666', '质保一班', '理学与信息科学学院');
