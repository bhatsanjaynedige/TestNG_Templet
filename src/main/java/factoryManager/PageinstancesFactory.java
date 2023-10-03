package factoryManager;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import factoryManager.*;
import Pages.BasePage;


public class PageinstancesFactory {

	public static <T extends BasePage> T getInstance(Class<T> type) {
		try {
			return type.getConstructor(WebDriver.class).newInstance(WebDriverManagerFactory.getDriver());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
