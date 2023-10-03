package testscases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import factoryManager.ConstantsManager;
import factoryManager.ObjectRepository;
import factoryManager.WebDriverManagerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.LogListener;
import listeners.ReportListener;
import util.LoggerUtil;



@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {

	protected WebDriver driver;
	public static Properties test;

	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		LoggerUtil.log("************************** Test Case Execution Started ************************************");
		ObjectRepository.loadAllPropertie();
	}

	@AfterSuite(alwaysRun = true)
	public void wrapAllUp(ITestContext context) {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		LoggerUtil.log("Total number of testcases : " + total);
		LoggerUtil.log("Number of testcases Passed : " + passed);
		LoggerUtil.log("Number of testcases Failed : " + failed);
		LoggerUtil.log("Number of testcases Skipped  : " + skipped);
		LoggerUtil.log("************************** Test Execution Finished ************************************");
	}

	@BeforeMethod
	protected void setup() throws Exception {
		test = ObjectRepository.ObjectRepo(System.getProperty("user.dir")+"//src//test//resources//configuration//test.properties");
		if (test.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("disable-infobars");
			driver = new ChromeDriver(ops);

		}
		if (test.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ops = new FirefoxOptions();
			ops.addArguments("disable-infobars");
			driver = new FirefoxDriver(ops);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverManagerFactory.setDriver(driver);

	}

	@AfterMethod
	public void wrapUp() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

}
