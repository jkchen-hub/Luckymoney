package com.example.luckymoney.controller;

//import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.luckymoney.config.LimitConfig;

/**
 * 
 * @author 联想
 *
 */
//@RestController = @Controller + @ResponseBody
@Controller
public class helloController {
	//使用@Value注解，自动注入 配置文件中的minMoney值
//	@Value("${minMoney}")
//	private BigDecimal minMoney;
//	@Value("${maxMoney}")
//	private BigDecimal maxMoney;
//	@Value("${description}")
//	private String description;
	
	
	@Autowired   //自动注入
	private LimitConfig limitConfig;
	
//	@GetMapping({"/hello","/hi"})
	@GetMapping("/hello")
	public String say() {
		return "说明：" + limitConfig.getDescription();
//		return "index";
	}
	
 }
