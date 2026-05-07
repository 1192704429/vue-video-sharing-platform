package com.video.server.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.video.server.entity.VideoComment;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description: 视频评价管理数据传输层
 * @author: video
 * @create: 2025.02.24 15:27:22
 */
@Data
@ToString
@TableName("video_comment")
public class VideoCommentDTO extends VideoComment {

    /**
     * 视频名称
     */
    @TableField(exist = false)
    private String videoName;
    /**
     * 封面图片
     */
    @TableField(exist = false)
    private String bannerImg;
    /**
     * 用户姓名
     */
    @TableField(exist = false)
    private String nickName;
    /**
     * 用户头像
     */
    @TableField(exist = false)
    private String headImg;

    /**
     * 用户姓名
     */
    @TableField(exist = false)
    private String nickNameTo;
    /**
     * 用户头像
     */
    @TableField(exist = false)
    private String headerImgTo;

    @TableField(exist = false)
    private List<VideoCommentDTO> videoCommentDTOList;

}
