package com.video.server.controller;

import com.video.server.common.BaseController;
import com.video.server.common.ReturnMsg;
import com.video.server.dto.BannerDTO;
import com.video.server.service.BannerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
* @description: 视频类别管理对外接口层
* @author: video
* @create: 2025.02.24 15:27:22
*/
@RestController
@RequestMapping("/banner")
public class BannerController extends BaseController<BannerService, BannerDTO> {

    @Override
    @Resource(name = "bannerService")
    protected void setBaseService(BannerService bannerService) {
        this.baseService = bannerService;
    }

    /**
    * 默认分页查询
    * @param bannerDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody BannerDTO bannerDTO) {
        return ReturnMsg.ok(baseService.basePage(bannerDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param bannerDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody BannerDTO bannerDTO) {
        return ReturnMsg.ok(baseService.findList(bannerDTO));
    }

    @Override
    protected void beforeSave(BannerDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

