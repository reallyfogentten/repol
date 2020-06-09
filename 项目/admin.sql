/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50623
 Source Host           : localhost:3306
 Source Schema         : codingcrm

 Target Server Type    : MySQL
 Target Server Version : 50623
 File Encoding         : 65001

 Date: 11/04/2020 17:14:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminPwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminRealName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminSex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminAge` int(10) NULL DEFAULT NULL,
  `adminBirthday` date NULL DEFAULT NULL,
  `adminAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminHead` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminType` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `admin` VALUES (2, 'jerry', '52934A72C3DB5E020D68E50A531C405E', 'j杰瑞', '男', 24, '1997-04-15', '安徽省合肥市蜀山区望江西路与浮山路交叉口南400米国科军通12栋一楼', '13838384388', '73964e6933b3450f8c1202d508fe851b.jpg', 3);
INSERT INTO `admin` VALUES (3, 'xh', 'E10ADC3949BA59ABBE56E057F20F883E', '张小红', '女', 23, '1998-07-15', '安徽省合肥市高薪取', '14848484488', '2f0d5bd6c95b42edb86b8b8f5db10529.jpg', 2);

SET FOREIGN_KEY_CHECKS = 1;
