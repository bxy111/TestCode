/*
 Navicat Premium Data Transfer

 Source Server         : MyTest
 Source Server Type    : MySQL
 Source Server Version : 50520
 Source Host           : localhost:3306
 Source Schema         : aowin

 Target Server Type    : MySQL
 Target Server Version : 50520
 File Encoding         : 65001

 Date: 15/01/2019 14:15:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `ID` int(11) NOT NULL,
  `SEX` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `SCORE` double(5, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1001, '女', 60.00);
INSERT INTO `student` VALUES (1002, '女', 59.90);
INSERT INTO `student` VALUES (1003, '女', NULL);
INSERT INTO `student` VALUES (1004, '女', 45.00);
INSERT INTO `student` VALUES (1005, '女', 70.00);
INSERT INTO `student` VALUES (1006, '男', 45.00);

SET FOREIGN_KEY_CHECKS = 1;
