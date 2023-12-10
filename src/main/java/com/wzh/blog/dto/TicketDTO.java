package com.wzh.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 车票dto
 *
 * @author yezhiqiu
 * @date 2022/01/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDTO {

    /**
     * 车票id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 始发站
     */
    private String departure;

    /**
     * 终点站
     */
    private String destination;

    /**
     * 出发时间
     */
    private Date departureTime;

    /**
     * 到达时间
     */
    private Date arrivalTime;

    /**
     * 历时
     */
    private String duration;

    /**
     * 车次
     */
    private String trainNumber;

    /**
     * 座位
     */
    private String seat;

    /**
     * 是否开心
     */
    private boolean happy;

    /**
     * 说明
     */
    private String memo;

}
