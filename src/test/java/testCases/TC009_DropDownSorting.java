package testCases;

import org.testng.annotations.Test;

import pageObjects.SortByRatingPage;
import testBase.BaseClass;

public class TC009_DropDownSorting extends BaseClass
{
	
	@Test(groups={"Master"})
	public void verify_DropDownSorting() throws InterruptedException
	{
	SortByRatingPage sbr = new SortByRatingPage(driver);
	sbr.ratingHighest();
	}

}
