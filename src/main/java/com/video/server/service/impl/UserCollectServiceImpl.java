package com.video.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.server.dao.UserCollectDao;
import com.video.server.dto.UserCollectDTO;
import com.video.server.service.UserCollectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 用户收藏管理业务层实现类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Service("userCollectService")
public class UserCollectServiceImpl extends ServiceImpl<UserCollectDao, UserCollectDTO> implements UserCollectService {

    @Override
    public Page<UserCollectDTO> basePage(UserCollectDTO userCollectDTO) {
        if (null != userCollectDTO.getCurrent() && null != userCollectDTO.getPageSize())
            userCollectDTO.setCurrent((userCollectDTO.getCurrent() - 1) * userCollectDTO.getPageSize());
        List<UserCollectDTO> list = this.baseMapper.findList(userCollectDTO);
        int count = this.baseMapper.findPageCount(userCollectDTO);
        Page<UserCollectDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<UserCollectDTO> findList(UserCollectDTO userCollectDTO) {
        return this.baseMapper.findList(userCollectDTO);
    }

}
