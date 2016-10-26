package com.tenkent.point.mail.service;

import com.tenkent.point.mall.repository.dao.PointTestDao;
import com.tenkent.point.mall.repository.dao.PointTestMapper;
import com.tenkent.point.mall.repository.entity.PointTest;
import com.tenkent.point.mall.repository.entity.PointTestL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class TestDaoTest {

	@Autowired
	private PointTestDao pointTestDao;

	//@Autowired
	//private PointTestMapper pointTestMapper;

	@Test
	public void testQueryById() {

		/*
		PointTest tt = new PointTest();
		tt.setTestId(10001);
		tt.setUserPhone(13451876050L);
		tt = pointTestMapper.selectOne(tt);
*/
		PointTestL pointTest = pointTestDao.queryById(10001,13451876050L);
		System.out.println(pointTest);
	}

	@Test
	public void testQueryAll() {

		List<PointTestL> list = pointTestDao.queryAll();
		for (PointTestL tt : list){
			System.out.println(tt);
		}
	}

	@Test
	public void testUpdateTime() {
		System.out.println("aaa");
	}

}
