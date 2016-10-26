package com.tenkent.point.mall.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tenkent.point.mall.repository.entity.PointTestL;
import com.tenkent.point.mall.service.IPointTestService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/point")
@Api(value = "/point", description="point Api")
public class PointTestController {

    @Autowired
    IPointTestService iPointTestService;

    @RequestMapping(value = "/test/{who}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取列表", httpMethod = "GET", response = List.class)
    public List<PointTestL> test( @ApiParam(required = true, name = "who", value = "who") @PathVariable("who") String who)
    {
        System.out.print(who);
        List<PointTestL> aa = iPointTestService.getAll();
        return aa;
    }
}
