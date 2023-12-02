/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云数据库
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : rm-m5e3u8r97i93wh3r5lo.mysql.rds.aliyuncs.com:3306
 Source Schema         : staff-manager

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 03/12/2023 01:19:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for staff_info
-- ----------------------------
DROP TABLE IF EXISTS `staff_info`;
CREATE TABLE `staff_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(3) NULL DEFAULT NULL COMMENT '年龄',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `emp_degree_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff_info
-- ----------------------------
INSERT INTO `staff_info` VALUES (5, 'weqeqwe', '男', 29, '后勤部', '大专');
INSERT INTO `staff_info` VALUES (6, NULL, '女', 29, '后勤部', '本科');
INSERT INTO `staff_info` VALUES (7, NULL, '男', 33, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (8, NULL, '男', 32, '业务部', '本科');
INSERT INTO `staff_info` VALUES (9, NULL, '女', 33, '业务部', '大专');
INSERT INTO `staff_info` VALUES (10, NULL, '女', 45, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (11, NULL, '女', 19, '人事部', '本科');
INSERT INTO `staff_info` VALUES (12, NULL, '男', 28, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (13, NULL, '女', 46, '后勤部', '研究生');
INSERT INTO `staff_info` VALUES (14, NULL, '男', 58, '业务部', '大专');
INSERT INTO `staff_info` VALUES (15, NULL, '女', 22, '人事部', '研究生');
INSERT INTO `staff_info` VALUES (16, NULL, '男', 26, '后勤部', '大专');
INSERT INTO `staff_info` VALUES (17, NULL, '男', 25, '人事部', '研究生');
INSERT INTO `staff_info` VALUES (18, NULL, '女', 29, '后勤部', '研究生');
INSERT INTO `staff_info` VALUES (19, NULL, '男', 45, '后勤部', '本科');
INSERT INTO `staff_info` VALUES (20, NULL, '女', 21, '业务部', '本科');
INSERT INTO `staff_info` VALUES (21, NULL, '男', 21, '业务部', '大专');
INSERT INTO `staff_info` VALUES (22, NULL, '男', 23, '业务部', '大专');
INSERT INTO `staff_info` VALUES (23, NULL, '女', 33, '业务部', '大专');
INSERT INTO `staff_info` VALUES (24, NULL, '男', 45, '人事部', '本科');
INSERT INTO `staff_info` VALUES (25, NULL, '男', 35, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (26, NULL, '男', 41, '后勤部', '本科');
INSERT INTO `staff_info` VALUES (27, NULL, '女', 25, '业务部', '大专');
INSERT INTO `staff_info` VALUES (28, NULL, '男', 26, '人事部', '研究生');
INSERT INTO `staff_info` VALUES (29, NULL, '男', 20, '后勤部', '本科');
INSERT INTO `staff_info` VALUES (30, NULL, '女', 21, '人事部', '研究生');
INSERT INTO `staff_info` VALUES (31, NULL, '男', 19, '后勤部', '研究生');
INSERT INTO `staff_info` VALUES (32, NULL, '女', 35, '后勤部', '大专');
INSERT INTO `staff_info` VALUES (33, NULL, '男', 24, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (34, NULL, '男', 29, '业务部', '大专');
INSERT INTO `staff_info` VALUES (35, NULL, '女', 33, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (36, NULL, '男', 45, '业务部', '本科');
INSERT INTO `staff_info` VALUES (37, '张一', '男', 25, '业务部', '本科');
INSERT INTO `staff_info` VALUES (38, '张二', '女', 26, '人事部', '本科');
INSERT INTO `staff_info` VALUES (39, '张三', '男', 27, '后勤部', '大专');
INSERT INTO `staff_info` VALUES (40, '张四', '女', 28, '人事部', '大专');
INSERT INTO `staff_info` VALUES (41, '张五', '男', 29, '后勤部', '大专');
INSERT INTO `staff_info` VALUES (42, '张六', '女', 29, '后勤部', '本科');
INSERT INTO `staff_info` VALUES (43, '张七', '男', 33, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (44, '张八', '男', 32, '业务部', '本科');
INSERT INTO `staff_info` VALUES (45, '张九', '女', 33, '业务部', '大专');
INSERT INTO `staff_info` VALUES (46, '李一', '女', 45, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (47, '李二', '女', 19, '人事部', '本科');
INSERT INTO `staff_info` VALUES (48, '李三', '男', 28, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (49, '李四', '女', 46, '后勤部', '研究生');
INSERT INTO `staff_info` VALUES (50, '李五', '男', 58, '业务部', '大专');
INSERT INTO `staff_info` VALUES (51, '李六', '女', 22, '人事部', '研究生');
INSERT INTO `staff_info` VALUES (52, '李七', '男', 26, '后勤部', '大专');
INSERT INTO `staff_info` VALUES (53, '李八', '男', 25, '人事部', '研究生');
INSERT INTO `staff_info` VALUES (54, '李九', '女', 29, '后勤部', '研究生');
INSERT INTO `staff_info` VALUES (55, '王一', '男', 45, '后勤部', '本科');
INSERT INTO `staff_info` VALUES (56, '王二', '女', 21, '业务部', '本科');
INSERT INTO `staff_info` VALUES (57, '王三', '男', 21, '业务部', '大专');
INSERT INTO `staff_info` VALUES (58, '王四', '男', 23, '业务部', '大专');
INSERT INTO `staff_info` VALUES (59, '王五', '女', 33, '业务部', '大专');
INSERT INTO `staff_info` VALUES (60, '王六', '男', 45, '人事部', '本科');
INSERT INTO `staff_info` VALUES (61, '王七', '男', 35, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (62, '王八', '男', 41, '后勤部', '本科');
INSERT INTO `staff_info` VALUES (63, '王九', '女', 25, '业务部', '大专');
INSERT INTO `staff_info` VALUES (64, '赵一', '男', 26, '人事部', '研究生');
INSERT INTO `staff_info` VALUES (65, '赵二', '男', 20, '后勤部', '本科');
INSERT INTO `staff_info` VALUES (66, '赵三', '女', 21, '人事部', '研究生');
INSERT INTO `staff_info` VALUES (67, '赵四', '男', 19, '后勤部', '研究生');
INSERT INTO `staff_info` VALUES (68, '赵五', '女', 35, '后勤部', '大专');
INSERT INTO `staff_info` VALUES (69, '赵六', '男', 24, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (70, '赵七', '男', 29, '业务部', '大专');
INSERT INTO `staff_info` VALUES (71, '赵八', '女', 33, '业务部', '研究生');
INSERT INTO `staff_info` VALUES (72, '赵九', '男', 45, '业务部', '本科');
INSERT INTO `staff_info` VALUES (73, 'wqewqew', '1', 12, '业务部', '研究生');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号名称',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$vTDkQ2TIckPPpS08IzrmZOgrh2WScEs8QFv5wSzPV5U4o2LQXqbnq', '管理员');

SET FOREIGN_KEY_CHECKS = 1;
