# 基于 SpringBoot+Vue 的视频分享平台的设计与实现

> 本文围绕一个基于 SpringBoot+Vue 的前后端分离视频分享平台展开，详细介绍了管理员端与用户端的功能设计、技术选型及核心业务流程。

## 一、项目背景

- 本平台适用于视频内容创作与分发场景，注册用户可上传、观看、互动视频内容。
- 解决视频内容从上传到审核再到展示的流程管理问题，同时支持分类、公告、轮播等运营功能。
- 满足管理员对内容审核、用户管理、数据运营的需求，为用户提供完整的视频观看与社交互动体验。

## 二、功能模块介绍

系统分为两个端：**管理员端** 与 **用户端**。管理员负责后台运营与审核，用户负责内容生产与消费。

| 系统端 | 角色 | 职责说明 |
| --- | --- | --- |
| 管理员端 | 管理员 | 登录后台，管理视频分类、轮播图、公告、审核视频、管理用户与评论数据 |
| 用户端 | 注册用户 | 登录后浏览视频、观看、点赞、评论、收藏、上传视频，管理个人中心 |


![功能模块图](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/azhou_promotion/img/module_structure/func_module_a693ea8c070e4fac8465ab9d1302575e.png)


## 三、技术栈说明

前端：Vue 2、Element UI

后端：Java 8、Spring Boot、MyBatis-Plus、Druid

数据库与中间件：MySQL

## 四、核心模块介绍

###### 管理员端

###### 管理员

- 后台账号登录，与普通用户入口分离
- 维护视频分类、轮播 Banner、系统公告
- 对用户上传视频做审核（待审→通过或驳回），控制前台是否展示
- 管理前台用户、视频、评论及点赞、收藏等数据
- 维护后台管理员信息

##### 界面展示

登录页：管理员输入账号密码登录后台

![登录页：管理员输入账号密码登录后台](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/2ddf639b-e2bf-45d3-8dc6-2b6052e05268.png)

轮播图管理页：维护平台轮播图，支持增删改操作

![轮播图管理页：维护平台轮播图，支持增删改操作](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/0d34c6e1-1575-42b8-826f-dfd1fedc52d2.png)

分类管理页：对科普视频的分类信息进行管理

![分类管理页：对科普视频的分类信息进行管理](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/511d5f5f-fb23-4ed8-846a-6faf07a310cd.png)

公告管理页：管理员查看、编辑、删除平台系统公告

![公告管理页：管理员查看、编辑、删除平台系统公告](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/910a4109-43d7-4bc2-8e0a-edaf360552d6.png)

公告管理页：修改平台系统公告的内容及相关信息

![公告管理页：修改平台系统公告的内容及相关信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/41f3aff0-bd91-47bd-831d-fd91a2f838eb.png)

视频管理页：对平台用户上传的视频进行管理与审核

![视频管理页：对平台用户上传的视频进行管理与审核](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/c2c95ed2-d28e-4ec1-8a84-89d27f354e72.png)

评论管理页：管理员查看并管理平台的用户评论

![评论管理页：管理员查看并管理平台的用户评论](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/a1c11b1e-fae3-4d9b-87dd-fe7ab25790af.png)

收藏管理页：管理员查看并管理平台内的用户收藏数据

![收藏管理页：管理员查看并管理平台内的用户收藏数据](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/d17bf416-4eef-421e-8c80-f734a4b52f6f.png)


###### 用户端

###### 注册用户

- 注册、登录后浏览首页、分类与公告
- 观看视频详情并播放，可进行点赞、收藏、评论
- 上传视频默认进入审核中，通过后参与列表排序展示
- 个人中心维护资料并查看稿件审核状态

##### 界面展示

注册页：填写信息，完成科普视频平台账号注册

![注册页：填写信息，完成科普视频平台账号注册](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/b4dc5759-8d59-4037-86a7-0d2881b02804.png)

登录页：用户输入账号密码登录科普视频分享创作平台

![登录页：用户输入账号密码登录科普视频分享创作平台](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/276f4304-6772-4817-8f58-1206def2f5b1.png)

首页：展示轮播和推荐科普视频，供用户浏览

![首页：展示轮播和推荐科普视频，供用户浏览](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/3811eb98-5f71-43ee-84cd-fd41fd861e38.png)

公告列表页：浏览平台发布的所有系统公告

![公告列表页：浏览平台发布的所有系统公告](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/b02692e5-5ae4-408e-83be-bc975a3bacc1.png)

公告详情页：展示开放用户反馈渠道的公告详情

![公告详情页：展示开放用户反馈渠道的公告详情](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/e049f56d-1aff-4188-8377-d3d65f7b4afc.png)

视频列表页：按分类浏览科普视频，支持搜索筛选

![视频列表页：按分类浏览科普视频，支持搜索筛选](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/99276928-f83b-420c-86c5-c93917501c4a.png)

视频详情页：展示视频详情，支持用户评论互动

![视频详情页：展示视频详情，支持用户评论互动](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/2e1a7daf-7585-48d4-86d0-da645fbe640c.png)

视频详情页：用户观看科普视频，查看视频详情内容

![视频详情页：用户观看科普视频，查看视频详情内容](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/7e1360a3-16e5-420c-841f-e698908b9f52.png)

视频发布页：填写视频信息，提交上传待审核视频

![视频发布页：填写视频信息，提交上传待审核视频](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/0493288e-9f84-47ab-8f72-ba1ce1b5af3d.png)

我的发布：查看个人发布视频及审核状态，可编辑删除

![我的发布：查看个人发布视频及审核状态，可编辑删除](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/a12d9f9c-7dbf-495a-8698-7d150d80f28c.png)

个人资料页：维护修改个人账号的基础信息

![个人资料页：维护修改个人账号的基础信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-07/3037180b-9002-4a55-8a60-fe947f8dedc4.png)


## 五、主要业务流程

1. 用户注册并登录用户端
2. 用户上传视频，视频状态设置为“待审核”
3. 管理员登录后台，查看待审视频列表
4. 管理员审核视频，选择“通过”或“驳回”
5. 若通过，视频在前台展示；若驳回，用户可在个人中心查看审核状态
6. 用户浏览视频、观看、点赞、收藏、评论
7. 管理员管理用户、评论、点赞、收藏等数据

## 六、项目拓展性

- 未来可增加教师或商家端角色，支持课程发布或商品推广场景
- 可引入视频推荐算法，提升用户体验
- 可扩展为多级审核流程，增加审核员与超级管理员权限分层
- 可接入第三方登录（微信、QQ）与支付系统，支持商业化运营

## 代码说明 
本仓库为项目的 **后端核心代码部分** 主要用于展示系统的业务设计思路与后端实现方式 出于学习展示与版权保护考虑 前端实现、完整数据库脚本及部署配置未在本仓库中公开 

##  项目交流 
本项目用于学习展示 如需项目完整功能演示、答辩说明或技术交流 请前往作者 GitHub 主页查看联系方式