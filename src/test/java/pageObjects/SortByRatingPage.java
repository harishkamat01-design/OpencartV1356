package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SortByRatingPage  extends BasePage
{
	public  SortByRatingPage( WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath = "//a[text()='Cameras'] " )
	WebElement btnCamera;

	@FindBy (xpath = "//select[@id='input-sort']")  
	WebElement drpSortByEle;


	
	public void ratingHighest() throws InterruptedException
	
	{
	  
	  Select   drpSortBy = new Select(drpSortByEle);
	 
			//drpSortBy.selectByContainsVisibleText("Rating(Highest)");
			//drpSortBy.selectByValue(" Rating (Highest) ");
			drpSortBy.selectByIndex(5);	
	Thread.sleep(3000);

	}
}
