package com.example.demo.run.Dao;/*
   User: wuwen
   Date: 2018-03-15
   Time: 19-23
   备注：
    
    
    
 */

import com.example.demo.run.Entity.device_log;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IndexDao {

    List<device_log> select_all(device_log device_log);

}
