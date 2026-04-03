package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage

{	
	//constructor
		public SearchPage(WebDriver driver) 
		{
			super(driver);
		}
		
	// locators 
		@FindBy(xpath="//a[normalize-space()='MacBook']")
		WebElement findSearch;
		
		@FindBy(xpath="//img[@class='img-responsive']")
		WebElement slkProduct;
		
		@FindBy(xpath="//input[@id='input-quantity']")
		WebElement updateQuantity;
		
		@FindBy(xpath="//button[@id='button-cart']")
		WebElement btnAddToCart;
		
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
		WebElement msg;
	// Action
		public boolean isProductExist(String string)
		{
			try
			{
				return(findSearch.isDisplayed());  // true
			}
			catch(Exception e)
			{
				return false;                      //false
			} 
				
		}
		
		public void selectProduct(String string)
		   {
			   slkProduct.click();
		   }
			
		   public void setQuantity(String string)
		   {
			   updateQuantity.clear();
			   updateQuantity.sendKeys();
	
		   }
		   
		   public void addToCart()
		   {
			   btnAddToCart.click();
		   }

			public boolean checkConfmsg()
			{
				try
				{
					return(msg.isDisplayed());  // true
				}
				catch(Exception e)
				{
					return false;                      //false
				} 
					
			}
}
