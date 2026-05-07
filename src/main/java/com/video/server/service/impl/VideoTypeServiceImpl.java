package com.video.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.server.dao.VideoTypeDao;
import com.video.server.dto.VideoTypeDTO;
import com.video.server.service.VideoTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 视频类别管理业务层实现类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Service("videoTypeService")
public class VideoTypeServiceImpl extends ServiceImpl<VideoTypeDao, VideoTypeDTO> implements VideoTypeService {

    @Override
    public Page<VideoTypeDTO> basePage(VideoTypeDTO videoTypeDTO) {
        if (null != videoTypeDTO.getCurrent() && null != videoTypeDTO.getPageSize())
            videoTypeDTO.setCurrent((videoTypeDTO.getCurrent() - 1) * videoTypeDTO.getPageSize());
        List<VideoTypeDTO> list = this.baseMapper.findList(videoTypeDTO);
        int count = this.baseMapper.findPageCount(videoTypeDTO);
        Page<VideoTypeDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<VideoTypeDTO> findList(VideoTypeDTO videoTypeDTO) {
        return this.baseMapper.findList(videoTypeDTO);
    }

}
