package com.example.demo.run.Controller;/*
   User: wuwen
   Date: 2018-03-15
   Time: 17-48
   备注：
    
    
    
 */

import com.example.demo.run.Service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.run.Entity.device_log;

import java.util.List;

@Controller
public class indexCotroller {
    @Autowired
    private IndexService indexService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "index2/index2";
    }

    @RequestMapping(value = "/index3")
    public String index3(device_log device_log, Model model) {
        List<device_log> device_loglist = indexService.select_all(device_log);
        model.addAttribute("device_loglist", device_loglist);
        return "index2/index3";
    }
}
