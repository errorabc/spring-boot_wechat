package com.example.demo.run.Dao;/*
   User: wuwen
   Date: 2018-03-20
   Time: 13-57
   备注：查询微信的配置参数
    
    
    
 */

import com.example.demo.run.Entity.sys_config;
import org.apache.ibatis.annotations.Param;

public interface Sys_Cofig_Dao {
    sys_config get(sys_config sys_config);//根据名称查询系统配置的参数
}
