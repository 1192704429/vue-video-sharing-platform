package com.video.server.entity;

import com.video.server.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 视频类别管理实体类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VideoType extends BaseEntity {

    /**
    * 类型编号
    */
    private Long id;
    /**
    * 分类名称
    */
    private String typeName;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
