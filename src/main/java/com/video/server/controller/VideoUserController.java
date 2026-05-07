package com.video.server.controller;

import com.video.server.common.BaseController;
import com.video.server.common.ReturnMsg;
import com.video.server.dto.VideoUserDTO;
import com.video.server.service.VideoUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

import cn.hutool.core.collection.CollectionUtil;

import java.util.Date;

/**
 * @description: 前台用户管理对外接口层
 * @author: video
 * @create: 2025.02.24 15:27:22
 */
@RestController
@RequestMapping("/videoUser")
public class VideoUserController extends BaseController<VideoUserService, VideoUserDTO> {


    @Override
    @Resource(name = "videoUserService")
    protected void setBaseService(VideoUserService videoUserService) {
        this.baseService = videoUserService;
    }

    /**
     * 默认分页查询
     *
     * @param videoUserDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody VideoUserDTO videoUserDTO) {
        return ReturnMsg.ok(baseService.basePage(videoUserDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param videoUserDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody VideoUserDTO videoUserDTO) {
        return ReturnMsg.ok(baseService.findList(videoUserDTO));
    }

    @Override
    protected void beforeSave(VideoUserDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }


    @PostMapping(value = "/login")
    public ReturnMsg login(@RequestBody VideoUserDTO videoUserDTO) throws Exception {
        List<VideoUserDTO> list = baseService.findList(videoUserDTO);
        if (CollectionUtil.isEmpty(list)) throw new Exception("账号或密码有误");
        return ReturnMsg.ok(list.get(0));
    }

    @PostMapping(value = "/register")
    public ReturnMsg register(@RequestBody VideoUserDTO videoUserDTO) throws Exception {
        VideoUserDTO videoUserDTO1 = new VideoUserDTO();
        videoUserDTO1.setAccount(videoUserDTO.getAccount());
        List<VideoUserDTO> list = baseService.findList(videoUserDTO1);
        if (CollectionUtil.isNotEmpty(list)) throw new Exception("账号已被占用");
        videoUserDTO.setNickName("用户-" + videoUserDTO.getAccount());
        videoUserDTO.setCreateTime(new Date());
        videoUserDTO.setHeadImg("https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2022-05-09/f2623747-22cd-4faa-8c37-bf53f88fe34d_2.png");
        this.baseService.save(videoUserDTO);
        return ReturnMsg.ok();
    }


}

