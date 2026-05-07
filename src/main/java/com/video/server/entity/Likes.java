package com.video.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.video.server.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @description: 后台用户管理实体类
 * @author: video
 * @create: 2025.02.24 15:27:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Likes extends BaseEntity {

    /**
     * 主键ID
     */
    private Long id;
    private Long userId;
    private Long videoId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
