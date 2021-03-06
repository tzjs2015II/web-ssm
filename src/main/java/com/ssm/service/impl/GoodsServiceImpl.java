package com.ssm.service.impl;

import com.ssm.dao.GoodsMapper;
import com.ssm.model.Goods;
import com.ssm.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectGoodsAll() {
        return this.goodsMapper.selectGoodsAll();

    }

    @Override
    public List<Goods> selectGoodsByName(String goodsName) {
        return this.goodsMapper.selectGoodsByName(goodsName);
    }

    @Override
    public Goods selectGoodsById(Long goodsId) {
        return this.goodsMapper.selectGoodsById(goodsId);
    }

    @Override
    public void updateGoods(Goods goods) {
        this.goodsMapper.updateGoods(goods);
    }

}