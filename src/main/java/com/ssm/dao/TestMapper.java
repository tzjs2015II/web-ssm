package com.ssm.dao;

import com.ssm.model.Test;

public interface TestMapper {
    Test selectTest(String testStr);
}
