package com.video.server.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.video.server.entity.Admin;
import lombok.Data;
import lombok.ToString;

/**
* @description: 后台用户管理数据传输层
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Data
@ToString
@TableName("admin")
public class AdminDTO extends Admin {


}
