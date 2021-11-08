package com.ctgu.yxr.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ctgu.yxr.exception.TokenUnavailableException;

import java.util.Calendar;
import java.util.Date;

public class JwtUtils {
    /**
     * 签发对象：用户的id
     * 签发时间：现在
     * 有效时间：30分钟
     * 载荷内容：用户名和用户编号
     * 加密秘钥：id+一段字符串
     * */
    public static String createToken(String userName){
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,30);
        Date expireDate = nowTime.getTime();

        /**
         * withAudience: 签发对象
         * withIssuedAt: 签发时间
         * withExpiredAt: 有效时间
         * withClaim: 荷载内容
         * sign: 签名
         * */
        return JWT.create().withAudience(userName)
                .withIssuedAt(new Date())
                .withExpiresAt(expireDate)
                .withClaim("userName",userName)
                .sign(Algorithm.HMAC256(userName + "HelloWorld"));
    }

    /**
     * 校验 token 的合法性
     * @param token token字符串
     * @param secret 用户名
     * @throws TokenUnavailableException
     * **/
    public static void verifyToken(String token,String secret) throws TokenUnavailableException {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret + "HelloWorld")).build();
            // 如果校验过程中出现了问题，会抛出TokenUnavailableException异常
            jwt = verifier.verify(token);
        } catch (Exception e){
            throw new TokenUnavailableException(e.getMessage());
        }
    }

    /**
     * 获取签发对象
     * @param token token字符串
     * @throws TokenUnavailableException
     * */
    public static String  getAudience(String token) throws TokenUnavailableException {
        String audience = null;
        try{
            audience = JWT.decode(token).getAudience().get(0);
            System.out.println(audience);
        }catch (JWTDecodeException e){
            throw new TokenUnavailableException(e.getMessage());
        }
        return audience;
    }

    /**
     * 通过载荷名字获取载荷的值
     */
    public static Claim getClaimByName(String token, String name){
        return JWT.decode(token).getClaim(name);
    }

}