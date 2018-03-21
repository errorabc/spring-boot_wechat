package com.example.demo.run.Entity;/*
   User: wuwen
   Date: 2018-03-20
   Time: 17-47
   备注：
    
    
    
 */

import com.example.demo.run.Dao.Sys_Cofig_Dao;
import com.example.demo.run.Untils.WeixinUtil;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.example.demo.run.Entity.sys_config;


public class Test {


    public static void main(String[] args) throws Exception {
        String accesstoken="8_9rj9evK15Dz5-UB6KyOVQ7as0d_g5R-3eEOY6eQMdepnLDAcfMCrJr12qwmD_MKnmZ-jluTeTUH-mQg7l_C-1baKlMQhD_ivMKI2UFaZtIUh7O85OZHwJmD6YjnNDzk_sQRhlgyQ76H3v0GzIOQfADAVBD";
        String  openid="o_vDO1KnSVBctv8ncZtImjwEh1YM";

       JSONObject jsonObject=WeixinUtil.user_infomation(accesstoken,openid);

    }
}
