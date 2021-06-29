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

/**
 * @author SunHang
 * @className: JJWTUtil
 * @description:
 * @createTime 2021/6/23 18:50
 */
public class JJWTUtil {
    private static final String CUSTOM_CLAIM = "uphone";
    private static final Long EXP_TIME = 10 * 60 * 1000L;
    private static final String KEYSTR = "U5FTZxEKTLG8gSmspf/kA4RgnHhr+mlA1w3LSPdprNY=";


//    public static void main(String[] args) {
//        System.out.println(generate("23242424"));
//        String token = generate("23242424");
//        Claims parse = parse(token);
//        assert parse != null;
//        System.out.println(getUhpone(parse));
//        System.out.println(getIssuredAt(parse));
//
//    }

    public static void getKey() {
        //Keys按照指定HS256算法生成密钥的工具类
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        byte[] encoded = key.getEncoded();
        String encode = Encoders.BASE64.encode(encoded);
        System.out.println(encode);
    }

    public static String generate(String uphone) {
        // 当前时间
        Date current = DateUtil.currentDate();
        // 过期时间
        Date exp = DateUtil.getNextDate(current, EXP_TIME);
        // 自定义签名
        Map<String, String> claims = new HashMap<>();
        claims.put(CUSTOM_CLAIM, uphone);
        // Keys:密钥工具类，按照指定算法生成密钥
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEYSTR));

        String jws = Jwts.builder()
                .setClaims(claims) // 自定义签名，放用户的标识,必须放标准签名之前
                .setIssuedAt(current) // 签发时间
                .setExpiration(exp) //过期时间
                .signWith(key)    // 指定密钥
                .compact();
        // jws是json字符串进行base64编码后的数据
        return jws;
    }

    public static Claims parse(String token) {
        //在对token的密文进行反向解密,与第二部分明文进行比对,比对通过正常返回,不通过,报异常
        Jws<Claims> claimsJws = null;
        try {
            claimsJws = Jwts.parserBuilder().setSigningKey(KEYSTR).build().parseClaimsJws(token);
        } catch (Exception e) {
            return null;
        }
        return claimsJws.getBody();
    }

    public static Date getIssuredAt(Claims c) {
        return c.getIssuedAt();
    }

    public static String getUhpone(Claims c) {
        return c.get(CUSTOM_CLAIM, String.class);
    }
}
