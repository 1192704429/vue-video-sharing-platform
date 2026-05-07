package com.video.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.video.server.dto.VideoCommentDTO;
import java.util.List;
/**
* @description: 视频评价管理业务层接口
* @author: video
* @create: 2025.02.24 15:27:22
*/
public interface VideoCommentService extends IService<VideoCommentDTO> {

    /**
    * 默认分页方法
    * @param videoCommentDTO
    * @return
    */
    Page<VideoCommentDTO> basePage(VideoCommentDTO videoCommentDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param videoCommentDTO
    * @return
    */
    List<VideoCommentDTO> findList(VideoCommentDTO videoCommentDTO);

}
