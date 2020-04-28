package com.ssm.service.impl;

import com.ssm.dao.TestMapper;
import com.ssm.model.Test;
import com.ssm.service.TestService;
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
