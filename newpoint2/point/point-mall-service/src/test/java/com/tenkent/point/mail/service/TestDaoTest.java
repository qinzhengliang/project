package com.tenkent.point.mail.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tenkent.point.mall.repository.dao.PointTestDao;
import com.tenkent.point.mall.repository.dao.PointTestMapper;
import com.tenkent.point.mall.repository.entity.PointTest;
import com.tenkent.point.mall.repository.entity.PointTestL;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-mybatis-config.xml", "classpath:spring/spring-service-config.xml" })
public class TestDaoTest {

	@Autowired
	private PointTestDao pointTestDao;

	@Autowired
	private PointTestMapper pointTestMapper;

	@Test
	public void testQueryById() {

		/*
		 * PointTest tt = new PointTest(); tt.setTestId(10001);
		 * tt.setUserPhone(13451876050L); tt = pointTestMapper.selectOne(tt);
		 */
		PointTestL pointTest = pointTestDao.queryById(10001, 13451876050L);
		System.out.println(pointTest);

		PageHelper.startPage(2, 2);

		List<PointTest> list = pointTestMapper.select(null);

		PageInfo<PointTest> pageInfo = new PageInfo<PointTest>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品：" + total);
		for (PointTest pointTest2 : list) {
			System.out.println(pointTest2);
		}
	}

	@Test
	public void testQueryAll() {

		List<PointTestL> list = pointTestDao.queryAll();
		for (PointTestL tt : list) {
			System.out.println(tt);
		}
	}

	@Test
	public void testUpdateTime() {
		System.out.println("aaa");
	}

}
