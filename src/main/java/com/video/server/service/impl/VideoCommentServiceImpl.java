package com.video.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.server.dao.VideoCommentDao;
import com.video.server.dto.VideoCommentDTO;
import com.video.server.service.VideoCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 视频评价管理业务层实现类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Service("videoCommentService")
public class VideoCommentServiceImpl extends ServiceImpl<VideoCommentDao, VideoCommentDTO> implements VideoCommentService {

    @Override
    public Page<VideoCommentDTO> basePage(VideoCommentDTO videoCommentDTO) {
        if (null != videoCommentDTO.getCurrent() && null != videoCommentDTO.getPageSize())
            videoCommentDTO.setCurrent((videoCommentDTO.getCurrent() - 1) * videoCommentDTO.getPageSize());
        List<VideoCommentDTO> list = this.baseMapper.findList(videoCommentDTO);
        int count = this.baseMapper.findPageCount(videoCommentDTO);
        Page<VideoCommentDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<VideoCommentDTO> findList(VideoCommentDTO videoCommentDTO) {
        return this.baseMapper.findList(videoCommentDTO);
    }

}
