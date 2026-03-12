package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest   *****");
		
		try
		{
		HomePage hp = new HomePage(driver); // we need to create an object of the HomePage Class to access the methods
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register  Link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver); // we need to create an object of the HomePage Class to access the methods
		
		logger.info("Providing customer details");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");   // this should be random gmail id which should be different every time.
		regpage.setTelephone(randomeNumber());
		
		String password = randomeAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating the expected message");
		String confmsg = regpage.getConfirmationMsg();  // I will put the confirmation message from getConfirmationMsg() to string confmsg
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		
		catch(Exception e)
		{
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("***** Finished TC001_AccountRegistrationTest   ***** ");
	}
}
