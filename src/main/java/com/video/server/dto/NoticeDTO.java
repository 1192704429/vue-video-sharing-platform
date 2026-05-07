package com.video.server.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.video.server.entity.Notice;
import lombok.Data;
import lombok.ToString;

/**
* @description: 公告信息表数据传输层
* @author: wuming
*/
@Data
@ToString
@TableName("notice")
public class NoticeDTO extends Notice {

}
