package com.micro.cloud.one.web.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("one-service")
public interface UserServiceClient {
	
	@GetMapping("/user/getUser")
	String getUser();
	
}
