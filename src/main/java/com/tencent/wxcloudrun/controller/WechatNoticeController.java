package com.tencent.wxcloudrun.controller;


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
     * 处理中心请求消息(GET)
     *
     * @param echostr   打印字符串
     * @return 返回文本
     */
    @RequestMapping(value = "/callback", method = {RequestMethod.GET}, produces = "text/plain")
    public String getHandleCallback(@RequestParam(value = "echostr", required = false) String echostr){
        log.info("微信公众号回调探测 echostr:{}", echostr);
        return echostr;
    }
    /**
     * 处理中心请求消息(POST)
     *
     * "MsgId": 24538793330803493
     * "MsgType": "text",
     * "CreateTime": 1714015019,
     * "FromUserName": "o4esP62QjDUWV6rvPdjL2yO4xAyw",
     * "ToUserName": "gh_202725f11c5b",
     * @return 返回文本
     */
    @RequestMapping(value = "/callback", method = {RequestMethod.POST}, produces = "application/xml")
    public String handCallBack(@RequestBody CallBackParam param){
        log.info("微信公众号回调  MsgId:{} , MsgType：{} , CreateTime:{}，FromUserName:{}，ToUserName:{}，content:{}",
                param.getMsgId(),param.getMsgType(),param.getCreateTime(),param.getFromUserName(),param.getToUserName(),param.getContent());

        return replyXml.replace("{toUser}", param.getFromUserName())
                .replace("{fromUser}", param.getToUserName())
                .replace("{createTime}", System.currentTimeMillis()/ 1000 + "")
                .replace("{content}", "你说的是："+ param.getContent())
                ;
    }
}
