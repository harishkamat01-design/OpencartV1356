package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonNamesPage extends BasePage
{
	public ButtonNamesPage(WebDriver driver)
	{
		super(driver);	
	}
	
	@FindBy (xpath="//a[text()='Desktops']")
	WebElement btnDesktops;

	@FindBy (xpath="//a[text()='Laptops & Notebooks']")
	WebElement btnLaptopsandNotebooks;

	@FindBy (xpath="//a[text()='Components']")
	WebElement btnComponents;

			public void openPage() throws InterruptedException
			{
			
			Actions act = new Actions(driver);
		
			act.contextClick(btnDesktops).build().perform();                        // right click is done , doesn't click on the right click as it outside DOM
			act.keyDown(Keys.CONTROL).click(btnDesktops).keyUp(Keys.CONTROL).perform();
    
			Thread.sleep(3000);
			
			//act.contextClick(btnLaptopsandNotebooks).build().perform();
			//act.keyDown(Keys.CONTROL).click(btnLaptopsandNotebooks).keyUp(Keys.CONTROL).perform();
			//Thread.sleep(3000);
			
			//act.contextClick(btnComponents).build().perform();
			//act.keyDown(Keys.CONTROL).click(btnComponents).keyUp(Keys.CONTROL).perform();
			//Thread.sleep(3000);
			
	

			
			}
}
