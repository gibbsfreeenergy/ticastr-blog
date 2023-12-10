package com.wzh.blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 说说
 *
 * @author yezhiqiu
 * @date 2022/01/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "车票对象")
public class TicketVO {

    /**
     * 说说id
     */
    @ApiModelProperty(name = "id", value = "车票id", dataType = "Integer")
    private Integer id;

    /**
     * 始发站
     */
    @ApiModelProperty(name = "departure", value = "始发站", dataType = "String")
    @NotBlank(message = "始发站不能为空")
    private String departure;

    /**
     * 终点站
     */
    @ApiModelProperty(name = "destination", value = "终点站", dataType = "String")
    @NotBlank(message = "终点站不能为空")
    private String destination;

    /**
     * 出发时间
     */
    @ApiModelProperty(name = "departureTime", value = "出发时间", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date departureTime;

    /**
     * 到达时间
     */
    @ApiModelProperty(name = "arrivalTime", value = "到达时间", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date arrivalTime;


    /**
     * 车次
     */
    @ApiModelProperty(name = "trainNumber", value = "车次", dataType = "String")
    @NotBlank(message = "车次不能为空")
    private String trainNumber;

    /**
     * 座位
     */
    @ApiModelProperty(name = "seat", value = "座位", dataType = "String")
    @NotBlank(message = "座位不能为空")
    private String seat;

    /**
     * 是否开心
     */
    @ApiModelProperty(name = "happy", value = "是否开心", dataType = "Boolean")
    private boolean happy;

    /**
     * 说明
     */
    @ApiModelProperty(name = "memo", value = "说明", dataType = "String")
    private String memo;

}
