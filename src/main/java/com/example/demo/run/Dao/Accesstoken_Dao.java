package com.example.demo.run.Dao;/*
   User: wuwen
   Date: 2018-03-20
   Time: 18-14
   备注：
    
    
    
 */

import com.example.demo.run.Entity.AccessToken;

public interface Accesstoken_Dao {

    boolean Add_Accesstoken(AccessToken accessToken);  //添加Accesstoken

    AccessToken find_Accesstoken(AccessToken accessToken);  //查询Accesstoken

    boolean update_token(AccessToken accessToken);//修改Accesstoken
}
