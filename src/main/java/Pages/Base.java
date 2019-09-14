package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Base {

	private static WebDriver driver;

	private static String chromedriverpath = "chromedriver";

	public static WebDriver getChromeDriver() {
	
		if (driver == null || driver.toString().endsWith("(null)")) {
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			driver = new ChromeDriver();	
		}
		return driver;
	}

	public static void explicitWait() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getVariables(String varName) {
		Properties prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("/Users/admin/eclipse-workspace/WebdriverTest/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop.getProperty(varName);
	}
	
}