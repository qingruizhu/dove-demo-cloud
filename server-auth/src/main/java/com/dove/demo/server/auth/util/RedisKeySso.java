package com.dove.demo.server.auth.util;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/4/30 09:34
 */
public class RedisKeySso {
    /**
     * The 验证码 PREFIX_AUTHCODE.
     */
    private static final String SSO_PREFIX_AUTHCODE = "demo:sso:authCode";
    private static final String COLON = ":";

    public static String authCode(String subject) {
        StringBuffer sb = new StringBuffer(SSO_PREFIX_AUTHCODE);
        sb.append(COLON);
        sb.append(subject);
        return sb.toString();
    }

}
