package com.wzh.blog.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzh.blog.dto.TicketDTO;
import com.wzh.blog.entity.Ticket;
import com.wzh.blog.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 车票
 *
 * @author yezhiqiu
 * @date 2022/01/23
 */
@Repository
public interface TicketDao extends BaseMapper<Ticket> {



    default List<TicketDTO> listTickets(LambdaQueryWrapper<Ticket> wrapper) {
        return this.selectList(wrapper).stream()
                .map(ticket -> {
                    TicketDTO ticketDTO = new TicketDTO();
                    // 假设有一个名为 TicketDTO 的类，包含与 Ticket 类相同的字段，并且有相应的 getter 和 setter 方法
                    // 你可能需要根据实际情况进行字段的映射
                    ticketDTO.setId(ticket.getId());
                    ticketDTO.setUserId(ticket.getUserId());
                    ticketDTO.setDeparture(ticket.getDeparture());
                    ticketDTO.setDestination(ticket.getDestination());
                    ticketDTO.setDepartureTime(ticket.getDepartureTime());
                    ticketDTO.setArrivalTime(ticket.getArrivalTime());
                    ticketDTO.setDuration(ticket.getDuration());
                    ticketDTO.setSeat(ticket.getSeat());
                    ticketDTO.setTrainNumber(ticket.getTrainNumber());
                    ticketDTO.setHappy(ticket.isHappy());
                    ticketDTO.setMemo(ticket.getMemo());
                    return ticketDTO;
                })
                .collect(Collectors.toList());
    }
}




