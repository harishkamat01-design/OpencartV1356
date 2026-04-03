package testCases;

import org.testng.annotations.Test;

import pageObjects.HeaderNamePage;
import testBase.BaseClass;

public class TC006_HeaderNameValidation  extends BaseClass
{

	@Test(groups= {"Master"} )
	public void verify_headerName()
	{
		
		HeaderNamePage hm = new HeaderNamePage(driver);
		hm.HeaderName();
		
		
	}
}
