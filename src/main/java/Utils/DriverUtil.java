package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverUtil {
	
	
	public static WebDriver driver;
	
    @Before
	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			
			
		}
		return driver;
	}
	@After
	public static void killDrivers() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	public static String getUrl(String url) {
		
		getDriver().get(url);
		
		return url;
	}
	
	
}
