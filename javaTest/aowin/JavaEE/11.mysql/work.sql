/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : se1809

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-10-16 17:18:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `d_no` int(11) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(50) NOT NULL,
  `d_location` varchar(100) NOT NULL,
  PRIMARY KEY (`d_no`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('10', 'ACCOUNTING', 'shanghai');
INSERT INTO `dept` VALUES ('20', 'RESEARCH', 'beijing');
INSERT INTO `dept` VALUES ('30', 'SALELS', 'shenzhen');
INSERT INTO `dept` VALUES ('40', 'OPERATIONS', 'fujian');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `e_no` int(11) NOT NULL AUTO_INCREMENT,
  `e_name` varchar(50) NOT NULL,
  `e_gender` char(2) NOT NULL,
  `dept_no` int(11) DEFAULT NULL,
  `e_job` varchar(50) DEFAULT NULL,
  `e_salary` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  PRIMARY KEY (`e_no`),
  KEY `fk_deptno` (`dept_no`),
  CONSTRAINT `fk_deptno` FOREIGN KEY (`dept_no`) REFERENCES `dept` (`d_no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1001', 'SMITH', 'M', '20', 'CLERK', '800', '2005-11-12');
INSERT INTO `employee` VALUES ('1002', 'ALLEN', 'F', '30', 'SALESMAN', '1600', '2003-05-12');
INSERT INTO `employee` VALUES ('1003', 'WARD', 'F', '30', 'SALESMAN', '1250', '2003-05-12');
INSERT INTO `employee` VALUES ('1004', 'JONES', 'M', '20', 'MANAGER', '2975', '1998-05-18');
INSERT INTO `employee` VALUES ('1005', 'MARTIN', 'M', '30', 'SALESMAN', '1250', '2001-06-12');
INSERT INTO `employee` VALUES ('1006', 'BLAKE', 'F', '30', 'MANAGER', '2850', '1997-02-15');
INSERT INTO `employee` VALUES ('1007', 'CLARK', 'M', '10', 'MANAGER', '2450', '2002-09-12');
INSERT INTO `employee` VALUES ('1008', 'SCOTT', 'M', '20', 'ANALYST', '3000', '2003-05-12');
INSERT INTO `employee` VALUES ('1009', 'KING', 'F', '10', 'PRESIDENT', '5000', '1995-01-01');
INSERT INTO `employee` VALUES ('1010', 'TURNER', 'F', '30', 'SALESMAN', '1500', '1997-10-12');
INSERT INTO `employee` VALUES ('1011', 'ADAMS', 'M', '20', 'CLERK', '1100', '1999-10-05');
INSERT INTO `employee` VALUES ('1012', 'JAMES', 'F', '30', 'CLERK', '950', '2008-06-15');
