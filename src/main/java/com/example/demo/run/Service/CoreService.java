package com.example.demo.run.Service;/*
   User: wuwen
   Date: 2018-03-19
   Time: 09-59
   备注：
    
    
    
 */

import com.example.demo.run.Dao.CoreDao;
import com.example.demo.run.Entity.Article;
import com.example.demo.run.Entity.NewsMessage;
import com.example.demo.run.Untils.WeixinUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.run.Untils.MessageUtil;
import com.example.demo.run.Entity.TextMessage;
import com.example.demo.run.Entity.sys_config;
import com.example.demo.run.Entity.sys_config;
import com.example.demo.run.Entity.user_info;
import com.example.demo.run.Entity.AccessToken;

@Service
public class CoreService {
    @Autowired
    private CoreDao coreDao;
    @Autowired
    private FollowService followService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private Sys_CofigService sys_cofigService;
    @Autowired
    private Reply_news reply_news;
    @Autowired
    private user_info_Service user_info_service;
    @Autowired
    private Accesstoken_Service accesstoken_service;

    public String processRequest(HttpServletRequest request) {
        sys_config sys_config = new sys_config();
        String respMessage = null;
        List<Article> articleList = new ArrayList<Article>();

        try {
            // 默认返回的文本消息内容
            String respContent = "回复消息";
            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            //接收文本消息内容
            String content = requestMap.get("Content");
            //创建文本消息
            TextMessage textMessage = new TextMessage();
            // 创建图文消息
            NewsMessage newsMessage = new NewsMessage();


//////////////关注公众号后，自动回复一条信
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                System.out.println(fromUserName);
                AccessToken accessToken = new AccessToken();
                user_info user_info = new user_info();
                user_info.setOpenid(fromUserName);
                user_info = user_info_service.find_user_info(user_info);
                if (null != user_info) {
                    System.out.println("该关注用户已在用户信息表中");
                } else {
                    /*
                    用户不在表中，就添加新用户的信息
                     */
                    //获取最新的accesstoken
                    String getaccessToken = accesstoken_service.Add_Accesstoken(accessToken);
                  ;
                    //获取用户的信息
                    JSONObject jsonObject = WeixinUtil.user_infomation(getaccessToken, fromUserName);

                    System.out.println(jsonObject);

                    user_info user_info1=new user_info();
                    //把用户的信息保存到数据库中去
                   if (user_info_service.add_user_info(user_info1,jsonObject)) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("添加失败");
                    }
                }

                respContent = "你关注了星城安，请输入帮助查看";
                textMessage.setContent(respContent);
                textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(new Date().getTime());
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
///////////回复文本消息
            if (content.equals("1")) {
                respContent = "这是文本消息";
                textMessage.setContent(respContent);
                textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(new Date().getTime());
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
//////////回复图文消息
            if (content.equals("2")) {
                Article article = new Article();
                newsMessage = articleService.Graphic_message(article);
                newsMessage.setToUserName(fromUserName);
                newsMessage.setFromUserName(toUserName);
                newsMessage.setCreateTime(new Date().getTime());
                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                respMessage = MessageUtil.newsMessageToXml(newsMessage);
            }
/////////
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }
}
