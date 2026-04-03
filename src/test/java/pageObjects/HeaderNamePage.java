package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderNamePage extends BasePage
{
	
	public HeaderNamePage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy (xpath="//a[text()='Qafox.com']")
	WebElement linkHeading;
	
	public boolean HeaderName()
	{
		try
		{
			
			return (linkHeading.isDisplayed()); // true
		}
		catch (Exception e)
		{
			return false;           //false
		}
	}

	
}
