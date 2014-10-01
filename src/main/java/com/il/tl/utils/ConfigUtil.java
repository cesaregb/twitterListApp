package com.il.tl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigUtil {
//	public static final String CONFIG_FILENAME = "resources.ga_skat";
	public static final String CONFIG_FILENAME = "resources/twitter4j.properties";
	
	public final static String OAUTH_CONSUMERKEY = "oauth.consumerKey";
	public final static String OAUTH_CONSUMERSECRET = "oauth.consumerSecret";
	public final static String DEBUG = "dbServer";

	private static Map<String, String> _config = new HashMap<String, String>();

	static {
		Properties props = new Properties();
		InputStream is = ConfigUtil.class.getClassLoader().getResourceAsStream(CONFIG_FILENAME);
		if (is != null) {
			try {
				props.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		_config = new HashMap<String, String>((Map) props);
	}

	public static String getConfigurationItem(String key) {
		return (String) _config.get(key);
	}
}
