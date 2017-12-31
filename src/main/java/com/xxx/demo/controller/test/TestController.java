package com.xxx.demo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author:@luomouren.
 * @Date:2017-12-31 18:43
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private static String PAGE_FILE_NAME = "test/";
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/demo")
    public String test(ModelMap map) {
        map.put("host","xxxSpringBootDemo");
        return PAGE_FILE_NAME+"test";
    }
}
