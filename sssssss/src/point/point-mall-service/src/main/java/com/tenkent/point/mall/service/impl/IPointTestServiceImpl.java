package com.tenkent.point.mall.service.impl;

import com.tenkent.point.mall.repository.dao.PointTestDao;
import com.tenkent.point.mall.repository.entity.PointTestL;
import com.tenkent.point.mall.service.IPointTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
@Service
public class IPointTestServiceImpl implements IPointTestService {

    @Autowired
    private PointTestDao pointTestDao;

    @Override
    public List<PointTestL> getAll() {
        return pointTestDao.queryAll();
    }
}
