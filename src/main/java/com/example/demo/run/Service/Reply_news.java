package com.example.demo.run.Service;/*
   User: wuwen
   Date: 2018-03-21
   Time: 14-48
   备注：发送文本消息
    
    
    
 */

import com.example.demo.run.Untils.WeixinUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Reply_news {
    public String Reply_text(String accessToken) {
        String message = "";
        JSONObject json2 = new JSONObject();
        json2.put("content", "hello word");  //消息内容，最内层

        JSONObject json = new JSONObject();
        json.put("touser", "o_vDO1KnSVBctv8ncZtImjwEh1YM");//外层
        json.put("msgtype", "text");
        json.put("text", json2);
        int result = WeixinUtil.message(json, accessToken);

        if (result == 0) {
            message = "发送文本成功";
        } else {
            message = "发送文本失败";
        }

        return message;
    }

    public String Reply_Graphic(String accessToken) {
        String message = "";

        JSONObject json2 = new JSONObject();
        json2.put("title", "这是测试推送图文消息标题");
        json2.put("description", "这是测试推送图文消息内容\n可以换行的\n试试吧");
        json2.put("picurl", "http://d.hiphotos.baidu.com/image/h%3D300/sign=6ee03d3602f41bd5c553eef461db81a0/f9198618367adab45913c15e87d4b31c8601e4e8.jpg");
        json2.put("url", "http://www.baidu.com");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(json2);

        JSONObject json3 = new JSONObject();
        json3.put("articles", jsonArray);

        JSONObject json = new JSONObject();
        json.put("touser", "o_vDO1KnSVBctv8ncZtImjwEh1YM");
        json.put("msgtype", "news");
        json.put("news", json3);


        int result = WeixinUtil.message(json, accessToken);

        if (result == 0) {
            message = "发送图文成功";
        } else {
            message = "发送图文失败";
        }

        return message;
    }
}
