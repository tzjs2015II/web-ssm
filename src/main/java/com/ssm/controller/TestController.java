package com.ssm.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.model.Test;
import com.ssm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/testShow.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response)throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String testString=request.getParameter("test");
        testString="1";
        Test test = this.testService.selectTest(testString);

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write("测试回传信息|| test msg");
        response.getWriter().close();
    }

}
