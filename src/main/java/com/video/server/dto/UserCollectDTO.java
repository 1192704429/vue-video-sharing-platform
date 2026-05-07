package com.video.server.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.video.server.entity.UserCollect;
import lombok.Data;
import lombok.ToString;

/**
* @description: 用户收藏管理数据传输层
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Data
@ToString
@TableName("user_collect")
public class UserCollectDTO extends UserCollect {

    /**
    * 视频名称
    */
    @TableField(exist = false)
    private String videoName;
    @TableField(exist = false)
    private String videoInfo;
    /**
    * 封面图片
    */
    @TableField(exist = false)
    private String bannerImg;
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

}
