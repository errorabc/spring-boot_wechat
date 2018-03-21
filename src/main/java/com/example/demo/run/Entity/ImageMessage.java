package com.example.demo.run.Entity;/*
   User: wuwen
   Date: 2018-03-20
   Time: 09-37
   备注：图片消息类
    
    
    
 */

public class ImageMessage  extends  BaseMessage{
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
