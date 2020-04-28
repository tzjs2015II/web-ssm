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
     *  测试查询全部接口
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/goodsSelectAll.do")
    public void goodsSelectAll(HttpServletRequest request, HttpServletResponse response)throws IOException {
        List<Goods> goodsList = this.goodsService.selectGoodsAll();
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(goodsList));
        response.getWriter().close();
    }
}