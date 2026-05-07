package com.video.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.server.dao.VideosDao;
import com.video.server.dto.VideosDTO;
import com.video.server.service.VideosService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 用户视频管理业务层实现类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Service("videosService")
public class VideosServiceImpl extends ServiceImpl<VideosDao, VideosDTO> implements VideosService {

    @Override
    public Page<VideosDTO> basePage(VideosDTO videosDTO) {
        if (null != videosDTO.getCurrent() && null != videosDTO.getPageSize())
            videosDTO.setCurrent((videosDTO.getCurrent() - 1) * videosDTO.getPageSize());
        List<VideosDTO> list = this.baseMapper.findList(videosDTO);
        int count = this.baseMapper.findPageCount(videosDTO);
        Page<VideosDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<VideosDTO> findList(VideosDTO videosDTO) {
        return this.baseMapper.findList(videosDTO);
    }

}
