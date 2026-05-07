package com.video.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.server.dao.LikesDao;
import com.video.server.dto.LikesDTO;
import com.video.server.dto.NoticeDTO;
import com.video.server.dto.VideosDTO;
import com.video.server.service.LikesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 后台用户管理业务层实现类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Service("likesService")
public class LikesServiceImpl extends ServiceImpl<LikesDao, LikesDTO> implements LikesService {


    @Override
    public List<LikesDTO> findList(LikesDTO userCollectDTO) {
        return this.baseMapper.findList(userCollectDTO);
    }

    @Override
    public Page<LikesDTO> basePage(LikesDTO likesDTO) {
        if (null != likesDTO.getCurrent() && null != likesDTO.getPageSize())
            likesDTO.setCurrent((likesDTO.getCurrent() - 1) * likesDTO.getPageSize());
        List<LikesDTO> list = this.baseMapper.findList(likesDTO);
        int count = this.baseMapper.findPageCount(likesDTO);
        Page<LikesDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }
}
