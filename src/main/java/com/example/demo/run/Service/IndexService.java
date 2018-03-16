package com.example.demo.run.Service;/*
   User: wuwen
   Date: 2018-03-15
   Time: 19-26
   备注：
    
    
    
 */

import com.example.demo.run.Dao.IndexDao;
import com.example.demo.run.Entity.device_log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    @Autowired
    private IndexDao indexDao;

    public List<device_log> select_all(device_log device_log) {
        return indexDao.select_all(device_log);
    }
}
