package com.google.project.crm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.google.project.crm.dao.ProductDao;
import com.google.project.crm.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrmAppApplicationTests {
	@Autowired
	private ProductDao pDao;
	@Test
	public void contextLoads() {
		pDao.save(new Product("clover", 100));
		System.out.println(pDao.findAll());
	}
	@Test
	public void contexads() {
		PageHelper.startPage(1, 3);
		System.out.println(pDao.findAll());
	}
}
