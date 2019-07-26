package com.example.shiro.utlis;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    /**
     * 密码,Md5,加盐
     */
    public static String Md5Salt(String password){
        try {
            // 确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            // 加密后的字符串
            // 1
            String newStr = base64en.encode(md5.digest(password.getBytes("utf-8")))+"wenshuo";
            String end = base64en.encode(md5.digest(newStr.getBytes("utf-8")));
            return end;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }catch (UnsupportedEncodingException c){
            c.printStackTrace();
            return "";
        }
    }




    /**
     * 利用MD5进行加密
     *
     * @param str 待加密的字符串
     * @return 加密后的字符串
     * @throws NoSuchAlgorithmException     没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        // 加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    public static void main(String[] args) {
        // 我是xiaotuzikln145000000
        String str = "dddd";
        String code;
        try {
            code = EncoderByMd5(str);
            System.out.println(code);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
