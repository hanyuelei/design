package codedesign.u014;

import codedesign.u014.storage.GredentialStorage;
import codedesign.u014.storage.MySqlGredentialStorage;

public class DefaultApiAuthenticator implements ApiAuthenticator {

	private GredentialStorage gredentialStorage;
	
	
	public DefaultApiAuthenticator(GredentialStorage gredentialStorage) {
		this.gredentialStorage = gredentialStorage;
	}

	public DefaultApiAuthenticator() {
		
		gredentialStorage = new MySqlGredentialStorage();
	}

	@Override
	public void auth(String url) {
		// TODO Auto-generated method stub
		ApiRequest  apiRequest = ApiRequest.buildFromUrl(url);
		auth(apiRequest);
	}

	@Override
	public void auth(ApiRequest apiRequest) {
		// TODO Auto-generated method stub
		String appId = apiRequest.getAppId();
		String token = apiRequest.getToken();
		long timestamp = apiRequest.getTimestamp();
		String baseUrl = apiRequest.getBaseUrl();
		
		AuthToken clientToken = new AuthToken(token, timestamp);
		System.out.println("clientToken.isExpried():"+clientToken.isExpried());
		if(clientToken.isExpried()) {
			throw new RuntimeException("Token is expired");
		}
		AuthToken serverToken = AuthToken.generateToken(baseUrl, appId, timestamp, gredentialStorage.getPasswordByAppId(appId));
		if(!serverToken.mathc(clientToken)) {
			throw new RuntimeException("Token verfication failed!!!");
		}
	}

}
