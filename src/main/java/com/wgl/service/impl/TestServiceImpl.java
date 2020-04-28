package com.wgl.service.impl;

import com.wgl.dao.TestMapper;
import com.wgl.model.Test;
import com.wgl.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("testService")
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;

    @Override
    public Test selectTest(String testStr) {
        return this.testMapper.selectTest(testStr);

    }
}
