package com.google.project.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.google.project.crm.entity.Product;

public interface ProductDao {
	@Select("select * from product")
	List<Product> findAll();
	
	@Insert("insert into product(name,price) values(#{name},#{price})")
	void save(Product p);
	@Delete("delete from product where id=#{id}")
	void delete(int id);
	@Update("update product set name=#{name},price=#{price} where id=#{id}")
	void update(Product p);
}
