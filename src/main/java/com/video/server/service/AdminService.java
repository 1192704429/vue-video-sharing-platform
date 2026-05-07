package com.video.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.video.server.dto.AdminDTO;
import java.util.List;
/**
* @description: 后台用户管理业务层接口
* @author: video
* @create: 2025.02.24 15:27:22
*/
public interface AdminService extends IService<AdminDTO> {

    /**
    * 默认分页方法
    * @param adminDTO
    * @return
    */
    Page<AdminDTO> basePage(AdminDTO adminDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param adminDTO
    * @return
    */
    List<AdminDTO> findList(AdminDTO adminDTO);

}
