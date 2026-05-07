package com.video.server.controller;

import com.video.server.common.BaseController;
import com.video.server.common.ReturnMsg;
import com.video.server.dto.VideosDTO;
import com.video.server.dto.UserCollectDTO;
import com.video.server.service.VideosService;
import com.video.server.service.UserCollectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @description: 用户收藏管理对外接口层
 * @author: video
 * @create: 2025.02.24 15:27:22
 */
@RestController
@RequestMapping("/userCollect")
public class UserCollectController extends BaseController<UserCollectService, UserCollectDTO> {

    @Autowired
    private VideosService videosService;

    @Override
    @Resource(name = "userCollectService")
    protected void setBaseService(UserCollectService userCollectService) {
        this.baseService = userCollectService;
    }

    /**
     * 默认分页查询
     *
     * @param userCollectDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody UserCollectDTO userCollectDTO) {
        return ReturnMsg.ok(baseService.basePage(userCollectDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param userCollectDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody UserCollectDTO userCollectDTO) {
        return ReturnMsg.ok(baseService.findList(userCollectDTO));
    }

    @Override
    protected void beforeSave(UserCollectDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        Long videosId = entity.getVideosId();
        VideosDTO id = videosService.getById(videosId);
        if (id != null) {
            Integer collectNum = id.getCollectNum();
            id.setCollectNum(collectNum + 1);
            videosService.updateById(id);
        }
        super.beforeSave(entity);
    }

    @Override
    protected void beforeRemoveById(Long id) throws Exception {
        UserCollectDTO service = this.baseService.getById(id);
        Long videosId = service.getVideosId();
        VideosDTO videosDTO = videosService.getById(videosId);
        if (videosDTO != null) {
            Integer collectNum = videosDTO.getCollectNum();
            videosDTO.setCollectNum(collectNum - 1);
            videosService.updateById(videosDTO);
        }
        super.beforeRemoveById(id);
    }
}

