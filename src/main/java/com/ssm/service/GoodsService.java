package com.ssm.service;

import com.ssm.model.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> selectGoodsAll ();

    List<Goods> selectGoodsByName(String goodsName);

    Goods selectGoodsById(Long goodsId);

    void updateGoods(Goods goods);
}
