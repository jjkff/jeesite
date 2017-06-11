package com.thinkgem.jeesite.common.utils;

import com.sun.tools.internal.ws.processor.model.Response;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jkf on 2017/4/8.
 */
@PermitAll
public class TokeUtils {

    private Date getExpiryDate(int minutes) {
        // 根据当前日期，来得到到期日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * 得到token
     * @param tel
     * @param expires
     * @param key
     * @return
     */
    public static String getJWTString(String tel,Date expires,Key key){
        if (tel == null) {
            throw new NullPointerException("null username is illegal");
        }
        if (expires == null) {
            throw new NullPointerException("null expires is illegal");
        }
        if (key == null) {
            throw new NullPointerException("null key is illegal");
        }
        //用签名算法HS256和私钥key生成token
        io.jsonwebtoken.SignatureAlgorithm s = io.jsonwebtoken.SignatureAlgorithm.ES256;
        String jwtString = Jwts.builder()
                .setIssuer("Jersey-Security-Basic")//设置发行人
                .setSubject(tel)//设置抽象主题
                .setAudience("user")//设置角色
                .setExpiration(expires)//过期时间
                .setIssuedAt(new Date())//设置现在时间
                .setId("1")//版本1
                .signWith(s,key)
                .compact();
        return jwtString;
    }

    public static boolean isValid(String token, Key key) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token.trim());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getName(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return claimsJws.getBody().getSubject();
        }
        return null;
    }

    public static String[] getRoles(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return claimsJws.getBody().getAudience().split(",");
        }
        return new String[]{};
    }

    public static int getVersion(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return Integer.parseInt(claimsJws.getBody().getId());
        }
        return -1;
    }


}
