package com.learn.shop.util;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * @author 江文谱
 * @version 1.0
 */
public class SHA {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String getFormattedText(byte[] bytes) {

        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static String encode(String str) {
        if (StringUtils.isNotBlank(str)) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA1");
                digest.update(str.getBytes());
                return getFormattedText(digest.digest());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
