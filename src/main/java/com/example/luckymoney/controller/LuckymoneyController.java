package com.example.luckymoney.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.luckymoney.domain.Luckymoney;
import com.example.luckymoney.repository.LuckymoneyRepository;
import com.example.luckymoney.service.LuckymoneyService;


/**
 * 
 * @author 联想
 *
 */
@RestController 
public class LuckymoneyController {

	@Autowired
	private LuckymoneyRepository repository;
	
	
	@Autowired
	private LuckymoneyService service;
	
	/**
	 * 获取所有红包列表  —— GET接口         查（所有）
	 */
	@GetMapping("/luckymoneys")
	public List<Luckymoney> list(){
		return repository.findAll();
	}
	
	/**
	 * 创建红包（发红包） —— POST接口      增
	 */
	@PostMapping("/luckymoneys")
	//这里面只给数据库中的字段producer和money赋值，其实还有consumer也可以加上，不加的话就为null值
	public Luckymoney create(@RequestParam("producer") String producer,
							 @RequestParam("money") BigDecimal money) {
		Luckymoney luckymoney = new Luckymoney();//实例化Luckymoney实体类对象
		/**
		 * 通过实体类的setter方法，贱传进来的参数producer和money数据赋值给对应的属性
		 */
		luckymoney.setProducer(producer);  
		luckymoney.setMoney(money);
		return repository.save(luckymoney);  //save()方法的参数是数据库实体类对象，在这里为Luckymoney的对象
	}
	
	/**
	 * 通过id查询红包    ——GET接口          查（一个）
	 */
	@GetMapping("/luckymoneys/{id}")
	public Luckymoney findById(@PathVariable("id") Integer id) {
		//findById的返回值类型为Optional，如果找不到则返回null
		return repository.findById(id).orElse(null);
	}
	
	/**
	 * 更行红包（领红包） ——PUT（或PATCH）接口       改
	 */
	@PutMapping("/luckymoneys/{id}")
	public Luckymoney put(@PathVariable("id") Integer id,
			              @RequestParam("consumer") String consumer) {
		Optional<Luckymoney> optional = repository.findById(id);
		if (optional.isPresent()) {//是否查找到
			Luckymoney luckymoney = optional.get(); //获取数据库里面的Luckymoney对象
//			luckymoney.setId(id); 
			luckymoney.setConsumer(consumer);//获得查找到的对象，并只修改其consumer属性
			return repository.save(luckymoney);
		}
		else {
			return null;
		}
	}
	
	/**
	 * 删除红包     ——DELETE接口       删
	 */
	@DeleteMapping("/luckymoneys/{id}")
	public String delete(@PathVariable("id") Integer id) {
		Optional<Luckymoney> optional = repository.findById(id);//先根据id查找Luckymoney对象
		if (optional.isPresent()) {//判断是否查找到
			repository.delete(optional.get());//找到了就删除
			return "成功";
		}
		else {
			return "id不存在";
		}
	}
	
	/**
	 * 事务举例
	 */
	@PostMapping("/luckymoneys/two")
	public void createTwo() {
		service.createTwo();
	}
}
				
