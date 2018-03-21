package com.example.demo.run.Controller;/*
   User: wuwen
   Date: 2018-03-19
   Time: 09-27
   备注：
    
    

 */

import com.example.demo.run.Entity.AccessToken;
import com.example.demo.run.Service.*;
import com.example.demo.run.Untils.SignUtil;
import com.example.demo.run.Untils.WeixinUtil;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.run.Entity.sys_config;
import com.example.demo.run.Entity.user_info;

@RestController
@RequestMapping("")
public class CoreController {
    @Autowired
    private CoreService coreService;
    @Autowired
    private Sys_CofigService sys_cofigService;
    @Autowired
    private Accesstoken_Service accesstoken_service;
    @Autowired
    private Reply_news reply_news;
    @Autowired
    private user_info_Service user_info_service;
    //增加日志
    private static Logger log = LoggerFactory.getLogger(CoreController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String checkSignature(@RequestParam(name = "signature", required = false) String signature,
                                 @RequestParam(name = "nonce", required = false) String nonce,
                                 @RequestParam(name = "timestamp", required = false) String timestamp,
                                 @RequestParam(name = "echostr", required = false) String echostr) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        sys_config sys_config = new sys_config();
        sys_config.setName("token");
        sys_config = sys_cofigService.get(sys_config);

        String token = sys_config.getParameter();
        System.out.println(token + "  " + "token");
        if (SignUtil.checkSignature(signature, timestamp, nonce, token)) {
            log.info("接入成功");
            return echostr;
        }
        log.error("接入失败");
        return "";
    }

    // 调用核心业务类接收消息、处理消息跟推送消息
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(HttpServletRequest req) {
        String respMessage = coreService.processRequest(req);
        System.out.println(respMessage);
        return respMessage;
    }

    /*
    获取最新的accesstoken
     */
    @RequestMapping(value = "/getaccesstoken")
    public String getaccesstoken(AccessToken accessToken) {

        String getaccessToken = accesstoken_service.Add_Accesstoken(accessToken);
        System.out.println("获取的accesstoken值为" + getaccessToken);
        return "";
    }

    /*
    推送文本消息
     */
    @RequestMapping(value = "/Reply_text")
    public String Reply_text(AccessToken accessToken) {
        //获取最新的accesstoken
        String getaccessToken = accesstoken_service.Add_Accesstoken(accessToken);
        String message = reply_news.Reply_text(getaccessToken);

        System.out.println(message);
        return "";
    }
    /*
    推送图文消息
     */

    @RequestMapping(value = "/Reply_Graphic")
    public String Reply_Graphic(AccessToken accessToken) {
        //获取最新的accesstoken
        String getaccessToken = accesstoken_service.Add_Accesstoken(accessToken);

        String message = reply_news.Reply_Graphic(getaccessToken);
        System.out.println(message);
        return "";
    }

    /*
   根据用户的openid获取用户的信息
     */
    @RequestMapping(value = "/get_user_information")
    public String get_user_information(AccessToken accessToken, user_info user_info) {
        //获取最新的accesstoken
        String getaccessToken = accesstoken_service.Add_Accesstoken(accessToken);
        String openid = "o_vDO1OCRKaEc6_9rvn6MqGyIVWk";
        //获取用户的信息
        JSONObject jsonObject = WeixinUtil.user_infomation(getaccessToken, openid);

        //把用户的信息保存到数据库中去
        if (user_info_service.add_user_info(user_info, jsonObject)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

        return "";
    }

}
