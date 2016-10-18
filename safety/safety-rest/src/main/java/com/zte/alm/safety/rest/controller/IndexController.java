package com.zte.alm.safety.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 10115916 on 2016/7/13 0013.
 */
@Controller
public class IndexController {
    @RequestMapping("api")
    public String Index(){
        return "index";
    }

}
