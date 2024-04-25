package com.tencent.wxcloudrun.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

//import me.chanjar.weixin.common.api.WxConsts;
//import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
/**
 * @author jiangwei.li
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class WechatNoticeController {





    /**
     * 处理中心请求消息(GET)
     *
     * @param signature 签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   打印字符串
     * @return 返回文本
     */
    @RequestMapping(value = "/callback/{appId}", method = {RequestMethod.GET}, produces = "text/plain")
    public String getHandleCallback(@PathVariable("appId") String appId,
                               @RequestParam(value = "signature", required = false) String signature,
                               @RequestParam(value = "timestamp", required = false) String timestamp,
                               @RequestParam(value = "nonce", required = false) String nonce,
                               @RequestParam(value = "echostr", required = false) String echostr){
        return echostr;
    }
    /**
     * 处理中心请求消息(POST)
     *
     * @param appId     公众号类型(这里对应系统配置中的type)
     * @param signature 签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @return 返回文本
     */
    @RequestMapping(value = "/callback/{appId}", method = {RequestMethod.POST}, produces = "application/xml")
    public String handCallBack(@PathVariable("appId") String appId,
                               @RequestParam(value = "signature", required = false) String signature,
                               @RequestParam(value = "timestamp", required = false) String timestamp,
                               @RequestParam(value = "nonce", required = false) String nonce,
                               @RequestBody String requestBody){
        //是否开启了回调，如果没开启，则将消息转发给业务段原本的服务上
        log.info("微信公众号回调  appId:{} , signature:{} , timestamp：{} , nonce:{}，requestBody:{}", appId, signature, timestamp, nonce, requestBody);
        // 处理请求
//        WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
//        try {
//            if(WxConsts.XmlMsgType.EVENT.equalsIgnoreCase(inMessage.getMsgType()) && WxConsts.EventType.TEMPLATE_SEND_JOB_FINISH.equalsIgnoreCase(inMessage.getEvent())){
//                // 线上每天有大量的 模板消息发送结果类型的推送 此处手动拦截 不做处理
//                log.info("模板消息发送结果通知类型,不做处理 msg is  {}", inMessage.getAllFieldsMap());
//                return "success";
//            }
//        } catch (Exception e) {
//            log.error("回调入口post, 处理微信请求异常", e);
//        }
        return "success";
    }
}
