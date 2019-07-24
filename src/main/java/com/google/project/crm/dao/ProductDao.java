package com.google.project.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.google.project.crm.entity.Product;

public interface ProductDao {
	@Select("select * from product")
	List<Product> findAll();
	
	@Insert("insert into product(name,price) values(#{name},#{price})")
	void save(Product p);
	
}
