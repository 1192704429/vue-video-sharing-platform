package com.video.server.entity;

import com.video.server.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 用户视频管理实体类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Videos extends BaseEntity {

    /**
    * 视频编号
    */
    private Long id;
    /**
    * 视频名称
    */
    private String videoName;
    /**
    * 视频简介
    */
    private String videoInfo;

    /**
    * 封面图片
    */
    private String bannerImg;
    /**
    * 介绍视频
    */
    private String videoUrl;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 视频分类
    */
    private Long typeId;

    /**
    * 点赞数
    */
    private Integer clickNum;
    /**
    * 收藏数
    */
    private Integer collectNum;
    /**
    * 用户编号
    */
    private Long userId;
    /**
    * 状态
    */
    private Integer status;


}
