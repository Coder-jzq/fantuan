package com.ruoyi.fantuan.uuid;

import java.util.UUID;

/**
 * @Author: Jia Zhenqi
 * @Date: 2023/2/4  11:52
 * @Version 1.0
 */
public class Uuid {

    /**
     * 生成uuid
     * @return
     */
    public static String getUUID(){
        String id = UUID.randomUUID().toString();
        String uid = id.replaceAll("-", "");
        return uid;
    }
}
