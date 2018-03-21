package com.example.demo.run.Entity;/*
   User: wuwen
   Date: 2018-03-20
   Time: 13-55
   备注：系统参数配置表
    
    
    
 */

public class sys_config {
    private String id;  //id
    private String parameter;//参数
    private String name;  //配置名称
    private String describe; //配置描述

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
