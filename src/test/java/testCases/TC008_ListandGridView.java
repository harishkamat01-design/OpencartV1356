package testCases;

import org.testng.annotations.Test;

import pageObjects.ListGridPage;
import pageObjects.SortByRatingPage;
import testBase.BaseClass;

public class TC008_ListandGridView extends BaseClass

{
	@Test(groups={"Master"})
	public void verify_listandgridview() throws InterruptedException
	{
	logger.info("*TC008_ListandGridView*");
	  ListGridPage lg = new ListGridPage(driver);
	  lg.headerCamera();
	  Thread.sleep(3000);
	  lg.listView();
	  Thread.sleep(3000);
	  lg.gridView();
	  Thread.sleep(3000);
	  
	  SortByRatingPage sbr = new SortByRatingPage(driver);
		sbr.ratingHighest();
		 Thread.sleep(3000);
	}
}
