package codedesign.u014.storage;

import java.util.HashMap;
import java.util.Map;

public class MySqlGredentialStorage implements GredentialStorage {
	 private static Map<String, String> passwordMap = new  HashMap();
	static {
        passwordMap.put("1001", "PASS-1001");
        passwordMap.put("1002", "PASS-1002");
        passwordMap.put("1003", "PASS-1003");
        passwordMap.put("1004", "PASS-1004");
        passwordMap.put("1005", "PASS-1005");
        passwordMap.put("1006", "PASS-1006");
    }
	@Override
	public String getPasswordByAppId(String appId) {
		// TODO Auto-generated method stub
		return passwordMap.get(appId);
	}

}
