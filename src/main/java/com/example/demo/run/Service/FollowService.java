package com.example.demo.run.Service;/*
   User: wuwen
   Date: 2018-03-20
   Time: 13-45
   备注：回复关注信息
    
    
    
 */

import com.example.demo.run.Dao.Sys_Cofig_Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.run.Entity.sys_config;

@Service
public class FollowService {
    @Autowired
    private Sys_Cofig_Dao sys_cofig_dao;

    public sys_config get(sys_config sys_config) {
        sys_config.setName("FoFollow_Reply");
        return sys_cofig_dao.get(sys_config);
    }
}
