package testscases;

import org.testng.annotations.Test;

import Pages.LoginFunctionalitytestsPage;
import factoryManager.*;


public class LoginFunctionalityTests extends BaseTest {
	
	
	@Test (testName = "Test Case 1: Register User")
	public void registerUser() {
		LoginFunctionalitytestsPage loginFunction=PageinstancesFactory.getInstance(LoginFunctionalitytestsPage.class);
		driver.get(test.getProperty("url"));
	}
	

}
