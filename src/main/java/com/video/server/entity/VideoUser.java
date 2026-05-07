package com.video.server.entity;

import com.video.server.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 前台用户管理实体类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VideoUser extends BaseEntity {

    /**
    * 用户编号
    */
    private Long id;
    /**
    * 账号
    */
    private String account;
    /**
    * 密码
    */
    private String password;
    /**
    * 姓名
    */
    private String nickName;
    /**
    * 头像
    */
    private String headImg;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
