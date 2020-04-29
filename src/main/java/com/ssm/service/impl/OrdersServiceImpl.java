package com.ssm.service.impl;

import com.ssm.dao.OrdersMapper;
import com.ssm.model.Orders;
import com.ssm.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public void addOrders(Orders orders) {
        this.ordersMapper.addOrders(orders);
    }
}
