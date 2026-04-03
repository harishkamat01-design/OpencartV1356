package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage 
{
	//WebDriver driver; ---> not needed
  public HomePage(WebDriver driver)
  {
	  super(driver);
  }
	
	
  @FindBy(xpath="//span[normalize-space()='My Account']")
  WebElement lnkMyaccount;
  
  @FindBy(xpath="//a[normalize-space()='Register']")
  WebElement lnkRegister;
  
  @FindBy(linkText="Login")   // step #5 for Login
  WebElement linkLogin;
  
  @FindBy(xpath="//input[@placeholder='Search']")
	WebElement productname;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;

  
  public void clickMyAccount()
  {
	  lnkMyaccount.click();
  }
  
  public void clickRegister()
  {
	  lnkRegister.click();
  }
  public void clickLogin()
  {
	  linkLogin.click();
	  
  }
  
  public void enterProductName(String pname) 
  {
	  productname.sendKeys(pname);
  }
  
  public void clickSearch()
  {
	  btnSearch.click();
  }
    
  
}
