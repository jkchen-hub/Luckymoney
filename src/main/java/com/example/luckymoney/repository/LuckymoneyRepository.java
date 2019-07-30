package com.example.luckymoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.luckymoney.domain.Luckymoney;

/**
 * 新建接口继承JpaRepository，实现数据库操作
 * @author 联想
 * @param Luckymoney 数据库实体类
 *        Integer    数据库实体类中id的类型
 */
public interface LuckymoneyRepository extends JpaRepository<Luckymoney, Integer>{

}
