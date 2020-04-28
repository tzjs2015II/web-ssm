package com.wgl.controller;

import com.wgl.model.Test;
import com.wgl.service.TestService;
import org.codehaus.jackson.map.ObjectMapper;
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

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response)throws IOException {
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        Integer userId = Integer.parseInt(request.getParameter("id"));
        String testString="";
        Test test = this.testService.selectTest(testString);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(test));
        response.getWriter().close();
    }

}
