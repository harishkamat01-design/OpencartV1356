package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("*Starting TC002_LoginTest*");           // these are logger message
		
		try
		{
		//HomePage
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//LoginPage
		LoginPage lp =new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));    // this is not a java file , these are from properties file , so we need to mention in "".
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc =  new MyAccountPage(driver);
		boolean tragetPage = macc.isMyAccountPageExists();         // true or false will be return but we want 
		Assert.assertTrue(tragetPage);								// validation in the Test case
		//Assert.assertEquals(tragetPage, true , "Login Failed");   // validation in the Test case
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*Finished TC002_LoginTest*");              // these are logger message
		 
	}
}
