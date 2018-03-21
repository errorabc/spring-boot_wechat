package com.example.demo.run.Service;/*
   User: wuwen
   Date: 2018-03-21
   Time: 09-44
   备注：
    
    
    
 */

import com.example.demo.run.Dao.Sys_Cofig_Dao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Action;

import com.example.demo.run.Entity.sys_config;
import org.springframework.stereotype.Service;

@Service
public class Sys_CofigService {
    @Autowired
    private Sys_Cofig_Dao sys_cofig_dao;

    public sys_config get(sys_config sys_config) {
        return sys_cofig_dao.get(sys_config);
    }
}
