package testCases;


import org.testng.annotations.Test;

import pageObjects.ButtonNamesPage;
import testBase.BaseClass;

public class TC007_OepnPageValidation extends BaseClass
{

	@Test(groups= {"Master"})
	
	public void verify_openPage() throws InterruptedException
	{
	
		ButtonNamesPage bn = new ButtonNamesPage(driver);
		bn.openPage();
	}
}
