package com.video.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.video.server.common.BaseController;
import com.video.server.common.ReturnMsg;
import com.video.server.dto.NoticeDTO;
import com.video.server.dto.UserCollectDTO;
import com.video.server.dto.VideosDTO;
import com.video.server.dto.LikesDTO;
import com.video.server.service.VideosService;
import com.video.server.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: 后台用户管理对外接口层
 * @author: video
 * @create: 2025.02.24 15:27:22
 */
@RestController
@RequestMapping("/likes")
public class LikesController extends BaseController<LikesService, LikesDTO> {
    @Autowired
    private VideosService videosService;

    @Override
    @Resource(name = "likesService")
    protected void setBaseService(LikesService likesService) {
        this.baseService = likesService;
    }


    /**
     * 默认分页查询
     *
     * @param likesDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody LikesDTO likesDTO) {
        return ReturnMsg.ok(baseService.basePage(likesDTO));
    }


    /**
     * 根据XML中的sql语句进行查询
     *
     * @param noticeDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody LikesDTO noticeDTO) {
        return ReturnMsg.ok(baseService.findList(noticeDTO));
    }

    @Override
    protected void beforeSave(LikesDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        Long videosId = entity.getVideoId();
        VideosDTO id = videosService.getById(videosId);
        if (id != null) {
            Integer collectNum = id.getClickNum();
            id.setClickNum(collectNum + 1);
            videosService.updateById(id);
        }
        super.beforeSave(entity);
    }

    @RequestMapping("/checkLike")
    public ReturnMsg checkLike(@RequestBody LikesDTO likesDTO) {
        LambdaQueryWrapper<LikesDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LikesDTO::getUserId, likesDTO.getUserId()).eq(LikesDTO::getVideoId, likesDTO.getVideoId());
        return ReturnMsg.ok(this.baseService.count(queryWrapper) > 0);
    }

    @RequestMapping("/del/like")
    public ReturnMsg delLikes(@RequestBody LikesDTO likesDTO) {
        LambdaQueryWrapper<LikesDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LikesDTO::getUserId, likesDTO.getUserId()).eq(LikesDTO::getVideoId, likesDTO.getVideoId());
        this.baseService.remove(queryWrapper);
        Long videosId = likesDTO.getVideoId();
        VideosDTO videosDTO = videosService.getById(videosId);
        if (videosDTO != null) {
            Integer collectNum = videosDTO.getClickNum();
            videosDTO.setClickNum(collectNum + 1);
            videosService.updateById(videosDTO);
        }
        return ReturnMsg.ok();
    }

}

