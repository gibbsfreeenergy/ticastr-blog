package com.wzh.blog.controller;

import com.wzh.blog.dto.ArchiveDTO;
import com.wzh.blog.dto.TicketDTO;
import com.wzh.blog.service.TicketService;
import com.wzh.blog.vo.PageResult;
import com.wzh.blog.vo.Result;
import com.wzh.blog.vo.TalkVO;
import com.wzh.blog.vo.TicketVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 车票控制器
 *
 * @author ticastr
 * @date 2023/12/10
 */
@Api(tags = "车票模块")
@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @ApiOperation(value = "查询所有车票")
    @GetMapping("/tickets")
    public Result<List<TicketDTO>> listTickets() {
        return Result.ok(ticketService.listTickets());
    }

    @ApiOperation(value = "保存或修改车票")
    @PostMapping("/admin/tickets")
    public Result<?> saveOrUpdateTalk(@Valid @RequestBody TicketVO ticketVO) {
        ticketService.saveOrUpdateTalk(ticketVO);
        return Result.ok();
    }

}
