package com.example.demo.run.Dao;/*
   User: wuwen
   Date: 2018-03-21
   Time: 16-36
   备注：操作用户的信息
    
    
    
 */
import com.example.demo.run.Entity.user_info;

public interface user_info_Dao {

     boolean add_user_info(user_info user_info);   //添加用户的信息

      user_info  find_user_info(user_info user_info);  //查询用户的信息


}
