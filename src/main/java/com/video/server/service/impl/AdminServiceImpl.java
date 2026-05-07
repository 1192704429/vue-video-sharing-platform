package com.video.server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.server.dao.AdminDao;
import com.video.server.dto.AdminDTO;
import com.video.server.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 后台用户管理业务层实现类
* @author: video
* @create: 2025.02.24 15:27:22
*/
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminDTO> implements AdminService {

    @Override
    public Page<AdminDTO> basePage(AdminDTO adminDTO) {
        if (null != adminDTO.getCurrent() && null != adminDTO.getPageSize())
            adminDTO.setCurrent((adminDTO.getCurrent() - 1) * adminDTO.getPageSize());
        List<AdminDTO> list = this.baseMapper.findList(adminDTO);
        int count = this.baseMapper.findPageCount(adminDTO);
        Page<AdminDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<AdminDTO> findList(AdminDTO adminDTO) {
        return this.baseMapper.findList(adminDTO);
    }

}
