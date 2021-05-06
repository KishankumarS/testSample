package executor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.google.common.io.Files;

import org.apache.tools.ant.types.resources.comparators.Reverse;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import helpers.ReportHelper;
import io.restassured.specification.RequestSpecification;
import pages.Reserve;
import pages.SearchPage;
import repository.Common;
import repository.SingleDriver;

//tags - uitest, apitest
@CucumberOptions(strict = true, monochrome = true, features = "src/test/resources/features", glue = "stepdefinition", format = {"pretty","json:target/cucumber.json"}, tags = { "@apitest" })

public class Runner extends AbstractTestNGCucumberTests {

	public static Properties config = null;
	public static Common com = null;
	public static SearchPage searchpage = null;
	public static Reserve reservePage = null;
	SingleDriver driver1 = null;
	WebDriver driver = null;

	public RequestSpecification httpRequest = null;
	
	public void LoadConfigProperty() throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config//configs.properties");
		config.load(ip);
	}

	public void configureDriverPath() throws IOException {
		if(System.getProperty("os.name").startsWith("Linux")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/driver/linux/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/driver/linux/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if(System.getProperty("os.name").startsWith("Mac")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/driver/mac/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/driver/mac/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if(System.getProperty("os.name").startsWith("Windows")) {
			String firefoxDriverPath = 
					System.getProperty("user.dir") + "//src//test//resources//driver//windows//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = 
					System.getProperty("user.dir") + "//src//test//resources//driver//windows//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
	}

	

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		/*
		 * driver1 = SingleDriver.getInstanceOfSingletonBrowserClass(); driver =
		 * driver1.getDriver(); maxWindow(); impliWait(30); deleteAllCookies();
		 * setEnv(); impliWait(30);
		 */
		 searchpage = new SearchPage();
		 reservePage  = new Reserve();
		 com = new Common();
	}
	
	

	@AfterClass(alwaysRun = true)
	public void takeScreenshot() throws IOException {
		/*
		 * File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * File trgtFile = new File(System.getProperty("user.dir") +
		 * "//screenshots/screenshot.png"); trgtFile.getParentFile().mkdir();
		 * trgtFile.createNewFile(); Files.copy(scrFile, trgtFile);
		 */
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownr(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName()
					+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
			File failureImageFile = new File(System.getProperty("user.dir") + "//screens//" + failureImageFileName);
			failureImageFile.getParentFile().mkdir();
			failureImageFile.createNewFile();
			Files.copy(imageFile, failureImageFile);
		}

	}
	@AfterSuite(alwaysRun=true)
	public void generateHTMLReports() {
		ReportHelper.generateCucuReport();
		com = new Common();
	}

	@AfterSuite(alwaysRun = true)
	public void quit() throws IOException, InterruptedException {
		driver.quit();
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void impliWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void maxWindow() {
		driver.manage().window().maximize();
	}

	public void pageLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public void setEnv() throws Exception {
		LoadConfigProperty();
		String baseUri = config.getProperty("siteUrl");
		driver.get(baseUri);
	}
}
