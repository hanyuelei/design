package codedesign.u014;

public interface ApiAuthenticator {

	void auth(String url);
	void auth(ApiRequest apiRequest);
}
