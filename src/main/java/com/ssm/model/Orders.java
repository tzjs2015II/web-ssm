package com.ssm.model;

import lombok.Data;
import java.util.Date;

@Data
/**
 *  订单实体
 */
public class Orders {
    /**
     * 订单id
     */
    private Double orderId;
    /**
     * 商品id
     */
    private Double goodsId;
    /**
     * 商品售价
     */
    private Double price;
    /**
     * 销售数量
     */
    private int sales;
    /**
     * 消费金额
     */
    private Double amount;
    /**
     * 消费产生的时间
     */
    private Date orderTime;
}
