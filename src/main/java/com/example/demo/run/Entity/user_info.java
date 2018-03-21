package com.example.demo.run.Entity;/*
   User: wuwen
   Date: 2018-03-21
   Time: 16-17
   备注：用户的基本信息
    
    
    
 */

public class user_info {
    private String openid;  //用户的ID,由微信生成
    private String nickname; //用户的昵称，用户的微信名
    private String name;//别名(由我们自己输入)
    private String sex;//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    private String city;//用户所在城市
    private String province;//	用户所在国家
    private String country;//用户所在省份
    private String headimgurl;//用户头像
    private String subscribe;//用户是否关注了公众号，没有关注0，关注为1

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }
}
