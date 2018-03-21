package com.example.demo.run.Service;/*
   User: wuwen
   Date: 2018-03-21
   Time: 16-43
   备注：
    
    
    
 */

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.run.Dao.user_info_Dao;
import com.example.demo.run.Entity.user_info;

@Service
public class user_info_Service {
    @Autowired
    private user_info_Dao user_info_dao;

    public boolean add_user_info(user_info user_info, JSONObject jsonObject) {

        user_info.setOpenid(jsonObject.getString("openid"));
        user_info.setNickname(jsonObject.getString("nickname"));
        user_info.setName("吴文");
        user_info.setSex(jsonObject.getString("sex"));
        user_info.setCity(jsonObject.getString("city"));
        user_info.setProvince(jsonObject.getString("province"));
        user_info.setCountry(jsonObject.getString("country"));
        user_info.setHeadimgurl(jsonObject.getString("headimgurl"));
        user_info.setSubscribe(jsonObject.getString("subscribe"));
        return user_info_dao.add_user_info(user_info);
    }
/*
根据openid查询用户是否存在
 */
    public user_info find_user_info(user_info user_info) {
        return user_info_dao.find_user_info(user_info);
    }
}
