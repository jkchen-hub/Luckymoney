package com.example.luckymoney.domain;

import java.io.Serializable;
//import javax.persistence.*;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *    创建数据库表Luckymoney
 * @author 联想
 *
 */
@Entity  //实体
//@Table(name="Luckymoney")//对应数据库的表，可有可无。没有就默认类名（Luckymoney）为数据库中的表名
public class Luckymoney implements Serializable {
    private static final long serialVersionUID = 1L;//版本号

	@Id   //主键
	@GeneratedValue //自增
	/**
	 * @Column(name = "id")
	 * 对应表中的列，可有可无，没有就默认id为数据库中的列名
	 * **Note：name="id"中的"id"表示数据库中的字段名，
	 * 而private Integer id中的id是实体中的变量名，
	 * 这里的两个"id"可以用不同的字符来代替，下同
	 */	
	
	private Integer id;
	
//	@Column(name = "money")
	private BigDecimal money;
	
	//发送方
//	@Column(name = "producer")
	private String producer;
	
	//接收方
//	@Column(name = "consumer")
	private String consumer;
	
	/**
	 * 必须含有空的构造方法
	 */
	public Luckymoney() {
		
	}

	/**
	 * 可以含有有参构造函数
	 * @param id
	 * @param money
	 * @param producer
	 * @param consumer
	 */
	public Luckymoney(Integer id, BigDecimal money, String producer, String consumer) {
		super();
		this.id = id;
		this.money = money;
		this.producer = producer;
		this.consumer = consumer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}
	
	
	/*
	 * private String description;
	 * 
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 * 
	 * public BigDecimal getMoney() { return money; }
	 * 
	 * public void setMoney(BigDecimal money) { this.money = money; }
	 * 
	 * public String getDescription() { return description; }
	 * 
	 * public void setDescription(String description) { this.description =
	 * description; }
	 */
	
	
}
