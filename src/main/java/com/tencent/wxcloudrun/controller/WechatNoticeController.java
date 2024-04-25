package com.tencent.wxcloudrun.controller;


import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.model.CallBackParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiangwei.li
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class WechatNoticeController {



    private static final String replyXml = "<xml>\n" +
            "  <ToUserName><![CDATA[{toUser}]]></ToUserName>\n" +
            "  <FromUserName><![CDATA[{fromUser}]]></FromUserName>\n" +
            "  <CreateTime>{createTime}</CreateTime>\n" +
            "  <MsgType><![CDATA[text]]></MsgType>\n" +
            "  <Content><![CDATA[{content}]]></Content>\n" +
            "</xml>";

    /**
     * 处理中心请求消息(POST)
     *
     * "MsgId": 24538793330803493
     * "MsgType": "text",
     * "CreateTime": 1714015019,
     * "FromUserName": "o4esP62QjDUWV6rvPdjL2yO4xAyw",
     * "ToUserName": "gh_202725f11c5b",
     * "action": "CheckContainerPath"
     * @return 返回文本
     */
    @RequestMapping(value = "/callback", method = {RequestMethod.POST}, produces = "application/xml")
    public String handCallBack(@RequestBody String body){
        log.info("微信公众号回调  body:{}", body);
        CallBackParam param = JSONObject.parseObject(body, CallBackParam.class);

        log.info("微信公众号回调  MsgId:{} , MsgType：{} , CreateTime:{}，FromUserName:{}，ToUserName:{}，content:{}",
                param.getMsgId(),param.getMsgType(),param.getCreateTime(),param.getFromUserName(),param.getToUserName(),param.getContent());
        if ("CheckContainerPath".equalsIgnoreCase(param.getAction())){
            return "success";
        }
        JSONObject result =  new JSONObject();
        result.put("ToUserName",param.getFromUserName());
        result.put("FromUserName",param.getToUserName());
        result.put("CreateTime",System.currentTimeMillis()/ 1000 + "");
        result.put("MsgType","text");
        result.put("Content","你说的是："+ param.getContent());
        return result.toJSONString();
    }




}