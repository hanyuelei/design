package codedesign.u014;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClientTest {

	@Test
	void success() {
		ApiAuthenticator authencator = new DefaultApiAuthenticator();
		String baseUrl = "/auth/desgin/queryResources";
		String appId = "1004";
		long timestamp = System.currentTimeMillis();
		String password = "PASS-1004";
		String token = AuthToken.generateTokenString(baseUrl, appId, timestamp, password);
		ApiRequest req1 = new ApiRequest(baseUrl, token, timestamp, appId);
		authencator.auth(req1);
	}
	
	@Test
	void failed() {
		ApiAuthenticator authencator = new DefaultApiAuthenticator();
		String baseUrl = "/auth/desgin/queryResources";
		String appId = "1004";
		long timestamp = System.currentTimeMillis();
		String password = "PASS-10042";
		String token = AuthToken.generateTokenString(baseUrl, appId, timestamp, password);
		ApiRequest req1 = new ApiRequest(baseUrl, token, timestamp, appId);
		authencator.auth(req1);
	}

}
