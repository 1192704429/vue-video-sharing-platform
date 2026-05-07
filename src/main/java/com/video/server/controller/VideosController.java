package com.video.server.controller;

import com.video.server.common.BaseController;
import com.video.server.common.ReturnMsg;
import com.video.server.dto.VideosDTO;
import com.video.server.service.VideosService;
import org.springframework.web.bind.annotation.*;
import com.video.server.common.BaseSelectEntity;

import java.util.ArrayList;

import com.video.server.service.VideoTypeService;
import com.video.server.dto.VideoTypeDTO;
import com.video.server.service.VideoUserService;
import com.video.server.dto.VideoUserDTO;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import java.util.Date;

/**
 * @description: 用户视频管理对外接口层
 * @author: video
 * @create: 2025.02.24 15:27:22
 */
@RestController
@RequestMapping("/videos")
public class VideosController extends BaseController<VideosService, VideosDTO> {

    @Autowired
    private VideoTypeService videoTypeService;

    @Autowired
    private VideoUserService videoUserService;

    @Override
    @Resource(name = "videosService")
    protected void setBaseService(VideosService videosService) {
        this.baseService = videosService;
    }

    /**
     * 默认分页查询
     *
     * @param videosDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody VideosDTO videosDTO) {
        return ReturnMsg.ok(baseService.basePage(videosDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param videosDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody VideosDTO videosDTO) {
        return ReturnMsg.ok(baseService.findList(videosDTO));
    }

    @Override
    protected void beforeSave(VideosDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/getIndex/{num}")
    public ReturnMsg getIndex(@PathVariable("num") Integer num) {
        VideosDTO videosDTO = new VideosDTO();
        videosDTO.setCurrent(1);
        videosDTO.setPageSize(num);
        return ReturnMsg.ok(baseService.findList(videosDTO));
    }

    @GetMapping("/addClick/{id}")
    public ReturnMsg addClick(@PathVariable("id") Long id) {
        VideosDTO id1 = this.baseService.getById(id);
        if (id1 != null) {
            Integer clickNum = id1.getClickNum();
            id1.setClickNum(clickNum + 1);
            this.baseService.updateById(id1);
        }
        return ReturnMsg.ok();
    }

    @GetMapping("/all/videoType")
    public ReturnMsg allVideoType() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<VideoTypeDTO> dtos = videoTypeService.list();
        for (VideoTypeDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getTypeName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

    @GetMapping("/all/videoUser")
    public ReturnMsg allVideoUser() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<VideoUserDTO> dtos = videoUserService.list();
        for (VideoUserDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getNickName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

