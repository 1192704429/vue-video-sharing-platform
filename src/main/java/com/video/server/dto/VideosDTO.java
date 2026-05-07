package com.video.server.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.video.server.entity.Videos;
import lombok.Data;
import lombok.ToString;

/**
* @description: 用户视频管理数据传输层
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Data
@ToString
@TableName("videos")
public class VideosDTO extends Videos {

    /**
    * 分类名称
    */
    @TableField(exist = false)
    private String typeName;
    /**
    * 姓名
    */
    @TableField(exist = false)
    private String nickName;
    /**
    * 头像
    */
    @TableField(exist = false)
    private String headImg;

    @TableField(exist = false)
    private Integer commentCount;


}
