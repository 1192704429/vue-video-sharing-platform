package com.video.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.video.server.dto.BannerDTO;

import java.util.List;

/**
* @description: 视频类别管理业务层接口
* @author: video
* @create: 2025.02.24 15:27:22
*/
public interface BannerService extends IService<BannerDTO> {

    /**
    * 默认分页方法
    * @param bannerDTO
    * @return
    */
    Page<BannerDTO> basePage(BannerDTO bannerDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param bannerDTO
    * @return
    */
    List<BannerDTO> findList(BannerDTO bannerDTO);

}
