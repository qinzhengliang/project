package com.tenkent.point.mall.repository.dao;

import java.util.Date;
import java.util.List;

import com.tenkent.point.mall.repository.entity.PointTestL;
import org.apache.ibatis.annotations.Param;

public interface PointTestDao {

	PointTestL queryById(@Param("testId") int testId, @Param("userPhone") long userPhone);

	List<PointTestL> queryAll();

	int updateTime(@Param("testId") int testId, @Param("userPhone") int userPhone, @Param("endTime") Date createTime);
}