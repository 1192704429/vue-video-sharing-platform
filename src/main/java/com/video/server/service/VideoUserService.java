package com.video.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.video.server.dto.VideoUserDTO;
import java.util.List;
/**
* @description: 前台用户管理业务层接口
* @author: video
* @create: 2025.02.24 15:27:22
*/
public interface VideoUserService extends IService<VideoUserDTO> {

    /**
    * 默认分页方法
    * @param videoUserDTO
    * @return
    */
    Page<VideoUserDTO> basePage(VideoUserDTO videoUserDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param videoUserDTO
    * @return
    */
    List<VideoUserDTO> findList(VideoUserDTO videoUserDTO);

}
