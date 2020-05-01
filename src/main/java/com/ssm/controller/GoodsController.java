package com.ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.model.Goods;
import com.ssm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     *  测试查询全部物品接口
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/goodsSelectAll.do")
    public void goodsSelectAll(HttpServletRequest request, HttpServletResponse response)throws IOException {
        List<Goods> goodsList = this.goodsService.selectGoodsAll();
        ObjectMapper mapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(mapper.writeValueAsString(goodsList));
        response.getWriter().close();
    }

    /**
     *  测试模糊查询物品接口
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/goodsSelectByName.do")
    public void goodsSelectByName(HttpServletRequest request, HttpServletResponse response)throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String goodsName = request.getParameter("goodsName");
        List<Goods> goodsList = this.goodsService.selectGoodsByName(goodsName);

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(goodsList));
        response.getWriter().close();
    }

    /**
     *  通过id查询物品信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/selectGoodsByIdResponse.do")
    public void selectGoodsByIdResponse(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setCharacterEncoding("UTF-8");
        Long goodsId= Long.valueOf(request.getParameter("goodsId"));
        Goods goods = this.goodsService.selectGoodsById(goodsId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(goods));
        response.getWriter().close();
    }


//---------------------------------------------------------------------------------------

    /**
     * 内部查询
     * @param goodsId
     * @return
     */
    public Goods selectGoodsById(Long goodsId){
        Goods goods = this.goodsService.selectGoodsById(goodsId);
        return goods;
    }

    /**
     *  更新库存
     * @param goodsId
     * @param goodsCont
     */
    public void updateGoods(Long goodsId,int goodsCont){
        Goods goods = selectGoodsById(goodsId);
        int goodsContNew= goods.getGoodsCont()-goodsCont;
        goods.setGoodsCont(goodsContNew);
        this.goodsService.updateGoods(goods);
    }
}
