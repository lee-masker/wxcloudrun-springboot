package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lijiangwei
 */

@Data
public class CallBackParam implements Serializable {
    /**
     *      * "MsgId": 24538793330803493
     *      * "MsgType": "text",
     *      * "CreateTime": 1714015019,
     *      * "FromUserName": "o4esP62QjDUWV6rvPdjL2yO4xAyw",
     *      * "ToUserName": "gh_202725f11c5b",
     */

    private Long MsgId;

    private String MsgType;

    private Long CreateTime;

    private String FromUserName;

    private String ToUserName;

    private String Content;
}
