package com.ssm.controller;

import com.ssm.model.Goods;
import com.ssm.model.Orders;
import com.ssm.service.OrdersService;
import com.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private GoodsController goodsController;

    /**
     *  测试添加订单
     * @param request
     * @param response
     */
    @RequestMapping(value="/addOrders.do",produces = "text/plain;charset=utf-8")
    public void addOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        response.setCharacterEncoding("UTF-8");
        Orders orders= new Orders();
        //通过雪花算法生成订单id
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1, 1);
        orders.setOrderId(idWorker.nextId());

        orders.setOrderTime(new Date());

        String[] goodsIdListStr=request.getParameter("goodsId").split(",");
        String[] salesList = request.getParameter("sales").split(",");
        //确定商品库存
        for(int i=0;i<goodsIdListStr.length;i++){
            Goods goods = goodsController.selectGoodsById(Long.valueOf(goodsIdListStr[i]));
            if(goods.getGoodsCont()< Integer.parseInt(salesList[i])){
                response.getWriter().write(goods.getGoodsName()+"的库存不足");
                response.getWriter().close();
                return;
            }
        }
        for(int i=0;i<goodsIdListStr.length;i++){
            Goods goods = goodsController.selectGoodsById(Long.valueOf(goodsIdListStr[i]));
            //计算总价
            orders.setAmount(Double.parseDouble(salesList[i]) * goods.getPrice());
            //设置商品数量
            orders.setSales(Integer.parseInt(salesList[i]));
            //获取商品id
            orders.setGoodsId(goods.getGoodsId());
            //映射商品价格
            orders.setPrice(goods.getPrice());
            //写入订单数据库
            this.ordersService.addOrders(orders);
            //修改goods表库存
            this.goodsController.updateGoods(goods.getGoodsId(),orders.getSales());
            response.getWriter().write("交易成功");
            response.getWriter().close();
        }
    }
}
