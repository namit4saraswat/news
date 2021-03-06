package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodayNews extends utils.DriverManager{
	
	
	@FindBy(name="q")
	public static WebElement searchBox;
	@FindBy(css = "#rso > div > div > div > a > h3")
	public static WebElement headline1;
	
	public TodayNews()
	{
		PageFactory.initElements(driver, this);
	}

	public void news_today(String url)
	{	
		driver.get(url);
		//System.out.println("Inside TodayNews " + headline1 + searchBox);
		searchBox.sendKeys("Today News");
		searchBox.sendKeys(Keys.ENTER);
		String headline1_text = headline1.getText();
		System.out.println(headline1_text);
		
		
	}

}
