package com.video.server.controller;

import com.video.server.common.BaseController;
import com.video.server.common.ReturnMsg;
import com.video.server.dto.VideoTypeDTO;
import com.video.server.service.VideoTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
/**
* @description: 视频类别管理对外接口层
* @author: video
* @create: 2025.02.24 15:27:22
*/
@RestController
@RequestMapping("/videoType")
public class VideoTypeController extends BaseController<VideoTypeService, VideoTypeDTO> {


    @Override
    @Resource(name = "videoTypeService")
    protected void setBaseService(VideoTypeService videoTypeService) {
        this.baseService = videoTypeService;
    }

    /**
    * 默认分页查询
    * @param videoTypeDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody VideoTypeDTO videoTypeDTO) {
        return ReturnMsg.ok(baseService.basePage(videoTypeDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param videoTypeDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody VideoTypeDTO videoTypeDTO) {
        return ReturnMsg.ok(baseService.findList(videoTypeDTO));
    }

    @Override
    protected void beforeSave(VideoTypeDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

