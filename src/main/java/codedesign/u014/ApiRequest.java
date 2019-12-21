package codedesign.u014;

public class ApiRequest {

	private String baseUrl;
	private String token;
	private long timestamp;
	private String appId;
	
	public ApiRequest(String baseUrl, String token, long timestamp, String appId) {
		super();
		this.baseUrl = baseUrl;
		this.token = token;
		this.timestamp = timestamp;
		this.appId = appId;
	}

	public static ApiRequest buildFromUrl(String url) {
		// baseUrl=urlxxx&appId=1001&timestamp=1307788865&token=a78cdef998
        // 根据URL解析出appId, token, createTime, url
		String[] reqArray =  url.split("&");
		String baseUrl = reqArray[0].split("=", 2)[1];
		String appId = reqArray[1].split("=", 2)[1];
		String timestamp = reqArray[2].split("=", 2)[1];
		String token = reqArray[3].split("=", 2)[1];
		return new ApiRequest(baseUrl, token, Long.parseLong(timestamp), appId);
	}

	public String getBaseUrl() {
		return baseUrl;
	}


	public String getToken() {
		return token;
	}


	public long getTimestamp() {
		return timestamp;
	}


	public String getAppId() {
		return appId;
	}


}
