package com.javasm.commons.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JJWTUtil {
    private static final String customClaim = "uname";
    private static final Long expTime=30*24*60*60*1000L;//做接口,一般token30天,后台管理系统:30分钟
    private static final String keystr ="XKuOJBUJbPSbYZtoFqzW6plpD9eN2FybfACA3g3h168=";

    /**
     * 生成符号加密算法要求的密钥.
     */
    public static void getKey(){
        //Keys按照指定HS256算法生成密钥的工具类
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        byte[] encoded = key.getEncoded();
        String encode = Encoders.BASE64.encode(encoded);// ascii UTF-8  BASE64
        System.out.println(encode);
    }

    //生成token令牌的,jjwt: {header}.{body}.{密文}
    public static String generate(String uname){
        Date current = DateUtil.currentDate();
        Date exp = DateUtil.getNextDate(current,expTime);
        Map<String,String> claims = new HashMap<>();
        claims.put(customClaim,uname);

        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(keystr));

        //header.body(签名信息).body密文
        //{k:v}.{"issuedAt":"2021-06-20","expir":"2021-6-21","subject":"","uphone":"1231231232131"}.{}
        String jws = Jwts.builder()
                .setClaims(claims)//自定义签名,用户标识,放在标准签名之前进行设置
                .setIssuedAt(current)//签发时间
                .setExpiration(exp)//过期时间
                .signWith(key)//指定密钥
                .compact();
        return jws;
    }

    public static Claims parse(String token){
        //在对token的密文进行反向解密,与第二部分明文进行比对,比对通过正常返回,不通过,报异常
        Jws<Claims> claimsJws = null;
        try{
            claimsJws = Jwts.parserBuilder().setSigningKey(keystr).build().parseClaimsJws(token);
        }catch (Exception e){
            //当token过期,token伪造
            return null;
        }
        return claimsJws.getBody();
    }

    public static Date getIssuredAt(Claims c){
        return c.getIssuedAt();
    }

    public static String getUname(Claims c){
        return c.get(customClaim,String.class);
    }

    public static void main(String[] args) {
        String t = generate("fyt");
        Claims parse = parse(t);
        System.out.println(getUname(parse));
    }
}
