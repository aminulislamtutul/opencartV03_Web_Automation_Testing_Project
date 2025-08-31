package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseClass {
	public static WebDriver driver;
	public Properties properties;
	public Logger logger;
	protected SoftAssert softAssert = new SoftAssert(); 
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os", "browser"})
	public void setUp(@Optional("windows") String os,
            @Optional("chrome") String br) throws IOException {
		
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		properties = new Properties();
		properties.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//OS
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); 
			break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); 
			break;
			case "firefox": capabilities.setBrowserName("firefox"); 
			break;
			default: System.out.println("No matching browser"); 
			return;
			}
			
			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
			
		}
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch (br.toLowerCase()) {
	        case "chrome": driver = new ChromeDriver();
	        break;
	        case "firefox": driver = new FirefoxDriver();
	        break;
	        case "edge": driver = new EdgeDriver();
	        break;
	        default: System.out.println("Invalid Browser Name..");
	        return;
			
		}
	}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(properties.getProperty("WebUrl"));
		driver.manage().window().maximize();
		
	}
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	@SuppressWarnings("deprecation")
	public String generateString() {
	        return RandomStringUtils.randomAlphabetic(5);
	    }

	    // Utility method to generate a random numeric string
	    @SuppressWarnings("deprecation")
		public String generateNumber() {
	        return RandomStringUtils.randomNumeric(5);
	    }

	    // Utility method to generate a random alphanumeric string
	    @SuppressWarnings("deprecation")
		public String generateAlphaNumeric() {
	        String generatedString = RandomStringUtils.randomAlphabetic(3);
	        String generatedNumber = RandomStringUtils.randomNumeric(3);
	        return generatedString + "@" + generatedNumber;

	    }
	    public String captureScreen(String tName) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tName + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}

}
