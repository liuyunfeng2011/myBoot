package com.action.myboot.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtils {
//	 public static final String TOKEN_HEADER = "sub";
//	    public static final String TOKEN_PREFIX = "Bearer ";
//
//	    private static final String SECRET = "jwtsecretdemo";
//	    private static final String ISS = "echisan";
//
//	    // 过期时间是3600秒，既是1个小时
//	    private static final long EXPIRATION = 3600L;
//
//	    // 选择了记住我之后的过期时间为7天
//	    private static final long EXPIRATION_REMEMBER = 604800L;
//
//	    // 创建token
//	    public static String createToken(String username, boolean isRememberMe) {
//	        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
//	        return Jwts.builder()
//	                .signWith(SignatureAlgorithm.HS512, SECRET)
//	                .setIssuer(ISS)
//	                .setSubject(username)
//	                .setIssuedAt(new Date())
//	                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
//	                .compact();
//	    }
//
//	    // 从token中获取用户名
//	    public static String getUsername(String token){
//	        return getTokenBody(token).getSubject();
//	    }
//
//	    // 是否已过期
//	    public static boolean isExpiration(String token){
//	        return getTokenBody(token).getExpiration().before(new Date());
//	    }
//
//	    private static Claims getTokenBody(String token){
//	        return Jwts.parser()
//	                .setSigningKey(SECRET)
//	                .parseClaimsJws(token)
//	                .getBody();
//	    }
	  static final String SECRET = "secret";

	    public static String generateToken(String username) {
	        HashMap<String, Object> map = new HashMap<>();
	        //you can put any data in the map
	        map.put("username", username);
	        String jwt = Jwts.builder()
	                .setClaims(map)
	                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L))// 1000 hour
	                .signWith(SignatureAlgorithm.HS512, SECRET)
	                .compact();
	        return "Bearer "+jwt; //jwt前面一般都会加Bearer
	    }

	    public static void validateToken(String token) {
	        try {
	            // parse the token.
	            Map<String, Object> body = Jwts.parser()
	                    .setSigningKey(SECRET)
	                    .parseClaimsJws(token.replace("Bearer ",""))
	                    .getBody();
	        }catch (Exception e){
	            throw new IllegalStateException("Invalid Token. "+e.getMessage());
	        }
	    }
}
