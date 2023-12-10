package com.wzh.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzh.blog.dao.TicketDao;
import com.wzh.blog.dao.UserInfoDao;
import com.wzh.blog.dto.MessageDTO;
import com.wzh.blog.dto.TicketDTO;
import com.wzh.blog.entity.Message;
import com.wzh.blog.entity.Ticket;
import com.wzh.blog.entity.UserInfo;
import com.wzh.blog.service.TicketService;
import com.wzh.blog.util.BeanCopyUtils;
import com.wzh.blog.util.UserUtils;
import com.wzh.blog.vo.PageResult;
import com.wzh.blog.vo.TicketVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wzh.blog.util.CommonUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.wzh.blog.constant.CommonConst.TRUE;


/**
 * 车票查询
 *
 * @author ticastr
 * @date 2023/12/10
 */
@Service
public class TicketServiceImpl extends ServiceImpl<TicketDao, Ticket> implements TicketService {

    @Autowired
    TicketDao ticketDao;

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public List<TicketDTO> listTickets() {
        LambdaQueryWrapper<Ticket> ticketWrapper = new LambdaQueryWrapper<>();
        ticketWrapper.select(Ticket::getId, Ticket::getUserId, Ticket::getDeparture, Ticket::getDestination, Ticket::getDepartureTime
                , Ticket::getArrivalTime, Ticket::getDuration, Ticket::getSeat, Ticket::getTrainNumber, Ticket::isHappy, Ticket::getMemo).orderByDesc(Ticket::getCreateTime);
        List<TicketDTO> ticketList = ticketDao.listTickets(ticketWrapper);
        ticketList.stream().map(ticketDTO -> {
            UserInfo userInfo = userInfoDao.selectById(ticketDTO.getUserId());
            ticketDTO.setAvatar(userInfo.getAvatar());
            ticketDTO.setNickname(userInfo.getNickname());
            return ticketDTO;
        }).collect(Collectors.toList());
        return BeanCopyUtils.copyList(ticketList, TicketDTO.class);
    }

    @Override
    public void saveOrUpdateTalk(TicketVO ticketVO) {
        Ticket ticket = BeanCopyUtils.copyObject(ticketVO, Ticket.class);
        ticket.setUserId(UserUtils.getLoginUser().getUserInfoId());
        String duration = CommonUtils.getDuration(ticket.getArrivalTime(), ticket.getDepartureTime());
        ticket.setDuration(duration);

        this.saveOrUpdate(ticket);
    }

}




