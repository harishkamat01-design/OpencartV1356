package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;


public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent;//populate common info on report
	public ExtentTest test; //creating test case entries in report and update the status of test methods
    
	String repName;
	
	public void onStart(ITestContext testContext)           //testContext is which test case is executed
	{
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.ss");
		 Date dt=new Date();
		 String currentdatetimestamp = df.format(dt);
		 */
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());    // timestamp  --- above 3 statements are clubbed in to single statement
		
		repName = "Test-report-" + timeStamp +".html";                         //Report name 
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);      //specific location of the report in html
		
//====================================================================================================================		
		sparkReporter.config().setDocumentTitle("opencart Automation Report"); //Title of the Report
		sparkReporter.config().setReportName("opencart Functional Testing"); //Name of the Report 
		sparkReporter.config().setTheme(Theme.DARK);                        //theme
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application","opencart");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Sub Module","Customers");
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
		
		String os= testContext.getCurrentXmlTest().getParameter("os"); 
		extent.setSystemInfo("Operating System", os);
		
		String browser= testContext.getCurrentXmlTest().getParameter("browser"); 
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
	}
	
	public void onTestSuccess(ITestResult result )
	{
		test=extent.createTest(result.getTestClass().getName()); //creates a new entry in the report
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		test.log(Status.PASS,result.getName()+  "got successfully executed"); //updates status 
	}
	
	public void onTestFailure(ITestResult result )
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+"got failed"); 
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(IOException e1)
		{
		e1.printStackTrace();	
		}
	}
	
	public void onTestSkipped(ITestResult result )
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+ "got skipped"); 
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
		
		// code for automatically open the report
		String pathOfExtentReport = System.getProperty("user.dir")+ "\\reports\\" +repName;
		File extentReport = new File(pathOfExtentReport);
		
		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e)
		{
		e.printStackTrace();	
		}
	
	}

}









