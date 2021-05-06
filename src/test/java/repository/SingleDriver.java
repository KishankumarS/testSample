package repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import executor.Runner;

public class SingleDriver extends Runner {
	// instance of singleton class
		private static SingleDriver instanceOfSingleDriver=null;
		
		
	    private WebDriver driver;

	    // Constructor
	    private SingleDriver(){
	    	try {
				LoadConfigProperty();
				configureDriverPath();
	    	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (config.getProperty("browser").equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("chrome")) {
				/*
				 * If you want to see the browser execution, please remove Chrome options
				 */
				
				ChromeOptions options = new ChromeOptions();
				/*
				 * options. addArguments("--headless"); options. addArguments("--no-sandbox");
				 * options. addArguments("--disable-gpu"); options.
				 * addArguments("--disable-dev-shm-usage"); options.
				 * setExperimentalOption("useAutomationExtension", false);
				 */
				
				driver = new ChromeDriver(options);
			}
	    }

	    // TO create instance of class
	    public static SingleDriver getInstanceOfSingletonBrowserClass(){
	        if(instanceOfSingleDriver==null){
	        	instanceOfSingleDriver = new SingleDriver();
	        }
	        return instanceOfSingleDriver;
	    }
	    
	    // To get driver
	    public WebDriver getDriver()
	    {
	    	return driver;
	    }
	    
	   
}
