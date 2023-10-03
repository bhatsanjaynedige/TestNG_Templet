package factoryManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import util.LoggerUtil;
public class ObjectRepository {
	public static Properties OR = new Properties();
	public static Properties ObjectRepo(String filepath) throws IOException {
		InputStream in = new FileInputStream(filepath);
		OR.load(in);
		return OR;
	}
	
	public static void loadAllPropertie() {
		try {
			FileInputStream Locator;
			Locator = new FileInputStream(ConstantsManager.PROPERTY_FILE_PATH);
			OR.load(Locator);
		} catch (IOException e) {
			LoggerUtil.getLogger().fatal("Could not load properties : " + e.getMessage());
		}
	}

	public static String getProperty(String key) {
		return OR.getProperty(key);
	}

	public static void putProperty(String key, String value) {
		OR.put(key, value);
	}
}
