package com.video.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.server.dao.BannerDao;
import com.video.server.dto.BannerDTO;
import com.video.server.service.BannerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 视频类别管理业务层实现类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Service("bannerService")
public class BannerServiceImpl extends ServiceImpl<BannerDao, BannerDTO> implements BannerService {

    @Override
    public Page<BannerDTO> basePage(BannerDTO bannerDTO) {
        if (null != bannerDTO.getCurrent() && null != bannerDTO.getPageSize())
            bannerDTO.setCurrent((bannerDTO.getCurrent() - 1) * bannerDTO.getPageSize());
        List<BannerDTO> list = this.baseMapper.findList(bannerDTO);
        int count = this.baseMapper.findPageCount(bannerDTO);
        Page<BannerDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<BannerDTO> findList(BannerDTO bannerDTO) {
        return this.baseMapper.findList(bannerDTO);
    }

}
