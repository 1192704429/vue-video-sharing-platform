package com.video.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.video.server.dto.VideosDTO;
import java.util.List;
/**
* @description: 用户视频管理业务层接口
* @author: video
* @create: 2025.02.24 15:27:22
*/
public interface VideosService extends IService<VideosDTO> {

    /**
    * 默认分页方法
    * @param videosDTO
    * @return
    */
    Page<VideosDTO> basePage(VideosDTO videosDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param videosDTO
    * @return
    */
    List<VideosDTO> findList(VideosDTO videosDTO);

}
