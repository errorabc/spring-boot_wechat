package com.example.demo.run.Entity;/*
   User: wuwen
   Date: 2018-03-20
   Time: 09-44
   备注：音频消息
    
    
    
 */

public class VoiceMessage extends BaseMessage{
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
