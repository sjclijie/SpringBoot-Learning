package com.example.chapter1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
    public String index(ModelMap map) {
        map.addAttribute("host", "https://www.suiyueyule.com");
        return "hello";
    }
}
