package com.ccab;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class TestController {


    @Autowired
    private PersentProperties persentProperties;


    @RequestMapping(path="/hello",method = RequestMethod.GET)
    public String First(){
        return persentProperties.toString() ;
    }
}
