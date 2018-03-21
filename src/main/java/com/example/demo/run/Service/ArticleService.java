package com.example.demo.run.Service;/*
   User: wuwen
   Date: 2018-03-20
   Time: 15-07
   备注：回复图文消息
    
    
    
 */

import com.example.demo.run.Entity.Article;
import com.example.demo.run.Entity.NewsMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    public NewsMessage Graphic_message(Article article) {

        List<Article> articleList = new ArrayList<Article>();
        NewsMessage newsMessage = new NewsMessage();

        article.setTitle("图文消息测试");
        article.setDescription("这是测试有没有换行\n\n如果有空行就代表换行成功\n\n点击图文可以跳转到百度首页");
        article.setPicUrl("http://g.hiphotos.baidu.com/image/h%3D300/sign=c5c54b2aad8b87d64f42ad1f37092860/eaf81a4c510fd9f9a1f3ac72292dd42a2934a4c1.jpg");
        article.setUrl("http://www.baidu.com");
        articleList.add(article);
        newsMessage.setArticleCount(articleList.size());
        newsMessage.setArticles(articleList);
        return newsMessage;
    }

}
