package com.example.luckymoney.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.luckymoney.domain.Luckymoney;
import com.example.luckymoney.repository.LuckymoneyRepository;

/**
 * 
 * @author 联想
 *
 */
@Service
public class LuckymoneyService {
	
	@Autowired //写入数据库
	private LuckymoneyRepository repository;

	/**
	 * 事务   指数据库事务（由多个步骤组成的一件事，要么成功，要么失败）
	 * @Transactional
	 */
	@Transactional
	public void createTwo() {
		Luckymoney luckymoney1 = new Luckymoney();
		luckymoney1.setProducer("jkchen");  
		luckymoney1.setMoney(new BigDecimal(50));
		//保存到数据库
		repository.save(luckymoney1);
		
		Luckymoney luckymoney2 = new Luckymoney();
		luckymoney2.setProducer("jkchen");  
		luckymoney2.setMoney(new BigDecimal(3330));
		//保存到数据库
		repository.save(luckymoney2);
		
	}
	
}
