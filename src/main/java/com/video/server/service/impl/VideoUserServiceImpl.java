package com.video.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.server.dao.VideoUserDao;
import com.video.server.dto.VideoUserDTO;
import com.video.server.service.VideoUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 前台用户管理业务层实现类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Service("videoUserService")
public class VideoUserServiceImpl extends ServiceImpl<VideoUserDao, VideoUserDTO> implements VideoUserService {

    @Override
    public Page<VideoUserDTO> basePage(VideoUserDTO videoUserDTO) {
        if (null != videoUserDTO.getCurrent() && null != videoUserDTO.getPageSize())
            videoUserDTO.setCurrent((videoUserDTO.getCurrent() - 1) * videoUserDTO.getPageSize());
        List<VideoUserDTO> list = this.baseMapper.findList(videoUserDTO);
        int count = this.baseMapper.findPageCount(videoUserDTO);
        Page<VideoUserDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<VideoUserDTO> findList(VideoUserDTO videoUserDTO) {
        return this.baseMapper.findList(videoUserDTO);
    }

}
