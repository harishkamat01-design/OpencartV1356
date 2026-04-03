package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass           //re-usbale methods will be put in here and along with logs 
{
			public static WebDriver driver;      // making this as driver as common across all the classes, so making it as static
			public Logger logger;               // import from import org.apache.logging.log4j.Logger and .LogManager;
			public Properties p;                // for properties file taken one variable p.

			@BeforeClass(groups = {"Sanity","Regression","Master"})
			
			@Parameters({"os","browser"})
	
	public void setup(String os, String br) throws IOException
	{
		//loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		//logger step
		logger = LogManager.getLogger(this.getClass());	
		
		
		//Running from Grid that is from remote --> step #10
						if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
						{
							DesiredCapabilities capabilities = new DesiredCapabilities();
							
							
							//os
							if(os.equalsIgnoreCase("Windows"))
							{
								capabilities.setPlatform(Platform.WIN11);
							}
							else if(os.equalsIgnoreCase("Linux"))
							{
								capabilities.setPlatform(Platform.LINUX);
							}
							else
							{
 								System.out.println("No matching os");
								return;
							}
							
							//browser     
							switch(br.toLowerCase())
							{
							case "chrome": capabilities.setBrowserName("chrome"); break;
							case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
							case "firefox": capabilities.setBrowserName("Firefox"); break;
							default: System.out.println("No matching browser"); return;
							}
							
							//launching RemoteWebDriver
							driver = new RemoteWebDriver(new URL("http://192.168.1.7:4444/wd/hub"), capabilities);
						}
		
						
						if(p.getProperty("execution_env").equalsIgnoreCase("local"))
						{
							switch(br.toLowerCase())
							{
							case "chrome"  : 	driver=new ChromeDriver(); break;
							case "edge"    : 	driver=new EdgeDriver(); break;
							case "firefox" : 	driver=new FirefoxDriver(); break;
							default : System.out.println("Invalid Browser..."); return;
							}
							
							
						}
		
		
		//parallel testing
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));    // appURL=https://tutorialsninja.com/demo/  from config.properties file
		driver.manage().window().maximize();
		
	 }
	
				@AfterClass(groups = {"Sanity","Regression","Master"})
				public void teardown()
				{
					driver.quit();
				}
				
				
				public String randomeString()
				{
					String generatedstring = RandomStringUtils.randomAlphabetic(5);
					return generatedstring;
				}
				
				public String randomeNumber()
				{
					String generatednumber = RandomStringUtils.randomNumeric(10);
					return generatednumber;
				}
				
				public String randomeAlphaNumeric()
				{
					String generatedstring = RandomStringUtils.randomAlphabetic(5);
					String generatednumber = RandomStringUtils.randomNumeric(3);
					return (generatedstring+"@"+generatednumber);
				}
				
				public String captureScreen(String tname)  throws IOException
				{
					String timeStamp = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
					
					TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
					File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
					
					String targetFilePath = System.getProperty("user.dir")+ "\\screenshots\\" + tname  + "_" + timeStamp + ".png";
					File targetFile = new File(targetFilePath);
					
					sourceFile.renameTo(targetFile);
				
					return targetFilePath;
				}
				
				
				
				

}
