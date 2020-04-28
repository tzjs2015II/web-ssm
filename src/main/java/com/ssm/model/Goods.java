package com.ssm.model;

import lombok.Data;

@Data
/**
 * 商品实体
 */
public class Goods {
    /**
     * 商品id
     */
    private Double goodsId;
    /**
     * 售价
     */
    private Double price;
    /**
     * 库存数量
     */
    private int goodsCont;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品类目
     */
    private String goodsMenu;
    /**
     * 类别编码
     */
    private String menuCode;
    /**
     *  商品状态
     */
    private int goodsStuds;

}
