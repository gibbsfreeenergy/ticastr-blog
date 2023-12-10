package com.wzh.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzh.blog.dto.TicketDTO;
import com.wzh.blog.entity.Ticket;
import com.wzh.blog.vo.PageResult;
import com.wzh.blog.vo.TicketVO;

import java.util.List;


/**
 * 车票查询
 *
 * @author yezhiqiu
 * @date 2023/12/10
 */
public interface TicketService extends IService<Ticket> {


    List<TicketDTO> listTickets();

    void saveOrUpdateTalk(TicketVO ticketVO);

}
