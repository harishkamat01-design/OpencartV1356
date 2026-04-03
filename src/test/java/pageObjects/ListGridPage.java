package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListGridPage extends BasePage
{
	public  ListGridPage(WebDriver driver)
	{
	       super(driver);
	}

	@FindBy (xpath = "//a[text()='Cameras'] " )
	WebElement btnCamera;

	@FindBy (xpath = "//i[@class='fa fa-th-list']")
	WebElement btnList;

	@FindBy (xpath="//i[@class='fa fa-th']")
	WebElement btnGrid;


	public void headerCamera()
	{
	 btnCamera.click();
	}

	public void listView()
	{
	 btnList.click();
	}

	public void gridView()
	{
	 btnGrid.click();
	}	
	
}
