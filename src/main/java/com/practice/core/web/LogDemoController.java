package com.practice.core.web;


import com.practice.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

//    private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String reqeustURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();

        myLogger.setRequestURL(reqeustURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
