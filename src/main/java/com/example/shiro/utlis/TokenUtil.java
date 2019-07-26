package com.example.shiro.utlis;

public class TokenUtil {


    /**
     * 末尾的数字id
     */
    public static int Guid = 100;
    /**
     * 生成token
     * @param username
     * @return token
     * @version 1.0
     */
    public static String generateToken(String username) {
        String str = username + "kln" + System.currentTimeMillis();

        int ran = 0;
        TokenUtil.Guid+=1;
        if(TokenUtil.Guid > 999){
            TokenUtil.Guid=100;
        }
        ran = TokenUtil.Guid;

        String token;
        try {
            token = Md5Util.EncoderByMd5(str + ran);
            token = token.replaceAll("\\+","a");
        } catch (Exception e) {
            throw new IllegalStateException("Token生成错误");
        }
        return token;
    }
}
