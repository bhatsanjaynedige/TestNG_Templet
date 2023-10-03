package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.BasePage;

public class LoginFunctionalitytestsPage extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, 50);

	public LoginFunctionalitytestsPage(WebDriver driver) {
		super(driver);
	}
	

}
