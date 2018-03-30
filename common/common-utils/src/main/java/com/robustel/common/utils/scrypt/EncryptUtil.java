package com.robustel.common.utils.scrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

/**
 * @Desc 加密工具
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-02
 */
public class EncryptUtil {

    /**
     * 单向信息加密(MD5)
     * 
     * @param password 密码
     * @return 加密成功返回加密后的字符串，加密失败返回null
     */
    public static String endcodingPassword(String password) {
        String result = null;
        try {
            // 生成实现指定摘要算法的 MessageDigest 对象。
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 使用指定的字节数组更新摘要。
            md.update(password.getBytes());
            // 通过执行诸如填充之类的最终操作完成哈希计算。
            byte[] encoding = md.digest();
            // 生成具体的md5密码到buf数组
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < encoding.length; offset++) {
                i = encoding[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // 32位的加密
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断登录密码是否和数据库密码一致
     * @param inputPassword
     * @param dbPassword
     * @return 一致返回true，不一致返回false
     */
    public static boolean isGt(String inputPassword, String dbPassword) {
        boolean result = false;
        if (StringUtils.isNotBlank(inputPassword) && dbPassword.equals(endcodingPassword(inputPassword))) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(endcodingPassword("9f81aaa15737697e3f390de981877b9c"));
    }
}