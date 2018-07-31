package com.micro.cloud.one.service.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@GetMapping("/getUser")
	public String getUser() {
		return setUser();
	}
	
	private String setUser() {
		Map<String, Object> map = new HashMap<>(3);
		map.put("id", 1);
		map.put("userName", "nicholes");
		map.put("realName", "测试");
		map.put("crateDate", new Date());
		try {
			return objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			logger.error("转换json出错：", e);
		}
		return "";
	}
}
