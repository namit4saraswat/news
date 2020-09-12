package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;


public class DriverManager {
//String browser = "Chrome";
//String url = "https://www.mindmeister.com";
	public static WebDriver driver;
	public static void getDriver(String browser) {
		
		
		String path = "C:\\Users\\namit\\Projects\\chromedriver.exe";
		String path1 =  "C:\\Users\\namit\\Projects\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		System.setProperty("webdriver.gecko.driver", path1);
		
		if (browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else
		{
			Assert.assertTrue(false, "No correct type sent");
		}
		
		driver.manage().window().maximize();
		
	}

}
