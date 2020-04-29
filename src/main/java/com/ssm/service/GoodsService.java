package com.ssm.service;

import com.ssm.model.Goods;

import java.util.List;

public interface GoodsService {
    public List<Goods> selectGoodsAll ();

    public List<Goods> selectGoodsByName(String goodsName);
}
