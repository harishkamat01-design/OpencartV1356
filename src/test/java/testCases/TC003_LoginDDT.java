package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 Data is valid - login success - test pass - logout
 Data is valid - login failed  - test fail
 
 Data is invalid - login success - test fail - logout
 Data is invalid - login failed  - test pass
 
 
 */
public class TC003_LoginDDT extends BaseClass
{

	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")   //DataProviders is a class name. Getting @DataProvider from the different class. 
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		try {
			logger.info("*Starting TC003_LoginDDT*");
		//HomePage
				HomePage hp =new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
		//LoginPage
				LoginPage lp =new LoginPage(driver);
				lp.setEmail(email);    // from DataProvier.
				lp.setPassword(pwd);
				lp.clickLogin();
				
		//MyAccountPage	
				MyAccountPage macc =  new MyAccountPage(driver);
				boolean tragetPage = macc.isMyAccountPageExists();         // true or false will be return but we want 
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if(tragetPage==true)                      //1. Data is valid - login success - test pass - logout
			{
				macc.linkLogout();
				Assert.assertTrue(true);	
			}
			else
			{
				Assert.assertTrue(false);              //2. Data is valid - login failed  - test fail
			}
		}
				
		if (exp.equalsIgnoreCase("Invalid"))
		{
			if(tragetPage==true)                      //3. Data is invalid - login success - test fail - logout
			{
				macc.linkLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);             //4. Data is invalid - login failed  - test pass
			}
		}
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*Finished TC003_LoginDDT*");
	}
}
