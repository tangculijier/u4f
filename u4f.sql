/*
Navicat MySQL Data Transfer

Source Server         : huang
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2016-02-28 21:19:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bestsiteforphoto`
-- ----------------------------
DROP TABLE IF EXISTS `bestsiteforphoto`;
CREATE TABLE `bestsiteforphoto` (
  `bestId` int(10) NOT NULL,
  `placeName` varchar(30) NOT NULL,
  `blongitude` double(10,0) NOT NULL,
  `blatitude` double(10,0) NOT NULL,
  PRIMARY KEY  (`bestId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bestsiteforphoto
-- ----------------------------

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityId` int(11) NOT NULL auto_increment,
  `cityName` varchar(30) NOT NULL,
  PRIMARY KEY  (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '西安');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int(10) NOT NULL auto_increment,
  `content` varchar(1000) NOT NULL,
  `commTypeId` int(2) NOT NULL,
  `userId` int(10) NOT NULL,
  `clongitude` double(10,0) NOT NULL,
  `clatitude` double(10,0) NOT NULL,
  PRIMARY KEY  (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `commmenttype`
-- ----------------------------
DROP TABLE IF EXISTS `commmenttype`;
CREATE TABLE `commmenttype` (
  `commTypeId` int(2) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commmenttype
-- ----------------------------

-- ----------------------------
-- Table structure for `facility`
-- ----------------------------
DROP TABLE IF EXISTS `facility`;
CREATE TABLE `facility` (
  `facilityId` int(10) NOT NULL auto_increment,
  `facilityLng` varchar(50) NOT NULL,
  `facilityLati` varchar(50) NOT NULL,
  `parkId` int(10) NOT NULL,
  `facilityType` int(10) NOT NULL,
  `facilityName` varchar(100) default NULL,
  PRIMARY KEY  (`facilityId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of facility
-- ----------------------------
INSERT INTO `facility` VALUES ('1', '108.98773', '34.262299', '11', '1', '厕所');
INSERT INTO `facility` VALUES ('2', '108.99197', '34.263015', '11', '1', '厕所');
INSERT INTO `facility` VALUES ('3', '108.992904', '34.261315', '11', '1', '厕所');
INSERT INTO `facility` VALUES ('4', '108.987586', '34.258898', '11', '2', '翠华餐厅');
INSERT INTO `facility` VALUES ('5', '108.992832', '34.259614', '11', '2', '张三饭馆');
INSERT INTO `facility` VALUES ('6', '108.991395', '34.258003', '11', '3', '李四商店');

-- ----------------------------
-- Table structure for `park`
-- ----------------------------
DROP TABLE IF EXISTS `park`;
CREATE TABLE `park` (
  `parkId` int(10) NOT NULL auto_increment,
  `parkName` varchar(100) NOT NULL,
  `belongCityId` int(11) default NULL,
  `parkAddress` varchar(300) default NULL,
  `parkTicket` varchar(300) default NULL,
  `parkTrans` varchar(300) default NULL,
  `parkLat` varchar(50) default NULL,
  `parkLng` varchar(50) default NULL,
  `parkIntroduction` varchar(500) default NULL,
  `parkOpenTime` varchar(200) default NULL,
  `parkPicture` varchar(200) default NULL,
  PRIMARY KEY  (`parkId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of park
-- ----------------------------
INSERT INTO `park` VALUES ('1', '深圳欢乐谷', '1', '华侨城杜鹃山', '全票：200元，夜场票：60元', '1、乘坐深圳地铁1、2号线在世界之窗站下车，步行3分钟即至欢乐谷；\r\n2、罗湖火车站乘坐观光巴士直达欢乐谷；\r\n3.市内乘坐20，21，26，32，42，43，54，59，66，70，72，78路等公交车车至世界之窗站下车', '22.545734', '113.987004', '欢乐谷', '公园开放时间：9:30-21:00，\r\n夜场开放时间：18:00-21:00', 'images/shenzhenhlg.png');
INSERT INTO `park` VALUES ('2', '深圳世界之窗', '1', '南山区深南大道9037号(欧陆风情街)	', '160元', '地铁1、2号线至世界之窗下车；\r\n市内乘坐204,M388、222、223、230、232、234、245、M413、323、324、327、329,369路等公交车至世界之窗站下车', '22.542287', '113.980444', '园林艺术', '9:00-22:30 ', 'images/shenzhensjzc.png');
INSERT INTO `park` VALUES ('3', '香港迪士尼', '2', '香港新界荃湾区大屿山东北部之竹篙湾', '一日门票：成人（12-64岁）：499港币；小童门票（3-11岁）：355港币；长者门票（65岁或以上）：100港币；普通日门票适用于有效期内的所有日期，特选日除外。\r\n两日门票：成人（12-64岁）：680港币；小童门票（3-11岁）：480港币；长者门票（65岁或以上）：170港币（适用于七日内任意两日）', '可乘搭\'A\'或\'E\'线路线至青屿干线缴费广场转乘R8线巴士，R8线巴士日间定期开往香港迪士尼乐园。', '22.318356', '114.056704', '迪士尼', '10：00-20：00', 'images/xianggangdsn.png');
INSERT INTO `park` VALUES ('4', '北京水魔方', '4', '北京市丰台区小屯路', '230元 网购215元', '地铁：地铁1号线, 在 玉泉路站 下车(D2口出),120米步行至玉泉路口南站乘坐338/507路, 在梅市口站下车\r\n\r\n自驾：西四环莲石路向西，玉泉路出口，左转向南沿小屯路500米即到.\r\n\r\n公交车：338/507路, 在梅市口站下车', '39.888184', '116.255402', '北京欢乐水魔方嬉水乐园位于北京市丰台区小屯路。占地500亩，总投资10亿元人民币。最大游客接待量3万人，是目前全球规模最大、游乐设施最先进、设备数量最多的顶级水上主题公园。 乐园由国际顶尖的主题景区设计公司精心规划，将中国传统建筑风情与高科技水上游乐项目相融合，将美国式的现代惊险水上娱乐与欧洲的古典健康的水疗理念相结合，建成首个中国人自己的水上乐园。 全球最大的万人海啸造浪池、惊险的龙卷风滑道、刺激的尖峰极速滑道、亚洲最大的黑暗漩涡等项目、形成最富有激情、最充满动感的巨型水上狂欢乐园。', '10:00—19:00。', 'images/beijingsmf.png');
INSERT INTO `park` VALUES ('13', '成都欢乐谷', '3', '成都市金牛区北三环一段与交大路交界', '全票190元/人，中小学生140元/人，大学生160元/人，1.2-1.5米儿童120元/人，夜场票70元/人。', '成都欢乐谷位于成都市北三环交大立交，金牛区西华大道16号，距天府广场6.6公里，至成都市中心商务区车行二十余分钟，至成绵、成渝高速入口车行时间分别为15和20分钟。', '30.72728', '104.041179', '', '9:00—21:00 夜场18:00—21:00', 'images/chengdu.png');

-- ----------------------------
-- Table structure for `path`
-- ----------------------------
DROP TABLE IF EXISTS `path`;
CREATE TABLE `path` (
  `pathId` int(11) NOT NULL,
  `pathFrom` int(11) default NULL,
  `pathTo` int(11) default NULL,
  `parkId` int(11) default NULL,
  PRIMARY KEY  (`pathId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of path
-- ----------------------------
INSERT INTO `path` VALUES ('-2', '1', '2', '13');
INSERT INTO `path` VALUES ('-1', '1', '3', '13');
INSERT INTO `path` VALUES ('0', '1', '23', '13');
INSERT INTO `path` VALUES ('1', '1', '24', '13');
INSERT INTO `path` VALUES ('2', '1', '2', '13');
INSERT INTO `path` VALUES ('3', '1', '3', '13');
INSERT INTO `path` VALUES ('4', '1', '4', '13');
INSERT INTO `path` VALUES ('5', '2', '3', '13');
INSERT INTO `path` VALUES ('6', '2', '4', '13');
INSERT INTO `path` VALUES ('7', '3', '4', '13');
INSERT INTO `path` VALUES ('8', '3', '5', '13');
INSERT INTO `path` VALUES ('9', '3', '6', '13');
INSERT INTO `path` VALUES ('10', '5', '6', '13');
INSERT INTO `path` VALUES ('11', '5', '7', '13');
INSERT INTO `path` VALUES ('12', '6', '7', '13');
INSERT INTO `path` VALUES ('13', '6', '8', '13');
INSERT INTO `path` VALUES ('14', '6', '11', '13');
INSERT INTO `path` VALUES ('15', '8', '9', '13');
INSERT INTO `path` VALUES ('16', '8', '11', '13');
INSERT INTO `path` VALUES ('17', '9', '10', '13');
INSERT INTO `path` VALUES ('18', '9', '11', '13');
INSERT INTO `path` VALUES ('19', '10', '11', '13');
INSERT INTO `path` VALUES ('20', '11', '12', '13');
INSERT INTO `path` VALUES ('21', '12', '13', null);
INSERT INTO `path` VALUES ('22', '12', '14', null);
INSERT INTO `path` VALUES ('23', '13', '14', null);
INSERT INTO `path` VALUES ('24', '13', '6', null);
INSERT INTO `path` VALUES ('25', '12', '15', '13');
INSERT INTO `path` VALUES ('26', '15', '16', '13');
INSERT INTO `path` VALUES ('27', '15', '17', '13');
INSERT INTO `path` VALUES ('28', '15', '18', '13');
INSERT INTO `path` VALUES ('29', '16', '17', '13');
INSERT INTO `path` VALUES ('30', '16', '21', '13');
INSERT INTO `path` VALUES ('31', '16', '22', '13');
INSERT INTO `path` VALUES ('32', '16', '23', '13');
INSERT INTO `path` VALUES ('33', '16', '24', '13');
INSERT INTO `path` VALUES ('34', '17', '18', '13');
INSERT INTO `path` VALUES ('35', '17', '21', '13');
INSERT INTO `path` VALUES ('36', '18', '19', '13');
INSERT INTO `path` VALUES ('37', '19', '20', '13');
INSERT INTO `path` VALUES ('38', '20', '21', '13');
INSERT INTO `path` VALUES ('39', '20', '22', '13');
INSERT INTO `path` VALUES ('40', '21', '22', '13');
INSERT INTO `path` VALUES ('41', '21', '23', '13');
INSERT INTO `path` VALUES ('42', '22', '23', '13');
INSERT INTO `path` VALUES ('43', '23', '24', '13');

-- ----------------------------
-- Table structure for `path_copy`
-- ----------------------------
DROP TABLE IF EXISTS `path_copy`;
CREATE TABLE `path_copy` (
  `pathId` int(11) NOT NULL,
  `pathFrom` int(11) default NULL,
  `pathTo` int(11) default NULL,
  `parkId` int(11) default NULL,
  PRIMARY KEY  (`pathId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of path_copy
-- ----------------------------
INSERT INTO `path_copy` VALUES ('1', '1', '2', '13');
INSERT INTO `path_copy` VALUES ('2', '1', '3', '13');
INSERT INTO `path_copy` VALUES ('3', '1', '4', '13');
INSERT INTO `path_copy` VALUES ('4', '1', '5', '13');
INSERT INTO `path_copy` VALUES ('5', '2', '3', '13');
INSERT INTO `path_copy` VALUES ('6', '2', '4', '13');
INSERT INTO `path_copy` VALUES ('7', '3', '4', '13');
INSERT INTO `path_copy` VALUES ('8', '3', '5', '13');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `projectId` int(10) NOT NULL,
  `parkId` int(10) default NULL,
  `projectCode` varchar(20) default NULL,
  `projectName` varchar(100) default NULL,
  `projectTime` double(20,1) default NULL,
  `projectLng` varchar(20) default NULL,
  `projectLati` varchar(20) default NULL,
  `projectType` varchar(10) default NULL,
  `projectPop` int(30) default NULL,
  `projectDescribe` varchar(300) default NULL,
  PRIMARY KEY  (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '13', '0', '入口', '0.0', null, null, '0/1/2', '0', null);
INSERT INTO `project` VALUES ('2', '13', 'A1', '旋转飞椅', '0.3', '1', '1', '1/2', '21318', null);
INSERT INTO `project` VALUES ('3', '13', 'A2', '旋转木马', '0.3', '1', '1', '1/2', '6491', null);
INSERT INTO `project` VALUES ('4', '13', 'A3', '水上摩天轮', '0.5', null, null, '2', '7780', null);
INSERT INTO `project` VALUES ('5', '13', 'A4', '碰碰车', '0.3', null, null, '0/2', '11462', null);
INSERT INTO `project` VALUES ('6', '13', 'A5', '天地双雄', '0.6', null, null, '0', '18181', null);
INSERT INTO `project` VALUES ('7', '13', 'A6', '大摆锤', '0.3', null, null, '0', '3090', null);
INSERT INTO `project` VALUES ('8', '13', 'A7', '精灵幽魂', '0.1', null, null, '2', '915', null);
INSERT INTO `project` VALUES ('9', '13', 'A8', '能量风暴', '0.3', null, null, '0/2', '1021', null);
INSERT INTO `project` VALUES ('10', '13', 'B1', '加勒比风暴', '1.5', null, null, '0/2', '10123', null);
INSERT INTO `project` VALUES ('11', '13', 'B2', '天地旋转', '0.4', null, null, '0/2', '1317', null);
INSERT INTO `project` VALUES ('12', '13', 'B3', '加勒比水公园', '0.5', null, null, '2', '1794', null);
INSERT INTO `project` VALUES ('13', '13', 'C1', '雪域飞龙', '1.5', null, null, '0', '44538', null);
INSERT INTO `project` VALUES ('14', '13', 'C2', '古墓奇遇', '0.5', null, null, '0', '454', null);
INSERT INTO `project` VALUES ('15', '13', 'C3', '水陆攻占', '0.3', null, null, '2', '1058', null);
INSERT INTO `project` VALUES ('16', '13', 'C4', '神树天梯', '0.4', null, null, '0/2', '831', null);
INSERT INTO `project` VALUES ('17', '13', 'C5', '日晷迷旋', '0.2', null, null, '2', '524', null);
INSERT INTO `project` VALUES ('18', '13', 'C6', '渔猎漂流', '1.0', null, null, '2', '5200', null);
INSERT INTO `project` VALUES ('19', '13', 'D1', '蝴蝶花园', '0.1', null, null, '1', '1113', null);
INSERT INTO `project` VALUES ('20', '13', 'D2', '观鸟园', '0.1', null, null, '1', '303', null);
INSERT INTO `project` VALUES ('21', '13', 'D3', '飞行岛', '0.4', null, null, '0', '1304', null);
INSERT INTO `project` VALUES ('22', '13', 'E1', '小青蛙跳', '0.2', null, null, '1', '420', null);
INSERT INTO `project` VALUES ('23', '13', 'E2', '转转杯', '0.2', null, null, '1/2', '653', null);
INSERT INTO `project` VALUES ('24', '13', 'E3', '小观光轮', '0.2', null, null, '2', '287', null);
INSERT INTO `project` VALUES ('25', '13', 'E4', '墨西哥大草帽', '0.3', null, null, '1', '1735', null);
INSERT INTO `project` VALUES ('26', '13', 'E5', '转转马', '0.3', null, null, '1', '442', null);
INSERT INTO `project` VALUES ('27', '13', 'E6', '疯狂的小鸟', '0.4', null, null, '1', '899', null);
INSERT INTO `project` VALUES ('28', '13', 'E7', '真人Cs', '1.0', null, null, '2', '15783', null);
INSERT INTO `project` VALUES ('29', '13', 'E8', '北极探险', '0.1', null, null, '1/2', '457', null);
INSERT INTO `project` VALUES ('30', '13', 'E9', '西部牛仔', '0.3', null, null, '2', '345', null);
INSERT INTO `project` VALUES ('31', '13', 'E10', '泡球战场', '0.3', null, null, '1/2', '811', null);
INSERT INTO `project` VALUES ('32', '13', 'E11', '疯狂老鼠', '0.4', null, null, '1', '1354', null);
INSERT INTO `project` VALUES ('33', '13', 'E12', '互动剧场', '1.2', null, null, '1/2', '17000', null);
INSERT INTO `project` VALUES ('34', '13', 'E13', '桑巴剧场', '0.2', null, null, '1', '198', null);
INSERT INTO `project` VALUES ('35', '13', 'F1', 'KAKA汽车', '0.5', null, null, '2', '367', null);
INSERT INTO `project` VALUES ('36', '13', 'F2', '疯狂汽车', '0.4', null, null, '1', '269', null);
INSERT INTO `project` VALUES ('37', '13', 'F3', '星际飞翔', '0.8', null, null, '0/2', '14930', null);
INSERT INTO `project` VALUES ('38', '13', 'F4', '深海探奇', '1.0', null, null, '1/2', '59717', null);
INSERT INTO `project` VALUES ('39', '13', 'F5', 'X战车', '0.6', null, null, '0', '19223', null);
INSERT INTO `project` VALUES ('40', '13', 'F6', '弹跳车', '0.3', null, null, '2', '198', null);
INSERT INTO `project` VALUES ('41', '13', 'F7', '小火车', '0.2', null, null, '1', '1110', null);
INSERT INTO `project` VALUES ('42', '13', 'F8', '飞跃西部', '1.2', null, null, '0', '20470', null);
INSERT INTO `project` VALUES ('43', '13', 'F9', '冲浪者', '1.0', null, null, '0', '2661', null);
INSERT INTO `project` VALUES ('44', '13', 'F10', '熊猫侠', '1.0', null, null, '1/2', '22136', null);
INSERT INTO `project` VALUES ('45', '13', 'G1', '云霄飞龙', '1.2', null, null, '0', '26056', null);
INSERT INTO `project` VALUES ('46', '13', 'G2', '飞跃地中海', '1.2', null, null, '0', '29503', null);
INSERT INTO `project` VALUES ('47', '13', 'G3', '地中海影院', '0.8', null, null, '1/2', '17726', null);
INSERT INTO `project` VALUES ('48', '13', 'G4', '金沙探险', '0.2', null, null, '2', '2348', null);
INSERT INTO `project` VALUES ('49', '13', 'G5', '幽灵古堡', '0.4', null, null, '2', '2769', null);

-- ----------------------------
-- Table structure for `project_copy`
-- ----------------------------
DROP TABLE IF EXISTS `project_copy`;
CREATE TABLE `project_copy` (
  `projectId` int(10) NOT NULL,
  `parkId` int(10) default NULL,
  `projectCode` varchar(20) default NULL,
  `projectName` varchar(100) default NULL,
  `projectTime` double(20,1) default NULL,
  `projectLng` varchar(20) default NULL,
  `projectLati` varchar(20) default NULL,
  `projectType` varchar(10) default NULL,
  `projectPop` int(30) default NULL,
  `projectDescribe` varchar(300) default NULL,
  PRIMARY KEY  (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_copy
-- ----------------------------
INSERT INTO `project_copy` VALUES ('1', '13', '0', '入口', '0.0', '', '', '0/1/2', '0', '');
INSERT INTO `project_copy` VALUES ('2', '13', 'A1', '旋转木马', '0.3', '1', '1', '1/2', '6491', null);
INSERT INTO `project_copy` VALUES ('3', '13', 'A2', '水上摩天轮', '0.5', null, null, '2', '7780', null);
INSERT INTO `project_copy` VALUES ('4', '13', 'A3', '碰碰车', '0.3', null, null, '0/2', '11462', null);
INSERT INTO `project_copy` VALUES ('5', '13', 'A4', '天地双雄', '0.6', null, null, '0', '18181', null);
INSERT INTO `project_copy` VALUES ('6', '13', 'B1', '加勒比风暴', '1.5', null, null, '0/2', '10123', null);
INSERT INTO `project_copy` VALUES ('7', '13', 'B2', '天地旋转', '0.4', null, null, '0/2', '1317', null);
INSERT INTO `project_copy` VALUES ('8', '13', 'B3', '加勒比水公园', '0.5', null, null, '2', '1794', null);
INSERT INTO `project_copy` VALUES ('9', '13', 'C1', '雪域飞龙', '1.5', null, null, '0', '44538', null);
INSERT INTO `project_copy` VALUES ('10', '13', 'C2', '水陆攻占', '0.3', null, null, '2', '1058', null);
INSERT INTO `project_copy` VALUES ('11', '13', 'C3', '神树天梯', '0.4', null, null, '0/2', '831', null);
INSERT INTO `project_copy` VALUES ('12', '13', 'C4', '渔猎漂流', '1.0', null, null, '2', '5200', null);
INSERT INTO `project_copy` VALUES ('13', '13', 'D1', '蝴蝶花园', '0.1', null, null, '1', '1113', null);
INSERT INTO `project_copy` VALUES ('14', '13', 'D2', '观鸟园', '0.1', null, null, '1', '303', null);
INSERT INTO `project_copy` VALUES ('15', '13', 'D3', '飞行岛', '0.4', null, null, '0', '1304', null);
INSERT INTO `project_copy` VALUES ('16', '13', 'E1', '小青蛙跳', '0.2', null, null, '1', '420', null);
INSERT INTO `project_copy` VALUES ('17', '13', 'E2', '墨西哥大草帽', '0.3', null, null, '1', '1735', null);
INSERT INTO `project_copy` VALUES ('18', '13', 'E3', '真人Cs', '1.0', null, null, '2', '15783', null);
INSERT INTO `project_copy` VALUES ('19', '13', 'F1', 'KAKA汽车', '0.5', null, null, '2', '367', null);
INSERT INTO `project_copy` VALUES ('20', '13', 'F2', '星际飞翔', '0.8', null, null, '0/2', '14930', null);
INSERT INTO `project_copy` VALUES ('21', '13', 'F3', '熊猫侠', '1.0', null, null, '1/2', '22136', null);
INSERT INTO `project_copy` VALUES ('22', '13', 'G1', '云霄飞龙', '1.2', null, null, '0', '26056', null);
INSERT INTO `project_copy` VALUES ('23', '13', 'G2', '飞跃地中海', '1.2', null, null, '0', '29503', null);
INSERT INTO `project_copy` VALUES ('24', '13', 'G3', '地中海影院', '0.8', null, null, '1/2', '17726', null);
INSERT INTO `project_copy` VALUES ('25', '13', 'G4', '金沙探险', '0.2', null, null, '2', '2348', null);

-- ----------------------------
-- Table structure for `project_copy_2`
-- ----------------------------
DROP TABLE IF EXISTS `project_copy_2`;
CREATE TABLE `project_copy_2` (
  `projectId` int(10) NOT NULL,
  `parkId` int(10) default NULL,
  `projectCode` varchar(20) default NULL,
  `projectName` varchar(100) default NULL,
  `projectTime` double(20,1) default NULL,
  `projectLng` varchar(20) default NULL,
  `projectLati` varchar(20) default NULL,
  `projectType` varchar(10) default NULL,
  `projectPop` int(30) default NULL,
  `projectDescribe` varchar(300) default NULL,
  PRIMARY KEY  (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_copy_2
-- ----------------------------
INSERT INTO `project_copy_2` VALUES ('1', '13', 'Gate', '入口', '0.0', '', '', '0/1/2', '0', '');
INSERT INTO `project_copy_2` VALUES ('2', '13', 'A1', '碰碰车', '0.3', null, null, '0/2', '11462', null);
INSERT INTO `project_copy_2` VALUES ('3', '13', 'B1', '天地旋转', '0.4', null, null, '0/2', '1317', null);
INSERT INTO `project_copy_2` VALUES ('4', '13', 'C1', '雪域飞龙', '1.5', null, null, '0', '44538', null);
INSERT INTO `project_copy_2` VALUES ('5', '13', 'D1', '蝴蝶花园', '0.1', null, null, '1', '1113', null);

-- ----------------------------
-- Table structure for `scenic`
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic` (
  `scenId` int(10) NOT NULL,
  `scenName` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL,
  `scenAreaId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scenic
-- ----------------------------

-- ----------------------------
-- Table structure for `signature`
-- ----------------------------
DROP TABLE IF EXISTS `signature`;
CREATE TABLE `signature` (
  `signatureId` int(10) NOT NULL auto_increment,
  `signatureTime` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `signatureLng` varchar(50) NOT NULL,
  `signatureLati` varchar(50) NOT NULL,
  `userId` int(10) NOT NULL,
  `projectId` int(10) NOT NULL,
  PRIMARY KEY  (`signatureId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signature
-- ----------------------------
INSERT INTO `signature` VALUES ('1', '2016-01-11 05:33:53', '108.99002', '34.25707', '2', '1');
INSERT INTO `signature` VALUES ('2', '2016-01-16 16:52:41', '108.990078', '34.24765', '2', '2');
INSERT INTO `signature` VALUES ('3', '2016-01-12 21:06:37', '108.99', '34.253', '2', '3');
INSERT INTO `signature` VALUES ('4', '2016-01-16 21:09:00', '108.989', '34.2619', '2', '14');
INSERT INTO `signature` VALUES ('5', '2016-01-16 21:09:56', '108.988622', '34.261656', '2', '13');
INSERT INTO `signature` VALUES ('6', '2016-01-13 21:14:05', '108.990034', '34.251998', '2', '4');
INSERT INTO `signature` VALUES ('7', '2016-01-14 21:18:02', '108.992648', '34.252514', '2', '6');
INSERT INTO `signature` VALUES ('8', '2016-01-16 21:18:31', '108.990199', '34.259653', '2', '8');
INSERT INTO `signature` VALUES ('9', '2016-01-16 21:18:59', '108.990592', '34.260612', '2', '12');
INSERT INTO `signature` VALUES ('10', '2016-01-15 21:19:24', '108.987751', '34.250962', '2', '7');
INSERT INTO `signature` VALUES ('11', '2016-01-16 21:19:54', '108.99324', '34.258176', '2', '9');
INSERT INTO `signature` VALUES ('12', '2016-01-16 21:20:20', '108.990347', '34.262853', '2', '11');
INSERT INTO `signature` VALUES ('13', '2016-01-16 21:20:39', '108.988722', '34.261756', '2', '10');

-- ----------------------------
-- Table structure for `partopentime`
-- ----------------------------
DROP TABLE IF EXISTS `partopentime`;
CREATE TABLE `partopentime` (
  `partTimeId` int(10) NOT NULL auto_increment,
  `parkId` int(10) default NULL,
  `parkDate` date default NULL,
  `openTime` time default NULL,
  `closeTime` time default NULL,
  PRIMARY KEY  (`partTimeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of partopentime
-- ----------------------------
INSERT INTO `partopentime` VALUES ('1', '3', '2016-02-28', '10:00:00', '18:15:00');
INSERT INTO `partopentime` VALUES ('2', '3', '2016-02-16', '10:00:00', '18:15:00');
INSERT INTO `partopentime` VALUES ('3', '3', '2016-02-17', '10:00:00', '18:15:00');
INSERT INTO `partopentime` VALUES ('4', '13', '2016-02-28', '10:00:00', '18:15:00');
INSERT INTO `partopentime` VALUES ('5', '2', '2016-02-28', '10:00:00', '22:15:00');
INSERT INTO `partopentime` VALUES ('6', '1', '2016-02-28', '10:00:00', '21:15:00');

-- ----------------------------
-- Table structure for `travelnote`
-- ----------------------------
DROP TABLE IF EXISTS `travelnote`;
CREATE TABLE `travelnote` (
  `travelNoteId` int(10) NOT NULL auto_increment,
  `userId` int(30) NOT NULL,
  `travelNoteTitle` varchar(100) default NULL,
  `travelNoteContent` text NOT NULL,
  `publicTime` varchar(100) NOT NULL default 'CURRENT_TIMESTAMP',
  `parkId` int(10) NOT NULL,
  PRIMARY KEY  (`travelNoteId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of travelnote
-- ----------------------------
INSERT INTO `travelnote` VALUES ('1', '5', '成都欢乐谷一天', '设备设施方面，还是算游乐园中比较大型的了，各种设备设施都还算是比较齐全的了，白天的话玩一个项目都需要排很久的长队，尤其是夏天的白天，那滋味简直就像是铁板烧！所以建议还是晚上来吧，同样也很好耍。价格方面，白天和晚上价格貌似不一样，晚上便宜的多，而且网上也有团购价格，建议不着急的朋友可以去网上团购，这样会比较划算。 吃的方面，在里面有吃的，但是会比较贵，建议可以自己带点吃的，最好带点水果，补充能量。推荐可以去那个水上的玩，个人感觉很好玩，尤其是海浪，夏天感觉还蛮舒服的!', '2015-12-13 15:56:05', '13');
INSERT INTO `travelnote` VALUES ('2', '6', '啦啦啦啦', '嗯，我欢乐谷的时候，都是几年前咯，那时门票应该才120，130左右的全票吧。我建议出门旅游，有学生证的就带上吧，应该会打折吧。还有进欢乐谷背个双肩包比较方便，带点水，吃的什么滴!里面的吃的喝的，我个人感觉贵。划船是要额外收费的，感觉亏。鬼屋没什么好玩，激流勇进和大铁锤比较好耍，我个人最爱飞跃地中海里的过山车，坐上去相当刺激，头发都要吹直。不知道为什么我不玩跳楼机，晕车的朋友可以带点晕车药，因为晕车贴:然井卵.如果你有点晕过山车，要么别玩，实在想玩就先不着急吃饭，以免你坐下来之后就吐。里面的卖的纪念品，小玩意的，贵。天气热的话，提前抹点防晒霜吧。要玩水的朋友，最好自带泳衣。如果衣服湿了的话，里面有设施，烘干衣服的地方，找人问问，就找到咯!', '2016-01-10 20:58:53', '13');
INSERT INTO `travelnote` VALUES ('3', '7', '一日游', '欢乐谷是个连锁游乐场，在大城市都有它的身影，欢乐谷很大，进场的时候要记住拿地图；园区内的餐饮店不多，一到饭点人挤人，排队点单会花费较长时间，有条件的话自带食物吧；门票是190元/人，夏季会开夜场，票70元/人\r\n推荐项目：\r\nDISK\'O\'：是骑乘类项目，伴随动感欢快的节奏， 人们跟着翩翩起舞，扭动、旋转，欢乐多，惊险小，惊险指数☆☆\r\n大摆锤：是由一台齿轮电机驱使其自身旋转，失重的感觉很强烈，让人忍不住尖叫，惊险指数，惊险指数☆☆☆\r\n天地双雄：是一座塔，由下而上高速弹射，到达最高点后再急速下降，上上下下反复几次，惊险指数☆☆☆☆\r\n云霄飞龙：我是再也不坐第二次了，它有超长的轨道，超大幅度升降，超多旋转，胃里简直翻江倒海，惊险指数☆☆☆☆☆☆', '2015-11-12 15:00:08', '13');
INSERT INTO `travelnote` VALUES ('4', '2', '知名学府', '知名学府，还是跟我学校一个系列的，怎么能不来看一看呢。跟我想象的西安交大，还是有点差别的，我觉得她应该更老一些，更有岁月的沧桑感才对，不过呢，看起来还是很年轻的！\n学校的位置超级好找，地铁出来走的稍微远一点，离兴庆公园超级近。学校的氛围还是很好的，一进门就觉得有个高水平大学的样子，几个广场，草地，都看见有学生在看书。\n学校的设施很全，去洗手间什么的，也很方便，基本上不会有人问你是不是游客什么的。\n公共服务也很好，有专门卖交大纪念品的地方，很喜欢。', '2015-11-14 13:10:12', '12');
INSERT INTO `travelnote` VALUES ('5', '3', '西安交大', '西安交大也是一所百年名校了（只可惜当年自己分数差了一点点没上啊），跟古都西安的气质特别相符，一进去就感觉浓浓的古典气息，浓浓的历史厚重感。西安交大有兴庆、雁塔和曲江三个校区，兴庆校区旁边就是兴庆宫公园，游玩的时候可以两个地方一起游玩。而兴庆校区的图书馆更是以钱学森名字命名的，叫“钱学森图书馆”，是由江泽民亲笔题字而成。\n西安交大给人最大的印象就是满校园的法国梧桐了，略显沧桑的梧桐更增添了学校的年代感。漫步在梧桐大道，脚踏着枯黄的落叶，自己也不自觉的安静下来，舍不得打闹嬉戏。', '2015-05-21 12:20:21', '12');
INSERT INTO `travelnote` VALUES ('6', '4', '哇', '虽然西交大不像河大，南大等等的学校有民国时期的老建筑，但是整个校园的法国梧桐为这所学校增添了不少风采。', '2015-05-01 10:09:12', '12');
INSERT INTO `travelnote` VALUES ('18', '15', null, '非常好玩！非常好玩！非常好玩！！重要的事要说三遍！！坐大摆锤吓哭我好吗？！！超级刺激！只要你坐过大摆锤，什么都不在话下了！坐了大摆锤以后跳楼机都玩了两次！去了欢乐谷没玩大摆锤那你就白来了相信我！推荐坐了飞椅再坐边上的转椅，然后再坐大摆锤！我只是亲身体验啊！！一定要相信我！期待下次', '2016-02-26 19:32:38', '13');
INSERT INTO `travelnote` VALUES ('19', '5', null, '设备设施方面，还是算游乐园中比较大型的了，各种设备设施都还算是比较齐全的了，白天的话玩一个项目都需要排很久的长队，尤其是夏天的白天，那滋味简直就像是铁板烧！所以建议还是晚上来吧，同样也很好耍。价格方面，白天和晚上价格貌似不一样，晚上便宜的多，而且网上也有团购价格，建议不着急的朋友可以去网上团购，这样会比较划算。 吃的方面，在里面有吃的，但是会比较贵，建议可以自己带点吃的，最好带点水果，补充能量。推荐可以去那个水上的玩，个人感觉很好玩，尤其是海浪，夏天感觉还蛮舒服的!', '2016-02-26 19:32:38', '13');
INSERT INTO `travelnote` VALUES ('20', '17', null, '成都三大主题公园之一，娱乐项目最多，设备设施最完善。当然，人也是最多的。必玩的推荐熊猫侠、飞跃西部、加勒比风暴、雪域飞龙；刺激的推荐飞跃地中海、云霄飞车、大摆锤和天地双雄；表演的推荐下午14点的滑稽卡通狂欢大巡游和12点的升级版《抓壮丁》。欢乐谷内美食偏贵，可以提前买点零食，留待下午的火锅再大快朵颐。', '2016-02-26 19:32:38', '13');
INSERT INTO `travelnote` VALUES ('21', '6', null, '嗯，我欢乐谷的时候，都是几年前咯，那时门票应该才120，130左右的全票吧。我建议出门旅游，有学生证的就带上吧，应该会打折吧。还有进欢乐谷背个双肩包比较方便，带点水，吃的什么滴!里面的吃的喝的，我个人感觉贵。划船是要额外收费的，感觉亏。鬼屋没什么好玩，激流勇进和大铁锤比较好耍，我个人最爱飞跃地中海里的过山车，坐上去相当刺激，头发都要吹直。不知道为什么我不玩跳楼机，晕车的朋友可以带点晕车药，因为晕车贴:然井卵.如果你有点晕过山车，要么别玩，实在想玩就先不着急吃饭，以免你坐下来之后就吐。里面的卖的纪念品，小玩意的，贵。天气热的话，提前抹点防晒霜吧。要玩水的朋友，最好自带泳衣。如果衣服湿了的话，里面有设施，烘干衣服的地方，找人问问，就找到咯!', '2016-02-26 19:32:38', '13');
INSERT INTO `travelnote` VALUES ('22', '19', null, '成都欢乐谷的门票比北京要便宜不少，我大帝都现在都是200多一张的票，不过园子比这里大太多了，我真的要给大家说明一下，成都欢乐谷的规模不大，甚至可以说很小，也就有北京欢乐谷的一半差不多了，所以喜欢超级乐园的朋友们不要抱太大希望，因为规模小，所以游乐设备相对也少一些，这就导致排队的人会比较多，周末的话一个大项目也要排上至少1个小时的队伍，有时间的朋友还是建议平时来玩吧，周二，周四人都不多，基本不怎么排队的，游玩的感受会好很多！', '2016-02-26 19:32:38', '13');
INSERT INTO `travelnote` VALUES ('23', '7', null, '欢乐谷是个连锁游乐场，在大城市都有它的身影，欢乐谷很大，进场的时候要记住拿地图；园区内的餐饮店不多，一到饭点人挤人，排队点单会花费较长时间，有条件的话自带食物吧；门票是190元/人，夏季会开夜场，票70元/人<br> 推荐项目：<br> DISK\'O\'：是骑乘类项目，伴随动感欢快的节奏， 人们跟着翩翩起舞，扭动、旋转，欢乐多，惊险小，惊险指数☆☆<br> 大摆锤：是由一台齿轮电机驱使其自身旋转，失重的感觉很强烈，让人忍不住尖叫，惊险指数，惊险指数☆☆☆<br> 天地双雄：是一座塔，由下而上高速弹射，到达最高点后再急速下降，上上下下反复几次，惊险指数☆☆☆☆<br> 云霄飞龙：我是再也不坐第二次了，它有超长的轨道，超大幅度升降，超多旋转，胃里简直翻江倒海，惊险指数☆☆☆☆☆☆', '2016-02-26 19:32:38', '13');
INSERT INTO `travelnote` VALUES ('24', '21', null, '去过两次，在大学的时候买过学生票，所以性价比很高。成都的欢乐谷不是特别大（个人觉得），急流勇进、跳楼机、大摆锤、过山车、天旋地转、海盗船、转转杯、鬼屋.....基本上国内其他地方的欢乐谷能看到的东西这里也都有。ps:跳楼机好像北京的欢乐谷就没有。成都欢乐谷的跳楼机有两个，名字叫“天地双雄”，一个属于上升很快下降也很快的，另外一个属于缓慢上升－快速上升－缓慢下降。两个都坐过，比较有发言权，胆子小的还是去坐比较快的那个，你都来不及反应就下来的，就无所谓害怕不害怕了。缓慢下来的真的超级恐怖，停在半空中的失重感也是够了。成都欢乐谷还有一个要特别推荐，就是大摆锤，从来没有见过哪里的大摆锤是建在二楼的，成都的大摆锤居然在二楼。90度甩上天空的时候，睁开眼看着下面的人完全就是小蚂蚁，真是太carzy了。建议有时间就别选周末去，真的人太多了，排个半天队都排不到，就会很奔溃。', '2016-02-26 19:32:38', '13');
INSERT INTO `travelnote` VALUES ('25', '22', null, '1。主要消费：门票200元，无学生票，不过可以通过网络订票，价格会优惠十元，主要是不用排队，直接就能取票，进入很方便。 游览车30元一位，不限次数上下。 门口寄存10元。<br> 2.游玩感受：虽然说门票的价格不低，但是感觉还是值得那个价位的，既可以玩旋转木马回忆你童年的天真无邪，也可以坐过山车追求刺激，大摆锤也是一个很好玩的项目，不像原来那样的简单的小角度，让你完美的体验超重和失重的双重体验，最刺激的就是过山车，如果你追求刺激一定要体验这个项目，会让你的肾上腺素快速的喷射。如果是带小孩子来玩的可以去水上乐园体验清凉之感。<br> 3.注意事项：记得一定要涂防晒霜，夏季的时候天气很热，防晒是必不可少的。<br> 最好还是早一点去，九点钟开馆，一般下午三点钟的时候人很多，排队游戏会很麻烦。<br> 一定要轻装上阵毕竟游乐园内设施和吃喝都是很完善的虽然价格贵，但是可以最大化的节约体力。', '2016-02-26 19:32:39', '13');
INSERT INTO `travelnote` VALUES ('26', '23', null, '在网上有团购票，团购的价格便宜些，白天夜场都能玩，夏天的水上乐园也是包含在门票里的，这是成都乃至在整个西南都算得上是比较大的游乐场了，如果喜欢刺激，不要错过这里，一期主要是游乐设施，适合学前儿童的小型设备，专为成年人设计的刺激项目在这里都有，园区内有麦当劳和肯德基，但肯地基只是一个售卖亭，不是真正的餐厅，二期有四个主题不同的电影院，4D、球形巨幕都有，能充分享受视觉盛宴，园区内多个表演场地每天多个时段会上演节目，推荐巴蜀风情园里的《抓壮丁》实景演出，虽然看过四五次了，但每次都有创新，还有爆破和车技，非常刺激。园区门口有个超大的停车场，正门外还有一个剧场、一个IMAX影院，一条商业街，星巴克、肯德基、必胜客、乡村基在这里都有，公共交通不太方便，出来后经常打不到车。', '2016-02-26 19:32:39', '13');
INSERT INTO `travelnote` VALUES ('27', '24', null, '在成都市区三环路外，占地面积较大，有人工湖泊。【就是一个大型的人造游乐场，和其他类似的东东一样，没啥区别，节日期间一般会有大型游园活动。【进去需要门票，看你买什么级别的套票，价位不等，不过最低都是上100元的，最高的200多。【可以在网上团购，但也便宜不到多少。【门口有公交车，不过从市中心过去拿是肯定要转车的，个人觉得若是没有私家车，打的最方便，当然的士价钱就高了。【要玩儿每一个项目就需要排队，尤其是周末或者节假日，一个项目排半小时算好的了。【欢乐谷内饮食较贵，可自备。【欢乐谷外有餐厅、M、KFC、乡村基等饮食店，也有运动、休闲服装专卖店。【总之，是个适合全家周末出游的好地方，尤其您家哟小孩子的话。', '2016-02-26 19:32:39', '13');
INSERT INTO `travelnote` VALUES ('28', '25', null, '一直很喜欢欢乐谷，不只适合小孩子，其实大人一样可以玩的很嗨。<br> 位置：在成都北三环，坐公交直达的话，在华侨城站下车就是了。<br> 价格：门票180，学生票是160，这是日场，夜场的只要90，五点半之后入园，整个园区是九点半关门。通票制，里面的项目都可以玩。学生证查的很严，一定要用自己的。<br> 餐饮：里面的餐饮比较贵，而且味道一般，欢乐谷就玩一天，建议自己带点吃的什么的很划算。<br> 推荐 ：我喜欢刺激，非常喜欢云霄飞龙，过山车，还有大摆锤！！坐了三次，不是周末去的，没排多久队。还有天地双雄，就是跳楼机，胆子大的尝试一下。还有激流勇进都是比较刺激的项目，要玩在外面就买哈雨衣，最好是有换洗，一身的水。哈哈，温柔一点的就是旋转飞椅，还有旋转木马什么的了。还可以看全景哈。也有好多小女生喜欢的摩天轮。<br> 最好就是选择非周末和节假日去，因为排队都要排一个多小时，那个人多的很有玩的根本玩不上。', '2016-02-26 19:32:39', '13');
INSERT INTO `travelnote` VALUES ('29', '26', null, '9：00钟开园进场，不是周末，感觉人不是很多，心头很爽，玩带水的项目要穿雨衣', '2016-02-26 19:32:39', '13');
INSERT INTO `travelnote` VALUES ('30', '27', null, '欢乐谷的项目少地方比较小。欢乐谷里面还是有大摆锤、飞跃旋转？过山车、鬼屋、碰碰车...但是巨坑啊，我们才刚开始玩一个项目就要下大雨的感觉,好吧.谁知道我们排队玩大摆锤的时候下大雨了，各种哭.我和三男生都特别想玩一直在排队,下雨了也在排队还是直接翻栏杆的..好不容易排到我们了刚坐上去甩了2圈就被游乐园喊停因为大雨不能玩了,心碎。<br> 鬼屋其实一点都不恐怖还没有真鬼。', '2016-02-26 19:32:39', '13');
INSERT INTO `travelnote` VALUES ('31', '28', null, '娱乐项目确实挺不错，四个人在里面是玩了整整一天。<br> 不过，至今还是对有些项目敬而远之。。。不是一般人能承受的住的。。。', '2016-02-26 19:32:39', '13');
INSERT INTO `travelnote` VALUES ('32', '29', null, '说实话，成都欢乐谷规模貌似没有北京欢乐谷大，是周四去的，人也不多，总之，没有如预想的一般，疯一下，有些小失望。', '2016-02-26 19:32:39', '13');

-- ----------------------------
-- Table structure for `travelphoto`
-- ----------------------------
DROP TABLE IF EXISTS `travelphoto`;
CREATE TABLE `travelphoto` (
  `travelPhotoId` int(10) NOT NULL auto_increment,
  `travelNoteId` int(10) NOT NULL,
  `image` varchar(200) NOT NULL,
  `photoName` varchar(100) NOT NULL,
  PRIMARY KEY  (`travelPhotoId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of travelphoto
-- ----------------------------
INSERT INTO `travelphoto` VALUES ('1', '2', 'images/bingmayong.png', '');
INSERT INTO `travelphoto` VALUES ('2', '2', 'images/dayanta.png', '');
INSERT INTO `travelphoto` VALUES ('3', '4', 'uploadImg/xjd.jpeg', 'xjd');
INSERT INTO `travelphoto` VALUES ('4', '6', 'uploadImg/xjd_6_1.jpeg', 'xjd_6_1');
INSERT INTO `travelphoto` VALUES ('5', '6', 'uploadImg/xjd_6_2.jpeg', 'xjd_6_2');
INSERT INTO `travelphoto` VALUES ('6', '6', 'uploadImg/xjd_6_3.jpeg', 'xjd_6_3');
INSERT INTO `travelphoto` VALUES ('21', '14', 'uploadImg/IMG_20160113_085352.jpg', 'IMG_20160113_085352.jpg');
INSERT INTO `travelphoto` VALUES ('22', '14', 'uploadImg/IMG_20160113_085340.jpg', 'IMG_20160113_085340.jpg');
INSERT INTO `travelphoto` VALUES ('23', '1', 'uploadImg/ic_home.png', 'ic_home.png');
INSERT INTO `travelphoto` VALUES ('24', '1', 'uploadImg/ic_suggestion.png', 'ic_suggestion.png');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(30) NOT NULL auto_increment,
  `username` varchar(30) default NULL,
  `password` varchar(20) default NULL,
  `level` varchar(30) default NULL,
  `score` int(10) default NULL,
  `userAvatar` varchar(100) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'houohou', '123456', '1', '120', null);
INSERT INTO `user` VALUES ('2', 'P颠P颠P颠颠', '123', '2', '380', null);
INSERT INTO `user` VALUES ('3', '颖子跟着太阳走', '123', '2', '240', null);
INSERT INTO `user` VALUES ('4', '毛毛', '123', '3', '500', null);
INSERT INTO `user` VALUES ('5', 'cheyenne', '1', '15', '2000', null);
INSERT INTO `user` VALUES ('6', '@panpan', '1', '3', '1041', null);
INSERT INTO `user` VALUES ('7', '多多 ', '1', '30', '71246', 'http://file32.mafengwo.net/M00/B7/DD/wKgBs1aVmjuAC-6oAAO9tHgmsAo65.head.w48.jpeg');
INSERT INTO `user` VALUES ('15', '马儿', null, '1', null, null);
INSERT INTO `user` VALUES ('17', 'Lan Luo', null, '1', null, null);
INSERT INTO `user` VALUES ('18', '@panpan', null, '1', null, null);
INSERT INTO `user` VALUES ('19', '五十个睡神', null, '1', null, null);
INSERT INTO `user` VALUES ('21', '阿年', null, '1', null, null);
INSERT INTO `user` VALUES ('22', '二虎子嘟嘟', null, '1', null, null);
INSERT INTO `user` VALUES ('23', '卓玛拉姆', null, '1', null, null);
INSERT INTO `user` VALUES ('24', '沙漠岛', null, '1', null, null);
INSERT INTO `user` VALUES ('25', '日光加蓝。', null, '1', null, null);
INSERT INTO `user` VALUES ('26', '虫牙', null, '1', null, null);
INSERT INTO `user` VALUES ('27', '饭傻傻', null, '1', null, null);
INSERT INTO `user` VALUES ('28', '请叫我石先森', null, '1', null, null);
INSERT INTO `user` VALUES ('29', 'tietie', null, '1', null, null);
