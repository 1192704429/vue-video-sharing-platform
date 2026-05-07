package com.video.server.controller;

import com.video.server.common.BaseController;
import com.video.server.common.ReturnMsg;
import com.video.server.dto.VideoCommentDTO;
import com.video.server.service.VideoCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
import java.util.stream.Collectors;

/**
* @description: 视频评价管理对外接口层
* @author: video
* @create: 2025.02.24 15:27:22
*/
@RestController
@RequestMapping("/videoComment")
public class VideoCommentController extends BaseController<VideoCommentService, VideoCommentDTO> {


    @Override
    @Resource(name = "videoCommentService")
    protected void setBaseService(VideoCommentService videoCommentService) {
        this.baseService = videoCommentService;
    }

    /**
    * 默认分页查询
    * @param videoCommentDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody VideoCommentDTO videoCommentDTO) {
        return ReturnMsg.ok(baseService.basePage(videoCommentDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param videoCommentDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody VideoCommentDTO videoCommentDTO) {
        return ReturnMsg.ok(baseService.findList(videoCommentDTO));
    }

    @PostMapping(value = "/findList1")
    public ReturnMsg findList1(@RequestBody VideoCommentDTO videoCommentDTO) {
        List<VideoCommentDTO> videoCommentDTOS = baseService.findList(videoCommentDTO);
        List<VideoCommentDTO> uniqueList = videoCommentDTOS.stream()
                .collect(Collectors.toMap(VideoCommentDTO::getVideosId, dto -> dto, (existing, replacement) -> existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        return ReturnMsg.ok(uniqueList);
    }

    @Override
    protected void beforeSave(VideoCommentDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @PostMapping(value = "/allComments")
    public ReturnMsg allComments(@RequestBody VideoCommentDTO commentsDTO) {
        List<VideoCommentDTO> baseServiceList = baseService.findList(commentsDTO);
        if (CollectionUtil.isNotEmpty(baseServiceList)) {
            for (VideoCommentDTO dto : baseServiceList) {
                VideoCommentDTO query = new VideoCommentDTO();
                query.setParentId(dto.getId());
                dto.setVideoCommentDTOList(this.baseService.findList(query));
            }
        }
        return ReturnMsg.ok(baseServiceList);
    }

}

