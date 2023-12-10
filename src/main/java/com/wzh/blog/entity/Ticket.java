package com.wzh.blog.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 车票
 *
 * @author ticastr
 * @date 2023/12/10
 * @since 2023-12-10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_ticket")
public class Ticket {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

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

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
