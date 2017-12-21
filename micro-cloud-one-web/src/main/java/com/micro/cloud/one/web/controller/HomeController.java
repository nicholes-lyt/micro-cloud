package com.micro.cloud.one.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("")
	public String index() {
		return "home/index";
	}
	
	@Value("${spring.demo.test}")
    String port;
	
	@ResponseBody
	@GetMapping("/hi")
    public String home(@RequestParam String name) {
		logger.debug("Logger Level ：DEBUG");
		logger.info("Logger Level ：INFO");
		logger.error("Logger Level ：ERROR");
        return "hi "+name+",i am from port:" +port;
    }
}
