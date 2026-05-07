package com.video.server.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.video.server.entity.Banner;
import com.video.server.entity.VideoType;
import lombok.Data;
import lombok.ToString;

/**
* @description: 视频类别管理数据传输层
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Data
@ToString
@TableName("banner")
public class BannerDTO extends Banner {


}
