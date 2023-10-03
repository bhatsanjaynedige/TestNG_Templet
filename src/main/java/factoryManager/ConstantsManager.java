package factoryManager;

public class ConstantsManager {

public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

	
	public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReportsDir/AutomationResult.html";

	
	public final static String PROJECT_NAME = "Automation Exercise";

	
	public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/test/resources/configuration/extentReport-config.xml";


	public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/test/resources/configuration/test.properties";
	


}
