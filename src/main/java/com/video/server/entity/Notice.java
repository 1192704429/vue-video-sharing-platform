package com.video.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.video.server.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
* @description: 公告信息表实体类
* @author: wuming
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notice extends BaseEntity {

    /**
    * 公告编号
    */
    private Long id;
    /**
    * 公告图片
    */
    private String bannerImg;

    /**
    * 公告内容
    */
    private String content;
    /**
    * 公告简介
    */
    private String info;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 公告标题
    */
    private String title;

    private Integer type;

}
