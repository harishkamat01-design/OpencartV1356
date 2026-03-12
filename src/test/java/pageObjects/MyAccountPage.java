package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	//constructor
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}

	//locator
	@FindBy(xpath = "//h2[text()='My Account']")   // MyAccount Page Heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")   // Logout link on the page, this is for step #6
	WebElement lnkLogout;
	
	
	// Action -> this is not validation as we don't use any validation in the Page Object Class
	// we do validation in the Test case

	public boolean isMyAccountPageExists()
	{
		try
		{
			return(msgHeading.isDisplayed());  // true
		}
		catch(Exception e)
		{
			return false;                      //false
		} 
	}
	
	public void linkLogout()
	{
		lnkLogout.click();
	}
	
	
}
