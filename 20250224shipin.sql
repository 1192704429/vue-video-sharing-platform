/*
 Navicat Premium Data Transfer

 Source Server         : server-dev
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : 49.234.55.245:10086
 Source Schema         : 20250224shipin

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 25/02/2025 17:12:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名(select)',
  `pass_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像(img)',
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', 'http://localhost:8092/file/36203cb3-860c-46f0-95b8-88112eba86b1.jpg', 'azhou', '2023-10-07 15:58:41');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '轮播编号',
  `banner_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '轮播' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (1, 'http://localhost:8092/video/8de364ad-192d-4fcf-9eaf-bbf8afd1ae0d.png', '2025-02-25 16:52:45');
INSERT INTO `banner` VALUES (2, 'http://localhost:8092/video/59dbfa66-63ac-4859-9738-ddf4f814e39a.png', '2025-02-25 16:52:50');

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  `video_id` bigint(20) NULL DEFAULT NULL COMMENT '视频编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户点赞' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES (10, 1, 170, '2025-02-25 15:09:09');
INSERT INTO `likes` VALUES (11, 2, 171, '2025-02-25 16:34:25');
INSERT INTO `likes` VALUES (12, 1, 172, '2025-02-25 17:08:33');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `banner_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图片',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `type` int(11) NULL DEFAULT NULL COMMENT '状态[0:隐藏,1:正常]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 115 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (112, '新功能上线通知', 'http://localhost:8092/video/0e08c844-d545-4eff-aef1-b5cb70249a95.jpg', '垃圾回收平台即将上线新的智能识别功能，能够更准确地识别垃圾类型。请大家注意使用。', '新功能上线通知', 1, '2025-02-17 08:10:30');
INSERT INTO `notice` VALUES (113, '安全操作指南', 'http://localhost:8092/video/0e08c844-d545-4eff-aef1-b5cb70249a95.jpg', '为了确保大家的安全，平台将发布新的安全操作指南。请大家仔细阅读并遵守。', '安全操作指南', 1, '2025-02-17 08:10:30');
INSERT INTO `notice` VALUES (114, '用户反馈渠道开放', 'http://localhost:8092/video/0e08c844-d545-4eff-aef1-b5cb70249a95.jpg', '开放用户反馈渠道：提升服务品质的关键一步\n\n在当今竞争激烈的市场环境中，用户反馈是企业持续改进和优化服务的重要依据。为了更好地满足用户需求，提升服务质量，我们决定正式开放用户反馈渠道。这一举措不仅体现了我们对用户意见的重视，也是我们不断追求卓越的承诺。\n\n为什么开放用户反馈渠道？\n了解用户需求：通过用户的直接反馈，我们可以更准确地了解他们的需求和期望，从而提供更加个性化的服务。\n\n快速解决问题：用户反馈可以帮助我们及时发现并解决产品和服务中的问题，避免小问题演变成大麻烦。\n\n增强用户参与感：开放反馈渠道让用户感受到他们的声音被听到和重视，从而增强他们的参与感和忠诚度。\n\n持续改进：用户反馈为我们提供了宝贵的改进建议，帮助我们不断优化产品和服务，保持市场竞争力。\n\n如何提供反馈？\n我们提供了多种便捷的反馈渠道，确保每位用户都能轻松表达自己的意见和建议：\n\n在线反馈表单：访问我们的官方网站，填写在线反馈表单，详细描述您的建议或问题。\n\n客服热线：拨打我们的客服热线，与客服代表直接沟通，实时解决问题。\n\n电子邮件：发送邮件至我们的反馈邮箱，详细描述您的反馈内容。\n\n社交媒体：通过我们的官方社交媒体平台留言或私信，我们的团队会及时回复。\n\n我们的承诺\n我们承诺认真对待每一条用户反馈，并采取以下措施确保反馈的有效性：\n\n及时响应：我们将在收到反馈后的24小时内进行初步响应，确保用户的问题得到及时关注。\n\n问题跟踪：建立反馈跟踪系统，确保每个问题都能得到妥善处理和解决。\n\n持续改进：定期分析用户反馈，识别共性问题，制定改进措施，并在后续服务中体现。\n\n结语\n开放用户反馈渠道是我们提升服务品质的重要一步。我们相信，通过用户的积极参与和宝贵意见，我们能够不断改进，提供更加优质的服务。感谢每一位用户的支持与信任，您的反馈是我们前进的动力。让我们一起携手，共同创造更美好的未来！\n\n如果您有任何意见或建议，请立即通过我们的反馈渠道告诉我们。我们期待听到您的声音！\n\n联系我们：\n\n在线反馈表单：[链接]\n\n客服热线：123-456-7890\n\n反馈邮箱：feedback@example.com\n\n社交媒体：@ExampleOfficial\n\n感谢您的支持与参与！\n\n这篇文章旨在传达开放用户反馈渠道的重要性，并提供具体的反馈方式和企业的承诺，以鼓励用户积极参与。', '用户反馈渠道开放', 1, '2025-02-17 08:10:30');

-- ----------------------------
-- Table structure for user_collect
-- ----------------------------
DROP TABLE IF EXISTS `user_collect`;
CREATE TABLE `user_collect`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `videos_id` bigint(20) NULL DEFAULT NULL COMMENT '视频ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_collect
-- ----------------------------
INSERT INTO `user_collect` VALUES (20, 1, 170, '2025-02-25 15:09:11');
INSERT INTO `user_collect` VALUES (21, 2, 171, '2025-02-25 16:34:25');
INSERT INTO `user_collect` VALUES (22, 1, 172, '2025-02-25 17:08:34');

-- ----------------------------
-- Table structure for video_comment
-- ----------------------------
DROP TABLE IF EXISTS `video_comment`;
CREATE TABLE `video_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `comment_info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评价内容',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `videos_id` bigint(20) NULL DEFAULT NULL COMMENT '视频ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `to_user_id` bigint(20) NULL DEFAULT NULL COMMENT '回复人编号',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父级评论编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video_comment
-- ----------------------------
INSERT INTO `video_comment` VALUES (3, '123123', 1, 2, '2023-10-09 11:38:17', NULL, 0);
INSERT INTO `video_comment` VALUES (4, '123123', 1, 2, '2023-10-09 11:44:14', NULL, 0);
INSERT INTO `video_comment` VALUES (7, 'hahah', 2, 2, '2023-10-09 13:53:44', 1, 3);
INSERT INTO `video_comment` VALUES (8, '123', 2, 2, '2023-10-09 13:53:49', NULL, 0);
INSERT INTO `video_comment` VALUES (9, '测试', 2, 3, '2023-10-09 13:55:47', NULL, 0);
INSERT INTO `video_comment` VALUES (11, '哈哈哈哈', 1, 8, '2023-10-09 15:08:41', NULL, 0);
INSERT INTO `video_comment` VALUES (13, '哈哈哈', 2, 8, '2023-10-09 15:11:53', 1, 11);
INSERT INTO `video_comment` VALUES (15, 'nb', 1, 170, '2025-02-25 15:09:19', NULL, 0);
INSERT INTO `video_comment` VALUES (16, '66666', 1, 170, '2025-02-25 15:09:24', NULL, 0);
INSERT INTO `video_comment` VALUES (17, '666', 2, 180, '2025-02-25 16:31:40', NULL, 0);
INSERT INTO `video_comment` VALUES (18, '真的假的', 2, 174, '2025-02-25 17:03:41', NULL, 0);
INSERT INTO `video_comment` VALUES (19, 'what?', 2, 174, '2025-02-25 17:03:46', NULL, 0);
INSERT INTO `video_comment` VALUES (20, '你说的', 1, 174, '2025-02-25 17:04:01', 2, 19);
INSERT INTO `video_comment` VALUES (21, '666', 1, 174, '2025-02-25 17:04:05', NULL, 0);

-- ----------------------------
-- Table structure for video_type
-- ----------------------------
DROP TABLE IF EXISTS `video_type`;
CREATE TABLE `video_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video_type
-- ----------------------------
INSERT INTO `video_type` VALUES (1, '地理', '2023-10-07 16:00:20');
INSERT INTO `video_type` VALUES (2, '日常', '2023-10-07 16:00:31');
INSERT INTO `video_type` VALUES (3, '养生', '2023-10-07 16:00:35');
INSERT INTO `video_type` VALUES (4, '健康', '2023-10-07 16:00:59');
INSERT INTO `video_type` VALUES (5, '其他', '2023-10-07 16:01:05');

-- ----------------------------
-- Table structure for video_user
-- ----------------------------
DROP TABLE IF EXISTS `video_user`;
CREATE TABLE `video_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video_user
-- ----------------------------
INSERT INTO `video_user` VALUES (1, 'azhou', 'azhou', 'azhou2', 'http://localhost:8092/file/96d34cec-3181-457f-b814-f1048eb80220.jpg', '2023-10-07 16:56:14');
INSERT INTO `video_user` VALUES (2, 'aneng', 'aneng', 'aneng', 'https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2022-05-09/f2623747-22cd-4faa-8c37-bf53f88fe34d_2.png', '2023-10-07 16:56:25');
INSERT INTO `video_user` VALUES (3, 'amo', 'amo', 'amo', 'http://localhost:8092/file/6571ece8-7e6e-42a5-b20d-5e8006a17c51.jpg', '2023-10-07 16:56:35');
INSERT INTO `video_user` VALUES (4, 'azhou1', 'azhou', 'azhou1', 'https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2022-05-09/f2623747-22cd-4faa-8c37-bf53f88fe34d_2.png', '2023-10-08 17:09:28');

-- ----------------------------
-- Table structure for videos
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `video_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频名称',
  `video_info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '视频简介',
  `banner_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图片',
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `type_id` bigint(20) NULL DEFAULT NULL COMMENT '视频分类',
  `click_num` int(11) NULL DEFAULT NULL COMMENT '点赞数',
  `collect_num` int(11) NULL DEFAULT NULL COMMENT '收藏数',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  `status` int(11) NULL DEFAULT 0 COMMENT '状态[0:审核中,1:审核通过,2:审核失败]',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 181 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of videos
-- ----------------------------
INSERT INTO `videos` VALUES (170, '天然气是如何开采出来的', '天然气开采全过程视频', 'http://localhost:8092/video/dcb1a46c-3825-46ba-a2db-00ad4af481a7.png', 'http://localhost:8092/video/48d54632-6298-4ef4-8d0f-4a7cb4ded2bf.mp4', '2025-02-25 13:30:45', 1, 1, 1, 1, 1);
INSERT INTO `videos` VALUES (171, '你知道一杯酒下肚，体内都发生了的变化', '酒下肚之后吗迅速挥发', 'http://localhost:8092/video/de876050-622d-4a59-b648-c946802d49da.png', 'http://localhost:8092/video/e8fe02ec-dc47-4715-b241-8cc19a08b481.mp4', '2025-02-25 13:36:00', 4, 1, 1, 1, 1);
INSERT INTO `videos` VALUES (172, '大学生科普作业视频', '大学生科普作业视频简介', 'http://localhost:8092/video/08bb53db-d525-4c66-b163-63d422284a5f.png', 'http://localhost:8092/video/d17e4e94-4cb1-4b45-87e1-18b20a3867a7.mp4', '2025-02-25 15:48:52', 5, 1, 1, 1, 1);
INSERT INTO `videos` VALUES (173, '辣椒那些事', '辣椒那些事简介', 'http://localhost:8092/video/3b0f2044-d65c-4661-966e-14c749030630.png', 'http://localhost:8092/video/b03a396b-f0bc-4ee2-89aa-01db4edff81e.mp4', '2025-02-25 15:49:47', 4, 0, 0, 1, 1);
INSERT INTO `videos` VALUES (174, '牛奶盒可乐圆瓶', '牛奶盒的设计以实用性为主导。其矩形形状不仅便于堆叠和存储，还能有效利用空间，减少运输和仓储成本。经典的圆瓶设计不仅符合人体工程学，握感舒适，还通过独特的曲线和标志性的瓶身设计，增强了品牌的辨识度。可乐瓶通常采用PET塑料或玻璃材质，具有良好的透明度和光泽感，能够直观地展示饮品的颜色和状态，增加消费者的购买欲望。', 'http://localhost:8092/video/c0a10cd9-0058-46ec-8f47-47a99399b93e.png', 'http://localhost:8092/video/7228ee34-6ef4-42da-8fae-7df759dddaf8.mp4', '2025-02-25 15:55:18', 2, 0, 0, 2, 1);
INSERT INTO `videos` VALUES (175, '地球的水是从哪里来的', '地球的水是从哪里来的简介', 'http://localhost:8092/video/7d858d54-ac42-46ba-96e1-f0f67d2faae0.png', 'http://localhost:8092/video/4fd90320-673c-4167-8ed7-603490ca588d.mp4', '2025-02-25 15:57:19', 1, 0, 0, 2, 1);
INSERT INTO `videos` VALUES (176, '关灯玩手机的危害有多大', '关灯玩手机的危害有多大简介', 'http://localhost:8092/video/ebc6e2be-c5a0-4930-a9e9-392b6b137c3a.png', 'http://localhost:8092/video/73f00e9f-1131-4093-8853-d90b92f14548.mp4', '2025-02-25 15:58:08', 4, 0, 0, 2, 1);
INSERT INTO `videos` VALUES (177, '古人要是近视了该怎么办', '古人要是近视了该怎么办简介', 'http://localhost:8092/video/5d789ee8-4015-4e63-845f-be7b6a2c5872.png', 'http://localhost:8092/video/a55c081e-8597-4e3c-b949-ae1949598bea.mp4', '2025-02-25 15:59:53', 5, 0, 0, 2, 1);
INSERT INTO `videos` VALUES (178, '科普类视频从哪里找', '科普类视频从哪里找，推荐10个', 'http://localhost:8092/video/a025de79-8d3d-444b-9671-0d172874031b.png', 'http://localhost:8092/video/77deb5ab-38cf-46fb-8635-6bb5d091737a.mp4', '2025-02-25 16:00:28', 5, 0, 0, 2, 1);
INSERT INTO `videos` VALUES (179, '人类究竟从何而来', '人类究竟从何而来简介', 'http://localhost:8092/video/cbbf6a28-4643-463d-b17a-9c8357e4e72d.png', 'http://localhost:8092/video/a9965993-14ce-4173-85bd-bb5d8d846c32.mp4', '2025-02-25 16:01:03', 5, 0, 0, 2, 0);
INSERT INTO `videos` VALUES (180, '人脑有多强大，与超级计算机相比', '人脑有多强大，与超级计算机相比', 'http://localhost:8092/video/48103adc-0bae-4a3c-a4fb-be1dc29310d9.png', 'http://localhost:8092/video/cff56b78-8450-4b8b-9aa8-9ccca36ad28b.mp4', '2025-02-25 16:01:58', 2, 0, 0, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
