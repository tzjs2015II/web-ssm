package com.ssm.dao;

import com.ssm.model.Goods;

import java.util.List;

public interface GoodsMapper {
    List<Goods> selectGoodsAll();

    List<Goods> selectGoodsByName(String goodsName);
}
