package codedesign.u014;

import codedesign.u014.utils.MD5Util;

public class AuthToken {

	private static final long  DEFAULT_EXPIRED_TIME_INTERVAL = 1 *60 *1000; 
	private String token;
	private long createTime;
	private long expiredTimeInterval =  DEFAULT_EXPIRED_TIME_INTERVAL;
	 private static final String SEPARATE = "@";
	public AuthToken(String token, long createTime) {
		this.token = token;
		this.createTime = createTime;
	}

	public AuthToken(String token, long createTime, long expiredTimeInterval) {
		this(token,createTime);
		this.expiredTimeInterval = expiredTimeInterval;
	}
	
	public static AuthToken generateToken(String originalUrl, String appId, long timestamp, String password) {
		String tokenString = generateTokenString(originalUrl, appId, timestamp, password);
		return new AuthToken(tokenString, timestamp);
	}
	
	public static String generateTokenString(String originalUrl, String appId, long timestamp, String password) {
		StringBuffer urlBuffer = new StringBuffer(originalUrl);
		urlBuffer.append(SEPARATE).append(appId);
		urlBuffer.append(SEPARATE).append(timestamp);
		urlBuffer.append(SEPARATE).append(password);
		String str =  MD5Util.md5(urlBuffer.toString());
		System.out.println("加密串"+str);
		return str;
	}
	public boolean isExpried() {
		  return createTime + expiredTimeInterval < System.currentTimeMillis();
	}
	
	public boolean mathc(AuthToken authToken) {
		return token.equals(authToken.getToken());
	}

	public String getToken() {
		return token;
	}
	
	
}
