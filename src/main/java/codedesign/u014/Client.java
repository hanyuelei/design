package codedesign.u014;

public class Client {

	public static void main(String[] args) {
		ApiAuthenticator authencator = new DefaultApiAuthenticator();
		String baseUrl = "/auth/desgin/queryResources";
		String appId = "1004";
		long timestamp = System.currentTimeMillis();
		String password = "PASS-1004";
		String token = AuthToken.generateTokenString(baseUrl, appId, timestamp, password);
		ApiRequest req1 = new ApiRequest(baseUrl, token, timestamp, appId);
		authencator.auth(req1);

	}
}
