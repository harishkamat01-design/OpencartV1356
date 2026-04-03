package testCases;

import org.testng.Assert;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddToCartPageTest extends BaseClass
{
  public void verify_addToCart()
  {
	  try 
	  {
	  HomePage hp=new HomePage(driver);
	  hp.enterProductName("iPhone");
	  hp.clickSearch();
	  
	  SearchPage sp=new SearchPage(driver);
	  
	  if( sp.isProductExist("iPhone"))
	  {
		  sp.selectProduct("iPhone");
		  sp.setQuantity("2");
		  sp.addToCart();
		  
	  }
	  Assert.assertEquals(sp.checkConfmsg(),true);
	  }
	  catch(Exception e)
	  {
		  Assert.fail();
	  }
	  
  }

}