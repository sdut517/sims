/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : sims

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 12/01/2022 12:49:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_ha
-- ----------------------------
DROP TABLE IF EXISTS `t_ha`;
CREATE TABLE `t_ha`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT NULL,
  `url` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_ha
-- ----------------------------
INSERT INTO `t_ha` VALUES ('8F237513925D4FD6A01F4A1EDFE370DB', 'Redmi小爱音箱', '20', '5ACDA5E8E43A49EBA6172E8393FFA22A', 0, '/static/image/f719adf6-d525-4b0e-93a3-b8472f699689.jpg');
INSERT INTO `t_ha` VALUES ('CEED1D9FBE834778A35848BAA496B49D', '格力空调', '6', 'F0B3C7B9361C45F6A4841A8A4AB76622', 0, '/static/image/666fde14-40ba-47d2-bcab-8eb48121ad33.jpeg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `supplier_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuff_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT NULL,
  `is_delete` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('A275144C37634B948CBF36A77FE00099', '购买格力空调', 'F0B3C7B9361C45F6A4841A8A4AB76622', 'A9C3BE1C59194DCD927176D883A0AE1D', 'CEED1D9FBE834778A35848BAA496B49D', '10', '2021-06-22 20:04:39', '30000', '418907585224BA0AC8F5971C3D5E1B1', 1, 0);
INSERT INTO `t_order` VALUES ('BB5476B67A7446A1B2673010404054EF', '卖出5台格力空调', 'F0B3C7B9361C45F6A4841A8A4AB76622', '75480BCE18E840A49910C99E4D3B2B70', 'CEED1D9FBE834778A35848BAA496B49D', '5', '2021-06-22 20:21:11', '20000', '418907585224BA0AC8F5971C3D5E1B1', 2, 0);
INSERT INTO `t_order` VALUES ('FFF7B99CC1754203AA122C763DE75FDC', '购买小爱音箱', '5ACDA5E8E43A49EBA6172E8393FFA22A', '960041F9A76B4935BC45DF2DD1FC67BF', '8F237513925D4FD6A01F4A1EDFE370DB', '10', '2021-06-22 19:49:32', '900', '418907585224BA0AC8F5971C3D5E1B1', 1, 0);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员', 0);
INSERT INTO `t_role` VALUES (2, '库存管理人员', 0);
INSERT INTO `t_role` VALUES (3, '业务人员', 0);

-- ----------------------------
-- Table structure for t_supplier
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier`;
CREATE TABLE `t_supplier`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_supplier
-- ----------------------------
INSERT INTO `t_supplier` VALUES ('75480BCE18E840A49910C99E4D3B2B70', '国美电器', '山东省淄博市 山东理工大学', '19865475214', 0);
INSERT INTO `t_supplier` VALUES ('960041F9A76B4935BC45DF2DD1FC67BF', '小米电视供货商', '山东省济南市槐荫区经十路22799号', '15512451245', 0);
INSERT INTO `t_supplier` VALUES ('A9C3BE1C59194DCD927176D883A0AE1D', '格力电器供应商', '北京市北京市东城区安定路20号6号楼（安贞桥北200米）', '15848464864', 0);

-- ----------------------------
-- Table structure for t_supplier_type
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier_type`;
CREATE TABLE `t_supplier_type`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `supplier_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_supplier_type
-- ----------------------------
INSERT INTO `t_supplier_type` VALUES ('032B71CAAD084EE695348381D969983C', '75480BCE18E840A49910C99E4D3B2B70', 'D962936CAF344E23977E9AFF1665DF72');
INSERT INTO `t_supplier_type` VALUES ('1BE5FFBC295C490C9C282C67C776B9C2', 'A9C3BE1C59194DCD927176D883A0AE1D', 'D962936CAF344E23977E9AFF1665DF72');
INSERT INTO `t_supplier_type` VALUES ('1E8BEAC22B544BE2A1BC693B834EA539', '75480BCE18E840A49910C99E4D3B2B70', 'B5DCA7D44FAD44A89DD1A37D7A4BB3E9');
INSERT INTO `t_supplier_type` VALUES ('31DEA411842D4367A1E42798C417BF86', '75480BCE18E840A49910C99E4D3B2B70', 'BEE3CA110E5A48D7A4A3959D8971EAE2');
INSERT INTO `t_supplier_type` VALUES ('4F74DE3FAC1E4D28ADAC542CB9564CE3', '75480BCE18E840A49910C99E4D3B2B70', 'F0B3C7B9361C45F6A4841A8A4AB76622');
INSERT INTO `t_supplier_type` VALUES ('659EF6E322474518A0EE4E20D0B3CA58', 'A9C3BE1C59194DCD927176D883A0AE1D', 'B5DCA7D44FAD44A89DD1A37D7A4BB3E9');
INSERT INTO `t_supplier_type` VALUES ('6F9A6BEFCCEB46258BE2D36AEA48E5A6', '75480BCE18E840A49910C99E4D3B2B70', '5ACDA5E8E43A49EBA6172E8393FFA22A');
INSERT INTO `t_supplier_type` VALUES ('89705BD02DF14996B0BF574FBFA14C29', '75480BCE18E840A49910C99E4D3B2B70', '9BD59BE1B9D449C598D23EC8F8FF6833');
INSERT INTO `t_supplier_type` VALUES ('C9EAC10527E245BBBFDBCD2CB4C7FC95', 'A9C3BE1C59194DCD927176D883A0AE1D', 'F0B3C7B9361C45F6A4841A8A4AB76622');
INSERT INTO `t_supplier_type` VALUES ('D51132512BFF456389DAAE09D455F3D4', '960041F9A76B4935BC45DF2DD1FC67BF', '5ACDA5E8E43A49EBA6172E8393FFA22A');
INSERT INTO `t_supplier_type` VALUES ('FFD43B49DAAD49E48D5E224747D2E147', '960041F9A76B4935BC45DF2DD1FC67BF', '9BD59BE1B9D449C598D23EC8F8FF6833');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_level` int(2) NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES ('5ACDA5E8E43A49EBA6172E8393FFA22A', '智能音箱', NULL, NULL, 0);
INSERT INTO `t_type` VALUES ('9BD59BE1B9D449C598D23EC8F8FF6833', '电视机', '', NULL, 0);
INSERT INTO `t_type` VALUES ('B5DCA7D44FAD44A89DD1A37D7A4BB3E9', '洗衣机', NULL, NULL, 0);
INSERT INTO `t_type` VALUES ('BEE3CA110E5A48D7A4A3959D8971EAE2', '电磁炉', NULL, NULL, 0);
INSERT INTO `t_type` VALUES ('D962936CAF344E23977E9AFF1665DF72', '冰箱', NULL, NULL, 0);
INSERT INTO `t_type` VALUES ('F0B3C7B9361C45F6A4841A8A4AB76622', '空调', NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roleid` int(2) NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('3BF40E90F29843048B6A0ACA074C0E35', '业务员', '19862516278', '123456', 3, 0);
INSERT INTO `t_user` VALUES ('418907585224BA0AC8F5971C3D5E1B1', '管理员', '18812345678', '123456', 1, 0);
INSERT INTO `t_user` VALUES ('9BF7AB533398416890C6B977D6A3EDD0', '仓库管理员', '18812345679', '123456', 2, 0);

SET FOREIGN_KEY_CHECKS = 1;
