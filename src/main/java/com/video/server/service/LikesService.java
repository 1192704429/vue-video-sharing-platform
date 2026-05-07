package com.video.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.video.server.dto.LikesDTO;
import com.video.server.dto.NoticeDTO;
import com.video.server.dto.UserCollectDTO;

import java.util.List;

/**
* @description: 后台用户管理业务层接口
* @author: video
* @create: 2025.02.24 15:27:22
*/
public interface LikesService extends IService<LikesDTO> {





    /**
     * 根据XML中的sql语句进行查询
     * @param userCollectDTO
     * @return
     */
    List<LikesDTO> findList(LikesDTO userCollectDTO);


    Page<LikesDTO>  basePage(LikesDTO likesDTO);
}
