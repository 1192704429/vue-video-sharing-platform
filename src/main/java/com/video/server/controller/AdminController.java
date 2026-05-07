package com.video.server.controller;

import com.video.server.common.BaseController;
import com.video.server.common.ReturnMsg;
import com.video.server.dto.AdminDTO;
import com.video.server.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
/**
* @description: 后台用户管理对外接口层
* @author: video
* @create: 2025.02.24 15:27:22
*/
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController<AdminService, AdminDTO> {


    @Override
    @Resource(name = "adminService")
    protected void setBaseService(AdminService adminService) {
        this.baseService = adminService;
    }

    /**
    * 默认分页查询
    * @param adminDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody AdminDTO adminDTO) {
        return ReturnMsg.ok(baseService.basePage(adminDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param adminDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody AdminDTO adminDTO) {
        return ReturnMsg.ok(baseService.findList(adminDTO));
    }

    @Override
    protected void beforeSave(AdminDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

