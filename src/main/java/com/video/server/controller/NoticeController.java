package com.video.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.video.server.common.BaseController;
import com.video.server.common.BaseSelectEntity;
import com.video.server.common.ReturnMsg;
import com.video.server.dto.NoticeDTO;
import com.video.server.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 公告信息表对外接口层
 * @author: wuming
 */
@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController<NoticeService, NoticeDTO> {

    @Override
    @Resource(name = "noticeService")
    protected void setBaseService(NoticeService noticeService) {
        this.baseService = noticeService;
    }

    /**
     * 默认分页查询
     *
     * @param noticeDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody NoticeDTO noticeDTO) {
        return ReturnMsg.ok(baseService.basePage(noticeDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param noticeDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody NoticeDTO noticeDTO) {
        return ReturnMsg.ok(baseService.findList(noticeDTO));
    }

    @Override
    protected void beforeSave(NoticeDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    /**
     * 首页推荐
     * @return
     */
    @GetMapping("/new")
    public ReturnMsg getNewNotice() {
        LambdaQueryWrapper<NoticeDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(NoticeDTO::getType,1);
        queryWrapper.orderByDesc(NoticeDTO::getCreateTime);
        return ReturnMsg.ok(this.baseService.list(queryWrapper));
    }

}
